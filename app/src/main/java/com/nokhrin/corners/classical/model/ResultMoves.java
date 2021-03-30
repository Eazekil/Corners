package com.nokhrin.corners.classical.model;

import com.nokhrin.corners.classical.view.StartAnimation;
import com.nokhrin.corners.draw.DrawView;

public class ResultMoves {
    private int[] botMoves;
    private int[] playerMoves;
    private int game;
    private DrawView drawView;
    private int[][] checkersPositions;
    private StartAnimation startAnimation;

    public void updateView() {
        drawView.invalidate();
    }

    public void endMove(){
        startAnimation = new StartAnimation();


    }





    public void setCheckersPositions(int[][] checkersPositions) {
        this.checkersPositions = checkersPositions;
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
}
