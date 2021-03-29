package com.nokhrin.corners.classical.model.bots;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.model.bots.bot1.BotMitya;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;

public class Bots {
    private BotMitya botMitya;
    private int[][] checkerPositions;
    private int[] botMove;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = new int[checkerPositions.length][checkerPositions.length];
        for (int i = 1; i < checkerPositions.length; i++) {
            for (int j = 1; j < checkerPositions.length; j++) {
                this.checkerPositions[i][j] = checkerPositions[i][j];
            }
        }

        botMitya = new BotMitya();
        botMove();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void botMove(){
        //bot start move
        botMitya.setCheckersPositions(checkerPositions);
        botMitya.moveMitya();

        botMove = new int[4];
        botMove[0] = botMitya.getStartI();
        botMove[1] = botMitya.getStartJ();
        botMove[1] = botMitya.getEndI();
        botMove[1] = botMitya.getEndJ();
    }

    public int[] getBotMove() {
        return botMove;
    }
}
