package com.nokhrin.corners.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.nokhrin.corners.resources.ResourcesBitmap;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.MARK_ON_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WIN_WIN;


public class DrawView extends View {
    private int sizeOfField;
    private int stepOnField;
    private int[][] checkersPositions;
    private Paint mPaint = new Paint();
    private int win;

    public DrawView(Context context) {
        super(context);

        //set variables
        ResourcesBitmap.setResourcesForDraw(this.getResources());
        win = 0;

        //find pictures in resources
        ResourcesBitmap.createBitmap();

    }

    public void setSizeOfField(int sizeOfField) {
        this.sizeOfField = sizeOfField;
    }

    public void setStepOnField(int stepOnField) {
        this.stepOnField = stepOnField;
    }

    public void setCheckersPositions(int[][] checkersPositions) {
        this.checkersPositions = checkersPositions;
    }

    public void setWin(int win) {
        this.win = win;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //draw chess field
        if (sizeOfField == 9) {
            canvas.drawBitmap(ResourcesBitmap.field8x8Bitmap, 0, 0, mPaint);
        }

        //draw checkers and marks
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                //white checkers
                if (checkersPositions[i][j] == WHITE_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //black checkers
                if (checkersPositions[i][j] == BLACK_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //white checkers with mark
                if (checkersPositions[i][j] == MARK_ON_WHITE_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    canvas.drawBitmap(ResourcesBitmap.checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //black checkers with mark
                if (checkersPositions[i][j] == MARK_ON_BLACK_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    canvas.drawBitmap(ResourcesBitmap.checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //target point
                if (checkersPositions[i][j] == TARGET_POINT_FOR_BLACK_CHECKER) {
                    canvas.drawBitmap(ResourcesBitmap.targetPointBitmap, (j - 1) * stepOnField + 50, (i - 1) * stepOnField + 50, mPaint);
                }
            }
        }

        //check we have winner
        if (win != 0) {
            if (win == PLAYER_WIN) {
                canvas.drawBitmap(ResourcesBitmap.playerWinBitmap, 0, 0, mPaint);
            } else if (win == BOT_WIN) {
                canvas.drawBitmap(ResourcesBitmap.playerLoseBitmap, 0, 0, mPaint);
            } else if (win == WIN_WIN) {
                canvas.drawBitmap(ResourcesBitmap.winWinBitmap, 0, 0, mPaint);
            }

        }

    }
}
