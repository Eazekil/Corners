package com.nokhrin.corners.multiplayer.game;




import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.game.PossibleMoves;
import com.nokhrin.corners.multiplayer.ActivityMultiplayerGame;
import com.nokhrin.corners.multiplayer.animation.Animation;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.ROLE_HOST;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;


public class PlayerMove {
    private int choiceI;
    private int choiceJ;
    ActivityMultiplayerGame activity;
    int touchI;
    int touchJ;
    int checker;
    int choiceChecker;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayerMove(int touchI, int touchJ, ActivityMultiplayerGame activity) {
        this.touchI = touchI;
        this.touchJ = touchJ;
        this.activity = activity;

        if(activity.role == ROLE_HOST){
            checker = WHITE_CHECKER;
            choiceChecker = MARK_ON_WHITE_CHECKER;
        }else{
            checker = BLACK_CHECKER;
            choiceChecker = MARK_ON_BLACK_CHECKER;
        }

        startPlayerMove();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startPlayerMove(){
        if (haveChoiceChecker()) {
            //check touch position it white checker
            if (activity.startGame.getCheckerPositions()[touchI][touchJ] == checker) {
                //update mark
                activity.startGame.getCheckerPositions()[touchI][touchJ] = choiceChecker;
                activity.startGame.getCheckerPositions()[choiceI][choiceJ] = checker;

                //update draw field
                activity.drawView.invalidate();

            } else {
                //check can move on touch coordinate
                PossibleMoves move = new PossibleMoves(activity.startGame.getCheckerPositions(), choiceI, choiceJ);
                if (move.isPossible(touchI, touchJ)) {

                    //mark player can't move more
                    activity.startGame.setPlayerMove(false);

                    //animate this move
                    Animation animation = new Animation(activity);
                    animation.step(choiceJ, choiceI, touchJ, touchI, checker);

                    //send this move to database
                    @SuppressLint("DefaultLocale") String s =String.format("%d %d %d %d",choiceI, choiceJ, touchI, touchJ);
                    activity.makeStep(s);


                }
            }

        } else {
            //check touch position it white checker
            if (activity.startGame.getCheckerPositions()[touchI][touchJ] == checker) {
                //update mark
                activity.startGame.getCheckerPositions()[touchI][touchJ] = choiceChecker;

                //update draw field
                activity.drawView.invalidate();
            }
        }
    }

    private boolean haveChoiceChecker() {
        int sizeOfField = activity.startGame.getCheckerPositions().length;

        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                if (activity.startGame.getCheckerPositions()[i][j] == choiceChecker) {
                    choiceI = i;
                    choiceJ = j;
                }
            }
        }

        //check we have choice checker
        return choiceI != 0;
    }
}
