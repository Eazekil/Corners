package com.nokhrin.corners.levels.level9;

import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countPointInLevel;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.PlayerMove.playerStartMove;
import static com.nokhrin.corners.levels.start.StartForLevel.addStartParameters;

public class Level9 {
    public static void startLevel() {
        //add start parameters
        sizeOfField = 7; //size field + 1
        countToMove = 15; //count of move player can
        countPointInLevel = 6; //count target point

        //add start parameters
        addStartParameters();

        //add checkers on start positions
        //for white checkers
        checkersPositions[4][1] = 1;
        checkersPositions[5][1] = 1;
        checkersPositions[5][2] = 1;
        checkersPositions[6][1] = 1;
        checkersPositions[6][2] = 1;
        checkersPositions[6][3] = 1;
        //for target points
        marksPositions[1][4] = 31;
        marksPositions[1][5] = 31;
        marksPositions[1][6] = 31;
        marksPositions[2][5] = 31;
        marksPositions[2][6] = 31;
        marksPositions[3][6] = 31;

        //start game
        playerStartMove();
    }
}
