package com.nokhrin.corners.multiplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nokhrin.corners.R;

import java.util.ArrayList;
import java.util.List;


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

    ///////////////////////////////////////////


    //DatabaseReference roomRef;
    //DatabaseReference roomsRef;


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


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            playerName = extras.getString("playerName");
        }

        buttonCreateRoom = findViewById(R.id.buttonCreateRoom);
        buttonJoinRoom = findViewById(R.id.buttonJoinRoom);
        etCreateRoom = findViewById(R.id.editTextCreateRoom);
        lvRooms = findViewById(R.id.listViewRooms);

        database = FirebaseDatabase.getInstance();

        roomsList = new ArrayList<>();


        buttonCreateRoom.setOnClickListener(v -> {
            roomName = etCreateRoom.getText().toString();

            if (!roomName.isEmpty()) {
                buttonCreateRoom.setText("Создание игры...");
                buttonCreateRoom.setEnabled(false);
                roomRef = database.getReference("rooms/" + roomName + "/player1");
                addEventListener();
                roomRef.setValue(playerName);
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

        lvRooms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                roomName = roomsList.get(position);
                roomRef = database.getReference("rooms/" + roomName + "/player2");
                addRoomEventListener();
                roomRef.setValue(playerName);
            }
        });


    }

    public void addEventListener() {
        roomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //go to multiplayer game activity
                Intent intent = new Intent(getApplicationContext(), ActivityMultiplayerGame.class);
                intent.putExtra("firstPlayerName", playerName);
                intent.putExtra("roomName", roomName);
                startActivity(intent);
                //finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error
                Toast.makeText(ActivityRooms.this, "что то пошло не так", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void addRoomsEventListener(){
        roomsRef = database.getReference("rooms");
        roomsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                roomsList.clear();
                Iterable<DataSnapshot> rooms = snapshot.getChildren();
                for(DataSnapshot dataSnapshot : rooms){
                    roomsList.add(dataSnapshot.getKey());

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityRooms.this,
                            android.R.layout.simple_list_item_1, roomsList);
                    lvRooms.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error - nothing
            }
        });
    }

    public void addRoomEventListener(){
        roomsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Intent intent = new Intent(getApplicationContext(), ActivityMultiplayerGame.class);
                intent.putExtra("secondPlayerName", playerName);
                intent.putExtra("roomName", roomName);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ActivityRooms.this, "какая то ошибка", Toast.LENGTH_SHORT).show();
            }
        });
    }
}