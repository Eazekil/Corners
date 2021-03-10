package com.nokhrin.corners.levels;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.nokhrin.corners.R;

import static com.nokhrin.corners.ActivityStart.widthDisplay;
import static com.nokhrin.corners.levels.ActivityLevels.sizePoint;
import static com.nokhrin.corners.levels.ActivityLevels.stepOnField;
import static com.nokhrin.corners.levels.DrawView.resourcesForDraw;

public class ResourcesBitmap {
    public static Bitmap field4x4Bitmap;
    public static Bitmap field5x5Bitmap;
    public static Bitmap field6x6Bitmap;
    public static Bitmap whiteCheckerBitmap;
    public static Bitmap blackCheckerBitmap;
    public static Bitmap checkMarkBitmap;
    public static Bitmap targetPointBitmap;
    public static Bitmap playerWinBitmap;
    public static Bitmap playerLoseBitmap;


    public static void createBitmap(){
        //create field 4x4
        field4x4Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_4x4), widthDisplay, widthDisplay, true);
        //create field 5x5
        field5x5Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_5x5), widthDisplay, widthDisplay, true);
        //create field 6x6
        field6x6Bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_6x6), widthDisplay, widthDisplay, true);

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
        Bitmap bitmap4 = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.red_circle);
        targetPointBitmap = Bitmap.createScaledBitmap(bitmap4, sizePoint, sizePoint, true);
        //create player to lose
        Bitmap bitmap5 = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer_lose);
        playerLoseBitmap = Bitmap.createScaledBitmap(bitmap5, widthDisplay, widthDisplay, true);
        //create player win
        Bitmap bitmap6 = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.homer);
        playerWinBitmap = Bitmap.createScaledBitmap(bitmap6, widthDisplay, widthDisplay, true);
    }
}
