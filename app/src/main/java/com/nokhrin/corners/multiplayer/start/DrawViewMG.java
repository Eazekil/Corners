package com.nokhrin.corners.multiplayer.start;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.widthDisplay;
import static com.nokhrin.corners.multiplayer.game.GameOver.gameIsOver;
import static com.nokhrin.corners.multiplayer.game.PlayerMove.touchOnField;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.checkersPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.marksPositions;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.playerWin;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.sizeOfField;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.sizePoint;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.stepOnField;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.touchI;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.touchJ;
import static com.nokhrin.corners.resources.ResourcesBitmap.blackCheckerBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.checkMarkBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.createBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.field8x8Bitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.playerLoseBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.playerWinBitmap;
import static com.nokhrin.corners.resources.ResourcesBitmap.setResourcesForDraw;
import static com.nokhrin.corners.resources.ResourcesBitmap.setSizePoint;
import static com.nokhrin.corners.resources.ResourcesBitmap.setStepOnField;
import static com.nokhrin.corners.resources.ResourcesBitmap.setWidthDisplay;
import static com.nokhrin.corners.resources.ResourcesBitmap.whiteCheckerBitmap;


public class DrawViewMG extends View implements View.OnTouchListener {
    //public static Resources resourcesForDraw;
    private Paint mPaint = new Paint();


    public DrawViewMG(Context context) {
        super(context);

       //set all variables
        setResourcesForDraw(this.getResources());
        setStepOnField(stepOnField);
        setWidthDisplay(widthDisplay);
        setSizePoint(sizePoint);

        //find pictures in resources
        createBitmap();

        //add touch listener
        setOnTouchListener(this);
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
                if (checkersPositions[i][j] == 1) {
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //black checkers
                if (checkersPositions[i][j] == 3) {
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

                //white checkers with mark
                if (checkersPositions[i][j] == 2) {
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    canvas.drawBitmap(checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                }

            }
        }


        if (gameIsOver()) {
            if (playerWin) {
                canvas.drawBitmap(playerWinBitmap, 0, 0, mPaint);
            } else {
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
