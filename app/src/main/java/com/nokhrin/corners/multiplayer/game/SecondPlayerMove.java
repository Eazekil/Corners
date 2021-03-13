package com.nokhrin.corners.multiplayer.game;

import android.annotation.SuppressLint;

import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.drawView;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.makeStep;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.playerMove;
import static com.nokhrin.corners.multiplayer.game.GameOver.gameIsOver;
import static com.nokhrin.corners.multiplayer.game.PossibleMoves.possibleMoves;
import static com.nokhrin.corners.multiplayer.game.PossibleMoves.possibleStep;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.checkersPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.choiceI;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.choiceJ;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.touchI;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.touchJ;
import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.MARK_ON_BLACK_CHECKER;

public class SecondPlayerMove {
    //public static int choiceI;//coordinate I of player's chosen checker
    //public static int choiceJ;//coordinate J of player's chosen checker


    //start move on the field
    public static void touchOnFieldSecondPlayer() {

        //check can player move
        if (!gameIsOver() && playerMove) {

            //check player choice checker
            if (choiceI != FREE_POSITION_ON_FIELD && choiceJ != FREE_POSITION_ON_FIELD) {

                //check player update chosen checker
                if (checkersPositions[touchI][touchJ] == BLACK_CHECKER) {

                    //update chosen checker
                    checkersPositions[touchI][touchJ] = MARK_ON_BLACK_CHECKER;

                    //update old chosen
                    checkersPositions[choiceI][choiceJ] = BLACK_CHECKER;

                    //update chosen coordinate
                    choiceI = touchI;
                    choiceJ = touchJ;

                    //find all move for choice checker
                    possibleStep();
                } else {

                    //check can move on touch coordinate
                    if (possibleMoves(touchI, touchJ)) {
                        //update checkers positions on field
                        checkersPositions[touchI][touchJ] = BLACK_CHECKER;
                        checkersPositions[choiceI][choiceJ] = FREE_POSITION_ON_FIELD;



                        playerMove = false;
                        @SuppressLint("DefaultLocale") String s =String.format("%d %d %d %d",choiceI, choiceJ, touchI, touchJ);
                        makeStep(s);

                        //clear chosen coordinate
                        choiceI = FREE_POSITION_ON_FIELD;
                        choiceJ = FREE_POSITION_ON_FIELD;


                        /*String s = "Ходов осталось : "+(--countToMove);
                        countMoveView.setVisibility(View.VISIBLE);
                        countMoveView.setText(s);*/

                    }

                }


            } else if (checkersPositions[touchI][touchJ] == BLACK_CHECKER) {
                //mark chosen checker
                checkersPositions[touchI][touchJ] = MARK_ON_BLACK_CHECKER;

                //update chosen coordinate
                choiceI = touchI;
                choiceJ = touchJ;

                //find all move for choice checker
                possibleStep();
            }

            //update draw field
            drawView.invalidate();

        }
    }
}
