package com.nokhrin.corners.classical;

import android.view.View;

import static com.nokhrin.corners.classical.GameMatrix.checkersPositions;
import static com.nokhrin.corners.classical.ActivityClassic.checkMark;
import static com.nokhrin.corners.classical.ActivityClassic.chessField;
import static com.nokhrin.corners.classical.ActivityClassic.countBlackCheckers;
import static com.nokhrin.corners.classical.ActivityClassic.countWhiteCheckers;
import static com.nokhrin.corners.classical.ActivityClassic.imageViewCheckersBlack;
import static com.nokhrin.corners.classical.ActivityClassic.imageViewCheckersWhite;
import static com.nokhrin.corners.classical.ActivityClassic.indentTop;
import static com.nokhrin.corners.classical.ActivityClassic.sizeOfField;
import static com.nokhrin.corners.classical.ActivityClassic.stepOnField;
import static com.nokhrin.corners.classical.ActivityClassic.widthDisplay;

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

                //draw black checker
                if(checkersPositions[i][j] == -1 || checkersPositions[i][j] == 3){
                    imageViewCheckersBlack[numberBlackCheckers].layout((j-1)* stepOnField,
                            (i-1)*stepOnField+indentTop,
                            (j-1)* stepOnField+ stepOnField,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    imageViewCheckersBlack[numberBlackCheckers].setVisibility(View.VISIBLE);
                    numberBlackCheckers--;
                }

                //draw white checker
                //and draw check mark on checker
                if(checkersPositions[i][j]==2){
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

                //draw white checker
                if(checkersPositions[i][j]==1){
                    imageViewCheckersWhite[numberWhiteCheckers].layout((j-1)* stepOnField,
                            (i-1)* stepOnField+ indentTop,
                            (j-1)* stepOnField+ stepOnField,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    imageViewCheckersWhite[numberWhiteCheckers].setVisibility(View.VISIBLE);
                    numberWhiteCheckers--;
                }

            }
        }
    }
}
