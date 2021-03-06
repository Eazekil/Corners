package com.nokhrin.corners.levels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;

public class ActivityLevels extends AppCompatActivity {
    private View levelsLayout;
    public static Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this all for make full screen
        setContentView(R.layout.activity_levels);
        levelsLayout = findViewById(R.id.ConstrainLayoutLevels);
        levelsLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //find all element and save in variables
        buttonMenu=findViewById(R.id.buttonMenu);

        //button return to Menu
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLevels.this, ActivityStart.class);
                startActivity(intent);
            }
        });



    }
}