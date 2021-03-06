package com.nokhrin.corners;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.classical.ActivityClassic;
import com.nokhrin.corners.levels.ActivityLevels;
import com.nokhrin.corners.multiplayer.ActivityMultiplayer;


public class ActivityStart extends AppCompatActivity {
    public static Button buttonLevel;
    public static Button buttonClassic;
    public static Button buttonMultiPlayer;
    public static int widthDisplay;
    public static int heightDisplay;
    private View startLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this all for make full screen
        setContentView(R.layout.activity_start);
        startLayout = findViewById(R.id.ConstrainLayoutStart);
        startLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //find all element
        buttonLevel = findViewById(R.id.buttonLevel);
        buttonClassic = findViewById(R.id.buttonClassic);
        buttonMultiPlayer = findViewById(R.id.buttonMultiPlayer);


        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        heightDisplay = size.y;

        //go to choice level activity
        buttonLevel.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityLevels.class);
            startActivity(intent);
        });
        //go to classic game activity
        buttonClassic.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityClassic.class);
            startActivity(intent);
        });
        //go to activity for play with friends
        buttonMultiPlayer.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityMultiplayer.class);
            startActivity(intent);
        });


    }
}