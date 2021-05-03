package com.nokhrin.corners.classical.view;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.view.DisplaySettings;

public class ViewParameters {
    private DisplaySettings displaySettings;
    private DrawView drawView;
    private ActivityClassic activity;
    private ViewElements viewElements;

    public void setActivity(ActivityClassic activity) {
        this.activity = activity;
        displaySettings = new DisplaySettings();

        //find all views for this activity
        viewElements = new ViewElements();
        viewElements.setActivity(activity);

        setParameters();
        setBackground();

        //create view for draw and add in layout
        drawView = new DrawView(activity.getApplicationContext(), (AppCompatActivity) activity);
        activity.getResultMoves().setDrawView(drawView);
        ((ViewGroup) viewElements.getFrameLayout()).addView(drawView);
        drawView.setCheckerPositions(activity.getStartGame().getCheckerPositions());
        drawView.setWidthDisplay(displaySettings.getWidthDisplay());
    }

    private void setParameters() {
        displaySettings.setLayout(viewElements.getConstrainLayout());
        displaySettings.setDisplay(activity.getWindowManager().getDefaultDisplay());
        displaySettings.setFrameLayout((FrameLayout) viewElements.getFrameLayout());
        displaySettings.setFlIndent((FrameLayout) viewElements.getFrameLayoutIndent());

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setBackground() {
        //draw game field like background
        viewElements.getFrameLayout().setBackground(activity.getResources().getDrawable(R.drawable.stone_field_8x8));
    }

    public DisplaySettings getDisplaySettings() {
        return displaySettings;
    }

    public DrawView getDrawView() {
        return drawView;
    }

    public ViewElements getViewElements() {
        return viewElements;
    }
}
