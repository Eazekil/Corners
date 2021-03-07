package com.nokhrin.corners.levels.level1;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import static com.nokhrin.corners.classical.GameMatrix.touchOnField;
import static com.nokhrin.corners.levels.ActivityLevels.buttonsLevelList;
import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.field4x4;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.ActivityLevels.stepOnField;
import static com.nokhrin.corners.levels.DrawFieldLevel.drawField;
import static com.nokhrin.corners.levels.PlayerMove.playerStartMove;

public class Level1{


    public static void startLevel1(){

        //invisible all buttons level
        for(Button button : buttonsLevelList){
            button.setVisibility(View.INVISIBLE);
        }

        //set visible field
        field4x4.setVisibility(View.VISIBLE);

        //
        playerStartMove();



        //add checkers on field
        for(int i=1;i<sizeOfField;i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = 0;
            }
        }

        checkersPositions[4][1] = 1;
        checkersPositions[4][2] = 1;

        drawField();

    }

}
