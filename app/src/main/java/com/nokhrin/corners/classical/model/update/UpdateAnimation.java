package com.nokhrin.corners.classical.model.update;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.nokhrin.corners.classical.view.Animation;
import com.nokhrin.corners.classical.model.StartGameClassic;

import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class UpdateAnimation {
    /*private Animation animation;
    private StartGameClassic startGame;

    public void setStartGame(StartGameClassic startGame) {
        this.startGame = startGame;
        animation = new Animation();
        animation.setDrawView(startGame.getActivity().getViewParameters().getDrawView());
        animation.setIndentTop(startGame.getActivity().getViewParameters().getDisplaySettings().getIndentTop());
        animation.setWidthDisplay(startGame.getActivity().getViewParameters().getDisplaySettings().getWidthDisplay());
    }

    public void setCheckerPositions(){
        animation.setCheckerPositions(startGame.getCheckerPositions());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setStep(int startI, int startJ, int endI, int endJ, int checker) {


        if (checker == WHITE_CHECKER) {
            animation.setImageView(startGame.getActivity().getViewElements().getIvChecker());
        } else {
            animation.setImageView(startGame.getActivity().getViewElements().getIvCheckerBlack());
        }

        animation.step(startJ, startI, endJ, endI, checker);
    }


    public void animate(){

    }
*/

}
