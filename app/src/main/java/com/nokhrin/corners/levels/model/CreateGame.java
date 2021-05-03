package com.nokhrin.corners.levels.model;

import com.nokhrin.corners.levels.database.LevelsDb;
import com.nokhrin.corners.levels.database.ReadDb;

import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.STONE_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class CreateGame {
    private ReadDb readDb;
    private int numberLevel;
    //private StartGame startGame;
    private LevelsDb levelsDb;
    private int[][] checkersPositions;
    private int[][] marksPositions;

    public void createGame(){
        readDb.setLevelsDb(levelsDb);
        readDb.read(numberLevel);

        //add start parameters
        int sizeOfField = readDb.getSizeField();
        int countToMove = readDb.getCountMove();
        int countPointInLevel = readDb.getCountPoint();
        ArrayList<Integer> whiteI = readDb.getWhiteI();
        ArrayList<Integer> whiteJ = readDb.getWhiteJ();
        ArrayList<Integer> stoneI = readDb.getStoneI();
        ArrayList<Integer> stoneJ = readDb.getStoneJ();
        ArrayList<Integer> pointI = readDb.getPointI();
        ArrayList<Integer> pointJ = readDb.getPointJ();
        //int minCountMove = 7;

        checkersPositions = new int[sizeOfField][sizeOfField];
        marksPositions = new int[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }

        for(int i=0;i<whiteI.size();i++){
            checkersPositions[whiteI.get(i)][whiteJ.get(i)] = WOODMAN_CHECKER;
        }
        for(int i=0;i<stoneI.size();i++){
            checkersPositions[stoneI.get(i)][stoneJ.get(i)] = STONE_CHECKER;
        }
        for(int i=0;i<pointI.size();i++){
            marksPositions[pointI.get(i)][pointJ.get(i)] = TARGET_POINT_FOR_WHITE_CHECKER;
        }

        //add start parameters
        //startGame.addStartParameters(sizeOfField, countToMove, countPointInLevel, checkersPositions, marksPositions);
    }

    public void setNumberLevel(int numberLevel) {
        this.numberLevel = numberLevel;
    }


    public void setLevelsDb(LevelsDb levelsDb) {
        this.levelsDb = levelsDb;
    }
}
