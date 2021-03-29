package com.nokhrin.corners.classical.model;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.model.bots.Bots;
import com.nokhrin.corners.classical.view.ActivityClassic;
import com.nokhrin.corners.classical.view.StartAnimation;
import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.game.StartGame;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;

public class StartGameClassic extends StartGame {
    private PlayerMoving playerMoving;
    private CheckMove checkMove;
    //private UpdateView updateView;
    private DrawView drawView;
    private ActivityClassic activity;
    private Bots bot;
    private GameOver game;
    private Positions positions;
    private ResultMoves moves;
    private StartAnimation startAnimation;

    public void setActivity(ActivityClassic activity) {
        this.activity = activity;

        //set start parameters this game
        StartParameters startParameters = new StartParameters();
        startParameters.setStartGame(this);

        positions = new Positions();
        positions.setStartGame(this);

        playerMoving = new PlayerMoving();
        playerMoving.setStartGame(this);

        checkMove = new CheckMove();
        checkMove.setStartGame(this);

       /* updateView = new UpdateView();
        updateView.setDrawView(activity.getViewParameters().getDrawView());*/



       /* updateAnimation = new UpdateAnimation();
        updateAnimation.setCheckerPositions();*/


        moves = new ResultMoves();


        bot = new Bots();
        game = new GameOver();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void botMove(){
        bot.setCheckerPositions(checkerPositions);
        moves.setBotMoves(bot.getBotMove());
        positions.moveChecker(bot.getBotMove()[0], bot.getBotMove()[1], bot.getBotMove()[2], bot.getBotMove()[3], BLACK_CHECKER);
        game.setCheckerPositions(checkerPositions);

        moves.setGame(game.getResultGame());

        startAnimation.setResultMoves(moves);
    }

    public PlayerMoving getPlayerMoving() {
        return playerMoving;
    }

    public CheckMove getCheckMove() {
        return checkMove;
    }

    public void setDrawView(DrawView drawView) {
        this.drawView = drawView;
        startAnimation = new StartAnimation();
        startAnimation.setStartGameClassic(this);
    }

    public DrawView getDrawView() {
        return drawView;
    }

    public ActivityClassic getActivity() {
        return activity;
    }

    public Positions getPositions() {
        return positions;
    }

    public ResultMoves getMoves() {
        return moves;
    }
}
