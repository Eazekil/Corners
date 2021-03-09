package com.nokhrin.corners.levels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;

import java.util.ArrayList;

import static com.nokhrin.corners.levels.level1.Level1.startLevel1;
import static com.nokhrin.corners.levels.level2.Level2.startLevel2;
import static com.nokhrin.corners.levels.level3.Level3.startLevel3;
import static com.nokhrin.corners.levels.level4.Level4.startLevel4;

public class ActivityLevels extends AppCompatActivity {
    private View levelsLayout;
    public Button buttonMenu;
    public Button buttonLevel1;
    public Button buttonLevel2;
    public Button buttonLevel3;
    public Button buttonLevel4;
    public Button buttonLevel5;
    public Button buttonLevel6;
    public static int sizeOfField;
    public static int stepOnField; // step on chess field and size of checkers
    public static int touchI;//coordinates of touch on chess field
    public static int touchJ;//coordinates of touch on chess field
    public static int countToMove;
    public static TextView countMoveView;
    public static int[][] checkersPositions; //= new int[sizeOfField][sizeOfField];//positions all checkers on field
    public static int[][] marksPositions; // = new int[sizeOfField][sizeOfField];//positions all marks on field
    public static DrawView drawView;
    public static ViewGroup frameLayoutLevels;
    public static int sizePoint;
    public static int countPointInLevel;
    public static ArrayList<Button> buttonLevelList = new ArrayList<>();
    // 1   - checker white
    // 2   - checker white with mark
    // -1  - checker black
    // 0 - this nothing
    // 31  - target point



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
        buttonMenu = findViewById(R.id.buttonMenu);
        frameLayoutLevels = findViewById(R.id.frameLayoutLevels);
        countMoveView = findViewById(R.id.textViewCountMove);
        //add levels
        buttonLevel1 = findViewById(R.id.buttonLevel1);
        buttonLevel2 = findViewById(R.id.buttonLevel2);
        buttonLevel3 = findViewById(R.id.buttonLevel3);
        buttonLevel4 = findViewById(R.id.buttonLevel4);
        buttonLevel5 = findViewById(R.id.buttonLevel5);
        buttonLevel6 = findViewById(R.id.buttonLevel6);
        buttonLevelList.add(buttonLevel1);
        buttonLevelList.add(buttonLevel2);
        buttonLevelList.add(buttonLevel3);
        buttonLevelList.add(buttonLevel4);
        buttonLevelList.add(buttonLevel5);
        buttonLevelList.add(buttonLevel6);


        //create view for draw
        drawView = new DrawView(getApplicationContext());
        frameLayoutLevels.addView(drawView);


        //button return to Menu
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityLevels.this, ActivityStart.class);
            startActivity(intent);
        });

        //level 1
        buttonLevel1.setOnClickListener(v -> {
            frameLayoutLevels.setVisibility(View.VISIBLE);
            for(Button button : buttonLevelList){
                button.setVisibility(View.INVISIBLE);
            }
            startLevel1();
        });

        //level 2
        buttonLevel2.setOnClickListener(v -> {
            frameLayoutLevels.setVisibility(View.VISIBLE);
            for(Button button : buttonLevelList){
                button.setVisibility(View.INVISIBLE);
            }
            startLevel2();
        });

        //level 3
        buttonLevel3.setOnClickListener(v -> {
            frameLayoutLevels.setVisibility(View.VISIBLE);
            for(Button button : buttonLevelList){
                button.setVisibility(View.INVISIBLE);
            }
            startLevel3();
        });

        //level 4
        buttonLevel4.setOnClickListener(v -> {
            frameLayoutLevels.setVisibility(View.VISIBLE);
            for(Button button : buttonLevelList){
                button.setVisibility(View.INVISIBLE);
            }
            startLevel4();
        });


    }



}