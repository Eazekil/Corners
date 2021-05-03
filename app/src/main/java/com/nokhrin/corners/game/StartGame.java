package com.nokhrin.corners.game;


import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public abstract class StartGame {
    protected int sizeOfField; //size of field +1
    protected int countTargetPoint; //count of checker
    protected int stepOnField; // step on chess field and size of checkers
    protected int[][] checkerPositions; //positions all checkers on field
    protected int win;
    protected boolean isPlayerMove;

    public StartGame(){
    }

    public int getSizeOfField() {
        return sizeOfField;
    }

    public int[][] getCheckerPositions() {
        return checkerPositions;
    }

    public int getCountTargetPoint() {
        return countTargetPoint;
    }

    public int getStepOnField() {
        return stepOnField;
    }

    public int getWin() {
        return win;
    }

    public boolean isPlayerMove() {
        return isPlayerMove;
    }

    public void setPlayerMove(boolean playerMove) {
        this.isPlayerMove = playerMove;
    }

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = new int[checkerPositions.length][checkerPositions.length];
        this.sizeOfField = checkerPositions.length;

        int count = 0;
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                this.checkerPositions[i][j] = checkerPositions[i][j];

                if(checkerPositions[i][j] == WHITE_CHECKER){
                    count++;
                }
            }
        }

        this.countTargetPoint = count;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
