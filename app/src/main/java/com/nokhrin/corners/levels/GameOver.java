package com.nokhrin.corners.levels;

import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countMoveView;
import static com.nokhrin.corners.levels.ActivityLevels.countPointInLevel;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;

public class GameOver {
    public static boolean playerWin;
    public static boolean gameIsOver(){
        boolean result = false;

        int count = 0;
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if(marksPositions[i][j] == 31 && checkersPositions[i][j] == 1){
                    count++;
                }
            }
        }

        if(count == countPointInLevel){
            result = true;
            playerWin = true;
            String s = "Уровень пройден";
            countMoveView.setText(s);
        }else if(countToMove == 0){
            result = true;
            playerWin = false;
            String s = "Увы и ах, ходы кончились";
            countMoveView.setText(s);
        }

        return result;
    }
}
