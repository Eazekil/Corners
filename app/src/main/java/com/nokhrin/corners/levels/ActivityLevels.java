package com.nokhrin.corners.levels;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.level1.Level1;
import com.nokhrin.corners.levels.level10.Level10;
import com.nokhrin.corners.levels.level11.Level11;
import com.nokhrin.corners.levels.level12.Level12;
import com.nokhrin.corners.levels.level2.Level2;
import com.nokhrin.corners.levels.level3.Level3;
import com.nokhrin.corners.levels.level4.Level4;
import com.nokhrin.corners.levels.level5.Level5;
import com.nokhrin.corners.levels.level6.Level6;
import com.nokhrin.corners.levels.level7.Level7;
import com.nokhrin.corners.levels.level8.Level8;
import com.nokhrin.corners.levels.level9.Level9;
import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.levels.start.PlayerProgress;
import com.nokhrin.corners.levels.start.StartGame;

import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.START_LEVELS;

public class ActivityLevels extends AppCompatActivity implements View.OnTouchListener{
    public TextView countMoveView;
    public DrawView drawView; //view for game field
    public int widthDisplay;
    public int indentTop;
    public StartGame startGame;
    public PlayerMove playerMove;
    public ImageView ivWoodman;
    public FrameLayout frameLayoutLevels;
    public int numberLevel;
    ArrayList<View> elementSetVisibleList = new ArrayList<>();
    public ArrayList<Button> buttonSetInvisibleList = new ArrayList<>();
    public SharedPreferences preferences;

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


        //find all element and save in variables
        Button buttonMenu = findViewById(R.id.buttonMenu);
        Button buttonReturnLevels = findViewById(R.id.buttonReturnLevel);
        Button buttonRestartLevel = findViewById(R.id.buttonRestartLevel);
        frameLayoutLevels = findViewById(R.id.frameLayoutLevel);
        countMoveView = findViewById(R.id.textViewCountMove);
        ivWoodman = findViewById(R.id.imageViewCheckerWoodman);

        

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        int heightDisplay = size.y;
        indentTop = (heightDisplay - widthDisplay) / 2;

        //set indent of top
        FrameLayout flIntent = findViewById(R.id.frameLayoutIndentLevels);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = indentTop;
        flIntent.setLayoutParams(params);

        //add start parameters for game field
        startGame = new StartGame(this);
        //set on touch listener
        frameLayoutLevels.setOnTouchListener(this);







        //add levels
        Button buttonLevel1 = findViewById(R.id.buttonLevel1);
        Button buttonLevel2 = findViewById(R.id.buttonLevel2);
        Button buttonLevel3 = findViewById(R.id.buttonLevel3);
        Button buttonLevel4 = findViewById(R.id.buttonLevel4);
        Button buttonLevel5 = findViewById(R.id.buttonLevel5);
        Button buttonLevel6 = findViewById(R.id.buttonLevel6);
        Button buttonLevel7 = findViewById(R.id.buttonLevel7);
        Button buttonLevel8 = findViewById(R.id.buttonLevel8);
        Button buttonLevel9 = findViewById(R.id.buttonLevel9);
        Button buttonLevel10 = findViewById(R.id.buttonLevel10);
        Button buttonLevel11 = findViewById(R.id.buttonLevel11);
        Button buttonLevel12 = findViewById(R.id.buttonLevel12);


        //add element for invisible
        buttonSetInvisibleList.add(buttonMenu);
        buttonSetInvisibleList.add(buttonLevel1);
        buttonSetInvisibleList.add(buttonLevel2);
        buttonSetInvisibleList.add(buttonLevel3);
        buttonSetInvisibleList.add(buttonLevel4);
        buttonSetInvisibleList.add(buttonLevel5);
        buttonSetInvisibleList.add(buttonLevel6);
        buttonSetInvisibleList.add(buttonLevel7);
        buttonSetInvisibleList.add(buttonLevel8);
        buttonSetInvisibleList.add(buttonLevel9);
        buttonSetInvisibleList.add(buttonLevel10);
        buttonSetInvisibleList.add(buttonLevel11);
        buttonSetInvisibleList.add(buttonLevel12);

        //add element for visible
        elementSetVisibleList.add(countMoveView);
        elementSetVisibleList.add(frameLayoutLevels);
        elementSetVisibleList.add(buttonReturnLevels);
        elementSetVisibleList.add(buttonRestartLevel);


