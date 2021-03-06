package com.nokhrin.corners.classical;


import static com.nokhrin.corners.classical.EvaluationFunction.setNewPositions;
import static com.nokhrin.corners.classical.GameMatrix.checkersPositions;
import static com.nokhrin.corners.classical.ActivityClassic.sizeOfField;

public class Move {
    private static int currentI = -1;
    private static int currentJ = -1;
    private static  boolean[][] lastPositions = new boolean[9][9];


    public static void setCurrentIJ(int setCurrentI, int setCurrentJ) {
        currentI = setCurrentI;
        currentJ = setCurrentJ;

        //clear last moves matrix
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                lastPositions[i][j] = false;
            }
        }
    }

    //can step on right
    public static boolean stepRight(int i, int j){

        boolean result = false;
        if(j+1 < sizeOfField){
            if(checkersPositions[i][j+1] == 0){
                result = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i, j +1);
            }
        }
        return result;
    }

    //can step on left
    public static boolean stepLeft(int i, int j){
        boolean result = false;
        if(j-1 > 0){
            if(checkersPositions[i][j-1] == 0){
                result = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i, j -1);
            }
        }
        return result;
    }

    //can step on bottom
    public static boolean stepBottom(int i, int j){
        boolean result = false;
        if(i+1 < sizeOfField){
            if(checkersPositions[i+1][j] == 0){
                result = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i + 1, j);
            }
        }
        return result;
    }

    //can step on top
    public static boolean stepTop(int i, int j){
        boolean result = false;
        if(i-1 > 0){
            if(checkersPositions[i-1][j] == 0){
                result = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i - 1, j);
            }
        }
        return result;
    }

    //can two step on right
    public static boolean jumpRight(int i, int j){
        boolean result = false;
        if(j+2 < sizeOfField){
            //check neighboring position is vacant and this position is free and this position is not any last positions
            if(checkersPositions[i][j+1] != 0 && checkersPositions[i][j+2] == 0 && !lastPositions[i][j+2]){
                result = true;

                //mark this position like last position
                lastPositions[i][j+2] = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i, j + 2);

                //can jump more
                jumpRight(i,j+2);
                jumpBottom(i, j+2);
                jumpTop(i,j+2);
            }
        }
        return result;
    }

    //can two step on left
    public static boolean jumpLeft(int i, int j){
        boolean result = false;
        if(j-2 > 0){
            //check neighboring position is vacant and this position is free and this position is not any last positions
            if(checkersPositions[i][j-1] != 0 && checkersPositions[i][j-2] == 0 && !lastPositions[i][j-2]){
                result = true;

                //mark this position like last position
                lastPositions[i][j-2] = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i, j - 2);

                //can jump more
                jumpLeft(i,j-2);
                jumpBottom(i, j-2);
                jumpTop(i,j-2);
            }
        }
        return result;
    }

    //can two step on bottom
    public static boolean jumpBottom(int i, int j){
        boolean result = false;
        if(i+2 < sizeOfField){
            //check neighboring position is vacant and this position is free and this position is not any last positions
            if(checkersPositions[i+1][j] != 0 && checkersPositions[i+2][j] == 0 && !lastPositions[i+2][j]){
                result = true;

                //mark this position like last position
                lastPositions[i+2][j] = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i + 2, j);

                //can jump more
                jumpBottom(i+2, j);
                jumpRight(i+2,j);
                jumpLeft(i+2,j);
            }
        }
        return result;
    }

    //can two step on top
    public static boolean jumpTop(int i, int j){
        boolean result = false;
        if(i-2 > 0){
            //check neighboring position is vacant and this position is free and this position is not any last positions
            if(checkersPositions[i-1][j] != 0 && checkersPositions[i-2][j] == 0 && !lastPositions[i-2][j]){
                result = true;

                //mark this position like last position
                lastPositions[i-2][j] = true;

                //calculate evaluation function for this position
                setNewPositions(currentI, currentJ, i - 2, j);

                //can jump more
                jumpTop(i-2,j);
                jumpRight(i-2,j);
                jumpLeft(i-2,j);
            }
        }
        return result;
    }

}
