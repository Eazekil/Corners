package com.nokhrin.corners.classical.animation;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.ActivityClassic;
import com.nokhrin.corners.classical.GameOver;
import com.nokhrin.corners.classical.bots.Bots;
import com.nokhrin.corners.game.StepsForAnimation;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.JUMP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.JUMP_LEFT;
import static com.nokhrin.corners.resources.Constants.JUMP_RIGHT;
import static com.nokhrin.corners.resources.Constants.JUMP_TOP;
import static com.nokhrin.corners.resources.Constants.STEP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.STEP_LEFT;
import static com.nokhrin.corners.resources.Constants.STEP_RIGHT;
import static com.nokhrin.corners.resources.Constants.STEP_TOP;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class Animation {
    ActivityClassic activity;
    StepsForAnimation stepsForAnimation;
    Bots bot;
    GameOver game;

    public Animation(ActivityClassic activity) {
        this.activity = activity;
        stepsForAnimation = new StepsForAnimation(activity);
        bot = new Bots(activity);
        game = new GameOver(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void step(int startJ, int startI, int endJ, int endI, int checker) {

        stepsForAnimation.setStartParameters(startI, startJ, endI, endJ);

        //get steps for animate checker
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

        objectAnimator.setDuration(600*steps.length);
        objectAnimator.start();


        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation, boolean isReverse) {
                activity.startGame.getCheckersPositions()[endI][endJ] = checker;
                activity.drawView.invalidate();
                activity.ivChecker.setVisibility(View.INVISIBLE);
                activity.ivCheckerBlack.setVisibility(View.INVISIBLE);

                //after player move bot can move
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(checker == WHITE_CHECKER){
                    //bot can move
                    bot.botMove();

                    //check game is over
                    if (game.isOver()) {
                        //set winner and update draw field
                        activity.drawView.invalidate();
                        activity.startGame.setPlayerMove(false);
                    }
                }else {
                    activity.startGame.setPlayerMove(true);
                }

            }
        });

    }
}
