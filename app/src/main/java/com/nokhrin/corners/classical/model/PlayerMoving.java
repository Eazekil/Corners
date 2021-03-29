package com.nokhrin.corners.classical.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.game.PossibleMoves;

import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class PlayerMoving {
    private int[][] checkersPositions;
    private StartGameClassic startGame;
    private HaveChecker haveChecker;

    public void setStartGame(StartGameClassic startGame) {
        this.startGame = startGame;
        this.checkersPositions = startGame.getCheckerPositions();
        haveChecker = new HaveChecker();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startPlayerMove(int touchI, int touchJ) {

        //check game is over
        if (!startGame.getCheckMove().isCanMove()) {
            return;
        }

        haveChecker.setCheckersPositions(checkersPositions);

        if (haveChecker.haveChoiceChecker()) {
            //update
            int choiceI = haveChecker.getChoiceI();
            int choiceJ = haveChecker.getChoiceJ();

            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WHITE_CHECKER) {
                startGame.getPositions().updateMark(choiceI, choiceJ, touchI, touchJ);
            } else {
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(checkersPositions, choiceI, choiceJ);
                if (move.isPossible(touchI, touchJ)) {

                    //mark player can't move more
                    startGame.setPlayerMove(false);

                    //update checker position
                    startGame.getPositions().moveChecker(choiceI, choiceJ, touchI, touchJ, WHITE_CHECKER);

                    //save this move
                    startGame.getMoves().setPlayerMoves(choiceI, choiceJ, touchI, touchJ);

                    //bot start moving
                    startGame.botMove();
                }
            }

        } else {
            //check touch position it white checker
            if (checkersPositions[touchI][touchJ] == WHITE_CHECKER) {
                startGame.getPositions().setMark(touchI, touchJ);
            }
        }
    }


}
