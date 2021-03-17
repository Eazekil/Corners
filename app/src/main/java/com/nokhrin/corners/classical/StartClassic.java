package com.nokhrin.corners.classical;


import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.ResourcesBitmap.setSizePoint;
import static com.nokhrin.corners.resources.ResourcesBitmap.setStepOnField;
import static com.nokhrin.corners.resources.ResourcesBitmap.setWidthDisplay;

public class StartClassic {
    public static int sizeOfField = 9; //size of field +1
    public static int countTargetPoint = 12; //count of checker
    public static int stepOnField; // step on chess field and size of checkers
    public static int[][] checkersPositions; //positions all checkers on field
    public static boolean playerWin;


    public void addStartParameters(int widthDisplay, int heightDisplay, int indentTop) {
        //update variables for this game
        stepOnField = widthDisplay / (sizeOfField - 1);
        int sizePoint = stepOnField / 3;
        playerWin = false;

        //set variables for create bitmap
        setStepOnField(stepOnField);
        setWidthDisplay(widthDisplay);
        setSizePoint(sizePoint);

        //create matrix
        checkersPositions = new int[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }

        //add checker on start positions
        //start white(1) checkers position
        //and target position for black checkers
        for (int i = 6; i < sizeOfField; i++) {
            for (int j = 1; j < 5; j++) {
                checkersPositions[i][j] = WHITE_CHECKER;
            }
        }

        //start black(3) checkers position
        //and target position for white checkers
        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < sizeOfField; j++) {
                checkersPositions[i][j] = BLACK_CHECKER;
            }
        }


    }
}
