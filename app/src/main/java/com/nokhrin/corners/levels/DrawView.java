package com.nokhrin.corners.levels;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.nokhrin.corners.resources.ResourcesBitmap;

import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.ActivityLevels.stepOnField;
import static com.nokhrin.corners.levels.ActivityLevels.touchI;
import static com.nokhrin.corners.levels.ActivityLevels.touchJ;
import static com.nokhrin.corners.levels.GameOver.gameIsOver;
import static com.nokhrin.corners.levels.GameOver.playerWin;
import static com.nokhrin.corners.levels.PlayerMove.touchOnField;
import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;


public class DrawView extends View implements View.OnTouchListener {
    public static Resources resourcesForDraw;
    private Paint mPaint = new Paint();

    public DrawView(Context context) {
        super(context);

        //find pictures in resources
        resourcesForDraw = this.getResources();

        //add touch listener
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //draw chess field
        if (sizeOfField == 5) {
            canvas.drawBitmap(ResourcesBitmap.stoneField4x4Bitmap, 0, 0, mPaint);
        } else if (sizeOfField == 6) {
            canvas.drawBitmap(ResourcesBitmap.stoneField5x5Bitmap, 0, 0, mPaint);
        } else if (sizeOfField == 7) {
            canvas.drawBitmap(ResourcesBitmap.stoneField6x6Bitmap, 0, 0, mPaint);
        }


        //draw checkers and marks
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                //target point
                if (marksPositions[i][j] == TARGET_POINT_FOR_WHITE_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.targetPointBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //white checkers
                if (checkersPositions[i][j] == WHITE_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.woodmanCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //black checkers
                if (checkersPositions[i][j] == BLACK_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.vikingCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //white checkers with mark
                if (checkersPositions[i][j] == MARK_ON_WHITE_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.woodmanSelectCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    //canvas.drawBitmap(ResourcesBitmap.checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

            }
        }


        if (gameIsOver()) {
            if (playerWin) {
                canvas.drawBitmap(ResourcesBitmap.playerWinBitmap, 0, 0, mPaint);
            } else {
                canvas.drawBitmap(ResourcesBitmap.playerLoseBitmap, 0, 0, mPaint);
            }
        }


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //get coordinates of touch
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        //convert coordinates X,Y in step on chess field
        touchI = touchY / stepOnField + 1;
        touchJ = touchX / stepOnField + 1;

        System.out.printf("_______________touch I and J : %d,%d", touchI, touchJ);
        System.out.println();

        touchOnField();
        return false;
    }
}
