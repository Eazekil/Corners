package com.nokhrin.corners.levels.level3;


import com.nokhrin.corners.levels.view.ActivityLevels;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class Level3 {
    public void startLevel(ActivityLevels activity) {
        //add start parameters
        int sizeOfField = 6; //size field + 1
        int countToMove = 8; //count of move player can
        int countPointInLevel = 4; //count target point

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
        checkersPositions[5][1] = WOODMAN_CHECKER;
        checkersPositions[5][2] = WOODMAN_CHECKER;
        checkersPositions[4][1] = WOODMAN_CHECKER;
        checkersPositions[4][2] = WOODMAN_CHECKER;
        //for target points
        marksPositions[1][4] = TARGET_POINT_FOR_WHITE_CHECKER;
        marksPositions[1][5] = TARGET_POINT_FOR_WHITE_CHECKER;
        marksPositions[2][4] = TARGET_POINT_FOR_WHITE_CHECKER;
        marksPositions[2][5] = TARGET_POINT_FOR_WHITE_CHECKER;

        //add start parameters
        //activity.startGame.addStartParameters(sizeOfField, countToMove, countPointInLevel, checkersPositions, marksPositions);

    }
}
