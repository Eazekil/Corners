package com.nokhrin.corners.multiplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;
import com.nokhrin.corners.multiplayer.Room.Room;

import java.util.ArrayList;
import java.util.List;

import static com.nokhrin.corners.resources.Constants.PLAYER_2;
import static com.nokhrin.corners.resources.Constants.PLAYER_NAME;
import static com.nokhrin.corners.resources.Constants.ROLE;
import static com.nokhrin.corners.resources.Constants.ROLE_GUEST;
import static com.nokhrin.corners.resources.Constants.ROLE_HOST;
import static com.nokhrin.corners.resources.Constants.ROOMS;
import static com.nokhrin.corners.resources.Constants.ROOM_NAME;


public class ActivityRooms extends AppCompatActivity {
    ListView lvRooms;
    Button buttonCreateRoom;
    Button buttonJoinRoom;
    EditText etCreateRoom;

    String playerName;
    String roomName;
    List<String> roomsList;

    FirebaseDatabase database;
    DatabaseReference roomRef;
    DatabaseReference roomsRef;
    int role;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);



        //this all for make full screen
        View levelsLayout = findViewById(R.id.ConstrainLayoutRooms);
        levelsLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        //get playerName
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            playerName = extras.getString(PLAYER_NAME);
        }

        //find all element on view
        buttonCreateRoom = findViewById(R.id.buttonCreateRoom);
        buttonJoinRoom = findViewById(R.id.buttonJoinRoom);
        etCreateRoom = findViewById(R.id.editTextCreateRoom);
        lvRooms = findViewById(R.id.listViewRooms);

        //find database
        database = FirebaseDatabase.getInstance();

        roomsList = new ArrayList<>();

        ////////////////button create new game and add this user as player1
        buttonCreateRoom.setOnClickListener(v -> {
            roomName = etCreateRoom.getText().toString();

            if (!roomName.isEmpty()) {
                buttonCreateRoom.setText("Создание игры...");
                buttonCreateRoom.setEnabled(false);
                roomRef = database.getReference(ROOMS + "/" + roomName + "/");
                Room room = new Room(null, null, playerName, null);
                role = ROLE_HOST;
                addEventListener();
                roomRef.setValue(room);
            } else {
                Toast.makeText(this, "Пожалуйста придумайте и введите Имя игры", Toast.LENGTH_SHORT).show();
            }
        });

        buttonJoinRoom.setOnClickListener(v -> {
            buttonJoinRoom.setEnabled(false);
            buttonJoinRoom.setText("Выберите игру");
            buttonCreateRoom.setVisibility(View.INVISIBLE);
            etCreateRoom.setVisibility(View.INVISIBLE);
            lvRooms.setVisibility(View.VISIBLE);

            addRoomsEventListener();
        });


        ////////////////join an existing room and add yourself as player2
        lvRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                roomName = roomsList.get(position);
                roomRef = database.getReference(ROOMS + "/" + roomName + "/");

                role = ROLE_GUEST;
                addEventListener();
                roomRef.child(PLAYER_2).setValue(playerName);
            }
        });

        //show if new room is available
        addRoomsEventListener();
    }


    //go to multiplayer game activity
    public void addEventListener() {
        roomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Intent intent = new Intent(getApplicationContext(), ActivityMultiplayerGame.class);
                if (role == ROLE_HOST) {
                    intent.putExtra(PLAYER_NAME, playerName);
                    intent.putExtra(ROOM_NAME, roomName);
                    intent.putExtra(ROLE, ROLE_HOST);

                    //if this listener not remove be bad
                    roomRef.removeEventListener(this);
                } else {
                    intent.putExtra(PLAYER_NAME, playerName);
                    intent.putExtra(ROOM_NAME, roomName);
                    intent.putExtra(ROLE, ROLE_GUEST);

                    //if this listener not remove be bad
                    roomRef.removeEventListener(this);
                }

                startActivity(intent);
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error
                Toast.makeText(ActivityRooms.this, "что то пошло не так", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //get list of rooms
    public void addRoomsEventListener() {
        roomsRef = database.getReference(ROOMS);
        roomsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                roomsList.clear();
                Iterable<DataSnapshot> rooms = snapshot.getChildren();
                for (DataSnapshot dataSnapshot : rooms) {

                    if (dataSnapshot.child(PLAYER_2).getValue() == null) {
                        roomsList.add(dataSnapshot.getKey());
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityRooms.this,
                                R.layout.my_list_item, roomsList);
                        lvRooms.setAdapter(adapter);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error - nothing
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ActivityStart.class);
        this.startActivity(intent);
        this.finish();
        super.onBackPressed();
    }

}