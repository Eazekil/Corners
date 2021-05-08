package com.nokhrin.corners.levels.model;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.game.PossibleMoves;
import com.nokhrin.corners.levels.view.Animation;
import com.nokhrin.corners.levels.view.ActivityGameLevel;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.SELECT_WOODMAN_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class PlayerMove {
    private int choiceI;//coordinate I of player's chosen checker
    private int choiceJ;//coordinate J of player's chosen checker
    private int[][] checkersPositions;
    private ResultMoves resultMoves;
    private StartGameLevel startGameLevel;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startPlayerMove(int touchI, int touchJ) {
        checkersPositions = startGameLevel.getCheckerPositions();


        if (haveChoiceChecker()) {
            System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WOODMAN_CHECKER) {

                //update mark
                checkersPositions[touchI][touchJ] = SELECT_WOODMAN_CHECKER;
                checkersPositions[choiceI][choiceJ] = WOODMAN_CHECKER;
                resultMoves.setCheckerPositions(checkersPositions);

                resultMoves.changeChoice(choiceI,choiceJ,touchI,touchJ);

            } else {
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(checkersPositions, choiceI, choiceJ);
                if (move.isPossible(touchI, touchJ)) {

                    //mark player can't move more
                    //startGameLevel.setPlayerMove(false);

                    //animate this move
                    resultMoves.setCheckerPositions(checkersPositions);
                    resultMoves.setPlayerMoves(choiceI, choiceJ, touchI, touchJ);

                    checkersPositions[touchI][touchJ] = WOODMAN_CHECKER;
                    checkersPositions[choiceI][choiceJ] = FREE_POSITION_ON_FIELD;

//                    animation.step(choiceJ, choiceI, touchJ, touchI, WOODMAN_CHECKER);
//
//                    int count = activity.startGame.getCountToMove() - 1;
//                    String s = "Ходов осталось : " + count;
//                    activity.countMoveView.setVisibility(View.VISIBLE);
//                    activity.countMoveView.setText(s);
//                    activity.startGame.setCountToMove(count);


                }
            }

        } else {
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WOODMAN_CHECKER) {
                //update mark
                checkersPositions[touchI][touchJ] = SELECT_WOODMAN_CHECKER;
                resultMoves.setCheckerPositions(checkersPositions);
                resultMoves.choiceChecker(touchI,touchJ);
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

    public void setResultMoves(ResultMoves resultMoves) {
        this.resultMoves = resultMoves;
    }

    public void setStartGameLevel(StartGameLevel startGameLevel) {
        this.startGameLevel = startGameLevel;
    }
}
