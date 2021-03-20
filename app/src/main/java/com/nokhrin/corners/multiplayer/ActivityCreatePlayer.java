package com.nokhrin.corners.multiplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;

import static com.nokhrin.corners.resources.Constants.PLAYER_NAME;


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
                intent.putExtra(PLAYER_NAME, playerName);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Пожалуйста введите Имя", Toast.LENGTH_SHORT).show();
            }
        });

    }

}