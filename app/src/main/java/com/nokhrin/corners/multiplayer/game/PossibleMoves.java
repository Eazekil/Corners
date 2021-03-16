package com.nokhrin.corners.multiplayer.game;

import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.choiceI;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.choiceJ;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.sizeOfField;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.checkersPositions;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;

public class PossibleMoves {
    public static boolean[][] resultPossibleMoves;
    public static  boolean[][] lastPlayerPositions;
    //public static  int[] steps;  //

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
            resultPossibleMoves[choiceI][choiceJ+1] = checkersPositions[choiceI][choiceJ+1] == FREE_POSITION_ON_FIELD;
        }
    }

    //can step on left
    public static void stepLeftWhite(){
        if(choiceJ-1 > 0){
            resultPossibleMoves[choiceI][choiceJ-1] = checkersPositions[choiceI][choiceJ-1] == FREE_POSITION_ON_FIELD;
        }
    }

    //can step on bottom
    public static void stepBottomWhite(){
        if(choiceI+1 < sizeOfField){
            resultPossibleMoves[choiceI+1][choiceJ] = checkersPositions[choiceI+1][choiceJ] == FREE_POSITION_ON_FIELD;
        }
    }

    //can step on top
    public static void stepTopWhite(){
        if(choiceI-1 < sizeOfField){
            resultPossibleMoves[choiceI-1][choiceJ] = checkersPositions[choiceI-1][choiceJ] == FREE_POSITION_ON_FIELD;
        }
    }

    //can two step on right
    public static void jumpRightWhite(int i, int j){
        if(j+2 < sizeOfField){
            if(checkersPositions[i][j+1] != FREE_POSITION_ON_FIELD && checkersPositions[i][j+2] == FREE_POSITION_ON_FIELD && !lastPlayerPositions[i][j+2]){
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
        if(j-2 > 0){
            if(checkersPositions[i][j-1] != FREE_POSITION_ON_FIELD && checkersPositions[i][j-2] == FREE_POSITION_ON_FIELD && !lastPlayerPositions[i][j-2]){
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
        if(i+2 < sizeOfField){
            if(checkersPositions[i+1][j] != FREE_POSITION_ON_FIELD && checkersPositions[i+2][j] == FREE_POSITION_ON_FIELD && !lastPlayerPositions[i+2][j]){
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
        if(i-2 > 0){
            if(checkersPositions[i-1][j] != FREE_POSITION_ON_FIELD && checkersPositions[i-2][j] == FREE_POSITION_ON_FIELD && !lastPlayerPositions[i-2][j]){
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
