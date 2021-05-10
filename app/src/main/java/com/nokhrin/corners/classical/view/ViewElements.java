package com.nokhrin.corners.classical.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nokhrin.corners.R;

public class ViewElements {
    private View frameLayout;
    private View constrainLayout;
    private View frameLayoutIndent;
    private ImageView ivChecker;
    private ImageView ivCheckerBlack;
    private Activity activity;
    private Button buttonMenu;
    private Button buttonRestart;

    public void setActivity(Activity activity) {
        this.activity = activity;
        findView();
    }

    private void findView() {
        frameLayout = activity.findViewById(R.id.frameLayoutClassic);
        ivChecker = activity.findViewById(R.id.imageViewCheckerWhite);
        ivCheckerBlack = activity.findViewById(R.id.imageViewCheckerBlack);
        buttonMenu = activity.findViewById(R.id.buttonMenu);
        buttonRestart = activity.findViewById(R.id.buttonRestart);
        constrainLayout = activity.findViewById(R.id.ConstrainLayoutClassic);
        frameLayoutIndent = activity.findViewById(R.id.frameLayoutIndentClassic);
    }

    public Button getButtonMenu() {
        return buttonMenu;
    }

    public Button getButtonRestart() {
        return buttonRestart;
    }

    public View getFrameLayout() {
        return frameLayout;
    }

    public View getConstrainLayout() {
        return constrainLayout;
    }

    public View getFrameLayoutIndent() {
        return frameLayoutIndent;
    }

    public ImageView getIvChecker() {
        return ivChecker;
    }

    public ImageView getIvCheckerBlack() {
        return ivCheckerBlack;
    }
}
