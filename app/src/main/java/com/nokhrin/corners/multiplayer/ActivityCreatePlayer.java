package com.nokhrin.corners.multiplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;


public class ActivityCreatePlayer extends AppCompatActivity {
    Button buttonCreatePlayer;
    EditText etPlayerName;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_player);

        //this all for make full screen
        View levelsLayout = findViewById(R.id.ConstrainLayoutCreatePlayer);
        levelsLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        etPlayerName = findViewById(R.id.editTextPlayerName);
        buttonCreatePlayer = findViewById(R.id.buttonCreatePlayer);

        buttonCreatePlayer.setOnClickListener(v -> {
            playerName = etPlayerName.getText().toString();

            if(!playerName.isEmpty()){
                //go to Rooms activity
                Intent intent = new Intent(getApplicationContext(), ActivityRooms.class);
                intent.putExtra("playerName", playerName);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Пожалуйста введите Имя", Toast.LENGTH_SHORT).show();
            }
        });









        /*database = FirebaseDatabase.getInstance();

        //check if the player exists and get reference
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        playerName = preferences.getString("playerName", "");
        if (!playerName.equals("")) {
            playerRef = database.getReference("players/" + playerName);
            addEventListener();
            playerRef.setValue("");
        }

        button.setOnClickListener(v -> {
            //logging the player in
            playerName = editText.getText().toString();
            editText.setText("");
            if (!playerName.equals("")) {
                button.setText("Вход в систему");
                button.setEnabled(false);
                playerRef = database.getReference("players/" + playerName);
                addEventListener();
                playerRef.setValue("");
            }
        });*/

    }

    /*private void addEventListener() {
        //read from database
        playerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //success - continue to the next screen after saving the player name
                if (!playerName.equals("")) {
                    SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("playerName", playerName);
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), ActivityRooms.class));
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error
                button.setText("Авторизоваться");
                button.setEnabled(true);
                Toast.makeText(ActivityCreatePlayer.this, "Ошибочка вышла", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

}