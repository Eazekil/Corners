package com.nokhrin.corners.classical.animation;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.ActivityClassic;
import com.nokhrin.corners.classical.StartClassic;
import com.nokhrin.corners.classical.bots.Bots;

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void step(int startJ, int startI, int endJ, int endI, int checker) {

        //get steps for animate checker
        StepsForAnimation stepsForAnimation = new StepsForAnimation(StartClassic.checkersPositions, startI, startJ, endI, endJ, StartClassic.sizeOfField);
        int[] steps = stepsForAnimation.steps();

        for(int ss: steps){
            System.out.println("************************************  "+ ss);
        }
        System.out.println("__________________________________________________________");


        //draw field without move checker
        StartClassic.checkersPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
        ActivityClassic.drawView.invalidate();

        //add checker on start position and set visible
        if(checker == WHITE_CHECKER){
            ActivityClassic.ivChecker.layout((startJ - 2) * StartClassic.stepOnField,
                    (startI - 1) * StartClassic.stepOnField + ActivityClassic.indentTop,
                    (startJ - 2) * StartClassic.stepOnField + StartClassic.stepOnField,
                    (startI - 1) * StartClassic.stepOnField + StartClassic.stepOnField + ActivityClassic.indentTop);
            ActivityClassic.ivChecker.setVisibility(View.VISIBLE);
        }else{
            ActivityClassic.ivCheckerBlack.layout((startJ - 2) * StartClassic.stepOnField,
                    (startI - 1) * StartClassic.stepOnField + ActivityClassic.indentTop,
                    (startJ - 2) * StartClassic.stepOnField + StartClassic.stepOnField,
                    (startI - 1) * StartClassic.stepOnField + StartClassic.stepOnField + ActivityClassic.indentTop);
            ActivityClassic.ivCheckerBlack.setVisibility(View.VISIBLE);
        }


        //create animation
        int mX = StartClassic.stepOnField;
        int mY = 0;
        ObjectAnimator objectAnimator;
        Path path = new Path();
        path.moveTo(mX, mY);
        for (int step : steps) {
            if (step == STEP_RIGHT) mX += StartClassic.stepOnField;
            if (step == STEP_LEFT) mX -= StartClassic.stepOnField;
            if (step == STEP_BOTTOM) mY += StartClassic.stepOnField;
            if (step == STEP_TOP) mY -= StartClassic.stepOnField;
            if (step == JUMP_RIGHT) mX += StartClassic.stepOnField * 2;
            if (step == JUMP_LEFT) mX -= StartClassic.stepOnField * 2;
            if (step == JUMP_BOTTOM) mY += StartClassic.stepOnField * 2;
            if (step == JUMP_TOP) mY -= StartClassic.stepOnField * 2;

            path.lineTo(mX, mY);
        }

        if(checker == WHITE_CHECKER){
            objectAnimator = ObjectAnimator.ofFloat(ActivityClassic.ivChecker, "translationX", "translationY", path);
        }else {
            objectAnimator = ObjectAnimator.ofFloat(ActivityClassic.ivCheckerBlack, "translationX", "translationY", path);
        }

        objectAnimator.setDuration(600*steps.length);
        objectAnimator.start();


        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation, boolean isReverse) {
                StartClassic.checkersPositions[endI][endJ] = checker;
                ActivityClassic.drawView.invalidate();
                ActivityClassic.ivChecker.setVisibility(View.INVISIBLE);
                ActivityClassic.ivCheckerBlack.setVisibility(View.INVISIBLE);

                //after player move bot can move
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(checker == WHITE_CHECKER){
                    Bots bot = new Bots();
                    bot.botMove();
                }



            }
        });

    }
}
