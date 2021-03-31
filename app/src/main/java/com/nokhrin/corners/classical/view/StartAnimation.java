package com.nokhrin.corners.classical.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.model.ResultMoves;
import com.nokhrin.corners.classical.model.StartGameClassic;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class StartAnimation {
    private ResultMoves resultMoves;
    private Animation animation;
    private int numberAnimation;
    private ActivityClassic activityClassic;

    public void setStartParameters() {
        animation = new Animation();
        animation.setStartAnimation(this);
        animation.setDrawView(activityClassic.getViewParameters().getDrawView());
        animation.setIndentTop(activityClassic.getViewParameters().getDisplaySettings().getIndentTop());
        animation.setCheckerPositions(activityClassic.getResultMoves().getCheckerPositions());
        animation.setWidthDisplay(activityClassic.getViewParameters().getDisplaySettings().getWidthDisplay());

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setResultMoves(ResultMoves resultMoves) {
        this.resultMoves = resultMoves;
        numberAnimation = 1;
        animate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animate(){
        if(numberAnimation == 1){
            animation.setImageView(activityClassic.getViewParameters().getViewElements().getIvChecker());
            animation.step(resultMoves.getPlayerMoves()[0], resultMoves.getPlayerMoves()[1], resultMoves.getPlayerMoves()[2], resultMoves.getPlayerMoves()[3], WHITE_CHECKER);
        }else if(numberAnimation == 2){
            animation.setImageView(activityClassic.getViewParameters().getViewElements().getIvCheckerBlack());
            animation.step(resultMoves.getBotMoves()[0], resultMoves.getBotMoves()[1], resultMoves.getBotMoves()[2], resultMoves.getBotMoves()[3], BLACK_CHECKER);
        }else if(numberAnimation == 3){
            if(resultMoves.getGame() == 0){
                //продолжить игру, разрешить игроку ходить
                activityClassic.getStartGame().setPlayerMove(true);
            }else {
                activityClassic.getViewParameters().getDrawView().setWin(resultMoves.getGame());
            }
        }

    }

    public void setActivityClassic(ActivityClassic activityClassic) {
        this.activityClassic = activityClassic;
    }

    public void setNumberAnimation(int numberAnimation) {
        this.numberAnimation = numberAnimation;
    }

    public int getNumberAnimation() {
        return numberAnimation;
    }
}
