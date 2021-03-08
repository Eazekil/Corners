package com.nokhrin.corners.levels;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;

import java.util.ArrayList;

import static com.nokhrin.corners.ActivityStart.heightDisplay;
import static com.nokhrin.corners.ActivityStart.widthDisplay;
import static com.nokhrin.corners.levels.PlayerMove.touchOnField;
import static com.nokhrin.corners.levels.level1.Level1.startLevel1;

public class ActivityLevels extends AppCompatActivity implements View.OnTouchListener {
    private View levelsLayout;
    public static Button buttonMenu;
    public static ImageView field4x4;
    public static ImageView checkMark;
    public static int countWhiteCheckers = 12;
    public static int countBlackCheckers = 12;
    public static int sizeOfField = 5;
    public static int stepOnField; // step on chess field and size of checkers
    public static int indentTop; //indent of the top of the display
    public static int indentLeft; //indent of the left of the display
    public static int sizeFieldOfPx;
    public static int touchI;//coordinates of touch on chess field
    public static int touchJ;//coordinates of touch on chess field
    public static int countToMove;
    public static int[][] checkersPositions = new int[sizeOfField][sizeOfField];//positions all checkers on field
    public static ArrayList<Button> buttonsLevelList = new ArrayList<>();
    public static ImageView[] imageViewCheckersWhite = new ImageView[countWhiteCheckers];
    public static ImageView[] imageViewCheckersBlack = new ImageView[countBlackCheckers];
    public static boolean gameOver = false;
    public static DrawView drawView;
    public static ViewGroup frameLayoutLevels;
    public static int widthLayout = 100;
    public static int heightLayout = 100;





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
        field4x4 = findViewById(R.id.imageField4x4);
        checkMark = findViewById(R.id.checkMark);
        frameLayoutLevels = findViewById(R.id.frameLayoutLevels);













        //read touch on field
        field4x4.setOnTouchListener(this);

        //
        sizeFieldOfPx = widthDisplay - widthDisplay/6;
        indentTop = (heightDisplay - widthDisplay)/2;
        indentLeft = widthDisplay/12;
        stepOnField = sizeFieldOfPx / (sizeOfField - 1);
        widthLayout = frameLayoutLevels.getWidth();
        heightLayout = frameLayoutLevels.getHeight();



        //added black checkers
        imageViewCheckersBlack[0]=findViewById(R.id.imageBlackCh1);
        imageViewCheckersBlack[1]=findViewById(R.id.imageBlackCh2);
        imageViewCheckersBlack[2]=findViewById(R.id.imageBlackCh3);
        imageViewCheckersBlack[3]=findViewById(R.id.imageBlackCh4);
        imageViewCheckersBlack[4]=findViewById(R.id.imageBlackCh5);
        imageViewCheckersBlack[5]=findViewById(R.id.imageBlackCh6);
        imageViewCheckersBlack[6]=findViewById(R.id.imageBlackCh7);
        imageViewCheckersBlack[7]=findViewById(R.id.imageBlackCh8);
        imageViewCheckersBlack[8]=findViewById(R.id.imageBlackCh9);
        imageViewCheckersBlack[9]=findViewById(R.id.imageBlackCh10);
        imageViewCheckersBlack[10]=findViewById(R.id.imageBlackCh11);
        imageViewCheckersBlack[11]=findViewById(R.id.imageBlackCh12);

        //added white checkers
        imageViewCheckersWhite[0]=findViewById(R.id.imageWhiteCh1);
        imageViewCheckersWhite[1]=findViewById(R.id.imageWhiteCh2);
        imageViewCheckersWhite[2]=findViewById(R.id.imageWhiteCh3);
        imageViewCheckersWhite[3]=findViewById(R.id.imageWhiteCh4);
        imageViewCheckersWhite[4]=findViewById(R.id.imageWhiteCh5);
        imageViewCheckersWhite[5]=findViewById(R.id.imageWhiteCh6);
        imageViewCheckersWhite[6]=findViewById(R.id.imageWhiteCh7);
        imageViewCheckersWhite[7]=findViewById(R.id.imageWhiteCh8);
        imageViewCheckersWhite[8]=findViewById(R.id.imageWhiteCh9);
        imageViewCheckersWhite[9]=findViewById(R.id.imageWhiteCh10);
        imageViewCheckersWhite[10]=findViewById(R.id.imageWhiteCh11);
        imageViewCheckersWhite[11]=findViewById(R.id.imageWhiteCh12);

        //button return to Menu
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLevels.this, ActivityStart.class);
                startActivity(intent);
            }
        });






        //add levels
        buttonsLevelList.add(findViewById(R.id.buttonLevel1));
        buttonsLevelList.add(findViewById(R.id.buttonLevel2));
        buttonsLevelList.add(findViewById(R.id.buttonLevel3));


        buttonsLevelList.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startLevel1();
                drawView = new DrawView(getApplicationContext());
                frameLayoutLevels.addView(drawView);
                startLevel1();
            }
        });


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //get coordinates of touch
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        //convert coordinates X,Y in step on chess field
        touchI = touchY/stepOnField+1;
        touchJ = touchX/stepOnField+1;

        System.out.println("_____touch I and J : "+touchI+","+touchJ);

        //start move on the field

        touchOnField();


        return false;
    }

    /*public void moveToMenu(){
        Intent intent = new Intent(this, ActivityStart.class);
        startActivity(intent);
    }*/



}