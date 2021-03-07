package com.nokhrin.corners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.nokhrin.corners.classical.ActivityClassic;
import com.nokhrin.corners.levels.ActivityLevels;


public class ActivityStart extends AppCompatActivity {
    private View startLayout;
    public static Button buttonLevel;
    public static Button buttonClassic;
    public static int widthDisplay;
    public static int heightDisplay;

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
        buttonLevel=findViewById(R.id.buttonLevel);
        buttonClassic=findViewById(R.id.buttonClassic);


        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        heightDisplay = size.y;


        buttonLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStart.this, ActivityLevels.class);
                startActivity(intent);
            }
        });

        buttonClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityStart.this, ActivityClassic.class);
                startActivity(intent);
            }
        });



    }
}