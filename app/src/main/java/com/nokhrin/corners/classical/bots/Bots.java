package com.nokhrin.corners.classical.bots;

import android.os.Build;

import androidx.annotation.RequiresApi;


import com.nokhrin.corners.classical.view.ActivityClassic;
import com.nokhrin.corners.classical.bots.bot1.BotMitya;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;

public class Bots {
    ActivityClassic activity;
    BotMitya botMitya;

    public Bots(ActivityClassic activity) {
        this.activity = activity;
        botMitya = new BotMitya(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void botMove(){
        //create new bot end he start move
        botMitya.moveMitya();

        //animate bot move
        activity.animation.step(botMitya.getStartJ(), botMitya.getStartI(), botMitya.getEndJ(), botMitya.getEndI(), BLACK_CHECKER);
    }
}
