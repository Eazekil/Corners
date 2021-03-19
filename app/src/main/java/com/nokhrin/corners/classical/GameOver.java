package com.nokhrin.corners.classical;


import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WIN_WIN;

public class GameOver {
    private int[][] checkersPositions;
    private int countTargetPoint;
    private int win;

    public GameOver(int[][] checkersPositions, int countTargetPoint, int win) {
        this.checkersPositions = checkersPositions;
        this.countTargetPoint = countTargetPoint;
        this.win = win;
    }

    public boolean isOver() {

        int sizeOfField = checkersPositions.length;
        int countPointWhite = 0;
        int countPointBlack = 0;

        //sum white checker in home
        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < sizeOfField; j++) {
                if (StartClassic.checkersPositions[i][j] == WHITE_CHECKER) {
                    countPointWhite++;
                }
            }
        }

        //sum black checker in home
        for (int i = 6; i < sizeOfField; i++) {
            for (int j = 1; j < 5; j++) {
                if (StartClassic.checkersPositions[i][j] == BLACK_CHECKER) {
                    countPointBlack++;
                }
            }
        }


        if (countPointWhite == StartClassic.countTargetPoint && countPointBlack == StartClassic.countTargetPoint) {
            StartClassic.win = WIN_WIN;
            return true;
        } else if (countPointWhite == StartClassic.countTargetPoint) {
            StartClassic.win = PLAYER_WIN;
            System.out.println("wiiiinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn player");
            return true;
        } else if (countPointBlack == StartClassic.countTargetPoint) {
            StartClassic.win = BOT_WIN;
            return true;
        } else {
            return false;
        }


    }
}
