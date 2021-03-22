package com.nokhrin.corners.levels;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

public class ActivityLevels extends AppCompatActivity {
    public static int sizeOfField;
    public static int stepOnField; // step on chess field and size of checkers
    public static int touchI;//coordinates of touch on chess field
    public static int touchJ;//coordinates of touch on chess field
    public static int countToMove;
    public static int[][] checkersPositions; //= new int[sizeOfField][sizeOfField];//positions all checkers on field
    public static int[][] marksPositions; // = new int[sizeOfField][sizeOfField];//positions all marks on field
    public static DrawView drawView; //view for game field
    public static int sizePoint;
    public static int countPointInLevel;
    public static ArrayList<Button> buttonSetInvisibleList = new ArrayList<>();
    public static ArrayList<View> elementSetVisibleList = new ArrayList<>();
    public static TextView countMoveView;
    public int numberLevel;
    public static int widthDisplay;


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
        ViewGroup frameLayoutLevels = findViewById(R.id.frameLayoutLevel);
        countMoveView = findViewById(R.id.textViewCountMove);

        //create view for draw
        drawView = new DrawView(getApplicationContext());
        frameLayoutLevels.addView(drawView);

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

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
         widthDisplay = size.x;
        int heightDisplay = size.y;


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
                Level1.startLevel();
            } else if (numberLevel == 2) {
                Level2.startLevel();
            } else if (numberLevel == 3) {
                Level3.startLevel();
            } else if (numberLevel == 4) {
                Level4.startLevel();
            } else if (numberLevel == 5) {
                Level5.startLevel();
            } else if (numberLevel == 6) {
                Level6.startLevel();
            } else if (numberLevel == 7) {
                Level7.startLevel();
            } else if (numberLevel == 8) {
                Level8.startLevel();
            } else if (numberLevel == 9) {
                Level9.startLevel();
            } else if (numberLevel == 10) {
                Level10.startLevel();
            } else if (numberLevel == 11) {
                Level11.startLevel();
            } else if (numberLevel == 12) {
                Level12.startLevel();
            }
            drawView.invalidate();
        });

        //level 1
        buttonLevel1.setOnClickListener(v -> {
            numberLevel = 1;
            Level1.startLevel();
        });
        //level 2
        buttonLevel2.setOnClickListener(v -> {
            numberLevel = 2;
            Level2.startLevel();
        });
        //level 3
        buttonLevel3.setOnClickListener(v -> {
            numberLevel = 3;
            Level3.startLevel();
        });
        //level 4
        buttonLevel4.setOnClickListener(v -> {
            numberLevel = 4;
            Level4.startLevel();
        });
        //level 5
        buttonLevel5.setOnClickListener(v -> {
            numberLevel = 5;
            Level5.startLevel();
        });
        //level 6
        buttonLevel6.setOnClickListener(v -> {
            numberLevel = 6;
            Level6.startLevel();
        });
        //level 7
        buttonLevel7.setOnClickListener(v -> {
            numberLevel = 7;
            Level7.startLevel();
        });
        //level 8
        buttonLevel8.setOnClickListener(v -> {
            numberLevel = 8;
            Level8.startLevel();
        });
        //level 9
        buttonLevel9.setOnClickListener(v -> {
            numberLevel = 9;
            Level9.startLevel();
        });
        //level 10
        buttonLevel10.setOnClickListener(v -> {
            numberLevel = 10;
            Level10.startLevel();
        });
        //level 11
        buttonLevel11.setOnClickListener(v -> {
            numberLevel = 11;
            Level11.startLevel();
        });
        //level 12
        buttonLevel12.setOnClickListener(v -> {
            numberLevel = 12;
            Level12.startLevel();
        });


    }
}