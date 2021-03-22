package com.nokhrin.corners.classical;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.game.PossibleMoves;

import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class PlayerMove {
    int choiceI;
    int choiceJ;
    ActivityClassic activity;
    int[][] checkersPositions;

    public PlayerMove(ActivityClassic activity) {
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startPlayerMove(int touchI, int touchJ) {
        checkersPositions = activity.startGame.getCheckersPositions();

        if (haveChoiceChecker()) {
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WHITE_CHECKER) {
                //update mark
                checkersPositions[touchI][touchJ] = MARK_ON_WHITE_CHECKER;
                checkersPositions[choiceI][choiceJ] = WHITE_CHECKER;

                //update draw field
                activity.drawView.invalidate();

            } else {
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(checkersPositions, choiceI, choiceJ);
                if (move.isPossible(touchI, touchJ)) {

                    //mark player can't move more
                    activity.startGame.setPlayerMove(false);

                    //animate this move
                    activity.animation.step(choiceJ, choiceI, touchJ, touchI, WHITE_CHECKER);
                }
            }

        } else {
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WHITE_CHECKER) {
                //update mark
                checkersPositions[touchI][touchJ] = MARK_ON_WHITE_CHECKER;

                //update draw field
                activity.drawView.invalidate();
            }
        }
    }

    private boolean haveChoiceChecker() {
        int sizeOfField = checkersPositions.length;

        choiceI = 0;
        choiceJ = 0;

        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if (checkersPositions[i][j] == MARK_ON_WHITE_CHECKER) {
                    choiceI = i;
                    choiceJ = j;
                }
            }
        }

        //check we have choice checker
        return choiceI != 0;
    }
}
