package com.nokhrin.corners.levels;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;


import com.nokhrin.corners.game.StepsForAnimation;
import com.nokhrin.corners.levels.view.ActivityLevels;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.JUMP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.JUMP_LEFT;
import static com.nokhrin.corners.resources.Constants.JUMP_RIGHT;
import static com.nokhrin.corners.resources.Constants.JUMP_TOP;
import static com.nokhrin.corners.resources.Constants.STEP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.STEP_LEFT;
import static com.nokhrin.corners.resources.Constants.STEP_RIGHT;
import static com.nokhrin.corners.resources.Constants.STEP_TOP;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class Animation {
    ActivityLevels activity;
    StepsForAnimation stepsForAnimation;
    GameOver game;

    public Animation(ActivityLevels activity) {
        this.activity = activity;
        stepsForAnimation = new StepsForAnimation();
        game = new GameOver(activity);

    }

   /* @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void step(int startJ, int startI, int endJ, int endI, int checker) {
        stepsForAnimation.setCheckersPositions(activity.startGame.getCheckerPositions());
        stepsForAnimation.setStartParameters(startI, startJ, endI, endJ);

        //get steps for animate checker
        int[] steps = stepsForAnimation.steps();

        //draw field without move checker
        activity.startGame.getCheckerPositions()[startI][startJ] = FREE_POSITION_ON_FIELD;
        activity.drawView.setCheckerPositions(activity.startGame.getCheckerPositions());
        activity.drawView.invalidate();

        int stepOnField = activity.startGame.getStepOnField();

        //add checker on start position and set visible
        if (checker == WOODMAN_CHECKER) {
            activity.ivWoodman.layout((startJ - 2) * stepOnField,
                    (startI - 1) * stepOnField+ stepOnField*2,
                    (startJ - 2) * stepOnField + stepOnField,
                    (startI - 1) * stepOnField + stepOnField+ stepOnField*2);
            activity.ivWoodman.setVisibility(View.VISIBLE);
        }


        //create animation
        int mX = stepOnField;
        int mY = 0;
        ObjectAnimator objectAnimator = null;
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

        if (checker == WOODMAN_CHECKER) {
            objectAnimator = ObjectAnimator.ofFloat(activity.ivWoodman, "translationX", "translationY", path);
        }

        objectAnimator.setDuration(600 * steps.length);
        objectAnimator.start();


        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation, boolean isReverse) {
                activity.startGame.getCheckerPositions()[endI][endJ] = checker;
                activity.drawView.invalidate();
                activity.ivWoodman.setVisibility(View.INVISIBLE);

                //check game is over
                if (game.isOver()) {
                    //set winner and update draw field
                    activity.drawView.setCheckerPositions(activity.startGame.getCheckerPositions());
                    activity.drawView.invalidate();

                    activity.startGame.setPlayerMove(false);
                } else {
                    activity.startGame.setPlayerMove(true);
                }


            }
        });


    }*/
}
