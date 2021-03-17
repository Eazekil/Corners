package com.nokhrin.corners.multiplayer.animation;


import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.JUMP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.JUMP_LEFT;
import static com.nokhrin.corners.resources.Constants.JUMP_RIGHT;
import static com.nokhrin.corners.resources.Constants.JUMP_TOP;
import static com.nokhrin.corners.resources.Constants.STEP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.STEP_LEFT;
import static com.nokhrin.corners.resources.Constants.STEP_RIGHT;
import static com.nokhrin.corners.resources.Constants.STEP_TOP;

public class StepsForAnimation {
    private int[][] checkersPositions;
    private int startI;
    private int startJ;
    private int endI;
    private int endJ;
    private int sizeOfField;
    private boolean[][] lastPlayerPositions;
    private ArrayList<Integer> steps;

    public StepsForAnimation(int[][] checkersPositions, int startI, int startJ, int endI, int endJ, int sizeOfField) {
        this.checkersPositions = checkersPositions;
        this.startI = startI;
        this.startJ = startJ;
        this.endI = endI;
        this.endJ = endJ;
        this.sizeOfField = sizeOfField;
    }

    public int[] steps() {
        steps = new ArrayList<>();


        lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
        //clear last Player moves matrix
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                lastPlayerPositions[i][j] = false;
            }
        }

        stepRight();
        stepLeft();
        stepBottom();
        stepTop();


        if (steps.size() < 1) {
            jumpRight(startI, startJ);
        }
        if(steps.size() < 1){
            lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
            jumpLeft(startI, startJ);
        }
        if(steps.size() < 1){
            lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
            jumpBottom(startI, startJ);
        }
        if(steps.size() < 1){
            lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
            jumpTop(startI, startJ);
        }

        int[] stepsL = new int[steps.size()];
        for(int i = 0; i< steps.size(); i++){
            stepsL[i] = steps.get(i);
        }

        return stepsL;
    }

    private boolean end(int i, int j) {
        return i == endI && j == endJ;
    }

    //can step on right
    private void stepRight() {
        if (startJ + 1 < sizeOfField) {
            if (checkersPositions[startI][startJ + 1] == FREE_POSITION_ON_FIELD
                    && end(startI, startJ + 1)) {
                steps.add(STEP_RIGHT);
            }
        }
    }

    //can step on left
    private void stepLeft() {
        if (startJ - 1 > 0) {
            if (checkersPositions[startI][startJ - 1] == FREE_POSITION_ON_FIELD
                    && end(startI, startJ - 1)) {
                steps.add(STEP_LEFT);
            }
        }
    }

    //can step on bottom
    private void stepBottom() {
        if (startI + 1 < sizeOfField) {
            if (checkersPositions[startI + 1][startJ] == FREE_POSITION_ON_FIELD
                    && end(startI + 1, startJ)) {
                steps.add(STEP_BOTTOM);
            }
        }
    }

    //can step on top
    private void stepTop() {
        if (startI - 1 < sizeOfField) {
            if (checkersPositions[startI - 1][startJ] == FREE_POSITION_ON_FIELD
                    && end(startI - 1, startJ)) {
                steps.add(STEP_TOP);
            }
        }
    }

    //can two step on right
    private void jumpRight(int i, int j) {
        if (j + 2 < sizeOfField) {
            if (checkersPositions[i][j + 1] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i][j + 2] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i][j + 2]) {

                steps.add(JUMP_RIGHT);

                if (end(i, j + 2)) {
                    return;
                }

                //mark this position like last position
                lastPlayerPositions[i][j + 2] = true;

                //can jump more
                jumpRight(i, j + 2);
                jumpBottom(i, j + 2);
                jumpTop(i, j + 2);
            }
        }
    }

    //can two step on left
    private void jumpLeft(int i, int j) {
        if (j - 2 > 0) {
            if (checkersPositions[i][j - 1] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i][j - 2] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i][j - 2]) {

                steps.add(JUMP_LEFT);

                if (end(i, j - 2)) {
                    return;
                }

                //mark this position like last position
                lastPlayerPositions[i][j - 2] = true;

                //can jump more
                jumpLeft(i, j - 2);
                jumpBottom(i, j - 2);
                jumpTop(i, j - 2);
            }
        }
    }

    //can two step on bottom
    private void jumpBottom(int i, int j) {
        if (i + 2 < sizeOfField) {
            if (checkersPositions[i + 1][j] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i + 2][j] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i + 2][j]) {

                steps.add(JUMP_BOTTOM);

                if (end(i + 2, j)) {
                    return;
                }

                //mark this position like last position
                lastPlayerPositions[i + 2][j] = true;

                //can jump more
                jumpBottom(i + 2, j);
                jumpRight(i + 2, j);
                jumpLeft(i + 2, j);
            }
        }
    }

    //can two step on top
    private void jumpTop(int i, int j) {
        if (i - 2 > 0) {
            if (checkersPositions[i - 1][j] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i - 2][j] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i - 2][j]) {

                steps.add(JUMP_TOP);

                if (end(i - 2, j)) {
                    return;
                }

                //mark this position like last position
                lastPlayerPositions[i - 2][j] = true;

                //can jump more
                jumpTop(i - 2, j);
                jumpRight(i - 2, j);
                jumpLeft(i - 2, j);
            }
        }
    }
}
