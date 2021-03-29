package com.nokhrin.corners.classical.model;


import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WIN_WIN;

public class GameOver {
    private int[][] checkerPositions;
    private int resultGame;

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = checkerPositions;
        isOver();
    }

    private boolean isOver() {
        int sizeOfField = checkerPositions.length;
        int countPointWhite = 0;
        int countPointBlack = 0;

        //sum white checker in home
        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < sizeOfField; j++) {
                if (checkerPositions[i][j] == WHITE_CHECKER) {
                    countPointWhite++;
                }
            }
        }

        //sum black checker in home
        for (int i = 6; i < sizeOfField; i++) {
            for (int j = 1; j < 5; j++) {
                if (checkerPositions[i][j] == BLACK_CHECKER) {
                    countPointBlack++;
                }
            }
        }

        //count of white checker
        int countTargetPoint = 0;
        for (int i = 1; i < checkerPositions.length; i++) {
            for (int j = 1; j < checkerPositions.length; j++) {
                if (checkerPositions[i][j] == WHITE_CHECKER) {
                    countTargetPoint++;
                }
            }
        }

        if (countPointWhite == countTargetPoint && countPointBlack == countTargetPoint) {
            resultGame = WIN_WIN;
            return true;
        } else if (countPointWhite == countTargetPoint) {
            resultGame = PLAYER_WIN;
            return true;
        } else if (countPointBlack == countTargetPoint) {
            resultGame = BOT_WIN;
            return true;
        } else {
            return false;
        }

    }

    public int getResultGame() {
        return resultGame;
    }
}
