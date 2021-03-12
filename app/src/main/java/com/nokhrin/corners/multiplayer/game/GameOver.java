package com.nokhrin.corners.multiplayer.game;



import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.checkersPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.countPointInLevel;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.marksPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.sizeOfField;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.playerWin;
import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;


public class GameOver {


    public static boolean gameIsOver(){
        boolean result = false;

        int countWhite = 0;
        int countBlack = 0;
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if(marksPositions[i][j] == TARGET_POINT_FOR_WHITE_CHECKER && checkersPositions[i][j] == WHITE_CHECKER){
                    countWhite++;
                }
                if(marksPositions[i][j] == TARGET_POINT_FOR_BLACK_CHECKER && checkersPositions[i][j] == BLACK_CHECKER){
                    countBlack++;
                }
            }
        }

        if(countWhite == countPointInLevel){
            result = true;
            playerWin = true;
            String s = "Вы победили";
            //countMoveView.setVisibility(View.VISIBLE);
            //countMoveView.setText(s);
        }else if(countBlack == countPointInLevel){
            result = true;
            playerWin = false;
            String s = "Увы и ах, вы проиграли";
            //countMoveView.setVisibility(View.VISIBLE);
            //countMoveView.setText(s);
        }

        return result;
    }
}
