package com.nokhrin.corners.levels.view;

import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nokhrin.corners.R;

public class ViewElements {
    private ActivityLevels activity;
    private TextView countMoveView;
    private ImageView ivWoodman;
    private FrameLayout frameLayoutLevels;
    private Button buttonMenu, buttonReturnLevels, buttonRestartLevel;

    public void setActivity(ActivityLevels activity) {
        this.activity = activity;
        findView();
    }

    private void findView() {
        frameLayoutLevels = activity.findViewById(R.id.frameLayoutLevel);
        countMoveView = activity.findViewById(R.id.textViewCountMove);
        ivWoodman = activity.findViewById(R.id.imageViewCheckerWoodman);
        buttonMenu = activity.findViewById(R.id.buttonMenu);
        buttonReturnLevels = activity.findViewById(R.id.buttonReturnLevel);
        buttonRestartLevel = activity.findViewById(R.id.buttonRestartLevel);
    }

    public TextView getCountMoveView() {
        return countMoveView;
    }

    public ImageView getIvWoodman() {
        return ivWoodman;
    }

    public FrameLayout getFrameLayoutLevels() {
        return frameLayoutLevels;
    }

    public Button getButtonMenu() {
        return buttonMenu;
    }

    public Button getButtonReturnLevels() {
        return buttonReturnLevels;
    }

    public Button getButtonRestartLevel() {
        return buttonRestartLevel;
    }
}
