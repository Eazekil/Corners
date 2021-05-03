package com.nokhrin.corners.levels.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.controller.ButtonsAdapter;
import com.nokhrin.corners.levels.database.LevelsDb;

import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.CREATE_NUMBER_LEVEL;

public class ActivityLevels extends AppCompatActivity /*implements View.OnTouchListener*/ {
    private LevelsDb levelsDb;

    @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility"})
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
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

        Button btMenu = findViewById(R.id.buttonMenu);
        btMenu.setOnClickListener(v -> {
            Intent intent = new Intent(this, ActivityStart.class);
            startActivity(intent);
            finish();
        });


        ArrayList<ButtonLevel> buttonLevels = new ArrayList<ButtonLevel>();
        ListView lvLevels = (ListView) findViewById(R.id.buttonList);
        buttonLevels.add(new ButtonLevel(1, 2));
        buttonLevels.add(new ButtonLevel(4, 2));
        buttonLevels.add(new ButtonLevel(7, 2));
        buttonLevels.add(new ButtonLevel(10, 2));
        buttonLevels.add(new ButtonLevel(13, 2));
        buttonLevels.add(new ButtonLevel(16, 2));
        buttonLevels.add(new ButtonLevel(19, 2));
        buttonLevels.add(new ButtonLevel(22, 2));
        buttonLevels.add(new ButtonLevel(25, 2));
        buttonLevels.add(new ButtonLevel(28, 2));
        buttonLevels.add(new ButtonLevel(31, 2));
        buttonLevels.add(new ButtonLevel(34, 2));

        ButtonsAdapter adapter = new ButtonsAdapter(this, R.layout.list_buttons, buttonLevels);
        //adapter.setOnTouchListener(onTouchListener);
        lvLevels.setAdapter(adapter);


    }

    public void setCreateNumberLevel(int createNumberLevel) {
        Intent intent = new Intent(this, ActivityGameLevel.class);
        intent.putExtra(CREATE_NUMBER_LEVEL, createNumberLevel);
        startActivity(intent);
        finish();
    }

    public LevelsDb getLevelsDb() {
        return levelsDb;
    }
}