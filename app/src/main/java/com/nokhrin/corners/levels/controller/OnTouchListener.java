package com.nokhrin.corners.levels.controller;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.classical.controller.Moving;
import com.nokhrin.corners.levels.view.ActivityGameLevel;
import com.nokhrin.corners.levels.view.ActivityLevels;

public class OnTouchListener implements View.OnTouchListener {
    private ActivityGameLevel activity;
    //private CreateGame createGame;
    private Moving moving;

    public void setActivity(ActivityGameLevel activity) {
        this.activity = activity;

        //create and set parameters for convert pixel coordinates in coordinates of game field
        moving = new Moving();
        moving.setSizeOfField(activity.getStartGame().getSizeOfField());
        moving.setWidthDisplay(activity.getViewParameters().getDisplaySettings().getWidthDisplay());
        setTouch();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setTouch() {
        activity.getViewParameters().getViewElements().getFrameLayoutLevels().setOnTouchListener(this);

        //button return to Menu
        activity.getViewParameters().getViewElements().getButtonMenu().setOnClickListener(v -> {
            Intent intent = new Intent(activity, ActivityStart.class);
            activity.startActivity(intent);
            activity.finish();
        });

        //button return to menu levels
        activity.getViewParameters().getViewElements().getButtonReturnLevels().setOnClickListener(v -> {
            Intent intent = new Intent(activity, ActivityLevels.class);
            activity.startActivity(intent);
            activity.finish();
        });

        //button restart level
        activity.getViewParameters().getViewElements().getButtonRestartLevel().setOnClickListener(v -> {
            /*Intent intent = new Intent(activity, ActivityLevels.class);
            activity.startActivity(intent);
            activity.finish();*/
            System.out.println("********************** restart");
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        moving.setTouchXY(touchX, touchY);

        //inform of touch coordinate
        //activity.getStartGame().getPlayerMoving().startPlayerMove(moving.getTouchI(), moving.getTouchJ());

        return false;
    }

    public void setNumberLevel(int numberLevel) {
        activity.getStartGame().setNumberLevel(numberLevel);
        activity.getViewParameters().setActivity(activity);
    }

}