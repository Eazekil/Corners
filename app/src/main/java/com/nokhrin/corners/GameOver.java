package com.nokhrin.corners;

import android.view.View;

import static com.nokhrin.corners.GameMatrix.checkersPositions;
import static com.nokhrin.corners.MainActivity.buttonStart;
import static com.nokhrin.corners.MainActivity.playerLoose;
import static com.nokhrin.corners.MainActivity.playerWin;
import static com.nokhrin.corners.MainActivity.sizeOfField;
import static com.nokhrin.corners.MainActivity.textForTest;
import static com.nokhrin.corners.MainActivity.winWin;

public class GameOver {
    public static boolean gameOver = false;

    public static void gameIsOver(){
        int countWhiteCheckersInHome = 0;
        int countBlackCheckersInHome = 0;

        for(int i=1;i<4;i++){
            for(int j=5;j<sizeOfField;j++){
                if(checkersPositions[i][j] == 1){
                    countWhiteCheckersInHome++;
                }
            }
        }

        for(int i=6;i<sizeOfField;i++){
            for(int j=1;j<5;j++){
                if(checkersPositions[i][j] == -1 || checkersPositions[i][j] == 3){
                    countBlackCheckersInHome++;
                }
            }
        }

        if(countWhiteCheckersInHome == 12 && countBlackCheckersInHome != 12){
            textForTest.setText("Святые шашки, ты выиграл!!!");
            textForTest.setVisibility(View.VISIBLE);
            buttonStart.setText("Играть снова");
            buttonStart.setVisibility(View.VISIBLE);
            playerWin.setVisibility(View.VISIBLE);
            gameOver = true;
        }

        if(countBlackCheckersInHome == 12 && countWhiteCheckersInHome != 12){
            textForTest.setText("Увы, бот тебя победил...");
            textForTest.setVisibility(View.VISIBLE);
            buttonStart.setText("Играть снова");
            buttonStart.setVisibility(View.VISIBLE);
            playerLoose.setVisibility(View.VISIBLE);
            gameOver = true;
        }

        if(countBlackCheckersInHome == 12 && countWhiteCheckersInHome == 12){
            textForTest.setText("Отличная игра, ничья!");
            textForTest.setVisibility(View.VISIBLE);
            buttonStart.setText("Играть снова");
            buttonStart.setVisibility(View.VISIBLE);
            winWin.setVisibility(View.VISIBLE);
            gameOver = true;
        }


    }
}
