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
import com.nokhrin.corners.classical.view.ActivityClassic;
import com.nokhrin.corners.levels.view.ActivityGameLevel;
import com.nokhrin.corners.multiplayer.ActivityMultiplayerGame;
import com.nokhrin.corners.game.StartGame;

import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.BOT_WIN;
import static com.nokhrin.corners.resources.Constants.MARK_ON_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.MARK_ON_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.PLAYER_WIN;
import static com.nokhrin.corners.resources.Constants.SELECT_WOODMAN_CHECKER;
import static com.nokhrin.corners.resources.Constants.STONE_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WIN_WIN;
import static com.nokhrin.corners.resources.Constants.WOODMAN_CHECKER;


@SuppressLint("ViewConstructor")
public class DrawView extends View {
    private Paint mPaint = new Paint();
    private ActivityMultiplayerGame activityMultiplayerGame;
    private Resources resourcesForDraw;
    private StartGame startGame;
    private int widthDisplay;
    private int sizeOfField;
    private int sizeOfStep;
    private int[][] checkerPositions;
    private int[][] marksPositions;
    private int win;
    private int indentFrame;

    public void setWin(int win) {
        this.win = win;
    }

    public void setCheckerPositions(int[][] checkerPositions) {
        this.checkerPositions = new int[checkerPositions.length][checkerPositions.length];
        for (int i = 1; i < checkerPositions.length; i++) {
            for (int j = 1; j < checkerPositions.length; j++) {
                this.checkerPositions[i][j] = checkerPositions[i][j];
            }
        }
        this.sizeOfField = checkerPositions.length;
    }

    public void setWidthDisplay(int widthDisplay) {
        this.widthDisplay = widthDisplay;
        this.indentFrame = widthDisplay * 30 / 1080;
        this.sizeOfStep = (int) ((widthDisplay - indentFrame * 2) / (checkerPositions.length - 1));

    }

    public DrawView(Context context, AppCompatActivity appCompatActivity) {
        super(context);
        if (appCompatActivity instanceof ActivityClassic) {
        }

        if (appCompatActivity instanceof ActivityMultiplayerGame) {
            this.activityMultiplayerGame = (ActivityMultiplayerGame) appCompatActivity;
            startGame = activityMultiplayerGame.startGame;
            widthDisplay = activityMultiplayerGame.widthDisplay;
            sizeOfField = activityMultiplayerGame.startGame.getSizeOfField();
            sizeOfStep = activityMultiplayerGame.startGame.getStepOnField();
        }

        if (appCompatActivity instanceof ActivityGameLevel) {
            marksPositions = ((ActivityGameLevel)appCompatActivity).getStartGame().getMarksPositions();
        }

        resourcesForDraw = this.getResources();
    }

    @Override
    @SuppressLint({"DrawAllocation", "UseCompatLoadingForDrawables"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*checkerPositions = startGame.getCheckersPositions();*/

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
                System.out.println("ssss  "+checkerPositions[i][j]);
                //target point
                if (marksPositions != null) {
                    if (marksPositions[i][j] == TARGET_POINT_FOR_WHITE_CHECKER) {
                        Bitmap targetPointBitmap = Bitmap.createScaledBitmap(
                                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.target_point), sizeOfStep, sizeOfStep, true);
                        canvas.drawBitmap(targetPointBitmap, (j - 1) * sizeOfStep + indentFrame, (i - 1) * sizeOfStep + indentFrame, mPaint);
                        targetPointBitmap.recycle();
                    }
                }


                //white checkers
                if (checkerPositions[i][j] == WHITE_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_white), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * sizeOfStep + indentFrame, (i - 1) * sizeOfStep + indentFrame, mPaint);
                    whiteCheckerBitmap.recycle();
                }

                //black checkers
                if (checkerPositions[i][j] == BLACK_CHECKER) {
                    Bitmap blackCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_black), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * sizeOfStep + indentFrame, (i - 1) * sizeOfStep + indentFrame, mPaint);
                    blackCheckerBitmap.recycle();
                }

                //white checkers with mark
                if (checkerPositions[i][j] == MARK_ON_WHITE_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_white), sizeOfStep, sizeOfStep, true);
                    Bitmap checkMarkBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.check_mark), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * sizeOfStep + indentFrame, (i - 1) * sizeOfStep + indentFrame, mPaint);
                    canvas.drawBitmap(checkMarkBitmap, (j - 1) * sizeOfStep + indentFrame, (i - 1) * sizeOfStep + indentFrame, mPaint);
                    whiteCheckerBitmap.recycle();
                    checkMarkBitmap.recycle();
                }

                //black checkers with mark
                if (checkerPositions[i][j] == MARK_ON_BLACK_CHECKER) {
                    Bitmap blackCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_black), sizeOfStep, sizeOfStep, true);
                    Bitmap checkMarkBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.check_mark), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(blackCheckerBitmap, (j - 1) * sizeOfStep + indentFrame, (i - 1) * sizeOfStep + indentFrame, mPaint);
                    canvas.drawBitmap(checkMarkBitmap, (j - 1) * sizeOfStep + indentFrame, (i - 1) * sizeOfStep + indentFrame, mPaint);
                    blackCheckerBitmap.recycle();
                    checkMarkBitmap.recycle();
                }

                //woodman checkers
                if (checkerPositions[i][j] == WOODMAN_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.woodman), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * sizeOfStep, (i - 1) * sizeOfStep, mPaint);
                    whiteCheckerBitmap.recycle();
                }

                //woodman select checkers
                if (checkerPositions[i][j] == SELECT_WOODMAN_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.woodman_select), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * sizeOfStep, (i - 1) * sizeOfStep, mPaint);
                    whiteCheckerBitmap.recycle();
                }

                //stone checkers
                if (checkerPositions[i][j] == STONE_CHECKER) {
                    Bitmap whiteCheckerBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(whiteCheckerBitmap, (j - 1) * sizeOfStep, (i - 1) * sizeOfStep, mPaint);
                    whiteCheckerBitmap.recycle();
                }


                //target point
                if (checkerPositions[i][j] == TARGET_POINT_FOR_BLACK_CHECKER) {
                    Bitmap targetPointBitmap = Bitmap.createScaledBitmap(
                            BitmapFactory.decodeResource(resourcesForDraw, R.drawable.target_point), sizeOfStep, sizeOfStep, true);
                    canvas.drawBitmap(targetPointBitmap, (j - 1) * sizeOfStep + 50, (i - 1) * sizeOfStep + 50, mPaint);
                    targetPointBitmap.recycle();
                }
            }
        }

        //check we have winner
        if (win != 0) {
            if (win == PLAYER_WIN) {
                Bitmap playerWinBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.shield_win), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(playerWinBitmap, 0, 0, mPaint);
                playerWinBitmap.recycle();
            } else if (win == BOT_WIN) {
                Bitmap playerLoseBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.shield_lose), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(playerLoseBitmap, 0, 0, mPaint);
                playerLoseBitmap.recycle();
            } else if (win == WIN_WIN) {
                Bitmap winWinBitmap = Bitmap.createScaledBitmap(
                        BitmapFactory.decodeResource(resourcesForDraw, R.drawable.shield_win), widthDisplay, widthDisplay, true);
                canvas.drawBitmap(winWinBitmap, 0, 0, mPaint);
                winWinBitmap.recycle();
            }

        }

    }
}
