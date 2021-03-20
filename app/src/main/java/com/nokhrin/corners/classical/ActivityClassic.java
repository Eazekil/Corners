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


public class ActivityClassic extends AppCompatActivity implements View.OnTouchListener {
    public StartGame startGame;
    public DrawView drawView;
    //public ResourcesBitmap resourcesBitmap;
    public ImageView ivChecker;
    public ImageView ivCheckerBlack;
    public int indentTop;
    public int widthDisplay;

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
        Button buttonMenu = findViewById(R.id.buttonMenu);
        Button buttonRestart = findViewById(R.id.buttonRestart);

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        int heightDisplay = size.y;
        indentTop = (heightDisplay - widthDisplay) / 2;

        //set indent of top
        FrameLayout flIntent = findViewById(R.id.frameLayoutIndentClassic);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = indentTop;
        flIntent.setLayoutParams(params);

        //add start parameters for game field
        startGame = new StartGame();
        startGame.addStartParameters(widthDisplay);

        //create view for draw and add in layout
        drawView = new DrawView(getApplicationContext(), this);
        ((ViewGroup) flClassic).addView(drawView);

        //set on touch listener
        flClassic.setOnTouchListener(this);

        //button return to Menu
        buttonMenu.setOnClickListener(v -> {
            //resourcesBitmap.recycle();
            Intent intent = new Intent(ActivityClassic.this, ActivityStart.class);
            startActivity(intent);
            finish();
        });

        //button restart this game
        buttonRestart.setOnClickListener(v -> {
            //resourcesBitmap.recycle();
            Intent intent = new Intent(ActivityClassic.this, ActivityClassic.class);
            startActivity(intent);
            finish();
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //get coordinates of touch
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        //convert coordinates X,Y in step on chess field
        int touchI = touchY / startGame.getStepOnField() + 1;
        int touchJ = touchX / startGame.getStepOnField() + 1;

        System.out.println("_______________________ " + touchI + "," + touchJ);

        //check game is over
        if(startGame.getWin() == 0 && startGame.isPlayerMove()){
            //start move on the field
            new PlayerMove(touchI, touchJ,this);
        }

        return false;
    }



}