package com.nokhrin.corners;

public class MoveForBot {
    private int positionsForBot[][];
    private Move move = new Move();
    int count=1;

    //start here
    public void setPositions(int[][] positions) {
        this.positionsForBot = positions;

        //add positions for class Move
        move.setCurrentPositions(positionsForBot);

        //find positions all black checkers
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(positionsForBot[i][j] == -1){
                    moveAdd(i,j);
                }
            }
        }

    }


    //find all move for this checker
    public void moveAdd(int i, int j){

        //add choice checker
        move.setCurrentIJ(i,j);

        //find all move for choice checker
        move.stepRight(i,j);
        move.stepLeft(i,j);
        move.stepBottom(i,j);
        move.stepTop(i,j);

        move.jumpRight(i,j);
        move.jumpLeft(i,j);
        move.jumpBottom(i,j);
        move.jumpTop(i,j);
    }

}
