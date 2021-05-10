package com.nokhrin.corners.levels.model

import android.util.Log
import com.nokhrin.corners.levels.view.ActivityGameLevel
import com.nokhrin.corners.resources.Constants

class GameOver {
    private var activity: ActivityGameLevel? = null
    fun setActivity(activity: ActivityGameLevel?) {
        this.activity = activity
    }//            activity.drawView.setWin(BOT_WIN);
//            s = "Увы и ах, ходы кончились";
//            activity.countMoveView.setVisibility(View.VISIBLE);
//            activity.countMoveView.setText(s);
//            editor.putInt(key, NONE_STAR);
    //editor.apply();
//            int countStar;
//            if(activity.getStartGame().getCountToMove() >0){
//                editor.putInt(key, THREE_STAR);
//                countStar = THREE_STAR;
//            }else{
//                editor.putInt(key, ONE_STAR);
//                countStar = ONE_STAR;
//            }
//            s = "Уровень пройден, количество звезд: " + countStar;
//            activity.countMoveView.setVisibility(View.VISIBLE);
//            activity.countMoveView.setText(s);
    //sum white checker in home

    //find editor
//        SharedPreferences.Editor editor = activity.preferences.edit();
//        String key = LEVEL_PROGRESS + activity.numberLevel;
//        String s = "";
    val isOver: Boolean
        get() {
            var result = false
            val checkersPositions = activity!!.startGame.checkerPositions
            val marksPositions = activity!!.startGame.marksPositions
            val sizeOfField = checkersPositions.size
            var countPointWhite = 0

            //sum white checker in home
            for (i in 1 until sizeOfField) {
                for (j in 1 until sizeOfField) {
                    if (marksPositions[i][j] == Constants.TARGET_POINT_FOR_WHITE_CHECKER
                            && checkersPositions[i][j] == Constants.WOODMAN_CHECKER) {
                        countPointWhite++
                    }
                }
            }
            Log.d(Constants.TAG, "isOver: countPointWhite = $countPointWhite")

            //find editor
//        SharedPreferences.Editor editor = activity.preferences.edit();
//        String key = LEVEL_PROGRESS + activity.numberLevel;
//        String s = "";
            if (countPointWhite == activity!!.startGame.countTargetPoint) {
                activity!!.startGame.win = Constants.PLAYER_WIN
                //            int countStar;
//            if(activity.getStartGame().getCountToMove() >0){
//                editor.putInt(key, THREE_STAR);
//                countStar = THREE_STAR;
//            }else{
//                editor.putInt(key, ONE_STAR);
//                countStar = ONE_STAR;
//            }
//            s = "Уровень пройден, количество звезд: " + countStar;
//            activity.countMoveView.setVisibility(View.VISIBLE);
//            activity.countMoveView.setText(s);
                result = true
            } else if (activity!!.startGame.countToMove == 0) {
                activity!!.startGame.win = Constants.BOT_WIN
                //            activity.drawView.setWin(BOT_WIN);
//            s = "Увы и ах, ходы кончились";
//            activity.countMoveView.setVisibility(View.VISIBLE);
//            activity.countMoveView.setText(s);
//            editor.putInt(key, NONE_STAR);
                result = true
            }
            //editor.apply();
            return result
        }
}