package com.nokhrin.corners.levels.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.controller.OnTouchListener;
import com.nokhrin.corners.levels.database.LevelsDb;
import com.nokhrin.corners.levels.model.StartGameLevel;

import static com.nokhrin.corners.resources.Constants.CREATE_NUMBER_LEVEL;

public class ActivityGameLevel extends AppCompatActivity {
    private ViewParameters viewParameters;
    private StartGameLevel startGame;
    private int numberLevel;
    private Animation animation;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level);

        //get number level
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numberLevel = extras.getInt(CREATE_NUMBER_LEVEL);
        }

        LevelsDb levelsDb = new LevelsDb(this);
        levelsDb.getReadableDatabase();
        levelsDb.putDb();

        startGame = new StartGameLevel();
        startGame.setActivity(this);
        startGame.setLevelsDb(levelsDb);
        startGame.setNumberLevel(numberLevel);

        //set start parameters for View
        viewParameters = new ViewParameters();
        viewParameters.setActivity(this);

        OnTouchListener onTouchListener = new OnTouchListener();
        onTouchListener.setActivity(this);

        animation = new Animation();
        animation.setActivity(this);

        viewParameters.getViewElements().getButtonMenu().setVisibility(View.INVISIBLE);
        viewParameters.getViewElements().getButtonRestartLevel().setVisibility(View.VISIBLE);
        viewParameters.getViewElements().getButtonReturnLevels().setVisibility(View.VISIBLE);
    }

    public ViewParameters getViewParameters() {
        return viewParameters;
    }

    public StartGameLevel getStartGame() {
        return startGame;
    }

    public Animation getAnimation() {
        return animation;
    }

    public int getNumberLevel() {
        return numberLevel;
    }
}