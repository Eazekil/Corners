package com.nokhrin.corners.multiplayer.game;


import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.multiplayer.ActivityMultiplayerGame;
import com.nokhrin.corners.multiplayer.animation.Animation;

import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;

public class SecondPlayer {
    ActivityMultiplayerGame activity;

    public SecondPlayer(Activity activity) {
        this.activity = (ActivityMultiplayerGame) activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void updatePosition(String moveIn) {
        String[] str = moveIn.split(" ");
        int startI;
        int startJ;
        int andI;
        int andJ;
        startI = Integer.parseInt(str[0]);
        startJ = Integer.parseInt(str[1]);
        andI = Integer.parseInt(str[2]);
        andJ = Integer.parseInt(str[3]);

        int sizeOfField = activity.startGame.getCheckersPositions().length;

        //convert start and end positions
        startI = sizeOfField - startI;
        startJ = sizeOfField - startJ;
        andI = sizeOfField - andI;
        andJ = sizeOfField - andJ;

        //animate this move
        Animation animation = new Animation(activity);
        animation.step(startJ, startI, andJ, andI, activity.startGame.getCheckersPositions()[startI][startJ]);

    }
}