        //find preferences
        preferences = getPreferences(MODE_PRIVATE);
        PlayerProgress playerProgress = new PlayerProgress(this);

        //check preferences for levels game already exist
        if(preferences.getBoolean(START_LEVELS, false)){
            //start update background for buttons
            playerProgress.checkLevels();
            System.out.println("111111111111111111111111111111111111111111111111111111");
        }else{
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(START_LEVELS, true);
            editor.apply();
        }




        //button return to Menu
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityLevels.this, ActivityStart.class);
            startActivity(intent);
            finish();
        });

        //button return to menu levels
        buttonReturnLevels.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityLevels.this, ActivityLevels.class);
            startActivity(intent);
            finish();
        });

        //button restart level
        buttonRestartLevel.setOnClickListener(v -> {
            if (numberLevel == 1) {
                Level1 level = new Level1();
                level.startLevel(this);
            } else if (numberLevel == 2) {
                Level2 level = new Level2();
                level.startLevel(this);
            } else if (numberLevel == 3) {
                Level3 level = new Level3();
                level.startLevel(this);
            } else if (numberLevel == 4) {
                Level4 level = new Level4();
                level.startLevel(this);
            } else if (numberLevel == 5) {
                Level5 level = new Level5();
                level.startLevel(this);
            } else if (numberLevel == 6) {
                Level6 level = new Level6();
                level.startLevel(this);
            } else if (numberLevel == 7) {
                Level7 level = new Level7();
                level.startLevel(this);
            } else if (numberLevel == 8) {
                Level8 level = new Level8();
                level.startLevel(this);
            } else if (numberLevel == 9) {
                Level9 level = new Level9();
                level.startLevel(this);
            } else if (numberLevel == 10) {
                Level10 level = new Level10();
                level.startLevel(this);
            } else if (numberLevel == 11) {
                Level11 level = new Level11();
                level.startLevel(this);
            } else if (numberLevel == 12) {
                Level12 level = new Level12();
                level.startLevel(this);
            }
            drawView.invalidate();
        });

        //level 1
        buttonLevel1.setOnClickListener(v -> {
            numberLevel =1;
            Level1 level = new Level1();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 2
        buttonLevel2.setOnClickListener(v -> {
            numberLevel = 2;
            Level2 level = new Level2();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 3
        buttonLevel3.setOnClickListener(v -> {
            numberLevel = 3;
            Level3 level = new Level3();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 4
        buttonLevel4.setOnClickListener(v -> {
            numberLevel = 4;
            Level4 level = new Level4();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 5
        buttonLevel5.setOnClickListener(v -> {
            numberLevel = 5;
            Level5 level = new Level5();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 6
        buttonLevel6.setOnClickListener(v -> {
            numberLevel = 6;
            Level6 level = new Level6();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 7
        buttonLevel7.setOnClickListener(v -> {
            numberLevel = 7;
            Level7 level = new Level7();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 8
        buttonLevel8.setOnClickListener(v -> {
            numberLevel = 8;
            Level8 level = new Level8();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 9
        buttonLevel9.setOnClickListener(v -> {
            numberLevel = 9;
            Level9 level = new Level9();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 10
        buttonLevel10.setOnClickListener(v -> {
            numberLevel = 10;
            Level10 level = new Level10();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 11
        buttonLevel11.setOnClickListener(v -> {
            numberLevel = 11;
            Level11 level = new Level11();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });
        //level 12
        buttonLevel12.setOnClickListener(v -> {
            numberLevel = 12;
            Level12 level = new Level12();
            level.startLevel(this);
            drawView = new DrawView(getApplicationContext(), this);
            frameLayoutLevels.addView(drawView);
            playerMove = new PlayerMove(this);
            visible();
        });


    }

    //set visible and invisible element on view
    private void visible(){
        for (View view : elementSetVisibleList) {
            view.setVisibility(View.VISIBLE);
        }
        for (Button button : buttonSetInvisibleList) {
            button.setVisibility(View.INVISIBLE);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //get coordinates of touch
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        //convert coordinates X,Y in step on chess field
        int touchI = touchY / startGame.getStepOnField() + 1;
        int touchJ = touchX / startGame.getStepOnField() + 1;

        System.out.println("_______________________ " + touchI + "," + touchJ);

        //check game is over
        if(startGame.getWin() == 0 && startGame.isPlayerMove()){
            //start move on the field
            playerMove.startPlayerMove(touchI, touchJ);
        }

        return false;
    }

}