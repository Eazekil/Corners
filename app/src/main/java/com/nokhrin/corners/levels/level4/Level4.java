package com.nokhrin.corners.levels.level4;

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

public class Level4 {
    public static void startLevel4() {
        //add start parameters
        sizeOfField = 6; //size field + 1
        countToMove = 12; //count of move player can
        countPointInLevel = 6; //count target point

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
        checkersPositions[5][1] = 1;
        checkersPositions[5][2] = 1;
        checkersPositions[4][1] = 1;
        checkersPositions[4][2] = 1;
        checkersPositions[4][3] = 1;
        checkersPositions[5][3] = 1;
        //for target points
        marksPositions[1][4] = 31;
        marksPositions[1][5] = 31;
        marksPositions[2][4] = 31;
        marksPositions[2][5] = 31;
        marksPositions[1][3] = 31;
        marksPositions[2][3] = 31;

        //start game
        playerStartMove();
    }
}
