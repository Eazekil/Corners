package com.nokhrin.corners.levels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.nokhrin.corners.R;
import com.nokhrin.corners.resources.ResourcesBitmap;

import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.marksPositions;
import static com.nokhrin.corners.levels.ActivityLevels.sizeOfField;
import static com.nokhrin.corners.levels.ActivityLevels.stepOnField;
import static com.nokhrin.corners.levels.ActivityLevels.touchI;
import static com.nokhrin.corners.levels.ActivityLevels.touchJ;
import static com.nokhrin.corners.levels.ActivityLevels.widthDisplay;
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
    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //draw chess field
        if (sizeOfField == 5) {
            Bitmap stoneField4x4Bitmap = Bitmap.createScaledBitmap(
              BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_4x4), widthDisplay, widthDisplay, true);
            canvas.drawBitmap(stoneField4x4Bitmap, 0, 0, mPaint);
        } else if (sizeOfField == 6) {
            Bitmap stoneField5x5Bitmap = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_5x5), widthDisplay, widthDisplay, true);
            canvas.drawBitmap(stoneField5x5Bitmap, 0, 0, mPaint);
        } else if (sizeOfField == 7) {
            Bitmap stoneField6x6Bitmap = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_6x6), widthDisplay, widthDisplay, true);
            canvas.drawBitmap(stoneField6x6Bitmap, 0, 0, mPaint);
        }


        //draw checkers and marks
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                //target point
                if (marksPositions[i][j] == TARGET_POINT_FOR_WHITE_CHECKER) {
                    Bitmap targetPointBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.target_point), stepOnField, stepOnField, true);
                    canvas.drawBitmap(targetPointBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //white checkers
                if (checkersPositions[i][j] == WHITE_CHECKER) {
                    Bitmap woodmanCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.woodman), stepOnField, stepOnField, true);
                    canvas.drawBitmap(woodmanCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //black checkers
                if (checkersPositions[i][j] == BLACK_CHECKER) {
                    Bitmap vikingCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone), stepOnField, stepOnField, true);
                    canvas.drawBitmap(vikingCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //white checkers with mark
                if (checkersPositions[i][j] == MARK_ON_WHITE_CHECKER) {
                    Bitmap woodmanSelectCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.woodman_select), stepOnField, stepOnField, true);
                    canvas.drawBitmap(woodmanSelectCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    //canvas.drawBitmap(ResourcesBitmap.checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

            }
        }


        if (gameIsOver()) {
            if (playerWin) {
                Bitmap playerWinBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(playerWinBitmap, 0, 0, mPaint);
            } else {
                Bitmap playerLoseBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer_lose), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(playerLoseBitmap, 0, 0, mPaint);
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
