package com.nokhrin.corners.classical;


import com.nokhrin.corners.classical.view.ActivityClassic;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WIN_WIN;

public class GameOver {
    ActivityClassic activity;
    int[][] checkersPositions;

    public GameOver(ActivityClassic activity) {
        this.activity = activity;
    }

    public boolean isOver() {
        checkersPositions = activity.startGame.getCheckersPositions();

        int sizeOfField = checkersPositions.length;
        int countPointWhite = 0;
        int countPointBlack = 0;

        //sum white checker in home
        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < sizeOfField; j++) {
                if (checkersPositions[i][j] == WHITE_CHECKER) {
                    countPointWhite++;
                }
            }
        }

        //sum black checker in home
        for (int i = 6; i < sizeOfField; i++) {
            for (int j = 1; j < 5; j++) {
                if (checkersPositions[i][j] == BLACK_CHECKER) {
                    countPointBlack++;
                }
            }
        }


        int countTargetPoint = activity.startGame.getCountTargetPoint();
        if (countPointWhite == countTargetPoint && countPointBlack == countTargetPoint) {
            activity.startGame.setWin(WIN_WIN);
            return true;
        } else if (countPointWhite == countTargetPoint) {
            activity.startGame.setWin(PLAYER_WIN);
            return true;
        } else if (countPointBlack == countTargetPoint) {
            activity.startGame.setWin(BOT_WIN);
            return true;
        } else {
            return false;
        }


    }
}
