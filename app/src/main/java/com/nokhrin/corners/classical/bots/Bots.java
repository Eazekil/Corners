package com.nokhrin.corners.classical.bots;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.StartClassic;
import com.nokhrin.corners.classical.animation.Animation;
import com.nokhrin.corners.classical.bots.bot1.BotMitya;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;

public class Bots {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void botMove(){
        BotMitya bot = new BotMitya();
        bot.moveMitya(StartClassic.checkersPositions);

        Animation animation = new Animation();
        animation.step(bot.getStartJ(), bot.getStartI(), bot.getEndJ(), bot.getEndI(), BLACK_CHECKER);


    }
}
