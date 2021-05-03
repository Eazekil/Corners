package com.nokhrin.corners.levels.view;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.view.DisplaySettings;

import static com.nokhrin.corners.resources.Constants.TAG;

public class ViewParameters {
    private DisplaySettings displaySettings;
    private DrawView drawView;
    private ActivityGameLevel activity;
    private ViewElements viewElements;

    public void setActivity(ActivityGameLevel activity) {
        this.activity = activity;
        displaySettings = new DisplaySettings();


        //find all views for this activity
        viewElements = new ViewElements();
        viewElements.setActivity(activity);

        setParameters();
        setBackground();

        //create view for draw and add in layout
        drawView = new DrawView(activity.getApplicationContext(), (AppCompatActivity) activity);
        //activity.getResultMoves().setDrawView(drawView);
        ((ViewGroup) viewElements.getFrameLayoutLevels()).addView(drawView);
        drawView.setCheckerPositions(activity.getStartGame().getCheckerPositions());
        drawView.setWidthDisplay(displaySettings.getWidthDisplay());
    }

    private void setParameters() {
        displaySettings.setLayout(viewElements.getConstrainLayout());
        displaySettings.setDisplay(activity.getWindowManager().getDefaultDisplay());
        displaySettings.setFrameLayout((FrameLayout) viewElements.getFrameLayoutLevels());
        displaySettings.setFlIndent((FrameLayout) viewElements.getFrameLayoutIndent());

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setBackground() {
        //draw game field like background
        int sizeOfField = activity.getStartGame().getSizeOfField();
        Log.d(TAG, "setBackground: sizeOfField = "+sizeOfField);
        if(sizeOfField == 5){
            viewElements.getFrameLayoutLevels().setBackground(activity.getResources().getDrawable(R.drawable.stone_field_4x4));
        }
        if(sizeOfField == 6){
            viewElements.getFrameLayoutLevels().setBackground(activity.getResources().getDrawable(R.drawable.stone_field_5x5));
        }
        if(sizeOfField == 7){
            viewElements.getFrameLayoutLevels().setBackground(activity.getResources().getDrawable(R.drawable.stone_field_6x6));
        }
        if(sizeOfField == 8){
            viewElements.getFrameLayoutLevels().setBackground(activity.getResources().getDrawable(R.drawable.stone_field_7x7));
        }
        if(sizeOfField == 9){
            viewElements.getFrameLayoutLevels().setBackground(activity.getResources().getDrawable(R.drawable.stone_field_8x8));
        }

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
