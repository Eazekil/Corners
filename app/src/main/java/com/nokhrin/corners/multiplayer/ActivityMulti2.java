package com.nokhrin.corners.multiplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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


public class ActivityMulti2 extends AppCompatActivity {
    ListView listView;
    Button button;
    List<String> roomsList;

    String playerName = "";
    String roomName = "";

    FirebaseDatabase database;
    DatabaseReference roomRef;
    DatabaseReference roomsRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi2);

        //this all for make full screen
        View levelsLayout = findViewById(R.id.ConstrainLayoutMulti2);
        levelsLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //get the player name and assign his room to the player name
        database = FirebaseDatabase.getInstance();
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        playerName = preferences.getString("playerName", "");
        roomName = "Комната принадлежит: " + playerName;

        listView = findViewById(R.id.reciclerViewOnMulti2);
        button = findViewById(R.id.buttonOnMulri2);

        //all existing available rooms
        roomsList = new ArrayList<>();

        button.setOnClickListener(v -> {
            //create room and add yourself as player1
            button.setText("Создание игры");
            button.setEnabled(false);
            roomName = "Комната принадлежит: " + playerName;
            roomRef = database.getReference("rooms/" + roomName + "/player1");
            addRoomEventListener();
            roomRef.setValue(playerName);
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //join an existing room and add yourself as player2
                roomName = roomsList.get(position);
                roomRef = database.getReference("rooms/" + roomName + "/player2");
                addRoomEventListener();
                roomRef.setValue(playerName);
            }
        });

        //show if new room is available
        addRoomsEventListener();
    }

    private void addRoomEventListener(){
        roomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //join the room
                button.setText("Создать игру");
                button.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), ActivityMulti3Game.class);
                intent.putExtra("roomName", roomName);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error
                button.setText("Создать игру");
                button.setEnabled(true);
                Toast.makeText(ActivityMulti2.this, "Опять же, ошибочка!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addRoomsEventListener(){
        roomsRef = database.getReference("rooms");
        roomsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //show list of rooms
                roomsList.clear();
                Iterable<DataSnapshot> rooms = snapshot.getChildren();
                for(DataSnapshot dataSnapshot : rooms){
                    roomsList.add(dataSnapshot.getKey());

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityMulti2.this,
                            android.R.layout.simple_list_item_1, roomsList);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error - nothing
            }
        });
    }
}