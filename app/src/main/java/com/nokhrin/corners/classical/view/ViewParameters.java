package com.nokhrin.corners.classical.view;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.classical.view.ActivityClassic;
import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.view.DisplaySettings;

public class ViewParameters {
    private DisplaySettings displaySettings;
    private DrawView drawView;
    private ActivityClassic activity;

    public void setActivity(ActivityClassic activity) {
        this.activity = activity;
        displaySettings = new DisplaySettings();
        setParameters();
        setBackground();

        //create view for draw and add in layout
        drawView = new DrawView(activity.getApplicationContext(), (AppCompatActivity) activity);
        ((ViewGroup) activity.getViewElements().getFrameLayout()).addView(drawView);
    }

    private void setParameters() {
        displaySettings.setLayout(activity.getViewElements().getConstrainLayout());
        displaySettings.setDisplay(activity.getWindowManager().getDefaultDisplay());
        displaySettings.setFlIntent((FrameLayout) activity.getViewElements().getFrameLayoutIndent());
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setBackground() {
        //draw game field like background
        activity.getViewElements().getFrameLayout().setBackground(
                activity.getResources().getDrawable(R.drawable.stone_field_8x8));
    }

    public DisplaySettings getDisplaySettings() {
        return displaySettings;
    }

    public DrawView getDrawView() {
        return drawView;
    }
}
