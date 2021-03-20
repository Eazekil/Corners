package com.nokhrin.corners.multiplayer;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nokhrin.corners.R;
import com.nokhrin.corners.draw.DrawView;
import com.nokhrin.corners.multiplayer.game.PlayerMove;
import com.nokhrin.corners.multiplayer.game.SecondPlayer;
import com.nokhrin.corners.multiplayer.start.StartGame;

import static com.nokhrin.corners.resources.Constants.MESSAGE;
import static com.nokhrin.corners.resources.Constants.PLAYER_1;
import static com.nokhrin.corners.resources.Constants.PLAYER_2;
import static com.nokhrin.corners.resources.Constants.PLAYER_NAME;
import static com.nokhrin.corners.resources.Constants.ROLE;
import static com.nokhrin.corners.resources.Constants.ROLE_HOST;
import static com.nokhrin.corners.resources.Constants.ROOMS;
import static com.nokhrin.corners.resources.Constants.ROOM_NAME;


public class
ActivityMultiplayerGame extends AppCompatActivity implements View.OnTouchListener{
    /*public  DrawViewMG drawView; //view for game field
    public  View ivChecker;
    public  View flMultiplayerGame;
    public  boolean playerMove;//can player to move
    public  int widthDisplay; //size width of display
    public  int heightDisplay; //size height of display
    public  int role; //role this player
    public  int indentTop; //role this player
    private
    private  DatabaseReference moveToRef; //reference to database
    private  DatabaseReference anotherPlayerRef; //reference to name another player*/
    String moveTo; //message move to
    DatabaseReference moveToRef; //reference to database
    DatabaseReference anotherPlayerRef; //reference to name another player
    FirebaseDatabase database;
    TextView tvRoomName;
    TextView tvPlayers;
    String roomName;
    String playerName;
    String anotherPlayerName;
    ActivityMultiplayerGame act;
    public int role; //role this player
    public int widthDisplay; //size width of display
    public int indentTop; //role this player
    public DrawView drawView;
    public StartGame startGame;
    public View ivChecker;
    public View ivCheckerBlack;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_game);

        //this all for make full screen
        View levelsLayout = findViewById(R.id.ConstrainLayoutMultiplayerGame);
        levelsLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //find element
        tvRoomName = findViewById(R.id.textViewRoomName);
        tvPlayers = findViewById(R.id.textViewPlayers);
        View flMultiplayerGame = findViewById(R.id.frameLayoutMultiplayerGame);
        ivChecker = findViewById(R.id.imageViewWhiteCheckerAn);
        ivCheckerBlack = findViewById(R.id.imageViewBlackChecker);


        //get roomName, Names of players and his role
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            roomName = extras.getString(ROOM_NAME);
            playerName = extras.getString(PLAYER_NAME);
            role = extras.getInt(ROLE);
        }

        //set room Name and Names of players
        tvRoomName.setText(roomName);
        String s = "ожидаем игрока...";
        tvPlayers.setText(s);

        //find database
        database = FirebaseDatabase.getInstance();

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        int heightDisplay = size.y;
        indentTop = (heightDisplay - widthDisplay) / 2;


        FrameLayout frameLayout = findViewById(R.id.frameLayoutIndent);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = indentTop;
        frameLayout.setLayoutParams(params);



        //add start parameters for game field
        //addStartParameters();
        startGame = new StartGame();
        startGame.addStartParameters(this);


        //create view for draw and add in layout
        drawView = new DrawView(getApplicationContext(), this);
        ((ViewGroup)flMultiplayerGame).addView(drawView);

        //set on touch listener
        flMultiplayerGame.setOnTouchListener(this);

        act = this;

        //get reference to message move to
        moveToRef = database.getReference(ROOMS + "/" + roomName + "/" + MESSAGE);

        //get reference to another player Name
        if (role == ROLE_HOST) {
            anotherPlayerRef = database.getReference(ROOMS + "/" + roomName + "/" + PLAYER_2);
        } else {
            anotherPlayerRef = database.getReference(ROOMS + "/" + roomName + "/" + PLAYER_1);
        }

        addRoomEventListener();

        if (anotherPlayerName == null) {
            addAnotherPlayerEventListener();
        }


    }

    public void addAnotherPlayerEventListener() {
        anotherPlayerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                anotherPlayerName = snapshot.getValue(String.class);
                if (anotherPlayerName != null) {
                    String s = "вы играете против: " + anotherPlayerName;
                    tvPlayers.setText(s);
                    String strToast = String.format("игрок: %s присоеденился к игре", anotherPlayerName);
                    Toast.makeText(ActivityMultiplayerGame.this, strToast, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error - nothing
            }
        });
    }

    ////////////////////////////////////////////send message to database
    private void addRoomEventListener() {
        moveToRef.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //moveTo received
                String message;
                message = snapshot.getValue(String.class);
                if (message != null) {
                    String player = message.split(" ")[4];

                    if (!player.equals(playerName)) {
                        SecondPlayer secondPlayer = new SecondPlayer(act);
                        secondPlayer.updatePosition(message);
                        Toast.makeText(ActivityMultiplayerGame.this, "Ваш ход", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //error - retry
                moveToRef.setValue(moveTo);
            }
        });
    }

    // update message in database
    public void makeStep(String sendM) {
        moveTo = sendM + " " + playerName;
        moveToRef.setValue(moveTo);
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