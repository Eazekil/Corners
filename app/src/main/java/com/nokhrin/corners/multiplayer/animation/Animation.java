package com.nokhrin.corners.multiplayer.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;


import com.nokhrin.corners.game.StepsForAnimation;
import com.nokhrin.corners.multiplayer.ActivityMultiplayerGame;
import com.nokhrin.corners.multiplayer.game.GameOver;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.JUMP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.JUMP_LEFT;
import static com.nokhrin.corners.resources.Constants.JUMP_RIGHT;
import static com.nokhrin.corners.resources.Constants.JUMP_TOP;
import static com.nokhrin.corners.resources.Constants.ROLE_GUEST;
import static com.nokhrin.corners.resources.Constants.ROLE_HOST;
import static com.nokhrin.corners.resources.Constants.STEP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.STEP_LEFT;
import static com.nokhrin.corners.resources.Constants.STEP_RIGHT;
import static com.nokhrin.corners.resources.Constants.STEP_TOP;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class Animation {
    private ActivityMultiplayerGame activity;

    public Animation(ActivityMultiplayerGame activity) {
        this.activity = activity;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void step(int startJ, int startI, int endJ, int endI, int checker) {

        //get steps for animate checker
        StepsForAnimation stepsForAnimation = new StepsForAnimation(activity.startGame.getCheckersPositions(), startI, startJ, endI, endJ);
        int[] steps = stepsForAnimation.steps();

        //draw field without move checker
        activity.startGame.getCheckersPositions()[startI][startJ] = FREE_POSITION_ON_FIELD;
        activity.drawView.invalidate();

        int stepOnField = activity.startGame.getStepOnField();

        //add checker on start position and set visible
        if(checker == WHITE_CHECKER){
            activity.ivChecker.layout((startJ - 2) * stepOnField,
                    (startI - 1) * stepOnField + activity.indentTop,
                    (startJ - 2) * stepOnField + stepOnField,
                    (startI - 1) * stepOnField + stepOnField + activity.indentTop);
            activity.ivChecker.setVisibility(View.VISIBLE);
        }else{
            activity.ivCheckerBlack.layout((startJ - 2) * stepOnField,
                    (startI - 1) * stepOnField + activity.indentTop,
                    (startJ - 2) * stepOnField + stepOnField,
                    (startI - 1) * stepOnField + stepOnField + activity.indentTop);
            activity.ivCheckerBlack.setVisibility(View.VISIBLE);
        }


        //create animation
        int mX = stepOnField;
        int mY = 0;
        ObjectAnimator objectAnimator;
        Path path = new Path();
        path.moveTo(mX, mY);
        for (int step : steps) {
            if (step == STEP_RIGHT) mX += stepOnField;
            if (step == STEP_LEFT) mX -= stepOnField;
            if (step == STEP_BOTTOM) mY += stepOnField;
            if (step == STEP_TOP) mY -= stepOnField;
            if (step == JUMP_RIGHT) mX += stepOnField * 2;
            if (step == JUMP_LEFT) mX -= stepOnField * 2;
            if (step == JUMP_BOTTOM) mY += stepOnField * 2;
            if (step == JUMP_TOP) mY -= stepOnField * 2;

            path.lineTo(mX, mY);
        }
        if(checker == WHITE_CHECKER){
            objectAnimator = ObjectAnimator.ofFloat(activity.ivChecker, "translationX", "translationY", path);
        }else {
            objectAnimator = ObjectAnimator.ofFloat(activity.ivCheckerBlack, "translationX", "translationY", path);
        }

        //set time of animation
        objectAnimator.setDuration(600*steps.length);
        objectAnimator.start();

        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                activity.startGame.getCheckersPositions()[endI][endJ] = checker;
                activity.ivChecker.setVisibility(View.INVISIBLE);
                activity.ivCheckerBlack.setVisibility(View.INVISIBLE);

                //check player move before animation
                if(activity.role == ROLE_HOST && checker == BLACK_CHECKER){
                    activity.startGame.setPlayerMove(true);
                }
                if(activity.role == ROLE_GUEST && checker == WHITE_CHECKER){
                    activity.startGame.setPlayerMove(true);
                }

                //check game is over
                GameOver game = new GameOver(activity);
                if (game.isOver()) {
                    activity.startGame.setPlayerMove(false);
                }

                activity.drawView.invalidate();
            }
        });

    }
}
