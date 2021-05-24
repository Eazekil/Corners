package com.nokhrin.corners.classical.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;
import com.nokhrin.corners.classical.controller.OnTouchListener;
import com.nokhrin.corners.classical.model.ResultMoves;
import com.nokhrin.corners.classical.model.StartGameClassic;
import com.nokhrin.corners.levels.view.ActivityLevels;


public class ActivityClassic extends AppCompatActivity {
    private StartGameClassic startGame;
    private ViewParameters viewParameters;
    private ResultMoves resultMoves;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        //add result for save moves
        resultMoves = new ResultMoves();
        resultMoves.setActivityClassic(this);

        //create new game
        startGame = new StartGameClassic();
        startGame.setResultMoves(resultMoves);
        startGame.createGameObject();


        //set start parameters for View
        viewParameters = new ViewParameters();
        viewParameters.setActivity(this);

        //add touchListener and buttons for this view
        OnTouchListener onTouchListener = new OnTouchListener();
        onTouchListener.setActivity(this);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ActivityStart.class);
        this.startActivity(intent);
        this.finish();
        super.onBackPressed();
    }

    public ViewParameters getViewParameters() {
        return viewParameters;
    }

    public StartGameClassic getStartGame() {
        return startGame;
    }

    public ResultMoves getResultMoves() {
        return resultMoves;
    }
}