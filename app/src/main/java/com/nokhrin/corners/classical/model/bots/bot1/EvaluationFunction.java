package com.nokhrin.corners.classical.model.bots.bot1;

import com.nokhrin.corners.classical.view.ActivityClassic;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;

public class EvaluationFunction {
    ActivityClassic activity;
    int minOfFunction;
    int sizeOfField;
    int[][] checkersPositions;
    int targetPositionI;
    int targetPositionJ;
    int[] result;

    public EvaluationFunction(ActivityClassic activity) {
        this.activity = activity;
    }

    public void setStartParameters(int targetPositionI, int targetPositionJ){
        this.targetPositionI = targetPositionI;
        this.targetPositionJ = targetPositionJ;
        checkersPositions = activity.startGame.getCheckersPositions();
        sizeOfField = checkersPositions.length;
        minOfFunction = 999;
        result = new int[5];
    }

    public void calculate(int startI, int startJ, int endI, int endJ) {
        //update position
        checkersPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
        checkersPositions[endI][endJ] = BLACK_CHECKER;

        //find all black checkers
        int resultOfFunction = 0;
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if (checkersPositions[i][j] == BLACK_CHECKER) {
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
        checkersPositions[startI][startJ] = BLACK_CHECKER;
        checkersPositions[endI][endJ] = FREE_POSITION_ON_FIELD;
    }

    public int[] getResult() {
        return result;
    }
}
