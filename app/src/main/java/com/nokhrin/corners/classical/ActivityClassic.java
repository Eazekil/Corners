package com.nokhrin.corners.classical;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.nokhrin.corners.ActivityStart;
import com.nokhrin.corners.R;
import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.resources.ResourcesBitmap;


public class ActivityClassic extends AppCompatActivity implements View.OnTouchListener {
    //public static DrawView drawView;
    //public static int indentTop;
    //public static ImageView ivChecker;
    //public static ImageView ivCheckerBlack;
    private StartClassic startClassic;
    private DrawView drawView;
    private ResourcesBitmap resourcesBitmap;

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
        ImageView ivChecker = findViewById(R.id.imageViewCheckerWhite);
        ImageView ivCheckerBlack = findViewById(R.id.imageViewCheckerBlack);
        Button buttonMenu = findViewById(R.id.buttonMenu);
        Button buttonRestart = findViewById(R.id.buttonRestart);

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widthDisplay = size.x;
        int heightDisplay = size.y;
        int indentTop = (heightDisplay - widthDisplay) / 2;

        //set indent of top
        FrameLayout flIntent = findViewById(R.id.frameLayoutIndentClassic);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = indentTop;
        flIntent.setLayoutParams(params);


        resourcesBitmap = new ResourcesBitmap();

        //add start parameters for game field
        startClassic = new StartClassic();
        startClassic.addStartParameters(widthDisplay, heightDisplay, indentTop, resourcesBitmap);


        //create view for draw and add in layout
        drawView = new DrawView(getApplicationContext(),resourcesBitmap);
        ((ViewGroup) flClassic).addView(drawView);




        //set parameters for bitmap
        drawView.setSizeOfField(startClassic.getSizeOfField());
        drawView.setStepOnField(startClassic.getStepOnField());
        drawView.setCheckersPositions(startClassic.getCheckersPositions());

        //set on touch listener
        flClassic.setOnTouchListener(this);


        //button return to Menu
        buttonMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityClassic.this, ActivityStart.class);
            startActivity(intent);
        });

        //button restart this game
        buttonRestart.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityClassic.this, ActivityClassic.class);
            startActivity(intent);
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //get coordinates of touch
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        //convert coordinates X,Y in step on chess field
        int touchI = touchY / startClassic.getStepOnField() + 1;
        int touchJ = touchX / startClassic.getStepOnField() + 1;

        System.out.println("_______________________ " + touchI + "," + touchJ);

        //check game is over
        if(startClassic.getWin() == 0 && startClassic.isPlayerMove()){
            //start move on the field
            new PlayerMove(touchI, touchJ, startClassic, drawView);
        }


        return false;
    }
}