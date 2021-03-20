package com.nokhrin.corners.draw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;
import com.nokhrin.corners.classical.ActivityClassic;
import com.nokhrin.corners.multiplayer.ActivityMultiplayerGame;
import com.nokhrin.corners.game.StartGame;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.MARK_ON_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WIN_WIN;


@SuppressLint("ViewConstructor")
public class DrawView extends View {
    Paint mPaint = new Paint();
    ActivityClassic activityClassic;
    ActivityMultiplayerGame activityMultiplayerGame;
    Resources resourcesForDraw;
    StartGame startGame;
    int widthDisplay;
    int sizeOfField;
    int stepOnField;


    public DrawView(Context context, AppCompatActivity appCompatActivity) {
        super(context);
        if (appCompatActivity instanceof ActivityClassic) {
            this.activityClassic = (ActivityClassic) appCompatActivity;
            widthDisplay = activityClassic.widthDisplay;
            sizeOfField = activityClassic.startGame.getSizeOfField();
            stepOnField = activityClassic.startGame.getStepOnField();
            startGame = activityClassic.startGame;
        }

        if (appCompatActivity instanceof ActivityMultiplayerGame) {
            this.activityMultiplayerGame = (ActivityMultiplayerGame) appCompatActivity;
            startGame = activityMultiplayerGame.startGame;
            widthDisplay = activityMultiplayerGame.widthDisplay;
            sizeOfField = activityMultiplayerGame.startGame.getSizeOfField();
            stepOnField = activityMultiplayerGame.startGame.getStepOnField();
        }

        resourcesForDraw = this.getResources();


    }


    @Override
    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*sizeOfField = activity.startGame.getSizeOfField();
        //ResourcesBitmap resourcesBitmap =  new ResourcesBitmap();
        int stepOnField = activity.startGame.getStepOnField();*/

        //draw chess field
        if (sizeOfField == 9) {
            //create stone field 8x8

            Bitmap stoneField8x8Bitmap = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_8x8),
                    widthDisplay, widthDisplay, true);
            canvas.drawBitmap(stoneField8x8Bitmap, 0, 0, mPaint);
            stoneField8x8Bitmap.recycle();
        }

        //draw checkers and marks
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                //white checkers
                if (startGame.getCheckersPositions()[i][j] == WHITE_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_white), stepOnField, stepOnField, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    whiteCheckerBitmap.recycle();
                }

                //black checkers
                if (startGame.getCheckersPositions()[i][j] == BLACK_CHECKER) {
                    Bitmap blackCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_black), stepOnField, stepOnField, true);
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    blackCheckerBitmap.recycle();
                }

                //white checkers with mark
                if (startGame.getCheckersPositions()[i][j] == MARK_ON_WHITE_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_white), stepOnField, stepOnField, true);
                    Bitmap checkMarkBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.check_mark), stepOnField, stepOnField, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    canvas.drawBitmap(checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    whiteCheckerBitmap.recycle();
                    checkMarkBitmap.recycle();
                }

                //black checkers with mark
                if (startGame.getCheckersPositions()[i][j] == MARK_ON_BLACK_CHECKER) {
                    Bitmap blackCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_black), stepOnField, stepOnField, true);
                    Bitmap checkMarkBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.check_mark), stepOnField, stepOnField, true);
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    canvas.drawBitmap(checkMarkBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    blackCheckerBitmap.recycle();
                    checkMarkBitmap.recycle();
                }

                //target point
                if (startGame.getCheckersPositions()[i][j] == TARGET_POINT_FOR_BLACK_CHECKER) {
                    Bitmap targetPointBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.target_point), stepOnField, stepOnField, true);
                    canvas.drawBitmap(targetPointBitmap, (j - 1) * stepOnField + 50, (i - 1) * stepOnField + 50, mPaint);
                    targetPointBitmap.recycle();
                }
            }
        }

        //check we have winner
        int win = startGame.getWin();
        if (win != 0) {
            if (win == PLAYER_WIN) {
                Bitmap playerWinBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(playerWinBitmap, 0, 0, mPaint);
                playerWinBitmap.recycle();
            } else if (win == BOT_WIN) {
                Bitmap playerLoseBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer_lose), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(playerLoseBitmap, 0, 0, mPaint);
                playerLoseBitmap.recycle();
            } else if (win == WIN_WIN) {
                Bitmap winWinBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(winWinBitmap, 0, 0, mPaint);
                winWinBitmap.recycle();
            }

        }

    }
}
