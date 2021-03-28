package com.nokhrin.corners.classical.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.game.PossibleMoves;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class PlayerMoving {
    private int[][] checkersPositions;
    private StartGameClassic startGame;
    private HaveChecker haveChecker;

    public void setStartGame(StartGameClassic startGame) {
        this.startGame = startGame;
        this.checkersPositions = startGame.getCheckersPositions();
        haveChecker = new HaveChecker();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startPlayerMove(int touchI, int touchJ) {

        //check game is over
        if (!startGame.getCheckMove().isCanMove()) {
            return;
        }


        if (haveChecker.haveChoiceChecker()) {

            //update
            int choiceI = haveChecker.getChoiceI();
            int choiceJ = haveChecker.getChoiceJ();

            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WHITE_CHECKER) {
                //update mark
                checkersPositions[touchI][touchJ] = MARK_ON_WHITE_CHECKER;
                checkersPositions[choiceI][choiceJ] = WHITE_CHECKER;

                //update draw field
                startGame.getUpdateView().updateDrawView();

            } else {
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(checkersPositions, choiceI, choiceJ);
                if (move.isPossible(touchI, touchJ)) {

                    //mark player can't move more
                    startGame.setPlayerMove(false);

                    //animate this move
                    startGame.getUpdateAnimation().setStep(choiceJ, choiceI, touchJ, touchI, WHITE_CHECKER);

                    //update checker position
                    checkersPositions[touchI][touchJ] = WHITE_CHECKER;
                    checkersPositions[choiceI][choiceJ] = FREE_POSITION_ON_FIELD;
                }
            }

        } else {
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WHITE_CHECKER) {
                //update mark
                checkersPositions[touchI][touchJ] = MARK_ON_WHITE_CHECKER;

                //update draw field
                startGame.getUpdateView().updateDrawView();
            }
        }
    }


}
