package com.nokhrin.corners.levels.model;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.levels.view.ActivityGameLevel;

import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class ResultMoves {
    private int[] playerMoves;
    private int game;
    private DrawView drawView;
    private int[][] checkerPositions;
    private ActivityGameLevel activity;

    private void updateView() {
        if(drawView == null) drawView = activity.getViewParameters().getDrawView();
        drawView.setCheckerPositions(checkerPositions);
        drawView.invalidate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void endMove(){
//        startAnimation = new StartAnimation();
//        startAnimation.setActivityClassic(activityClassic);
//        startAnimation.setStartParameters();
//        startAnimation.setResultMoves(this);
    }

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = new int[checkerPositions.length][checkerPositions.length];
        for (int i = 1; i < checkerPositions.length; i++) {
            for (int j = 1; j < checkerPositions.length; j++) {
                this.checkerPositions[i][j] = checkerPositions[i][j];
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setPlayerMoves(int startI, int startJ, int endI, int endJ) {
        this.playerMoves = new int[4];
        this.playerMoves[0] = startI;
        this.playerMoves[1] = startJ;
        this.playerMoves[2] = endI;
        this.playerMoves[3] = endJ;
        @SuppressLint("DefaultLocale") String ss= String.format("_____===-______ %d %d %d %d",startI,startJ,endI,endJ );
        System.out.println(ss);
        //checkerPositions[startI][startJ] = WOODMAN_CHECKER;
        activity.getAnimation().setCheckerPositions(checkerPositions);
        activity.getAnimation().step(startI,startJ,endI,endJ);
    }

    public void changeChoice(int startI, int startJ, int endI, int endJ){
//        checkerPositions[startI][startJ] = WOODMAN_CHECKER;
//        checkerPositions[endI][endJ] = SELECT_WOODMAN_CHECKER;
        updateView();
    }

    public void choiceChecker(int i, int j){
        updateView();
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

    public void setActivity(ActivityGameLevel activity) {
        this.activity = activity;
    }
}
