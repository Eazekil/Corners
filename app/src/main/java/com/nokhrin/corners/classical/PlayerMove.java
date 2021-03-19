package com.nokhrin.corners.classical;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.animation.Animation;

import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.game.PossibleMoves;

import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class PlayerMove {
    private int touchI;
    private int touchJ;
    private int choiceI;
    private int choiceJ;
    private StartClassic startClassic;
    private DrawView drawView;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayerMove(int touchI, int touchJ, StartClassic startClassic, DrawView drawView) {
        this.touchI = touchI;
        this.touchJ = touchJ;
        this.startClassic = startClassic;
        this.drawView = drawView;

        startPlayerMove();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startPlayerMove(){
        if (haveChoiceChecker()) {
            //check touch position it white checker
            if (startClassic.getCheckersPositions()[touchI][touchJ] == WHITE_CHECKER) {
                //update mark
                startClassic.getCheckersPositions()[touchI][touchJ] = MARK_ON_WHITE_CHECKER;
                startClassic.getCheckersPositions()[choiceI][choiceJ] = WHITE_CHECKER;

                //update draw field
                drawView.invalidate();

            } else {
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(startClassic.getCheckersPositions(), choiceI, choiceJ);
                if (move.isPossible(touchI, touchJ)) {

                    //mark player can't move more
                    startClassic.setPlayerMove(false);

                    //animate this move
                    Animation animation = new Animation();
                    animation.step(choiceJ, choiceI, touchJ, touchI, WHITE_CHECKER);
                }
            }

        } else {
            //check touch position it white checker
            if (startClassic.getCheckersPositions()[touchI][touchJ] == WHITE_CHECKER) {
                //update mark
                startClassic.getCheckersPositions()[touchI][touchJ] = MARK_ON_WHITE_CHECKER;

                //update draw field
                drawView.setCheckersPositions(startClassic.getCheckersPositions());
                drawView.invalidate();
            }
        }
    }

    private boolean haveChoiceChecker() {
        int sizeOfField = startClassic.getCheckersPositions().length;

        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if (startClassic.getCheckersPositions()[i][j] == MARK_ON_WHITE_CHECKER) {
                    choiceI = i;
                    choiceJ = j;
                }
            }
        }

        //check we have choice checker
        return choiceI != 0;
    }
}
