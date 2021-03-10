package com.nokhrin.corners.levels.level4;

import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countPointInLevel;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.PlayerMove.playerStartMove;
import static com.nokhrin.corners.levels.start.StartForLevel.addStartParameters;

public class Level4 {
    public static void startLevel() {
        //add start parameters
        sizeOfField = 6; //size field + 1
        countToMove = 10; //count of move player can
        countPointInLevel = 4; //count target point

        //add start parameters
        addStartParameters();

        //add checkers on start positions
        //for white checkers
        checkersPositions[5][1] = 1;
        checkersPositions[5][2] = 1;
        checkersPositions[4][1] = 1;
        checkersPositions[4][2] = 1;
        checkersPositions[3][3] = 3;
        //for target points
        marksPositions[1][4] = 31;
        marksPositions[1][5] = 31;
        marksPositions[2][4] = 31;
        marksPositions[2][5] = 31;



        ////////////////////////////////////////////// copy this for other level
        /*//add start parameters
        sizeOfField = 6; //size field + 1
        countToMove = 12; //count of move player can
        countPointInLevel = 6; //count target point

        //add start parameters
        addStartParameters();

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
        marksPositions[2][3] = 31;*/

        //start game
        playerStartMove();
    }
}
