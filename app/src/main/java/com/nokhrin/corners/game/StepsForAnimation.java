package com.nokhrin.corners.game;


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

    public StepsForAnimation(int[][] checkersPositions, int startI, int startJ, int endI, int endJ) {
        this.checkersPositions = checkersPositions;
        this.startI = startI;
        this.startJ = startJ;
        this.endI = endI;
        this.endJ = endJ;
        sizeOfField = checkersPositions.length;
    }

    public int[] steps() {
        steps = new ArrayList<>();

        //update last Player moves matrix
        lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                lastPlayerPositions[i][j] = false;
            }
        }

        //can step
        stepRight();
        stepLeft();
        stepBottom();
        stepTop();

        //check if we can jump then steps added like reverse
        boolean reverse = false;
        if (steps.size() < 1) {
            jumpRight(startI, startJ);
            reverse = true;
        }
        if (steps.size() < 1) {
            lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
            jumpLeft(startI, startJ);
            reverse = true;
        }
        if (steps.size() < 1) {
            lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
            jumpBottom(startI, startJ);
            reverse = true;
        }
        if (steps.size() < 1) {
            lastPlayerPositions = new boolean[sizeOfField][sizeOfField];
            jumpTop(startI, startJ);
            reverse = true;
        }

        //save result
        int[] stepsResult = new int[steps.size()];
        if (reverse) {
            for (int i = 0; i < steps.size(); i++) {
                stepsResult[i] = steps.get(steps.size() - 1- i);
            }
        } else {
            for (int i = 0; i < steps.size(); i++) {
                stepsResult[i] = steps.get(i);
            }
        }

        return stepsResult;
    }

    //check if current coordinate is end coordinate
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
        if (startI - 1 > 0) {
            if (checkersPositions[startI - 1][startJ] == FREE_POSITION_ON_FIELD
                    && end(startI - 1, startJ)) {
                steps.add(STEP_TOP);
            }
        }
    }

    //can two step on right
    private boolean jumpRight(int i, int j) {
        boolean result = false;
        if (j + 2 < sizeOfField) {
            if (checkersPositions[i][j + 1] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i][j + 2] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i][j + 2]) {

                //check is end coordinate
                if (end(i, j + 2)) {
                    steps.add(JUMP_RIGHT);
                    result = true;
                }

                //mark this position like last position
                lastPlayerPositions[i][j + 2] = true;

                //check can jump more
                if (jumpRight(i, j + 2)) {
                    result = true;
                    steps.add(JUMP_RIGHT);
                    jumpRight(i, j + 2);
                }
                if (jumpBottom(i, j + 2)) {
                    result = true;
                    steps.add(JUMP_RIGHT);
                    jumpBottom(i, j + 2);
                }
                if (jumpTop(i, j + 2)) {
                    result = true;
                    steps.add(JUMP_RIGHT);
                    jumpTop(i, j + 2);
                }

            }
        }
        return result;
    }

    //can two step on left
    private boolean jumpLeft(int i, int j) {
        boolean result = false;
        if (j - 2 > 0) {
            if (checkersPositions[i][j - 1] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i][j - 2] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i][j - 2]) {

                //check is end coordinate
                if (end(i, j - 2)) {
                    steps.add(JUMP_LEFT);
                    result = true;
                }

                //mark this position like last position
                lastPlayerPositions[i][j - 2] = true;

                //can jump more
                if (jumpLeft(i, j - 2)) {
                    result = true;
                    steps.add(JUMP_LEFT);
                    jumpLeft(i, j - 2);
                }
                if (jumpBottom(i, j - 2)) {
                    result = true;
                    steps.add(JUMP_LEFT);
                    jumpBottom(i, j - 2);
                }
                if (jumpTop(i, j - 2)) {
                    result = true;
                    steps.add(JUMP_LEFT);
                    jumpTop(i, j - 2);
                }

            }
        }
        return result;
    }

    //can two step on bottom
    private boolean jumpBottom(int i, int j) {
        boolean result = false;
        if (i + 2 < sizeOfField) {
            if (checkersPositions[i + 1][j] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i + 2][j] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i + 2][j]) {

                //check is end coordinate
                if (end(i + 2, j)) {
                    steps.add(JUMP_BOTTOM);
                    result = true;
                }

                //mark this position like last position
                lastPlayerPositions[i + 2][j] = true;

                //can jump more
                if (jumpBottom(i + 2, j)) {
                    result = true;
                    steps.add(JUMP_BOTTOM);
                    jumpBottom(i + 2, j);
                }
                if (jumpRight(i + 2, j)) {
                    result = true;
                    steps.add(JUMP_BOTTOM);
                    jumpRight(i + 2, j);
                }
                if (jumpLeft(i + 2, j)) {
                    result = true;
                    steps.add(JUMP_BOTTOM);
                    jumpLeft(i + 2, j);
                }

            }
        }
        return result;
    }

    //can two step on top
    private boolean jumpTop(int i, int j) {
        boolean result = false;
        if (i - 2 > 0) {
            if (checkersPositions[i - 1][j] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i - 2][j] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i - 2][j]) {

                //check is end coordinate
                if (end(i - 2, j)) {
                    steps.add(JUMP_TOP);
                    result = true;
                }

                //mark this position like last position
                lastPlayerPositions[i - 2][j] = true;

                //can jump more
                if (jumpTop(i - 2, j)) {
                    result = true;
                    steps.add(JUMP_TOP);
                    jumpTop(i - 2, j);
                }
                if (jumpRight(i - 2, j)) {
                    result = true;
                    steps.add(JUMP_TOP);
                    jumpRight(i - 2, j);
                }
                if (jumpLeft(i - 2, j)) {
                    result = true;
                    steps.add(JUMP_TOP);
                    jumpLeft(i - 2, j);
                }

            }
        }
        return result;
    }
}
