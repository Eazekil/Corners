package com.nokhrin.corners.draw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
    int[][] checkerPositions;


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

    public static Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    @Override
    @SuppressLint({"DrawAllocation", "UseCompatLoadingForDrawables"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        checkerPositions = startGame.getCheckersPositions();

        /*sizeOfField = activity.startGame.getSizeOfField();
        //ResourcesBitmap resourcesBitmap =  new ResourcesBitmap();
        int stepOnField = activity.startGame.getStepOnField();*/

        //draw chess field
       /* if (sizeOfField == 9) {

            //create stone field 8x8
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_8x8, options);


            *//*System.out.println("****************************************************************************");
            System.out.println(resourcesForDraw == null);
            System.out.println(R.mipmap.stone_field_8x8 == 0);
            System.out.println(activityClassic == null);
            System.out.println(activityClassic.getResources() == null);
            System.out.println(activityClassic.getResources().getDrawable(R.drawable.checker_white) == null);




            activityClassic.getResources().getDrawable(R.mipmap.stone_field_8x8);


            Bitmap bitmap = drawableToBitmap(activityClassic.getResources().getDrawable(R.mipmap.stone_field_8x8));

            Bitmap stoneField8x8Bitmap = Bitmap.createScaledBitmap(
                    bitmap,
                    widthDisplay, widthDisplay, true);*//*

            canvas.drawBitmap(bitmap, 0, 0, mPaint);
            bitmap.recycle();
        }*/

        //draw checkers and marks
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                //white checkers
                if (checkerPositions[i][j] == WHITE_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_white), stepOnField, stepOnField, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    whiteCheckerBitmap.recycle();
                }

                //black checkers
                if (checkerPositions[i][j] == BLACK_CHECKER) {
                    Bitmap blackCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_black), stepOnField, stepOnField, true);
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * stepOnField, (i - 1) * stepOnField, mPaint);
                    blackCheckerBitmap.recycle();
                }

                //white checkers with mark
                if (checkerPositions[i][j] == MARK_ON_WHITE_CHECKER) {
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
                if (checkerPositions[i][j] == MARK_ON_BLACK_CHECKER) {
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
                if (checkerPositions[i][j] == TARGET_POINT_FOR_BLACK_CHECKER) {
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
