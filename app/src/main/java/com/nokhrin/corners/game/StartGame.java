package com.nokhrin.corners.game;

public class StartGame {
    private int sizeOfField; //size of field +1
    private int countTargetPoint; //count of checker
    private int stepOnField; // step on chess field and size of checkers
    private int[][] checkersPositions; //positions all checkers on field
    private int win = 0;
    private boolean playerMove;

    public int getSizeOfField() {
        return sizeOfField;
    }

    public int getStepOnField() {
        return stepOnField;
    }

    public int[][] getCheckersPositions() {
        return checkersPositions;
    }

    public int getCountTargetPoint() {
        return countTargetPoint;
    }

    public int getWin() {
        return win;
    }

    public boolean isPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(boolean playerMove) {
        this.playerMove = playerMove;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
