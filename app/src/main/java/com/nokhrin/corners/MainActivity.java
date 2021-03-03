package com.nokhrin.corners;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.nokhrin.corners.DrawField.drawField;
import static com.nokhrin.corners.GameMatrix.startPositions;
import static com.nokhrin.corners.GameMatrix.touchOnField;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public static int countBlackCheckers=12;
    public static int countWhiteCheckers=13;
    public static int sizeOfField = 9;
    public static ImageView[] imageViewCheckersWhite = new ImageView[countWhiteCheckers];
    public static ImageView[] imageViewCheckersBlack = new ImageView[countBlackCheckers];
    public static ImageView[] imageViewCheckersInHome = new ImageView[countBlackCheckers];
    Button buttonStart;
    public static ImageView chessField;
    public static ImageView checkMark;
    TextView textForTest;
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
        setContentView(R.layout.activity_main);

        //find all element and save in variables
        chessField = findViewById(R.id.chessField);
        checkMark = findViewById(R.id.checkMark);
        buttonStart=findViewById(R.id.buttonStart);
        textForTest=findViewById(R.id.textForTest);

        //button start game
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //add checkers on a start positions
                startPositions();

                drawField();
                chessField.setVisibility(View.VISIBLE);
            }
        });

        //read touch on field
        chessField.setOnTouchListener(this);

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        heightDisplay = size.y;
        stepOnField = (widthDisplay)/(sizeOfField-1);
        indentTop =heightDisplay/partValueOfDisplay;


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
        imageViewCheckersWhite[0]=findViewById(R.id.imageEror1);
        imageViewCheckersWhite[1]=findViewById(R.id.imageWhiteCh1);
        imageViewCheckersWhite[2]=findViewById(R.id.imageWhiteCh2);
        imageViewCheckersWhite[3]=findViewById(R.id.imageWhiteCh3);
        imageViewCheckersWhite[4]=findViewById(R.id.imageWhiteCh4);
        imageViewCheckersWhite[5]=findViewById(R.id.imageWhiteCh5);
        imageViewCheckersWhite[6]=findViewById(R.id.imageWhiteCh6);
        imageViewCheckersWhite[7]=findViewById(R.id.imageWhiteCh7);
        imageViewCheckersWhite[8]=findViewById(R.id.imageWhiteCh8);
        imageViewCheckersWhite[9]=findViewById(R.id.imageWhiteCh9);
        imageViewCheckersWhite[10]=findViewById(R.id.imageWhiteCh10);
        imageViewCheckersWhite[11]=findViewById(R.id.imageWhiteCh11);
        imageViewCheckersWhite[12]=findViewById(R.id.imageWhiteCh12);


        //added home checkers
        imageViewCheckersInHome[0]=findViewById(R.id.imageHome1);
        imageViewCheckersInHome[1]=findViewById(R.id.imageHome2);
        imageViewCheckersInHome[2]=findViewById(R.id.imageHome3);
        imageViewCheckersInHome[3]=findViewById(R.id.imageHome4);
        imageViewCheckersInHome[4]=findViewById(R.id.imageHome5);
        imageViewCheckersInHome[5]=findViewById(R.id.imageHome6);
        imageViewCheckersInHome[6]=findViewById(R.id.imageHome7);
        imageViewCheckersInHome[7]=findViewById(R.id.imageHome8);
        imageViewCheckersInHome[8]=findViewById(R.id.imageHome9);
        imageViewCheckersInHome[9]=findViewById(R.id.imageHome10);
        imageViewCheckersInHome[10]=findViewById(R.id.imageHome11);
        imageViewCheckersInHome[11]=findViewById(R.id.imageHome12);

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