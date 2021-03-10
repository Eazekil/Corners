package com.nokhrin.corners.levels.start;

import android.view.View;
import android.widget.Button;

import static com.nokhrin.corners.ActivityStart.widthDisplay;
import static com.nokhrin.corners.levels.ActivityLevels.buttonSetInvisibleList;
import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countMoveView;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.elementSetVisibleList;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.ActivityLevels.sizePoint;
import static com.nokhrin.corners.levels.ActivityLevels.stepOnField;
import static com.nokhrin.corners.levels.PlayerMove.choiceI;
import static com.nokhrin.corners.levels.PlayerMove.choiceJ;
import static com.nokhrin.corners.levels.PossibleMoves.lastPlayerPositions;
import static com.nokhrin.corners.levels.PossibleMoves.resultPossibleMoves;
import static com.nokhrin.corners.levels.ResourcesBitmap.createBitmap;

public class StartForLevel {
    public static void addStartParameters(){
        choiceI = 0;//coordinate I of player's chosen checker
        choiceJ = 0;//coordinate J of player's chosen checker

        //set visible and invisible element on view
        for (View view : elementSetVisibleList) {
            view.setVisibility(View.VISIBLE);
        }
        for (Button button : buttonSetInvisibleList) {
            button.setVisibility(View.INVISIBLE);
        }

        //update variables for this level
        stepOnField = widthDisplay / (sizeOfField - 1);
        sizePoint = stepOnField / 3;
        createBitmap();

        //add text
        String s = "Ходов осталось : " + countToMove;
        countMoveView.setVisibility(View.VISIBLE);
        countMoveView.setText(s);

        //create matrix
        checkersPositions = new int[sizeOfField][sizeOfField];
        marksPositions = new int[sizeOfField][sizeOfField];
        resultPossibleMoves = new boolean[sizeOfField][sizeOfField];
        lastPlayerPositions = new boolean[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = 0;
            }
        }
    }
}
