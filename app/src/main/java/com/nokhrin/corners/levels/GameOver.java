package com.nokhrin.corners.levels;

import android.content.SharedPreferences;
import android.view.View;


import com.nokhrin.corners.levels.view.ActivityLevels;

import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.LEVEL_PROGRESS;
import static com.nokhrin.corners.resources.Constants.NONE_STAR;
import static com.nokhrin.corners.resources.Constants.ONE_STAR;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.THREE_STAR;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class GameOver {
    ActivityLevels activity;
    int[][] checkersPositions;
    int[][] marksPositions;

    public GameOver(ActivityLevels activity) {
        this.activity = activity;
    }

    /*public boolean isOver() {
        boolean result = false;
        checkersPositions = activity.startGame.getCheckerPositions();
        marksPositions = activity.startGame.getMarksPositions();
        int sizeOfField = checkersPositions.length;
        int countPointWhite = 0;

        //sum white checker in home
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if (marksPositions[i][j] == TARGET_POINT_FOR_WHITE_CHECKER
                        && checkersPositions[i][j] == WOODMAN_CHECKER) {
                    countPointWhite++;
                }
            }
        }

        //find editor
        SharedPreferences.Editor editor = activity.preferences.edit();
        String key = LEVEL_PROGRESS + activity.numberLevel;
        String s = "";

        if (countPointWhite == activity.startGame.getCountPointInLevel()) {
            activity.startGame.setWin(PLAYER_WIN);
            activity.drawView.setWin(PLAYER_WIN);
            int countStar;
            if(activity.startGame.getCountToMove() >0){
                editor.putInt(key, THREE_STAR);
                countStar = THREE_STAR;
            }else{
                editor.putInt(key, ONE_STAR);
                countStar = ONE_STAR;
            }
            s = "Уровень пройден, количество звезд: " + countStar;
            activity.countMoveView.setVisibility(View.VISIBLE);
            activity.countMoveView.setText(s);
            result = true;
        } else if (activity.startGame.getCountToMove() == 0) {
            activity.startGame.setWin(BOT_WIN);
            activity.drawView.setWin(BOT_WIN);
            s = "Увы и ах, ходы кончились";
            activity.countMoveView.setVisibility(View.VISIBLE);
            activity.countMoveView.setText(s);
            editor.putInt(key, NONE_STAR);
            result = true;
        }
        editor.apply();


        return result;
    }*/
}
