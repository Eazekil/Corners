package com.nokhrin.corners.classical;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;

import static com.nokhrin.corners.classical.GameMatrix.touchOnField;
import static com.nokhrin.corners.classical.DrawField.drawField;
import static com.nokhrin.corners.classical.GameMatrix.startPositions;


public class ActivityClassic extends AppCompatActivity implements View.OnTouchListener {
    private View classicLayout;
    public static int countBlackCheckers=12;
    public static int countWhiteCheckers=12;
    public static int sizeOfField = 9;
    public static ImageView[] imageViewCheckersWhite = new ImageView[countWhiteCheckers];
    public static ImageView[] imageViewCheckersBlack = new ImageView[countBlackCheckers];
    public static Button buttonStart;
    public static Button buttonMenu;
    public static Button buttonRestart;
    public static ImageView chessField;
    public static ImageView checkMark;
    public static ImageView playerWin;
    public static ImageView playerLoose;
    public static ImageView winWin;
    public static TextView textForTest;
    public static  int widthDisplay;
    public static int heightDisplay;
    public static int stepOnField; // step on chess field and size of checkers
    public static int indentTop; //indent of the top of the display
    int partValueOfDisplay = 20; //for indent
    public static int touchI;//coordinates of touch on chess field
    public static int touchJ;//coordinates of touch on chess field

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this all for make full screen
        setContentView(R.layout.activity_classic);
        classicLayout = findViewById(R.id.ConstrainLayoutClassic);
        classicLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //find all element and save in variables
        chessField = findViewById(R.id.chessField);
        checkMark = findViewById(R.id.checkMark);
        buttonStart=findViewById(R.id.buttonStartClassic);
        buttonMenu=findViewById(R.id.buttonMenu);
        buttonRestart=findViewById(R.id.buttonRestart);
        playerWin=findViewById(R.id.imagePlayerWin);
        playerLoose=findViewById(R.id.imagePlayerLoose);
        winWin=findViewById(R.id.imageWinWin);

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


        //read touch on field
        chessField.setOnTouchListener(this);

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        heightDisplay = size.y;
        stepOnField = (widthDisplay)/(sizeOfField-1);
        indentTop =(heightDisplay - widthDisplay)/2;

        //button start game
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set invisible other view
                buttonStart.setVisibility(View.INVISIBLE);
                buttonMenu.setVisibility(View.VISIBLE);
                buttonRestart.setVisibility(View.VISIBLE);
                buttonStart.setVisibility(View.INVISIBLE);
                playerWin.setVisibility(View.INVISIBLE);
                playerLoose.setVisibility(View.INVISIBLE);
                winWin.setVisibility(View.INVISIBLE);

                //add checkers on a start positions
                startPositions();

                drawField();
                chessField.setVisibility(View.VISIBLE);
            }
        });

        //button return to Menu
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityClassic.this, ActivityStart.class);
                startActivity(intent);
            }
        });

        //button restart this game
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add checkers on a start positions
                startPositions();

                //update
                drawField();
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

        //start move on the field
        touchOnField();

        return false;
    }
}