package com.nokhrin.corners.classical.model;

import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;

public class HaveChecker {
    private int[][] checkersPositions;
    private int choiceI;
    private int choiceJ;

    public void setCheckersPositions(int[][] checkersPositions) {
        this.checkersPositions = checkersPositions;
    }

    public boolean haveChoiceChecker() {
        choiceI = 0;
        choiceJ = 0;

        for (int i = 1; i < checkersPositions.length; i++) {
            for (int j = 1; j < checkersPositions.length; j++) {
                if (checkersPositions[i][j] == MARK_ON_WHITE_CHECKER) {
                    choiceI = i;
                    choiceJ = j;
                }
            }
        }

        //check we have choice checker
        return choiceI != 0;
    }

    public int getChoiceI() {
        return choiceI;
    }

    public int getChoiceJ() {
        return choiceJ;
    }
}
