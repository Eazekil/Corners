package com.nokhrin.corners.multiplayer.game;


import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.drawView;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.playerMove;
import static com.nokhrin.corners.multiplayer.game.GameOver.gameIsOver;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.checkersPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.sizeOfField;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;

public class SecondPlayer {

    public static void updatePosition(String moveIn) {
        String[] str = moveIn.split(" ");
        int startI;
        int startJ;
        int andI;
        int andJ;
        startI = Integer.parseInt(str[0]);
        startJ = Integer.parseInt(str[1]);
        andI = Integer.parseInt(str[2]);
        andJ = Integer.parseInt(str[3]);

        //convert start and end positions
        startI = sizeOfField - startI;
        startJ = sizeOfField - startJ;
        andI = sizeOfField - andI;
        andJ = sizeOfField - andJ;


        //update checkers positions on field
        checkersPositions[andI][andJ] = checkersPositions[startI][startJ];
        checkersPositions[startI][startJ] = FREE_POSITION_ON_FIELD;

        //check game is over
        gameIsOver();

        //update draw field
        drawView.invalidate();

        //player can move
        if (!gameIsOver()) {
            playerMove = true;
        }

    }
}
