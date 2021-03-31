package com.nokhrin.corners.classical.model.bots.bot1;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;

public class EvaluationFunction {
    private int minOfFunction;
    private int sizeOfField;
    private int[][] checkerPositions;
    private int targetPositionI;
    private int targetPositionJ;
    private int[] result;

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = new int[checkerPositions.length][checkerPositions.length];
        for (int i = 1; i < checkerPositions.length; i++) {
            for (int j = 1; j < checkerPositions.length; j++) {
                this.checkerPositions[i][j] = checkerPositions[i][j];
            }
        }
        /*this.checkersPositions = checkersPositions;*/
    }

    public void setStartParameters(int targetPositionI, int targetPositionJ){
        this.targetPositionI = targetPositionI;
        this.targetPositionJ = targetPositionJ;
        sizeOfField = checkerPositions.length;
        minOfFunction = 999;
        result = new int[5];
    }

    public void calculate(int startI, int startJ, int endI, int endJ) {
        //update position
        checkerPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
        checkerPositions[endI][endJ] = BLACK_CHECKER;

        //find all black checkers
        int resultOfFunction = 0;
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if (checkerPositions[i][j] == BLACK_CHECKER) {
                    //sum of length to target position
                    resultOfFunction = resultOfFunction + Math.abs(targetPositionI - i) + Math.abs(targetPositionJ - j);
                }
            }
        }

        //find minimum of evaluation function
        if (resultOfFunction < minOfFunction) {
            minOfFunction = resultOfFunction;

            //save result
            result[0] = startI;
            result[1] = startJ;
            result[2] = endI;
            result[3] = endJ;
        }

        //return checker in old position
        checkerPositions[startI][startJ] = BLACK_CHECKER;
        checkerPositions[endI][endJ] = FREE_POSITION_ON_FIELD;
    }

    public int[] getResult() {
        return result;
    }
}
