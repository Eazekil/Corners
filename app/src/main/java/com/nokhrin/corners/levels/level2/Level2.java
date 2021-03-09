package com.nokhrin.corners.levels.level2;

import android.view.View;

import static com.nokhrin.corners.ActivityStart.widthDisplay;
import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countMoveView;
import static com.nokhrin.corners.levels.ActivityLevels.countPointInLevel;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.ActivityLevels.sizePoint;
import static com.nokhrin.corners.levels.ActivityLevels.stepOnField;
import static com.nokhrin.corners.levels.PlayerMove.playerStartMove;
import static com.nokhrin.corners.levels.ResourcesBitmap.createBitmap;

public class Level2 {

    public static void startLevel2() {
        //add start parameters
        sizeOfField = 5; //size field + 1
        countToMove = 10; //count of move player can
        countPointInLevel = 3; //count target point

        //update variables for this level
        stepOnField = widthDisplay / (sizeOfField - 1);
        sizePoint = stepOnField /3;
        createBitmap();

        //add text
        countMoveView.setVisibility(View.VISIBLE);
        String s = "Ходов осталось : "+countToMove;
        countMoveView.setText(s);

        //create matrix
        checkersPositions = new int[sizeOfField][sizeOfField];
        marksPositions = new int[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = 0;
                marksPositions[i][j] = 0;
            }
        }

        //add checkers on start positions
        //for white checkers
        checkersPositions[4][1] = 1;
        checkersPositions[4][2] = 1;
        checkersPositions[3][1] = 1;
        //for target points
        marksPositions[1][3] = 31;
        marksPositions[1][4] = 31;
        marksPositions[2][4] = 31;

        //start game
        playerStartMove();
    }
}
