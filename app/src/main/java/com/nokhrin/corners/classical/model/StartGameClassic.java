package com.nokhrin.corners.classical.model;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.model.bots.Bots;
import com.nokhrin.corners.game.StartGame;

public class StartGameClassic extends StartGame {
    private PlayerMoving playerMoving;
    private CheckMove checkMove;
    private ResultMoves resultMoves;
    private Bots bot;
    private GameOver game;
    private Positions positions;


    public void setResultMoves(ResultMoves resultMoves) {
        this.resultMoves = resultMoves;

        //set start parameters this game
        StartParameters startParameters = new StartParameters();
        startParameters.setStartGame(this);
    }

    public void createGameObject() {
        positions = new Positions();
        positions.setCheckersPositions(checkerPositions);
        positions.setResultMoves(resultMoves);

        playerMoving = new PlayerMoving();
        playerMoving.setStartGame(this);

        checkMove = new CheckMove();
        checkMove.setStartGame(this);
        

        bot = new Bots();
        bot.setPositions(positions);

        game = new GameOver();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void botMove(){
        bot.setCheckerPositions(checkerPositions);

        //check game is over
        game.setCheckerPositions(checkerPositions);
        //add result
        resultMoves.setGame(game.getResultGame());

        resultMoves.endMove();
    }

    public PlayerMoving getPlayerMoving() {
        return playerMoving;
    }

    public CheckMove getCheckMove() {
        return checkMove;
    }

    public Positions getPositions() {
        return positions;
    }

    public ResultMoves getMoves() {
        return resultMoves;
    }
}
