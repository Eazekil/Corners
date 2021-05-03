package com.nokhrin.corners.levels.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.levels.view.ActivityGameLevel;

import static com.nokhrin.corners.resources.Constants.SELECT_WOODMAN_CHECKER;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class ResultMoves {
    private int[] botMoves;
    private int[] playerMoves;
    private int game;
    private DrawView drawView;
    private int[][] checkerPositions;
    private StartAnimation startAnimation;
    private ActivityGameLevel activity;

    private void updateView() {
        drawView.setCheckerPositions(checkerPositions);
        drawView.invalidate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void endMove(){
        startAnimation = new StartAnimation();
        startAnimation.setActivityClassic(activityClassic);
        startAnimation.setStartParameters();
        startAnimation.setResultMoves(this);
    }

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = new int[checkerPositions.length][checkerPositions.length];
        for (int i = 1; i < checkerPositions.length; i++) {
            for (int j = 1; j < checkerPositions.length; j++) {
                this.checkerPositions[i][j] = checkerPositions[i][j];
            }
        }
    }

    public void setBotMoves(int[] botMoves) {
        this.botMoves = botMoves;
    }

    public void setDrawView(DrawView drawView) {
        this.drawView = drawView;
    }

    public void setPlayerMoves(int startI, int startJ, int endI, int endJ) {
        this.playerMoves = new int[4];
        this.playerMoves[0] = startI;
        this.playerMoves[1] = startJ;
        this.playerMoves[2] = endI;
        this.playerMoves[3] = endJ;
    }

    public void changeChoice(int startI, int startJ, int endI, int endJ){
//        checkerPositions[startI][startJ] = WOODMAN_CHECKER;
//        checkerPositions[endI][endJ] = SELECT_WOODMAN_CHECKER;
        updateView();
    }

    public void setActivityClassic(ActivityClassic activityClassic) {
        this.activityClassic = activityClassic;
    }

    public int[] getBotMoves() {
        return botMoves;
    }

    public int[] getPlayerMoves() {
        return playerMoves;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public int[][] getCheckerPositions() {
        return checkerPositions;
    }
}
