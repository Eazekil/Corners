package com.nokhrin.corners.classical.model;


import com.nokhrin.corners.classical.GameOver;
import com.nokhrin.corners.classical.bots.Bots;
import com.nokhrin.corners.classical.model.update.UpdateAnimation;
import com.nokhrin.corners.classical.model.update.UpdateView;
import com.nokhrin.corners.classical.view.ActivityClassic;
import com.nokhrin.corners.game.StartGame;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class StartGameClassic extends StartGame {
    private PlayerMoving playerMoving;
    private CheckMove checkMove;
    private UpdateView updateView;
    private UpdateAnimation updateAnimation;
    private ActivityClassic activity;
    private Bots bot;
    private GameOver game;

    public void setActivity(ActivityClassic activity) {
        this.activity = activity;

        sizeOfField = 9;
        countTargetPoint = 12;

        StartParameters startParameters = new StartParameters();
        startParameters.setStartGame(this);

        playerMoving = new PlayerMoving();
        playerMoving.setStartGame(this);

        checkMove = new CheckMove();
        checkMove.setStartGame(this);

        updateView = new UpdateView();
        updateView.setDrawView(activity.getViewParameters().getDrawView());
    }

    public PlayerMoving getPlayerMoving() {
        return playerMoving;
    }

    public CheckMove getCheckMove() {
        return checkMove;
    }

    public UpdateView getUpdateView() {
        return updateView;
    }

    public UpdateAnimation getUpdateAnimation() {
        return updateAnimation;
    }

    public ActivityClassic getActivity() {
        return activity;
    }
}
