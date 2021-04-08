package com.nokhrin.corners;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.classical.view.ActivityClassic;
import com.nokhrin.corners.levels.ActivityLevels;
import com.nokhrin.corners.multiplayer.ActivityCreatePlayer;



public class ActivityStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //find animation for buttons
        final Animation alphaChangeAnimation = AnimationUtils.loadAnimation(this, R.anim.button_change_alpha_on_click);

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


        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widthDisplay = size.x;
        int heightDisplay = size.y;

        //go to choice level activity
        buttonLevel.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityLevels.class);
            v.startAnimation(alphaChangeAnimation);
            startActivity(intent);
            finish();
        });
        //go to classic game activity
        buttonClassic.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityClassic.class);
            v.startAnimation(alphaChangeAnimation);
            startActivity(intent);
            finish();
        });
        //go to activity for play with friends
        buttonMultiPlayer.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityStart.this, ActivityCreatePlayer.class);
            v.startAnimation(alphaChangeAnimation);
            startActivity(intent);
            finish();
        });


    }
}