package com.nokhrin.corners.classical.model.bots;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.model.Positions;
import com.nokhrin.corners.classical.model.bots.bot1.BotMitya;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;

public class Bots {
    private BotMitya botMitya;
    private int[][] checkerPositions;
    private Positions positions;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = checkerPositions;
        botMitya = new BotMitya();
        botMitya.setCheckersPositions(checkerPositions);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void botMove(){
        //bot start move

        botMitya.moveMitya();

        int[] botMove = new int[4];
        botMove[0] = botMitya.getStartI();
        botMove[1] = botMitya.getStartJ();
        botMove[2] = botMitya.getEndI();
        botMove[3] = botMitya.getEndJ();

        positions.moveChecker(botMove[0], botMove[1], botMove[2], botMove[3], BLACK_CHECKER);
        positions.getResultMoves().setBotMoves(botMove);
    }


    public void setPositions(Positions positions) {
        this.positions = positions;
    }

}
