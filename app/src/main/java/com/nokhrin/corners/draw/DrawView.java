package com.nokhrin.corners.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.ResourcesBitmap.blackCheckerBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.checkMarkBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.createBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.field8x8Bitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.setResourcesForDraw;
import static com.nokhrin.corners.resources.ResourcesBitmap.whiteCheckerBitmap;


public class DrawView extends View {
    private int sizeOfField;
    private int stepOnField;
    private int[][] checkersPositions;
    private Paint mPaint = new Paint();

    public void setSizeOfField(int sizeOfField) {
        this.sizeOfField = sizeOfField;
    }

    public void setStepOnField(int stepOnField) {
        this.stepOnField = stepOnField;
    }

    public void setCheckersPositions(int[][] checkersPositions) {
        this.checkersPositions = checkersPositions;
    }

    public DrawView(Context context) {
        super(context);

       //set all variables
        setResourcesForDraw(this.getResources());

        //find pictures in resources
        createBitmap();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //draw chess field
        if(sizeOfField == 9){
            canvas.drawBitmap(field8x8Bitmap, 0, 0, mPaint);
        }


        //draw checkers and marks
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                //white checkers
                if (checkersPositions[i][j] == WHITE_CHECKER) {
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //black checkers
                if (checkersPositions[i][j] == BLACK_CHECKER) {
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //white checkers with mark
                if (checkersPositions[i][j] == MARK_ON_WHITE_CHECKER) {
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    canvas.drawBitmap(checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //black checkers with mark
                if (checkersPositions[i][j] == MARK_ON_BLACK_CHECKER) {
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    canvas.drawBitmap(checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

            }
        }


    }
}
