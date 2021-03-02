package com.nokhrin.corners;

import android.view.View;

import static com.nokhrin.corners.MainActivity.checkMark;
import static com.nokhrin.corners.MainActivity.chessField;
import static com.nokhrin.corners.MainActivity.countBlackCheckers;
import static com.nokhrin.corners.MainActivity.countWhiteCheckers;
import static com.nokhrin.corners.MainActivity.imageViewCheckersBlack;
import static com.nokhrin.corners.MainActivity.imageViewCheckersWhite;
import static com.nokhrin.corners.MainActivity.indentTop;
import static com.nokhrin.corners.MainActivity.sizeOfField;
import static com.nokhrin.corners.MainActivity.stepOnField;
import static com.nokhrin.corners.MainActivity.widthDisplay;

public class DrawField {

    //Отображает пешки согласно двумерному массиву checkersPositions
    //0 = пешки отсутствуют    1 = белые пешки    -1 = черные пешки
    public static void drawField(){
        int numberBlackCheckers = countBlackCheckers - 1;
        int numberWhiteCheckers = countWhiteCheckers - 1;
        chessField.layout(0, indentTop,widthDisplay, widthDisplay+ indentTop);
        checkMark.setVisibility(View.INVISIBLE);


        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){

                //draw black checkers
                if(GameMatrix.checkersPositions[i][j]==-1){
                    imageViewCheckersBlack[numberBlackCheckers].layout((j-1)* stepOnField,
                            (i-1)*stepOnField+indentTop,
                            (j-1)* stepOnField+ stepOnField,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    imageViewCheckersBlack[numberBlackCheckers].setVisibility(View.VISIBLE);
                    numberBlackCheckers--;
                }

                //draw white checkers
                if(GameMatrix.checkersPositions[i][j]==1){
                    imageViewCheckersWhite[numberWhiteCheckers].layout((j-1)* stepOnField,
                            (i-1)* stepOnField+ indentTop,
                            (j-1)* stepOnField+ stepOnField,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    imageViewCheckersWhite[numberWhiteCheckers].setVisibility(View.VISIBLE);
                    numberWhiteCheckers--;
                }

                //draw white check
                //and draw check mark on checker
                if(GameMatrix.checkersPositions[i][j]==2){
                    imageViewCheckersWhite[numberWhiteCheckers].layout((j-1)* stepOnField,
                            (i-1)* stepOnField+ indentTop,
                            (j-1)* stepOnField+ stepOnField,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    imageViewCheckersWhite[numberWhiteCheckers].setVisibility(View.VISIBLE);
                    numberWhiteCheckers--;

                    checkMark.layout((j-1)* stepOnField,
                            (i-1)* stepOnField+ indentTop,
                            (j-1)* stepOnField+ stepOnField,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    checkMark.setVisibility(View.VISIBLE);
                }

            }
        }
    }
}
