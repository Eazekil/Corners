package com.nokhrin.corners.resources;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.nokhrin.corners.R;


public class ResourcesBitmap {
    public static Bitmap chessField4x4Bitmap;
    public static Bitmap chessField5x5Bitmap;
    public static Bitmap chessField6x6Bitmap;
    public static Bitmap chessField8x8Bitmap;
    public static Bitmap stoneField8x8Bitmap;
    public static Bitmap stoneField4x4Bitmap;
    public static Bitmap stoneField5x5Bitmap;
    public static Bitmap stoneField6x6Bitmap;
    public static Bitmap whiteCheckerBitmap;
    public static Bitmap blackCheckerBitmap;
    public static Bitmap woodmanCheckerBitmap;
    public static Bitmap woodmanSelectCheckerBitmap;
    public static Bitmap vikingCheckerBitmap;
    public static Bitmap vikingSelectCheckerBitmap;
    public static Bitmap checkMarkBitmap;
    public static Bitmap targetPointBitmap;
    public static Bitmap playerWinBitmap;
    public static Bitmap playerLoseBitmap;
    public static Bitmap winWinBitmap;
    private static Resources resourcesForDraw;
    private static int stepOnField;
    private static int sizePoint;
    private static int widthDisplay;

    public static void setResourcesForDraw(Resources resourcesForDraw) {
        ResourcesBitmap.resourcesForDraw = resourcesForDraw;
    }

    public static void setStepOnField(int stepOnField) {
        ResourcesBitmap.stepOnField = stepOnField;
    }

    public static void setWidthDisplay(int widthDisplay) {
        ResourcesBitmap.widthDisplay = widthDisplay;
    }

    public static void setSizePoint(int sizePoint) {
        ResourcesBitmap.sizePoint = sizePoint;
    }

    public static void createBitmapForChessField() {
        //create chess field 4x4
        chessField4x4Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_4x4), widthDisplay, widthDisplay, true);
        //create chess field 5x5
        chessField5x5Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_5x5), widthDisplay, widthDisplay, true);
        //create chess field 6x6
        chessField6x6Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_6x6), widthDisplay, widthDisplay, true);
        //create chess field 8x8
        chessField8x8Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field), widthDisplay, widthDisplay, true);
        //create stone field 8x8
        stoneField8x8Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_8x8), widthDisplay, widthDisplay, true);

        //create checker white
        whiteCheckerBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_white), stepOnField, stepOnField, true);
        //create checker black
        blackCheckerBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_black), stepOnField, stepOnField, true);

        //create check mark
        Bitmap bitmap3 = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.check_mark);
        checkMarkBitmap = Bitmap.createScaledBitmap(bitmap3, stepOnField, stepOnField, true);
        //create target point
        targetPointBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.target_point), stepOnField, stepOnField, true);
        //create player to lose
        playerLoseBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer_lose), widthDisplay, widthDisplay, true);
        //create player win
        playerWinBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer), widthDisplay, widthDisplay, true);
        //create win win
        winWinBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer), widthDisplay, widthDisplay, true);

    }


    public static void createBitmapForStoneField() {
        //create stone field 4x4
        stoneField4x4Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_4x4), widthDisplay, widthDisplay, true);
        //create stone field 5x5
        stoneField5x5Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_5x5), widthDisplay, widthDisplay, true);
        //create stone field 6x6
        stoneField6x6Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_6x6), widthDisplay, widthDisplay, true);
        //create stone field 8x8
        stoneField8x8Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.stone_field_8x8), widthDisplay, widthDisplay, true);

        //create checker Woodman
        woodmanCheckerBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.woodman), stepOnField, stepOnField, true);
        //create checker Woodman select
        woodmanSelectCheckerBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.woodman_select), stepOnField, stepOnField, true);
        //create checker Viking
        vikingCheckerBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.viking), stepOnField, stepOnField, true);
        //create checker Viking select
        vikingSelectCheckerBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.viking_select), stepOnField, stepOnField, true);

        //create check mark
        checkMarkBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.check_mark), stepOnField, stepOnField, true);
        //create target point
        targetPointBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.target_point), stepOnField, stepOnField, true);
        //create player to lose
        playerLoseBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer_lose), widthDisplay, widthDisplay, true);
        //create player win
        playerWinBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer), widthDisplay, widthDisplay, true);
        //create win win
        winWinBitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer), widthDisplay, widthDisplay, true);

    }
}
