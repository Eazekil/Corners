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

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private static  int countBlackCheckers=12;
    private static  int countWhiteCheckers=12;
    private static ImageView[] imageViewCheckersWhite = new ImageView[countWhiteCheckers];
    private static ImageView[] imageViewCheckersBlack = new ImageView[countBlackCheckers];
    private static Button buttonStart;
    private static ImageView chessField;
    public static ImageView checkMark;
    private static TextView textForTest;


    GameMatrix gameMatrix = new GameMatrix();

    //Отображает пешки согласно двумерному массиву checkersPositions
    //0 = пешки отсутствуют    1 = белые пешки    -1 = черные пешки
    public static void drawField(){
        int numberBlackCheckers=countBlackCheckers-1;
        int numberWhiteCheckers=countWhiteCheckers-1;
        chessField.layout(0,GameMatrix.top,GameMatrix.widthDisplay,GameMatrix.widthDisplay+GameMatrix.top);
        checkMark.setVisibility(View.INVISIBLE);


        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){

                //draw black checkers
                if(GameMatrix.checkersPositions[i][j]==-1){
                    imageViewCheckersBlack[numberBlackCheckers].layout((j-1)*GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top,
                            (j-1)*GameMatrix.stepOnField+GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top+GameMatrix.stepOnField);
                    imageViewCheckersBlack[numberBlackCheckers].setVisibility(View.VISIBLE);
                    numberBlackCheckers--;
                }

                //draw white checkers
                if(GameMatrix.checkersPositions[i][j]==1){
                    imageViewCheckersWhite[numberWhiteCheckers].layout((j-1)*GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top,
                            (j-1)*GameMatrix.stepOnField+GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top+GameMatrix.stepOnField);
                    imageViewCheckersWhite[numberWhiteCheckers].setVisibility(View.VISIBLE);
                    numberWhiteCheckers--;
                }

                //draw white check
                //draw check mark on checker
                if(GameMatrix.checkersPositions[i][j]==2){
                    imageViewCheckersWhite[numberWhiteCheckers].layout((j-1)*GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top,
                            (j-1)*GameMatrix.stepOnField+GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top+GameMatrix.stepOnField);
                    imageViewCheckersWhite[numberWhiteCheckers].setVisibility(View.VISIBLE);
                    numberWhiteCheckers--;

                    checkMark.layout((j-1)*GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top,
                            (j-1)*GameMatrix.stepOnField+GameMatrix.stepOnField,
                            (i-1)*GameMatrix.stepOnField+GameMatrix.top+GameMatrix.stepOnField);
                    checkMark.setVisibility(View.VISIBLE);
                }

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chessField = findViewById(R.id.chessField);
        checkMark = findViewById(R.id.checkMark);
        buttonStart=findViewById(R.id.buttonStart);
        textForTest=findViewById(R.id.textForTest);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawField();
                chessField.setVisibility(View.VISIBLE);
            }
        });

        chessField.setOnTouchListener(this);

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        gameMatrix.setSize(size);

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
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gameMatrix.setTouch((int) event.getX(), (int) event.getY());
        //drawField();
        return false;
    }
}