package com.nokhrin.corners.classical.model;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class Positions {
    private StartGameClassic startGame;
    private int[][] checkersPositions;

    public void setStartGame(StartGameClassic startGame) {
        this.startGame = startGame;
        checkersPositions = startGame.getCheckerPositions();
    }

    public void updateMark(int startI, int startJ, int endI, int endJ){
        checkersPositions[endI][endJ] = MARK_ON_WHITE_CHECKER;
        checkersPositions[startI][startJ] = WHITE_CHECKER;

        startGame.getDrawView().setCheckerPositions(checkersPositions);
        startGame.getDrawView().invalidate();
    }

    public void setMark(int i, int j){
        checkersPositions[i][j] = MARK_ON_WHITE_CHECKER;

        startGame.getDrawView().setCheckerPositions(checkersPositions);
        startGame.getDrawView().invalidate();
    }

    public void moveChecker(int startI, int startJ, int endI, int endJ, int checker){
        checkersPositions[endI][endJ] = checker;
        checkersPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
    }
}
