package com.nokhrin.corners.levels.model;


import com.nokhrin.corners.game.StartGame;
import com.nokhrin.corners.levels.database.LevelsDb;
import com.nokhrin.corners.levels.database.ReadDb;
import com.nokhrin.corners.levels.view.ActivityGameLevel;

import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.STONE_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class StartGameLevel extends StartGame {
    private LevelsDb levelsDb;
    private ReadDb readDb;
    private int countToMove;
    private int countBronze;
    private int countSilver;
    private int countGold;
    private int[][] marksPositions;
    private PlayerMove move;
    private ActivityGameLevel activity;
    private GameOver gameOver;

    public void setNumberLevel(int numberLevel) {
        readDb = new ReadDb();
        readDb.setLevelsDb(levelsDb);
        readDb.read(numberLevel);
        addParameters();
    }

    private void addParameters() {
        sizeOfField = readDb.getSizeField();
        countToMove = readDb.getCountMove();
        countTargetPoint = readDb.getCountPoint();
        countBronze = countToMove;
        countSilver = readDb.getCountSilver();
        countGold = readDb.getCountGold();
        ArrayList<Integer> whiteI = readDb.getWhiteI();
        ArrayList<Integer> whiteJ = readDb.getWhiteJ();
        ArrayList<Integer> stoneI = readDb.getStoneI();
        ArrayList<Integer> stoneJ = readDb.getStoneJ();
        ArrayList<Integer> pointI = readDb.getPointI();
        ArrayList<Integer> pointJ = readDb.getPointJ();

        checkerPositions = new int[sizeOfField][sizeOfField];
        marksPositions = new int[sizeOfField][sizeOfField];
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkerPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }

        for(int i=0;i<whiteI.size();i++){
            checkerPositions[whiteI.get(i)][whiteJ.get(i)] = WOODMAN_CHECKER;
        }
        for(int i=0;i<stoneI.size();i++){
            checkerPositions[stoneI.get(i)][stoneJ.get(i)] = STONE_CHECKER;
        }
        for(int i=0;i<pointI.size();i++){
            marksPositions[pointI.get(i)][pointJ.get(i)] = TARGET_POINT_FOR_WHITE_CHECKER;

        }

        win = 0;
        isPlayerMove = true;

        ResultMoves resultMoves = new ResultMoves();
        resultMoves.setActivity(activity);

        move = new PlayerMove();
        move.setStartGameLevel(this);
        move.setResultMoves(resultMoves);

        gameOver = new GameOver();
        gameOver.setActivity(activity);
    }

    public void setLevelsDb(LevelsDb levelsDb) {
        this.levelsDb = levelsDb;
    }

    public int[][] getMarksPositions() {
        return marksPositions;
    }

    public PlayerMove getPlayerMove() {
        return move;
    }

    public void setActivity(ActivityGameLevel activity) {
        this.activity = activity;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public int getCountToMove() {
        return countToMove;
    }

    public void setCountToMove(int countToMove) {
        this.countToMove = countToMove;
    }

    public int getCountSilver() {
        return countSilver;
    }

    public int getCountGold() {
        return countGold;
    }

    public int getCountBronze() {
        return countBronze;
    }
}
