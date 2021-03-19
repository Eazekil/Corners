package com.nokhrin.corners.classical;


import com.nokhrin.corners.resources.ResourcesBitmap;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class StartClassic {
    private int sizeOfField = 9; //size of field +1
    private int countTargetPoint = 12; //count of checker
    private int stepOnField; // step on chess field and size of checkers
    private int[][] checkersPositions; //positions all checkers on field
    private int win;
    private boolean playerMove;



    public void addStartParameters(int widthDisplay, int heightDisplay, int indentTop, ResourcesBitmap resourcesBitmap) {
        //update variables for this game
        stepOnField = widthDisplay / (sizeOfField - 1);
        int sizePoint = stepOnField / 3;
        playerMove = true;

        //set variables for create bitmap

        resourcesBitmap.setStepOnField(stepOnField);
        resourcesBitmap.setWidthDisplay(widthDisplay);
        resourcesBitmap.setSizePoint(sizePoint);

        //create matrix
        checkersPositions = new int[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }

        //add checker on start positions
       /* //start white checkers position
        for (int i = 6; i < sizeOfField; i++) {
            for (int j = 1; j < 5; j++) {
                checkersPositions[i][j] = WHITE_CHECKER;
            }
        }

        //start black checkers position
        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < sizeOfField; j++) {
                checkersPositions[i][j] = BLACK_CHECKER;
            }
        }*/


        //////////////////////////////////////////////////////////////////////////////
        //start white checkers position
        for (int i = 5; i < sizeOfField - 1; i++) {
            for (int j = 1; j < 5; j++) {
                checkersPositions[i][j] = BLACK_CHECKER;
            }
        }


        //start black checkers position
        for (int i = 1; i < 4; i++) {
            for (int j = 4; j < sizeOfField - 1; j++) {
                checkersPositions[i][j] = WHITE_CHECKER;
            }
        }
        //////////////////////////////////////////////////////////////////////////////

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
}
