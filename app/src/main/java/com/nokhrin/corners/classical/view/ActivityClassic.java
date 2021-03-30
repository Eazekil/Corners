package com.nokhrin.corners.classical.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.classical.controller.OnTouchListener;
import com.nokhrin.corners.classical.model.ResultMoves;
import com.nokhrin.corners.classical.model.StartGameClassic;


public class ActivityClassic extends AppCompatActivity {
    private StartGameClassic startGame;
    private ViewParameters viewParameters;
    private ResultMoves resultMoves;

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        //add result for save moves
        resultMoves = new ResultMoves();

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