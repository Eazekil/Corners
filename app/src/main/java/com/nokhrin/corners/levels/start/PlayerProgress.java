package com.nokhrin.corners.levels.start;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.widget.Button;

import com.nokhrin.corners.R;
import com.nokhrin.corners.levels.ActivityLevels;

import java.util.ArrayList;

import static com.nokhrin.corners.resources.Constants.LEVEL_PROGRESS;
import static com.nokhrin.corners.resources.Constants.ONE_STAR;
import static com.nokhrin.corners.resources.Constants.THREE_STAR;
import static com.nokhrin.corners.resources.Constants.TWO_STAR;

public class PlayerProgress {
    ActivityLevels activity;

    public PlayerProgress(ActivityLevels activity) {
        this.activity = activity;
    }

    public void checkLevels() {
        ArrayList<Button> buttons = activity.buttonSetInvisibleList;
        SharedPreferences preferences = activity.preferences;
        System.out.println("222222222222222222222222222222222222222222222222222");
        for (int i = 1; i < buttons.size(); i++) {
            String key = LEVEL_PROGRESS + i;
            int progress = preferences.getInt(key, 0);
            if (progress != 0) {
                setBackground(buttons.get(i), progress);
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setBackground(Button button, int progress) {
        System.out.println("3333333333333333333333333333333333333333333333333");
        if (progress == ONE_STAR) {
            button.setBackground(activity.getResources().getDrawable(R.drawable.button_star_1));
        } else if (progress == TWO_STAR) {
            button.setBackground(activity.getResources().getDrawable(R.drawable.button_star_2));
        } else if (progress == THREE_STAR) {
            System.out.println("4444444444444444444444444444444444444444444444444444");
            button.setBackground(activity.getResources().getDrawable(R.drawable.button_star_3));
        }
    }
}
