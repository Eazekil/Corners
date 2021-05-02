package com.nokhrin.corners.levels.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.controller.OnTouchListener;
import com.nokhrin.corners.levels.database.CreateDb;
import com.nokhrin.corners.levels.database.LevelsDb;
import com.nokhrin.corners.levels.model.StartGameLevel;
import com.nokhrin.corners.levels.view.ViewParameters;
import com.nokhrin.corners.resources.Constants;

import java.io.File;

import static com.nokhrin.corners.levels.database.LevelsDb.DATABASE_NAME;
import static com.nokhrin.corners.resources.Constants.CREATE_NUMBER_LEVEL;
import static com.nokhrin.corners.resources.Constants.PLAYER_NAME;

public class ActivityGameLevel extends AppCompatActivity {
    private OnTouchListener onTouchListener;
    private ViewParameters viewParameters;
    private StartGameLevel startGame;
    private LevelsDb levelsDb;
    private int numberLevel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level);

        //get number level
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numberLevel = extras.getInt(CREATE_NUMBER_LEVEL);
        }

        levelsDb = new LevelsDb(this);
        levelsDb.getReadableDatabase();
        levelsDb.putDb();

        startGame = new StartGameLevel();
        startGame.setLevelsDb(levelsDb);
        startGame.setNumberLevel(numberLevel);

        //set start parameters for View
        viewParameters = new ViewParameters();
        viewParameters.setActivity(this);

        onTouchListener =new OnTouchListener();
        onTouchListener.setActivity(this);
    }

    public OnTouchListener getOnTouchListener() {
        return onTouchListener;
    }

    public ViewParameters getViewParameters() {
        return viewParameters;
    }

    public StartGameLevel getStartGame() {
        return startGame;
    }

    public LevelsDb getLevelsDb() {
        return levelsDb;
    }
}