package com.nokhrin.corners.levels;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.controller.OnTouchListener;
import com.nokhrin.corners.levels.database.LevelsDb;
import com.nokhrin.corners.levels.model.StartGameLevel;
import com.nokhrin.corners.levels.view.ViewParameters;

public class ActivityGameLevel extends AppCompatActivity {
    private OnTouchListener onTouchListener;
    private ViewParameters viewParameters;
    private StartGameLevel startGame;
    private LevelsDb levelsDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this all for make full screen
        setContentView(R.layout.activity_levels);
        View levelsLayout = findViewById(R.id.ConstrainLayoutLevels);
        levelsLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        levelsDb = new LevelsDb(this);
        startGame = new StartGameLevel();
        startGame.setLevelsDb(levelsDb);

        //set start parameters for View
        viewParameters = new ViewParameters();
        viewParameters.setActivity(this);

        onTouchListener =new OnTouchListener();
        onTouchListener.setActivity(this);
    }
}