package com.nokhrin.corners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.classical.view.ActivityClassic;
import com.nokhrin.corners.levels.view.ActivityLevels;
import com.nokhrin.corners.levels.database.ActivityCreateLevel;
import com.nokhrin.corners.multiplayer.ActivityCreatePlayer;



public class ActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this all for make full screen
        setContentView(R.layout.activity_start);
        View startLayout = findViewById(R.id.ConstrainLayoutStart);
        startLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //find all element
        Button buttonLevel = findViewById(R.id.buttonLevel);
        Button buttonClassic = findViewById(R.id.buttonClassic);
        Button buttonMultiPlayer = findViewById(R.id.buttonMultiPlayer);
        Button buttonCreateLevel = findViewById(R.id.buttonCreateLevel);


        /*//discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widthDisplay = size.x;
        int heightDisplay = size.y;*/

        //go to choice level activity
        buttonLevel.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityLevels.class);
            startActivity(intent);
            finish();
        });
        //go to classic game activity
        buttonClassic.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityClassic.class);
            startActivity(intent);
            finish();
        });
        //go to activity for play with friends
        buttonMultiPlayer.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityCreatePlayer.class);
            startActivity(intent);
            finish();
        });

        buttonCreateLevel.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityCreateLevel.class);
            startActivity(intent);
            finish();
        });

    }
}