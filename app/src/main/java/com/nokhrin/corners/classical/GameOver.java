package com.nokhrin.corners.classical;


import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class GameOver {
    public boolean isOver(){

        int sizeOfField = StartClassic.checkersPositions.length;
        int countPoint = 0;

        for (int i = 1; i < 4; i++) {
            for (int j = 5; j < sizeOfField; j++) {
                if(StartClassic.checkersPositions[i][j] == WHITE_CHECKER){
                    countPoint++;
                }
            }
        }

        if(countPoint == StartClassic.countTargetPoint){
            StartClassic.playerWin = true;
            return true;
        }else{
            return false;
        }

    }
}
