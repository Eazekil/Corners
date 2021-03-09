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
    public static Bitmap whiteCheckerBitmap;
    public static Bitmap checkMarkBitmap;
    public static Bitmap targetPointBitmap;
    public static Bitmap playerWinBitmap;
    public static Bitmap playerLoseBitmap;


    public static void createBitmap(){
        //create field 4x4
        Bitmap bitmap = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.chess_field_4x4);
        field4x4Bitmap = Bitmap.createScaledBitmap(bitmap, widthDisplay, widthDisplay, true);
        //create checker white
        Bitmap bitmap2 = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.checker_white);
        whiteCheckerBitmap = Bitmap.createScaledBitmap(bitmap2, stepOnField, stepOnField, true);
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
