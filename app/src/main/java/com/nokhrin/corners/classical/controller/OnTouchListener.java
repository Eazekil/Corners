package com.nokhrin.corners.classical.controller;


import android.content.Intent;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.classical.view.ActivityClassic;

public class OnTouchListener implements View.OnTouchListener {
    private ActivityClassic activity;
    private Moving moving;

    public void setActivity(ActivityClassic activity) {
        this.activity = activity;

        //create and set parameters for convert pixel coordinates in coordinates of game field
        moving = new Moving();
        moving.setSizeOfField(activity.getStartGame().getSizeOfField());
        moving.setWidthDisplay(activity.getViewParameters().getDisplaySettings().getWidthDisplay());
        setTouch();
    }

    private void setTouch() {
        activity.getViewElements().getFrameLayout().setOnTouchListener(this);

        //button return to Menu
        activity.getViewElements().getButtonMenu().setOnClickListener(v -> {
            Intent intent = new Intent(activity, ActivityStart.class);
            activity.startActivity(intent);
            activity.finish();
        });

        //button restart this game
        activity.getViewElements().getButtonRestart().setOnClickListener(v -> {
            Intent intent = new Intent(activity, ActivityClassic.class);
            activity.startActivity(intent);
            activity.finish();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        moving.setTouchXY(touchX, touchY);

        //inform of touch coordinate
        activity.getStartGame().getPlayerMoving().startPlayerMove(moving.getTouchI(), moving.getTouchJ());

        return false;
    }
}
