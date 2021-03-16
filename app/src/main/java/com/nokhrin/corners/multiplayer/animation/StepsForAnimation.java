package com.nokhrin.corners.multiplayer.animation;


import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;

public class StepsForAnimation {
    private int[][] checkersPositions;
    private int startI;
    private int startJ;
    private int endI;
    private int endJ;
    private int sizeOfField;
    private boolean[][] lastPlayerPositions;
    private ArrayList<Integer> resultSteps;
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
        resultSteps = new ArrayList<>();
        steps = new ArrayList<>();

        stepRight();
        stepLeft();
        stepBottom();
        stepTop();

        if (resultSteps.size() < 1) {
            jumpRight(startI, startJ);
            steps = new ArrayList<>();
            jumpLeft(startI, startJ);
            steps = new ArrayList<>();
            jumpBottom(startI, startJ);
            steps = new ArrayList<>();
            jumpTop(startI, startJ);
        }

        int[] steps = new int[resultSteps.size()];
        for(int i = 0; i<resultSteps.size();i++){
            steps[i] = resultSteps.get(i);
        }

        return steps;
    }

    private boolean end(int i, int j) {
        return i == endI && j == endJ;
    }

    //can step on right
    private void stepRight() {
        if (startJ + 1 < sizeOfField) {
            if (checkersPositions[startI][startJ + 1] == FREE_POSITION_ON_FIELD
                    && end(startI, startJ + 1)) {
                resultSteps.add(1);
            }
        }
    }

    //can step on left
    private void stepLeft() {
        if (startJ - 1 > 0) {
            if (checkersPositions[startI][startJ - 1] == FREE_POSITION_ON_FIELD
                    && end(startI, startJ - 1)) {
                resultSteps.add(2);
            }
        }
    }

    //can step on bottom
    private void stepBottom() {
        if (startI + 1 < sizeOfField) {
            if (checkersPositions[startI + 1][startJ] == FREE_POSITION_ON_FIELD
                    && end(startI + 1, startJ)) {
                resultSteps.add(3);
            }
        }
    }

    //can step on top
    private void stepTop() {
        if (startI - 1 < sizeOfField) {
            if (checkersPositions[startI - 1][startJ] == FREE_POSITION_ON_FIELD
                    && end(startI - 1, startJ)) {
                resultSteps.add(4);
            }
        }
    }

    //can two step on right
    private void jumpRight(int i, int j) {
        if (j + 2 < sizeOfField) {
            if (checkersPositions[i][j + 1] != FREE_POSITION_ON_FIELD
                    && checkersPositions[i][j + 2] == FREE_POSITION_ON_FIELD
                    && !lastPlayerPositions[i][j + 2]) {

                steps.add(5);

                if (end(startI, startJ + 2)) {
                    resultSteps.addAll(steps);
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

                steps.add(6);

                if (end(startI, startJ - 2)) {
                    resultSteps.addAll(steps);
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

                steps.add(7);

                if (end(startI + 2, startJ)) {
                    resultSteps.addAll(steps);
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

                steps.add(8);

                if (end(startI - 2, startJ)) {
                    resultSteps.addAll(steps);
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
