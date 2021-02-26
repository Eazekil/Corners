package com.nokhrin.corners;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    private float touchX;
    private float touchY;
    Bitmap chessField;

    public GraphicsView(Context context) {
        super(context);
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chess_field);
        chessField= Bitmap.createBitmap(myBitmap,0,0,200,200);
    }

    @Override
    protected void onDraw(Canvas canvas){
        // загружаем иконку из ресурсов в объект myBitmap

        // рисуем myBitmap на канве в координатах касания
        canvas.drawBitmap(chessField, 0, 0, null);

    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            touchX = event.getX();
            touchY = event.getY();
            invalidate();
        }
        return true;
    }
}
