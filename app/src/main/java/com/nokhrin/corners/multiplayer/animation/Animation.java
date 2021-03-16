package com.nokhrin.corners.multiplayer.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.drawView;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.indentTop;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.ivChecker;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.checkersPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.sizeOfField;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.stepOnField;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class Animation {

    public static void step(int x, int y, int endX, int endY) {

        //draw field without move checker
        checkersPositions[y][x] = FREE_POSITION_ON_FIELD;
        drawView.invalidate();

        //add checker on start position and set visible
        ivChecker.layout((x - 2) * stepOnField, (y - 1) * stepOnField + indentTop, (x - 2) * stepOnField + stepOnField, (y - 1) * stepOnField + stepOnField + indentTop);
        ivChecker.setVisibility(View.VISIBLE);

        StepsForAnimation stepsForAnimation = new StepsForAnimation(checkersPositions, y, x, endY, endX, sizeOfField);
        int[] steps = stepsForAnimation.steps();

        List<Animator> animList = new ArrayList<>();
        for (int step : steps) {
            ObjectAnimator objectAnimator = null;
            System.out.println("______ step = " +step);

           /* if(step == 1){
                objectAnimator = ObjectAnimator.ofFloat(ivChecker, "translationX", stepOnField, stepOnField * 2); //stepOnField, stepOnField * 2
            }
            if(step == 2){
                objectAnimator = ObjectAnimator.ofFloat(ivChecker, "translationX", stepOnField, 0 );
            }*/
            if(step == 3){
                objectAnimator = ObjectAnimator.ofFloat(ivChecker, "translationY", 0, 0, stepOnField,stepOnField*2);
            }

            objectAnimator.setDuration(1600);
            animList.add(objectAnimator);
        }

        AnimatorSet s = new AnimatorSet();
        s.playSequentially(animList);
        s.start();
        s.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                checkersPositions[endY][endX] = WHITE_CHECKER;
                drawView.invalidate();
                ivChecker.setVisibility(View.INVISIBLE);

            }
        });




       /* //start animation
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivChecker, "translationX", stepOnField, stepOnField * 2);
        objectAnimator.setDuration(1000);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(ivChecker, "translationY", 0, stepOnField );
        objectAnimator2.setDuration(1000);
        //objectAnimator.start();
        List<Animator> animList = new ArrayList<>();
        animList.add(objectAnimator);
        animList.add(objectAnimator2);

        AnimatorSet s = new AnimatorSet();
        //s.play(objectAnimator).with(objectAnimator2);
        //s.play(objectAnimator).before(objectAnimator2);
        //s.play(objectAnimator2).after(objectAnimator);
        s.playSequentially(animList);
        s.start();*/
        //AnimatorSet.play(Animator)

        /*//before end animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                objectAnimator2.start();

            }
        });

        objectAnimator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                checkersPositions[endY+1][endX] = WHITE_CHECKER;
                drawView.invalidate();
                ivChecker.setVisibility(View.INVISIBLE);
            }
        });*/


    }

}
