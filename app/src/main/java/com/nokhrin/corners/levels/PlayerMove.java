package com.nokhrin.corners.levels;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.game.PossibleMoves;

import static com.nokhrin.corners.resources.Constants.SELECT_WOODMAN_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class PlayerMove {
    int choiceI;//coordinate I of player's chosen checker
    int choiceJ;//coordinate J of player's chosen checker
    int[][] checkersPositions;
    ActivityLevels activity;
    Animation animation;

    public PlayerMove(ActivityLevels activity) {
        this.activity = activity;
        animation = new Animation(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startPlayerMove(int touchI, int touchJ) {
        checkersPositions = activity.startGame.getCheckersPositions();

        if (haveChoiceChecker()) {
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WOODMAN_CHECKER) {
                //update mark
                checkersPositions[touchI][touchJ] = SELECT_WOODMAN_CHECKER;
                checkersPositions[choiceI][choiceJ] = WOODMAN_CHECKER;

                //update draw field
                activity.drawView.invalidate();

            } else {
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(checkersPositions, choiceI, choiceJ);
                if (move.isPossible(touchI, touchJ)) {

                    //mark player can't move more
                    activity.startGame.setPlayerMove(false);

                    //animate this move
                    animation.step(choiceJ, choiceI, touchJ, touchI, WOODMAN_CHECKER);

                    int count = activity.startGame.getCountToMove() - 1;
                    String s = "Ходов осталось : " + count;
                    activity.countMoveView.setVisibility(View.VISIBLE);
                    activity.countMoveView.setText(s);
                    activity.startGame.setCountToMove(count);


                }
            }

        } else {
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WOODMAN_CHECKER) {
                //update mark
                checkersPositions[touchI][touchJ] = SELECT_WOODMAN_CHECKER;

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
                if (checkersPositions[i][j] == SELECT_WOODMAN_CHECKER) {
                    choiceI = i;
                    choiceJ = j;
                }
            }
        }

        //check we have choice checker
        return choiceI != 0;
    }

}
