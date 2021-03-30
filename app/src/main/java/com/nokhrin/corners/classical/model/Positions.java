package com.nokhrin.corners.classical.model;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class Positions {
    private ResultMoves resultMoves;
    private int[][] checkersPositions;

    public void setCheckersPositions(int[][] checkersPositions) {
        this.checkersPositions = checkersPositions;
    }

    public void setResultMoves(ResultMoves resultMoves) {
        this.resultMoves = resultMoves;
    }

    public void updateMark(int startI, int startJ, int endI, int endJ){
        checkersPositions[endI][endJ] = MARK_ON_WHITE_CHECKER;
        checkersPositions[startI][startJ] = WHITE_CHECKER;

        resultMoves.setCheckersPositions(checkersPositions);
        resultMoves.updateView();
    }

    public void setMark(int i, int j){
        checkersPositions[i][j] = MARK_ON_WHITE_CHECKER;

        resultMoves.setCheckersPositions(checkersPositions);
        resultMoves.updateView();
    }

    public void moveChecker(int startI, int startJ, int endI, int endJ, int checker){
        checkersPositions[endI][endJ] = checker;
        checkersPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
    }

    public ResultMoves getResultMoves() {
        return resultMoves;
    }
}
