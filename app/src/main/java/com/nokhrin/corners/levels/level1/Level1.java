package com.nokhrin.corners.levels.level1;


import com.nokhrin.corners.levels.ActivityLevels;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;


public class Level1 {

    public void startLevel(ActivityLevels activity) {
        //add start parameters
        int sizeOfField = 5; //size field + 1
        int countToMove = 9; //count of move player can
        int countPointInLevel = 2; //count target point
        int minCountMove = 7;

        int[][] checkersPositions = new int[sizeOfField][sizeOfField];
        int[][] marksPositions = new int[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }

        //add checkers on start positions
        //for white checkers
        checkersPositions[4][1] = WOODMAN_CHECKER;
        checkersPositions[4][2] = WOODMAN_CHECKER;
        //for target points
        marksPositions[1][3] = TARGET_POINT_FOR_WHITE_CHECKER;
        marksPositions[1][4] = TARGET_POINT_FOR_WHITE_CHECKER;

        //add start parameters
        activity.startGame.addStartParameters(sizeOfField, countToMove, countPointInLevel, checkersPositions, marksPositions);
    }


}
