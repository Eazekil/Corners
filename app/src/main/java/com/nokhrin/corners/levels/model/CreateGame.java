package com.nokhrin.corners.levels.model;

import com.nokhrin.corners.levels.database.ReadDb;

import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class CreateGame {
    private ReadDb readDb;

    public void createGame(){
        //add start parameters
        int sizeOfField = readDb.getSizeField();
        int countToMove = readDb.getCountMove();
        int countPointInLevel = readDb.getCountPoint();
        ArrayList<Integer> whiteI = readDb;
        ArrayList<Integer> whiteJ;
        ArrayList<Integer> stoneI;
        ArrayList<Integer> stoneJ;
        ArrayList<Integer> pointI;
        ArrayList<Integer> pointJ;
        //int minCountMove = 7;

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
    }

    public void setReadDb(ReadDb readDb) {
        this.readDb = readDb;
    }
}
