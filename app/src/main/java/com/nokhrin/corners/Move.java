package com.nokhrin.corners;


import static com.nokhrin.corners.EvaluationFunction.setNewPositions;
import static com.nokhrin.corners.MainActivity.sizeOfField;
import static com.nokhrin.corners.GameMatrix.checkersPositions;

public class Move {
    private static int currentI = -1;
    private static int currentJ = -1;


    public static void setCurrentIJ(int setCurrentI, int setCurrentJ) {
        currentI = setCurrentI;
        currentJ = setCurrentJ;
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
            if(checkersPositions[i][j+1] != 0 && checkersPositions[i][j+2] == 0){
                result = true;

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
            if(checkersPositions[i][j-1] != 0 && checkersPositions[i][j-2] == 0){
                result = true;

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
            if(checkersPositions[i+1][j] != 0 && checkersPositions[i+2][j] == 0){
                result = true;

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
            if(checkersPositions[i-1][j] != 0 && checkersPositions[i-2][j] == 0){
                result = true;

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
