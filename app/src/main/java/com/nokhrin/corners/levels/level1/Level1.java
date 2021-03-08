package com.nokhrin.corners.levels.level1;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;

import com.nokhrin.corners.R;

import static com.nokhrin.corners.ActivityStart.widthDisplay;
import static com.nokhrin.corners.levels.ActivityLevels.buttonsLevelList;
import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.field4x4;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.DrawFieldLevel.drawField;
import static com.nokhrin.corners.levels.DrawView.resourcesForDraw;
import static com.nokhrin.corners.levels.DrawView.fieldBitmap;
import static com.nokhrin.corners.levels.PlayerMove.playerStartMove;

public class Level1 {


    public static void startLevel1() {

        //invisible all buttons level
        for (Button button : buttonsLevelList) {
            button.setVisibility(View.INVISIBLE);
        }

        countToMove = 7;

        //set visible field
        /*field4x4.setVisibility(View.VISIBLE);
        textCountMove.setVisibility(View.VISIBLE);*/

        /*countMove.setVisibility(View.VISIBLE);

        countMove.setText(s);*/
        //updateText("Осталось ходов : " + countToMove);
        //String s = "Осталось ходов : "+countToMove;
        //textCountMove.setText(s);
        //drawField();

        Bitmap bitmap = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_4x4);
        fieldBitmap = Bitmap.createScaledBitmap(bitmap, widthDisplay, widthDisplay, true);



        //
        playerStartMove();


        //add checkers on field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = 0;
            }
        }

        checkersPositions[4][1] = 1;
        checkersPositions[4][2] = 1;

        drawField();

    }

}
