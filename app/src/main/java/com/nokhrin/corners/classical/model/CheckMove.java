package com.nokhrin.corners.classical.model;

import com.nokhrin.corners.game.StartGame;

public class CheckMove {
    private StartGame startGame;

    public void setStartGame(StartGame startGame) {
        this.startGame = startGame;
    }

    public boolean isCanMove() {
        return startGame.getWin() == 0 && startGame.isPlayerMove();
    }
}
