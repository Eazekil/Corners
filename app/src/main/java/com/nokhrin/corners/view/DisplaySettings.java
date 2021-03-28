package com.nokhrin.corners.view;

import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class DisplaySettings {
    private View layout;
    private Display display;
    private int widthDisplay;
    private int heightDisplay;
    private int indentTop;
    private FrameLayout flIntent;

    public void setFlIntent(FrameLayout flIntent) {
        this.flIntent = flIntent;
        setIndentLayout();
    }

    public void setLayout(View layout) {
        this.layout = layout;
        setFullScreen();
    }

    public void setDisplay(Display display) {
        this.display = display;
        setDisplayParameters();
    }

    private void setFullScreen(){
        layout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void setDisplayParameters(){
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        heightDisplay = size.y;
        indentTop = (heightDisplay - widthDisplay) / 2;

    }

    private void setIndentLayout(){
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = indentTop;
        flIntent.setLayoutParams(params);
    }

    public int getWidthDisplay() {
        return widthDisplay;
    }

    public int getIndentTop() {
        return indentTop;
    }
}
