package com.nokhrin.corners.levels.view;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nokhrin.corners.R;

public class ViewElements {
    private ActivityGameLevel activity;
    private TextView tvCountMove;
    private ImageView ivWoodman;
    private ImageView ivStars;
    private FrameLayout frameLayoutLevels;
    private View constrainLayout;
    private View frameLayoutIndent;
    private Button buttonMenu, buttonReturnLevels, buttonRestartLevel, bNextLevel;

    public void setActivity(ActivityGameLevel activity) {
        this.activity = activity;
        findView();
    }

    private void findView() {
        frameLayoutLevels = activity.findViewById(R.id.frameLayoutLevel);
        frameLayoutIndent = activity.findViewById(R.id.frameLayoutIndentLevels);
        tvCountMove = activity.findViewById(R.id.textViewCountMove);
        ivWoodman = activity.findViewById(R.id.imageViewCheckerWoodman);
        ivStars = activity.findViewById(R.id.ivStars);
        buttonMenu = activity.findViewById(R.id.buttonMenu);
        buttonReturnLevels = activity.findViewById(R.id.buttonReturnLevel);
        buttonRestartLevel = activity.findViewById(R.id.buttonRestartLevel);
        constrainLayout = activity.findViewById(R.id.constrainLayout);
        bNextLevel = activity.findViewById(R.id.bNextLevel);
    }

    public TextView getTvCountMove() {
        return tvCountMove;
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

    public View getConstrainLayout() {
        return constrainLayout;
    }

    public View getFrameLayoutIndent() {
        return frameLayoutIndent;
    }

    public Button getbNextLevel() {
        return bNextLevel;
    }

    public ImageView getIvStars() {
        return ivStars;
    }
}
