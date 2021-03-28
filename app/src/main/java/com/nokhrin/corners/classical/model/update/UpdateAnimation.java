package com.nokhrin.corners.classical.model.update;

import com.nokhrin.corners.classical.animation.Animation;
import com.nokhrin.corners.classical.model.StartGameClassic;

import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class UpdateAnimation {
    private Animation animation;
    private StartGameClassic startGame;

    public void setStartGame(StartGameClassic startGame) {
        this.startGame = startGame;
        animation = new Animation();
        animation.setCheckersPositions(startGame.getCheckersPositions());
        animation.setDrawView(startGame.getActivity().getViewParameters().getDrawView());
        animation.setIndentTop(startGame.getActivity().getViewParameters().getDisplaySettings().getIndentTop());
        animation.setWidthDisplay(startGame.getActivity().getViewParameters().getDisplaySettings().getWidthDisplay());
    }

    public void setStep(int startJ, int startI, int endJ, int endI, int checker) {
        if (checker == WHITE_CHECKER) {
            animation.setImageView(startGame.getActivity().getViewElements().getIvChecker());
        } else {
            animation.setImageView(startGame.getActivity().getViewElements().getIvCheckerBlack());
        }

        animation.step(startJ, startI, endJ, endI);
    }
}
