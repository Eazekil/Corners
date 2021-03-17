package com.nokhrin.corners.classical;

import com.nokhrin.corners.game.PossibleMoves;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class PlayerMove {
    int touchI;
    int touchJ;
    int choiceI;
    int choiceJ;

    public PlayerMove(int touchI, int touchJ) {
        this.touchI = touchI;
        this.touchJ = touchJ;

        if(haveChoiceChecker()){
            //check touch position it white checker
            if(StartClassic.checkersPositions[touchI][touchJ] == WHITE_CHECKER){
                //update mark
                StartClassic.checkersPositions[touchI][touchJ] = MARK_ON_WHITE_CHECKER;
                StartClassic.checkersPositions[choiceI][choiceJ] = WHITE_CHECKER;

                //update draw field
                ActivityClassic.drawView.invalidate();

            }else{
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(StartClassic.checkersPositions, choiceI, choiceJ);
                if(move.possibleMoves(touchI, touchJ)){
                    StartClassic.checkersPositions[touchI][touchJ] = WHITE_CHECKER;
                    StartClassic.checkersPositions[choiceI][choiceJ] = FREE_POSITION_ON_FIELD;

                    GameOver game = new GameOver();
                    if(game.isOver()){

                    }

                    //update draw field
                    ActivityClassic.drawView.invalidate();
                }
            }

        }
    }


    public boolean haveChoiceChecker(){
        int sizeOfField = StartClassic.checkersPositions.length;

        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                if(StartClassic.checkersPositions[i][j] == MARK_ON_WHITE_CHECKER){
                    choiceI = i;
                    choiceJ = j;
                }
            }
        }

        //check we have choice checker
        return choiceI != 0;
    }


}
