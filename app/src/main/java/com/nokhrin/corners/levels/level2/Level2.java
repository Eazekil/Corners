package com.nokhrin.corners.levels.level2;

import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countPointInLevel;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.PlayerMove.playerStartMove;
import static com.nokhrin.corners.levels.start.StartForLevel.addStartParameters;

public class Level2 {

    public static void startLevel() {
        //add start parameters
        sizeOfField = 5; //size field + 1
        countToMove = 10; //count of move player can
        countPointInLevel = 3; //count target point

        //add start parameters
        addStartParameters();

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
