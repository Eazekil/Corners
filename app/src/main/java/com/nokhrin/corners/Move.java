package com.nokhrin.corners;

import static com.nokhrin.corners.MainActivity.sizeOfField;

public class Move {
    private int currentI;
    private int currentJ;
    private int currentPositions[][] = new int [sizeOfField][sizeOfField];
    public static EvaluationFunction evaluationFunction = new EvaluationFunction();
    int count=1;

    public void setCurrentPositions(int[][] setCurrentPositions) {
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                currentPositions[i][j] = setCurrentPositions[i][j];
            }
        }
    }

    public void setCurrentIJ(int currentI, int currentJ) {
        this.currentI = currentI;
        this.currentJ = currentJ;
    }



    //can step on right
    public boolean stepRight(int i, int j){

        boolean result = false;
        if(j+1 < sizeOfField){
            if(currentPositions[i][j+1] == 0){
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI, currentJ +1);
            }
        }
        return result;
    }

    //can step on left
    public boolean stepLeft(int i, int j){
        boolean result = false;
        if(j-1 > 0){
            if(currentPositions[i][j-1] == 0){
                count++;
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI, currentJ -1);
            }
        }
        return result;
    }

    //can step on bottom
    public boolean stepBottom(int i, int j){
        boolean result = false;
        if(i+1 < sizeOfField){
            if(currentPositions[i+1][j] == 0){
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI + 1, currentJ);
            }
        }
        return result;
    }

    //can step on top
    public boolean stepTop(int i, int j){
        boolean result = false;
        if(i-1 > 0){
            if(currentPositions[i-1][j] == 0){
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI - 1, currentJ);
            }
        }
        return result;
    }

    //can two step on right
    public boolean jumpRight(int i, int j){
        boolean result = false;
        if(j+2 < sizeOfField){
            if(currentPositions[i][j+1] != 0 && currentPositions[i][j+2] == 0){
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI, currentJ + 2);

                //can jump more
                jumpRight(i,j+2);
                jumpBottom(i, j+2);
                jumpTop(i,j+2);
            }
        }
        return result;
    }

    //can two step on left
    public boolean jumpLeft(int i, int j){
        boolean result = false;
        if(j-2 > 0){
            if(currentPositions[i][j-1] != 0 && currentPositions[i][j-2] == 0){
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI, currentJ - 2);

                //can jump more
                jumpLeft(i,j-2);
                jumpBottom(i, j-2);
                jumpTop(i,j-2);
            }
        }
        return result;
    }

    //can two step on bottom
    public boolean jumpBottom(int i, int j){
        boolean result = false;
        if(i+2 < sizeOfField){
            if(currentPositions[i+1][j] != 0 && currentPositions[i+2][j] == 0){
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI + 2, currentJ);

                //can jump more
                jumpBottom(i+2, j);
                jumpRight(i+2,j);
                jumpLeft(i+2,j);
            }
        }
        return result;
    }

    //can two step on top
    public boolean jumpTop(int i, int j){
        boolean result = false;
        if(i-2 > 0){
            if(currentPositions[i-1][j] != 0 && currentPositions[i-2][j] == 0){
                result = true;

                //calculate evaluation function for this position
                evaluationFunction.setNewPositions(currentPositions, currentI, currentJ, currentI - 2, currentJ);

                //can jump more
                jumpTop(i-2,j);
                jumpRight(i-2,j);
                jumpLeft(i-2,j);
            }
        }
        return result;
    }





}
