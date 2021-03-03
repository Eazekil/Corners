package com.nokhrin.corners;

import static com.nokhrin.corners.GameMatrix.checkersPositions;
import static com.nokhrin.corners.GameMatrix.choiceI;
import static com.nokhrin.corners.GameMatrix.choiceJ;
import static com.nokhrin.corners.MainActivity.sizeOfField;

public class PossibleMoves {
    private static boolean[][] resultPossibleMoves = new boolean[sizeOfField][sizeOfField];
    private static  boolean[][] lastPlayerPositions = new boolean[9][9];

    public static boolean possibleMoves(int endI, int endJ){
        //possibleStep();
        return resultPossibleMoves[endI][endJ];
    }


    //find all move for choice checker
    public static void possibleStep(){

        //clear resultPossibleMoves matrix
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                resultPossibleMoves[i][j] = false;
            }
        }

        //clear last Player moves matrix
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                lastPlayerPositions[i][j] = false;
            }
        }

        stepRightWhite();
        stepLeftWhite();
        stepBottomWhite();
        stepTopWhite();

        jumpRightWhite(choiceI,choiceJ);
        jumpLeftWhite(choiceI,choiceJ);
        jumpBottomWhite(choiceI,choiceJ);
        jumpTopWhite(choiceI,choiceJ);

    }


    //can step on right
    public static void stepRightWhite(){
        if(choiceJ+1 < sizeOfField){
            resultPossibleMoves[choiceI][choiceJ+1] = checkersPositions[choiceI][choiceJ+1] == 0;
        }
    }

    //can step on left
    public static void stepLeftWhite(){
        if(choiceJ-1 > 0){
            resultPossibleMoves[choiceI][choiceJ-1] = checkersPositions[choiceI][choiceJ-1] == 0;
        }
    }

    //can step on bottom
    public static void stepBottomWhite(){
        if(choiceI+1 < sizeOfField){
            resultPossibleMoves[choiceI+1][choiceJ] = checkersPositions[choiceI+1][choiceJ] == 0;
        }
    }

    //can step on top
    public static void stepTopWhite(){
        if(choiceI-1 < sizeOfField){
            resultPossibleMoves[choiceI-1][choiceJ] = checkersPositions[choiceI-1][choiceJ] == 0;
        }
    }

    //can two step on right
    public static void jumpRightWhite(int i, int j){
        if(j+2 < sizeOfField){
            if(checkersPositions[i][j+1] != 0 && checkersPositions[i][j+2] == 0 && !lastPlayerPositions[i][j+2]){
                resultPossibleMoves[i][j+2] = true;

                //mark this position like last position
                lastPlayerPositions[i][j+2] = true;

                //can jump more
                jumpRightWhite(i,j+2);
                jumpBottomWhite(i, j+2);
                jumpTopWhite(i,j+2);
            }
        }
    }

    //can two step on left
    public static void jumpLeftWhite(int i, int j){
        boolean result = false;
        if(j-2 > 0){
            if(checkersPositions[i][j-1] != 0 && checkersPositions[i][j-2] == 0 && !lastPlayerPositions[i][j-2]){
                resultPossibleMoves[i][j-2] = true;

                //mark this position like last position
                lastPlayerPositions[i][j-2] = true;

                //can jump more
                jumpLeftWhite(i,j-2);
                jumpBottomWhite(i, j-2);
                jumpTopWhite(i,j-2);
            }
        }
    }

    //can two step on bottom
    public static void jumpBottomWhite(int i, int j){
        boolean result = false;
        if(i+2 < sizeOfField){
            if(checkersPositions[i+1][j] != 0 && checkersPositions[i+2][j] == 0 && !lastPlayerPositions[i+2][j]){
                resultPossibleMoves[i+2][j] = true;

                //mark this position like last position
                lastPlayerPositions[i+2][j] = true;

                //can jump more
                jumpBottomWhite(i+2, j);
                jumpRightWhite(i+2,j);
                jumpLeftWhite(i+2,j);
            }
        }
    }

    //can two step on top
    public static void jumpTopWhite(int i, int j){
        boolean result = false;
        if(i-2 > 0){
            if(checkersPositions[i-1][j] != 0 && checkersPositions[i-2][j] == 0 && !lastPlayerPositions[i-2][j]){
                resultPossibleMoves[i-2][j] = true;

                //mark this position like last position
                lastPlayerPositions[i-2][j] = true;

                //can jump more
                jumpTopWhite(i-2,j);
                jumpRightWhite(i-2,j);
                jumpLeftWhite(i-2,j);
            }
        }
    }
}
