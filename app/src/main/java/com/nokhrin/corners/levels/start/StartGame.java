package com.nokhrin.corners.levels.start;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;


import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.ActivityLevels;


public class StartGame extends com.nokhrin.corners.game.StartGame{
    int stepOnField; // step on chess field and size of checkers
    private int[][] checkersPositions; //positions all checkers on field
    private int[][] marksPositions; //positions all checkers on field
    private int win;
    int sizeOfField;
    ActivityLevels activity;
    int widthDisplay;
    int sizePoint;
    int countToMove;
    int countPointInLevel;
    TextView countMoveView;
    boolean playerMove;

    public StartGame(ActivityLevels activity) {
        this.activity = activity;
        this.widthDisplay = activity.widthDisplay;
        this.countMoveView = activity.countMoveView;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void addStartParameters(int sizeOfField, int countToMove, int countPointInLevel, int[][] checkersPositions, int[][] marksPositions) {
        this.sizeOfField = sizeOfField;
        this.countPointInLevel = countPointInLevel;
        this.countToMove = countToMove;
        this.checkersPositions =checkersPositions;
        this.marksPositions =marksPositions;

        win = 0;
        playerMove = true;

        //set field like background
        if(sizeOfField == 5){
            activity.frameLayoutLevels.setBackground(activity.getResources().getDrawable(R.drawable.stone_field_4x4));
        }
        if(sizeOfField == 6){
            activity.frameLayoutLevels.setBackground(activity.getResources().getDrawable(R.drawable.stone_field_5x5));
        }
        if(sizeOfField == 7){
            activity.frameLayoutLevels.setBackground(activity.getResources().getDrawable(R.drawable.stone_field_6x6));
        }

        //update variables for this level
        stepOnField = widthDisplay / (sizeOfField - 1);
        sizePoint = stepOnField / 3;

        //add text
        String s = "Ходов осталось : " + countToMove;
        countMoveView.setVisibility(View.VISIBLE);
        countMoveView.setText(s);

    }

    public int getSizeOfField() {
        return sizeOfField;
    }

    public int getStepOnField() {
        return stepOnField;
    }

    public int[][] getCheckerPositions() {
        return checkersPositions;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int[][] getMarksPositions() {
        return marksPositions;
    }

    public boolean isPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(boolean playerMove) {
        this.playerMove = playerMove;
    }

    public int getCountPointInLevel() {
        return countPointInLevel;
    }

    public int getCountToMove() {
        return countToMove;
    }

    public void setCountToMove(int countToMove) {
        this.countToMove = countToMove;
    }
}
