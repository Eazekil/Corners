package com.nokhrin.corners.classical;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.nokhrin.corners.R;
import com.nokhrin.corners.draw.DrawView;


public class ActivityClassic extends AppCompatActivity implements View.OnTouchListener {
    public static DrawView drawView;
    public static int indentTop;
    public static ImageView ivChecker;
    public static ImageView ivCheckerBlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this all for make full screen
        setContentView(R.layout.activity_classic);
        View classicLayout = findViewById(R.id.ConstrainLayoutClassic);
        classicLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //find element
        View flClassic = findViewById(R.id.frameLayoutClassic);
        ivChecker = findViewById(R.id.imageViewCheckerWhite);
        ivCheckerBlack = findViewById(R.id.imageViewCheckerBlack);

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widthDisplay = size.x;
        int heightDisplay = size.y;
        indentTop = (heightDisplay - widthDisplay) / 2;

        //set indent of top
        FrameLayout flIntent = findViewById(R.id.frameLayoutIndentClassic);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = indentTop;
        flIntent.setLayoutParams(params);


        //add start parameters for game field
        new StartClassic().addStartParameters(widthDisplay, heightDisplay, indentTop);


        //create view for draw and add in layout
        drawView = new DrawView(getApplicationContext());
        ((ViewGroup) flClassic).addView(drawView);

        //set parameters for bitmap
        drawView.setSizeOfField(StartClassic.sizeOfField);
        drawView.setStepOnField(StartClassic.stepOnField);
        drawView.setCheckersPositions(StartClassic.checkersPositions);

        //set on touch listener
        flClassic.setOnTouchListener(this);







        /*//button return to Menu
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityClassic.this, ActivityStart.class);
            startActivity(intent);
        });

        //button restart this game
        buttonRestart.setOnClickListener(v -> {
            //add checkers on a start positions
            startPositions();

            //update
            drawField();
        });*/


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //get coordinates of touch
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        //convert coordinates X,Y in step on chess field
        int touchI = touchY / StartClassic.stepOnField + 1;
        int touchJ = touchX / StartClassic.stepOnField + 1;

        System.out.println("_______________________ " + touchI + "," + touchJ);

        //start move on the field
        new PlayerMove(touchI, touchJ);

        return false;
    }
}