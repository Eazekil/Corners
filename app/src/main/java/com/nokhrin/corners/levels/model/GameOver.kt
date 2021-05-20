package com.nokhrin.corners.levels.model

import android.content.ContentValues
import android.util.Log
import com.nokhrin.corners.levels.database.LevelsDb.*
import com.nokhrin.corners.levels.database.ReadDb
import com.nokhrin.corners.levels.view.ActivityGameLevel
import com.nokhrin.corners.resources.Constants

class GameOver {
    private var countBronze = 0
    private var countSilver = 0
    private var countGold = 0
    private var activity: ActivityGameLevel? = null

    fun setActivity(activity: ActivityGameLevel) {
        this.activity = activity
        countBronze = activity.startGame.countBronze
        countSilver = activity.startGame.countSilver
        countGold = activity.startGame.countGold
    }
    val isOver: Boolean
        get() {
            var result = false
            var checkersPositions = activity?.startGame?.checkerPositions
            var marksPositions = activity?.startGame?.marksPositions
            var sizeOfField = checkersPositions?.size
            var countPointWhite = 0

            //sum white checker in home
            if (sizeOfField == null) sizeOfField = 0
            if(checkersPositions == null) checkersPositions = Array(1) { IntArray(1) }
            if(marksPositions == null) marksPositions = Array(1) { IntArray(1) }
            for (i in 1 until sizeOfField) {
                for (j in 1 until sizeOfField) {
                    if ((marksPositions[i][j] ==   Constants.TARGET_POINT_FOR_WHITE_CHECKER)
                        && (checkersPositions[i][j] == Constants.WOODMAN_CHECKER)
                    ) {
                        countPointWhite++
                    }
                }
            }
            Log.d(Constants.TAG, "isOver: countPointWhite = $countPointWhite")

            if (countPointWhite == activity?.startGame?.countTargetPoint) {
                activity?.startGame?.win = Constants.PLAYER_WIN
                //rate()
                result = true
            } else if (activity?.startGame?.countToMove == 0) {
                activity?.startGame?.win = Constants.BOT_WIN
                //rate()
                result = true
            }
            rate()
            return result
        }

    private fun getScore(): Int {
        val resultMove = activity?.startGame?.countToMove ?: return 0
        return when {
            resultMove >= countGold -> 3
            resultMove >= countSilver -> 2
            resultMove >= countBronze -> 1
            else -> 0
        }
    }

    private fun rate() {
        val score = getScore()
        val readDb = ReadDb()
        readDb.setLevelsDb(activity?.levelsDb)
        val processLevel = activity?.numberLevel?.let { readDb.progress[it] }
        if(processLevel != null) if(score <= processLevel) return

        val contentValues = ContentValues()
        contentValues.put(KEY_COUNT_STARS, score)
        contentValues.put(KEY_NUMBER_LEVEL, activity?.numberLevel)
        val dataBase = activity?.levelsDb?.writableDatabase

        dataBase?.update(TABLE_PROGRESS, contentValues, "$KEY_NUMBER_LEVEL= ?", arrayOf(
            activity?.numberLevel.toString()
        ))

        activity?.levelsDb?.close()
    }
}