package com.nokhrin.corners.classical.model;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class StartParameters {
    private StartGameClassic startGame;

    public void setStartGame(StartGameClassic startGame) {
        this.startGame = startGame;

        updateStartParameters();
    }

    private void updateStartParameters(){
        startGame.setPlayerMove(true);
        int sizeOfField = 9;//set size
        int[][] checkersPositions = new int[sizeOfField][sizeOfField];//create matrix

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }




        //add checker on start positions
        //start white checkers position
        for (int i = 6; i < sizeOfField; i++) {
            for (int j = 1; j < 5; j++) {
                checkersPositions[i][j] = WHITE_CHECKER;
            }
        }

        //start black checkers position
        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < sizeOfField; j++) {
                checkersPositions[i][j] = BLACK_CHECKER;
            }
        }



        //////////////////////////////////////////////////////////////////////////////
        //start white checkers position
        /*for (int i = 5; i < sizeOfField - 1; i++) {
            for (int j = 1; j < 5; j++) {
                checkersPositions[i][j] = BLACK_CHECKER;
            }
        }
        //start black checkers position
        for (int i = 1; i < 4; i++) {
            for (int j = 4; j < sizeOfField - 1; j++) {
                checkersPositions[i][j] = WHITE_CHECKER;
            }
        }*/
        //////////////////////////////////////////////////////////////////////////////

        startGame.setCheckerPositions(checkersPositions);
    }
}
