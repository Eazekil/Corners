package com.nokhrin.corners.classical.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.classical.animation.Animation;
import com.nokhrin.corners.classical.controller.Moving;
import com.nokhrin.corners.classical.controller.OnTouchListener;
import com.nokhrin.corners.classical.model.StartGameClassic;


public class ActivityClassic extends AppCompatActivity /*implements View.OnTouchListener*/ {
    private StartGameClassic startGame;
    //private Animation animation;
    private ViewParameters viewParameters;
    private ViewElements viewElements;


    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        //create new game
        startGame = new StartGameClassic();
        startGame.setActivity(this);

        //find all views for this activity
        viewElements = new ViewElements();
        viewElements.setActivity(this);

        //set start parameters for View
        viewParameters = new ViewParameters();
        viewParameters.setActivity(this);

        //add touchListener and buttons for this view
        OnTouchListener onTouchListener = new OnTouchListener();
        onTouchListener.setActivity(this);
    }

    public ViewParameters getViewParameters() {
        return viewParameters;
    }

    public ViewElements getViewElements() {
        return viewElements;
    }

    public StartGameClassic getStartGame() {
        return startGame;
    }
}