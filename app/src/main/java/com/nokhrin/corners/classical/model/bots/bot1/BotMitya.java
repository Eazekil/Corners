package com.nokhrin.corners.classical.model.bots.bot1;


import com.nokhrin.corners.game.PossibleMoves;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;

public class BotMitya {
    private int startI;
    private int startJ;
    private int endI;
    private int endJ;
    private int[][] checkersPositions;
    private EvaluationFunction evaluationFunction;

    public void setCheckersPositions(int[][] checkersPositions) {
        this.checkersPositions = checkersPositions;
        evaluationFunction = new EvaluationFunction();
        evaluationFunction.setCheckersPositions(checkersPositions);
    }

    public void moveMitya() {
        int sizeOfField = checkersPositions.length;
        int targetPositionI = 8;
        int targetPositionJ = 1;

        //check target position and mark
        if (checkersPositions[8][1] == BLACK_CHECKER) {
            for (int i = 6; i < sizeOfField; i++) {
                for (int j = 1; j < 5; j++) {
                    if (checkersPositions[i][j] != BLACK_CHECKER) {
                        targetPositionI = i;
                        targetPositionJ = j;
                    }
                }
            }
        }

        //create new function
        evaluationFunction.setStartParameters(targetPositionI, targetPositionJ);

        //find positions all black checkers
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if (checkersPositions[i][j] == BLACK_CHECKER) {

                    //calculate evaluation function for all position for this checker
                    PossibleMoves move = new PossibleMoves(checkersPositions, i, j);
                    for (int endI = i; endI < sizeOfField; endI++) {
                        for (int endJ = j; endJ > 0; endJ--) {
                            if (move.isPossible(endI, endJ)) {
                                //считаем оценочную функцию для этих координат
                                evaluationFunction.calculate(i, j, endI, endJ);
                            }
                        }
                    }

                }
            }
        }

        //get end save result
        int[] result = evaluationFunction.getResult();
        startI = result[0];
        startJ = result[1];
        endI = result[2];
        endJ = result[3];
    }

    public int getStartI() {
        return startI;
    }

    public int getStartJ() {
        return startJ;
    }

    public int getEndI() {
        return endI;
    }

    public int getEndJ() {
        return endJ;
    }
}
