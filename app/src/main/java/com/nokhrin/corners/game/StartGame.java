package com.nokhrin.corners.game;

public abstract class StartGame {
    protected int sizeOfField; //size of field +1
    protected int countTargetPoint; //count of checker
    protected int stepOnField; // step on chess field and size of checkers
    protected int[][] checkersPositions; //positions all checkers on field
    protected int win;
    protected boolean playerMove;

    public StartGame(){
    }

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
