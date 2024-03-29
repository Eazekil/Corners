package com.nokhrin.corners.levels.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Path;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.R;
import com.nokhrin.corners.game.StepsForAnimation;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.JUMP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.JUMP_LEFT;
import static com.nokhrin.corners.resources.Constants.JUMP_RIGHT;
import static com.nokhrin.corners.resources.Constants.JUMP_TOP;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.STEP_BOTTOM;
import static com.nokhrin.corners.resources.Constants.STEP_LEFT;
import static com.nokhrin.corners.resources.Constants.STEP_RIGHT;
import static com.nokhrin.corners.resources.Constants.STEP_TOP;
import static com.nokhrin.corners.resources.Constants.TAG;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;

public class Animation {
    private ActivityGameLevel activity;
    private StepsForAnimation stepsForAnimation;
    private int[][] checkerPositions;
    private int sizeOfStep;
    private int indentTop;
    private int win = 0;
    private int indentFrame;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void step(int startI, int startJ, int endI, int endJ) {
        Log.d(TAG, "setActivity: stepOnField_____++" + sizeOfStep);
        int countMove =activity.getStartGame().getCountToMove();


        stepsForAnimation.setCheckersPositions(checkerPositions);
        stepsForAnimation.setStartParameters(startI, startJ, endI, endJ);

        //get steps for animate checker
        int[] steps = stepsForAnimation.steps();

        //draw field without move checker
        checkerPositions[startI][startJ] = FREE_POSITION_ON_FIELD;
        activity.getViewParameters().getDrawView().setCheckerPositions(checkerPositions);
        activity.getViewParameters().getDrawView().invalidate();

        //add checker on start position and set visible
        activity.getViewParameters().getViewElements().getIvWoodman().layout((startJ - 2) * sizeOfStep + indentFrame,
                (startI - 1) * sizeOfStep + indentTop + indentFrame,
                (startJ - 2) * sizeOfStep + sizeOfStep + indentFrame,
                (startI - 1) * sizeOfStep + sizeOfStep + indentTop+ indentFrame
        );
        activity.getViewParameters().getViewElements().getIvWoodman().setVisibility(View.VISIBLE);

        //create animation
        int mX = sizeOfStep;
        int mY = 0;
        ObjectAnimator objectAnimator;
        Path path = new Path();
        path.moveTo(mX, mY);
        for (int step : steps) {
            if (step == STEP_RIGHT) mX += sizeOfStep;
            if (step == STEP_LEFT) mX -= sizeOfStep;
            if (step == STEP_BOTTOM) mY += sizeOfStep;
            if (step == STEP_TOP) mY -= sizeOfStep;
            if (step == JUMP_RIGHT) mX += sizeOfStep * 2;
            if (step == JUMP_LEFT) mX -= sizeOfStep * 2;
            if (step == JUMP_BOTTOM) mY += sizeOfStep * 2;
            if (step == JUMP_TOP) mY -= sizeOfStep * 2;

            path.lineTo(mX, mY);
        }

        objectAnimator = ObjectAnimator.ofFloat(activity.getViewParameters().getViewElements().getIvWoodman(), "translationX", "translationY", path);

        objectAnimator.setDuration(600 * steps.length);
        objectAnimator.start();


        //after end of animation draw checker on field and set invisible view
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onAnimationEnd(android.animation.Animator animation, boolean isReverse) {
                checkerPositions[endI][endJ] = WOODMAN_CHECKER;
                activity.getViewParameters().getDrawView().setCheckerPositions(checkerPositions);
                activity.getViewParameters().getDrawView().invalidate();
                Log.d(TAG, "onAnimationEnd: invalidateDrawView");
                activity.getViewParameters().getViewElements().getIvWoodman().setVisibility(View.INVISIBLE);
                if(win >0){
                    activity.getViewParameters().getDrawView().setWin(win);
                    activity.getViewParameters().getViewElements().getbNextLevel().setVisibility(View.VISIBLE);
                    activity.getViewParameters().getViewElements().getTvCountMove().setVisibility(View.INVISIBLE);
                    int stars = activity.getStartGame().getGameOver().getScore();
                    if(stars == 0){
                        activity.getViewParameters().getViewElements().getIvStars().setImageResource(R.drawable.star_0);
                    }else if(stars == 1){
                        activity.getViewParameters().getViewElements().getIvStars().setImageResource(R.drawable.star_1);
                    }else if(stars == 2){
                        activity.getViewParameters().getViewElements().getIvStars().setImageResource(R.drawable.star_2);
                    }else if(stars == 3){
                        activity.getViewParameters().getViewElements().getIvStars().setImageResource(R.drawable.star_3);
                    }
                    activity.getViewParameters().getViewElements().getIvStars().setVisibility(View.VISIBLE);
                }
                if(countMove > 0 || win == PLAYER_WIN){
                    @SuppressLint({"StringFormatInvalid", "LocalSuppress"})
                    String message = String.format(activity.getString(R.string.count_move_level), countMove);
                    activity.getViewParameters().getViewElements().getTvCountMove().setText(message);
                }else{
                    activity.getViewParameters().getViewElements().getTvCountMove().setText(R.string.moves_over);
                }
            }
        });


    }

    public void setActivity(ActivityGameLevel activity) {
        this.activity = activity;
        stepsForAnimation = new StepsForAnimation();
        indentFrame = activity.getViewParameters().getDisplaySettings().getWidthDisplay() * 30 / 1080;
        sizeOfStep = ((activity.getViewParameters().getDisplaySettings().getWidthDisplay() - indentFrame * 2) / (activity.getStartGame().getCheckerPositions().length - 1));
        Log.d(TAG, "setActivity: stepOnField_____" + sizeOfStep);
        indentTop = activity.getViewParameters().getDisplaySettings().getIndentTop();
        activity.getViewParameters().getViewElements().getTvCountMove().setVisibility(View.VISIBLE);
        @SuppressLint({"StringFormatInvalid", "LocalSuppress"})
        String message = String.format(activity.getString(R.string.count_move_level), activity.getStartGame().getCountToMove());
        activity.getViewParameters().getViewElements().getTvCountMove().setText(message);
    }

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = checkerPositions;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
