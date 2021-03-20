package com.nokhrin.corners.multiplayer.start;




import com.nokhrin.corners.multiplayer.ActivityMultiplayerGame;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.ROLE_HOST;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class StartGame extends com.nokhrin.corners.game.StartGame {
    private int sizeOfField = 9; //size of field +1
    private int countTargetPoint = 12; //count of checker
    private int stepOnField; // step on chess field and size of checkers
    private int[][] checkersPositions; //positions all checkers on field
    private int win;
    private boolean playerMove;



    public void addStartParameters(ActivityMultiplayerGame activity) {
        //update variables for this game
        stepOnField = activity.widthDisplay / (sizeOfField - 1);

        //create matrix
        checkersPositions = new int[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }

        //add checker on start positions
        //start white checkers position
        if(activity.role == ROLE_HOST){
            for (int i = 6; i < sizeOfField; i++) {
                for (int j = 1; j < 5; j++) {
                    checkersPositions[i][j] = WHITE_CHECKER;
                }
            }

            //and target position for white checkers
            for (int i = 1; i < 4; i++) {
                for (int j = 5; j < sizeOfField; j++) {
                    checkersPositions[i][j] = BLACK_CHECKER;
                }
            }

            //mark player can move
            playerMove = true;
        }else{
            for (int i = 6; i < sizeOfField; i++) {
                for (int j = 1; j < 5; j++) {
                    checkersPositions[i][j] = BLACK_CHECKER;
                }
            }

            //start white checkers position
            for (int i = 1; i < 4; i++) {
                for (int j = 5; j < sizeOfField; j++) {
                    checkersPositions[i][j] = WHITE_CHECKER;
                }
            }
            //mark player can move
            playerMove = false;
        }

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
