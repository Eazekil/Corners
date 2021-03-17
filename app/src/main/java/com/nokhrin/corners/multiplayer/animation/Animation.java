package com.nokhrin.corners.multiplayer.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.drawView;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.indentTop;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.ivChecker;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.checkersPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.sizeOfField;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.stepOnField;
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
    public static void step(int x, int y, int endX, int endY) {

        //get steps for animate checker
        StepsForAnimation stepsForAnimation = new StepsForAnimation(checkersPositions, y, x, endY, endX, sizeOfField);
        int[] steps = stepsForAnimation.steps();

        //draw field without move checker
        checkersPositions[y][x] = FREE_POSITION_ON_FIELD;
        drawView.invalidate();

        //add checker on start position and set visible
        ivChecker.layout((x - 2) * stepOnField,
                (y - 1) * stepOnField + indentTop,
                (x - 2) * stepOnField + stepOnField,
                (y - 1) * stepOnField + stepOnField + indentTop);
        ivChecker.setVisibility(View.VISIBLE);

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
        objectAnimator = ObjectAnimator.ofFloat(ivChecker, "translationX", "translationY", path);
        objectAnimator.setDuration(600*steps.length);
        objectAnimator.start();


        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                checkersPositions[endY][endX] = WHITE_CHECKER;
                drawView.invalidate();
                ivChecker.setVisibility(View.INVISIBLE);
            }
        });

    }
}
