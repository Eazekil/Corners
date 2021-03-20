package com.nokhrin.corners.multiplayer.game;




import com.nokhrin.corners.multiplayer.ActivityMultiplayerGame;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.ROLE_HOST;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WIN_WIN;


public class GameOver {
    private ActivityMultiplayerGame activity;

    public GameOver(ActivityMultiplayerGame activity) {
        this.activity = activity;
    }

    public boolean isOver() {

        int sizeOfField = activity.startGame.getCheckersPositions().length;
        int countPointWhite = 0;
        int countPointBlack = 0;

        if(activity.role == ROLE_HOST){
            //sum white checker in home
            for (int i = 1; i < 4; i++) {
                for (int j = 5; j < sizeOfField; j++) {
                    if (activity.startGame.getCheckersPositions()[i][j] == WHITE_CHECKER) {
                        countPointWhite++;
                    }
                }
            }

            //sum black checker in home
            for (int i = 6; i < sizeOfField; i++) {
                for (int j = 1; j < 5; j++) {
                    if (activity.startGame.getCheckersPositions()[i][j] == BLACK_CHECKER) {
                        countPointBlack++;
                    }
                }
            }
        }else{
            //sum white checker in home
            for (int i = 1; i < 4; i++) {
                for (int j = 5; j < sizeOfField; j++) {
                    if (activity.startGame.getCheckersPositions()[i][j] == BLACK_CHECKER) {
                        countPointBlack++;
                    }
                }
            }

            //sum black checker in home
            for (int i = 6; i < sizeOfField; i++) {
                for (int j = 1; j < 5; j++) {
                    if (activity.startGame.getCheckersPositions()[i][j] == WHITE_CHECKER) {
                        countPointWhite++;
                    }
                }
            }
        }



        if (countPointWhite == activity.startGame.getCountTargetPoint()
                && countPointBlack == activity.startGame.getCountTargetPoint()) {
            activity.startGame.setWin(WIN_WIN);
            return true;
        } else if (countPointWhite == activity.startGame.getCountTargetPoint()) {
            if (activity.role == ROLE_HOST) {
                activity.startGame.setWin(PLAYER_WIN);
            } else {
                activity.startGame.setWin(BOT_WIN);
            }
            return true;
        } else if (countPointBlack == activity.startGame.getCountTargetPoint()) {
            if (activity.role == ROLE_HOST) {
                activity.startGame.setWin(BOT_WIN);
            } else {
                activity.startGame.setWin(PLAYER_WIN);
            }
            return true;
        } else {
            return false;
        }
    }

}
