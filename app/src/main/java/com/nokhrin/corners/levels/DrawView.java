package com.nokhrin.corners.levels;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;

import static android.app.PendingIntent.getActivity;
import static androidx.core.content.ContextCompat.startActivity;
import static com.nokhrin.corners.ActivityStart.heightDisplay;
import static com.nokhrin.corners.ActivityStart.widthDisplay;
import static com.nokhrin.corners.levels.ActivityLevels.heightLayout;
import static com.nokhrin.corners.levels.ActivityLevels.widthLayout;

public class DrawView extends View implements View.OnTouchListener {
    private Paint mPaint = new Paint();
    public static Bitmap fieldBitmap;
    public static Resources resourcesForDraw;
    Context copyContext;

    public DrawView(Context context) {
        super(context);

        copyContext = context;

        //find pictures in resources
        resourcesForDraw = this.getResources();
        /*//background
        Bitmap bitmap = BitmapFactory.decodeResource(resourcesForDraw, R.drawable.yelow_background);
        backgroundBitmap = Bitmap.createScaledBitmap(bitmap, widthDisplay, widthDisplay, true);*/


        //add touch listener
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*//discover size of display
        int width = canvas.getWidth();
        int height = canvas.getHeight();*/

        //draw background
        canvas.drawBitmap(fieldBitmap, 0, 0, mPaint);


        /*// draw text
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(100);
        canvas.drawText("Наконецто", 100, 200, mPaint);*/



    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //get coordinates of touch
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        System.out.printf("_______________touch X and Y : %d,%d", touchX, touchY);
        System.out.println("                           SSSSSSSSSSSSSSSSSSSS");



        /*//convert coordinates X,Y in step on chess field
        touchI = touchY/stepOnField+1;
        touchJ = touchX/stepOnField+1;*/

        return false;
    }
}
