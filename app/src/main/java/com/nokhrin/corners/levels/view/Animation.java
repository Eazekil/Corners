package com.nokhrin.corners.levels.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;


import com.nokhrin.corners.game.StepsForAnimation;
import com.nokhrin.corners.levels.GameOver;
import com.nokhrin.corners.levels.view.ActivityGameLevel;
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
    private ActivityGameLevel activity;
    private StepsForAnimation stepsForAnimation;
    private int[][] checkerPositions;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void step(int startI, int startJ, int endI, int endJ) {
        stepsForAnimation.setCheckersPositions(checkerPositions);
        stepsForAnimation.setStartParameters(startI, startJ, endI, endJ);

        //get steps for animate checker
        int[] steps = stepsForAnimation.steps();

        //draw field without move checker
        checkerPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
        activity.getViewParameters().getDrawView().setCheckerPositions(checkerPositions);
        activity.getViewParameters().getDrawView().invalidate();

        int stepOnField = activity.getStartGame().getStepOnField();

        //add checker on start position and set visible
        //if (checker == WOODMAN_CHECKER) { }
        activity.getViewParameters().getViewElements().getIvWoodman().layout((startJ - 2) * stepOnField,
                (startI - 1) * stepOnField+ stepOnField*2,
                (startJ - 2) * stepOnField + stepOnField,
                (startI - 1) * stepOnField + stepOnField+ stepOnField*2);
        activity.getViewParameters().getViewElements().getIvWoodman().setVisibility(View.VISIBLE);

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

        objectAnimator = ObjectAnimator.ofFloat(activity.getViewParameters().getViewElements().getIvWoodman(), "translationX", "translationY", path);

        objectAnimator.setDuration(600 * steps.length);
        objectAnimator.start();


        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation, boolean isReverse) {
                checkerPositions[endI][endJ] = WOODMAN_CHECKER;
                activity.getViewParameters().getDrawView().invalidate();
                activity.getViewParameters().getViewElements().getIvWoodman().setVisibility(View.INVISIBLE);

                //check game is over
//                if (game.isOver()) {
//                    //set winner and update draw field
//                    activity.getViewParameters().getDrawView().setCheckerPositions(activity.getStartGame().getCheckerPositions());
//                    activity.getViewParameters().getDrawView().invalidate();
//
//                    activity.getStartGame().setPlayerMove(false);
//                } else {
//                    activity.getStartGame().setPlayerMove(true);
//                }


            }
        });


    }

    public void setActivity(ActivityGameLevel activity) {
        this.activity = activity;
        stepsForAnimation = new StepsForAnimation();
    }

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = checkerPositions;
    }
}
