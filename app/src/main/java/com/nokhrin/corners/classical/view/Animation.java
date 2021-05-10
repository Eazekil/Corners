package com.nokhrin.corners.classical.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.view.DrawView;
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

public class Animation {
    private StepsForAnimation stepsForAnimation;
    private int[][] checkerPositions;
    private DrawView drawView;
    private ImageView imageView;
    private int stepOnField;
    private int indentTop;
    private StartAnimation startAnimation;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void step(int startI, int startJ, int endI, int endJ, int checker) {
        stepsForAnimation.setStartParameters(startI, startJ, endI, endJ);

        //get steps for animate checker
        int[] steps = stepsForAnimation.steps();

        //draw field without move checker
        checkerPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
        drawView.setCheckerPositions(checkerPositions);
        drawView.invalidate();

        //add checker on start position and set visible
        imageView.layout((startJ - 2) * stepOnField,
                (startI - 1) * stepOnField + indentTop,
                (startJ - 2) * stepOnField + stepOnField,
                (startI - 1) * stepOnField + stepOnField + indentTop);
        imageView.setVisibility(View.VISIBLE);

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

        objectAnimator = ObjectAnimator.ofFloat(imageView, "translationX", "translationY", path);
        objectAnimator.setDuration(600*steps.length);
        objectAnimator.start();

        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation, boolean isReverse) {
                checkerPositions[endI][endJ] = checker;
                imageView.setVisibility(View.INVISIBLE);
                drawView.setCheckerPositions(checkerPositions);
                drawView.invalidate();
                startAnimation.setNumberAnimation(startAnimation.getNumberAnimation()+1);
                startAnimation.animate();
            }
        });

    }

    public void setStartAnimation(StartAnimation startAnimation) {
        this.startAnimation = startAnimation;
    }

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = checkerPositions;

        //update checker positions in other object
        drawView.setCheckerPositions(checkerPositions);
        stepsForAnimation = new StepsForAnimation();
        stepsForAnimation.setCheckersPositions(checkerPositions);
    }

    public void setDrawView(DrawView drawView) {
        this.drawView = drawView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setWidthDisplay(int widthDisplay) {
        stepOnField = widthDisplay / (checkerPositions.length - 1);

    }

    public void setIndentTop(int indentTop) {
        this.indentTop = indentTop;
    }
}
