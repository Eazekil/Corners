package com.nokhrin.corners.levels;

import android.view.View;

import static com.nokhrin.corners.levels.ActivityLevels.indentLeft;
import static com.nokhrin.corners.levels.ActivityLevels.indentTop;
import static com.nokhrin.corners.levels.ActivityLevels.checkMark;
import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countBlackCheckers;
import static com.nokhrin.corners.levels.ActivityLevels.countWhiteCheckers;
import static com.nokhrin.corners.levels.ActivityLevels.field4x4;
import static com.nokhrin.corners.levels.ActivityLevels.imageViewCheckersBlack;
import static com.nokhrin.corners.levels.ActivityLevels.imageViewCheckersWhite;
import static com.nokhrin.corners.levels.ActivityLevels.sizeFieldOfPx;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.ActivityLevels.stepOnField;

public class DrawFieldLevel {


    //Отображает пешки согласно двумерному массиву checkersPositions
    //0 = пешки отсутствуют    1 = белые пешки    -1 = черные пешки
    public static void drawField(){
        int numberBlackCheckers = countBlackCheckers - 1;
        int numberWhiteCheckers = countWhiteCheckers - 1;
        field4x4.layout(indentLeft, indentTop, indentLeft+sizeFieldOfPx, sizeFieldOfPx+ indentTop);
        checkMark.setVisibility(View.INVISIBLE);


        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){

                //draw black checker
                if(checkersPositions[i][j] == -1 || checkersPositions[i][j] == 3){
                    imageViewCheckersBlack[numberBlackCheckers].layout((j-1)* stepOnField + indentLeft,
                            (i-1)*stepOnField+indentTop,
                            (j-1)* stepOnField+ stepOnField + indentLeft,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    imageViewCheckersBlack[numberBlackCheckers].setVisibility(View.VISIBLE);
                    numberBlackCheckers--;
                }

                //draw white checker
                //and draw check mark on checker
                if(checkersPositions[i][j]==2){
                    imageViewCheckersWhite[numberWhiteCheckers].layout((j-1)* stepOnField + indentLeft,
                            (i-1)* stepOnField+ indentTop,
                            (j-1)* stepOnField+ stepOnField + indentLeft,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    imageViewCheckersWhite[numberWhiteCheckers].setVisibility(View.VISIBLE);
                    numberWhiteCheckers--;

                    checkMark.layout((j-1)* stepOnField + indentLeft,
                            (i-1)* stepOnField+ indentTop,
                            (j-1)* stepOnField+ stepOnField + indentLeft,
                            (i-1)* stepOnField+ indentTop + stepOnField);
                    checkMark.setVisibility(View.VISIBLE);
                }

                //draw white checker
                if(checkersPositions[i][j]==1){
                    imageViewCheckersWhite[numberWhiteCheckers].layout((j-1)* stepOnField + indentLeft,
                            (i-1) * stepOnField + indentTop,
                            (j-1) * stepOnField + stepOnField + indentLeft,
                            (i-1) * stepOnField + indentTop + stepOnField);
                    imageViewCheckersWhite[numberWhiteCheckers].setVisibility(View.VISIBLE);
                    numberWhiteCheckers--;
                }

            }
        }
    }
}
