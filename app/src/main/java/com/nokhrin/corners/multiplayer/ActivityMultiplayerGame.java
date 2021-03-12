package com.nokhrin.corners.multiplayer;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nokhrin.corners.R;
import com.nokhrin.corners.multiplayer.game.StepOn;
import com.nokhrin.corners.multiplayer.start.DrawViewMG;

import java.util.ArrayList;

import static com.nokhrin.corners.multiplayer.game.SecondPlayer.updatePosition;
import static com.nokhrin.corners.multiplayer.start.StartMultiplayerGame.addStartParameters;


public class ActivityMultiplayerGame extends AppCompatActivity {
    public static DrawViewMG drawView; //view for game field
    public static boolean playerMove;//can player to move
    public static int widthDisplay; //size width of display
    public static int heightDisplay; //size height of display

    FirebaseDatabase database;
    private static DatabaseReference moveToRef;
    TextView tvRoomName;
    TextView tvPlayers;

    String roomName;
    static String firstPlayerName;
    String secondPlayerName;
    private static String moveTo;


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

        //get roomName and Names of players
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            roomName = extras.getString("roomName");
            firstPlayerName = extras.getString("firstPlayerName");
            secondPlayerName = extras.getString("secondPlayerName");
        }

        //set room Name and Names of players
        tvRoomName.setText(roomName);
        String s = firstPlayerName + " против: ожидаем игрока...";
        tvPlayers.setText(s);

        //find database
        database = FirebaseDatabase.getInstance();




        /////////////////////////////////////////////////////////////////////

        //find frame layout
        ViewGroup flMultiplayerGame = findViewById(R.id.frameLayoutMultiplayerGame);

        //discover size of the display
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        widthDisplay = size.x;
        heightDisplay = size.y;

        //add start parameters for game field
        addStartParameters();

        //create view for draw and add in layout
        drawView = new DrawViewMG(getApplicationContext());
        flMultiplayerGame.addView(drawView);

        //listen to incoming moveTo
        moveToRef = database.getReference("rooms/"+roomName+"/moveTo");
        addRoomEventListener();

    }

    public static void makeStep(String sendM){
        moveTo = sendM+" "+firstPlayerName;
        /*moveTo.setStartI(startI);
        moveTo.setStartJ(startJ);
        moveTo.setEndI(endI);
        moveTo.setEndJ(endJ);*/

        // update list in database
        moveToRef.setValue(moveTo);
    }

    private void addRoomEventListener(){
        moveToRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //moveTo received
                String moveIn;
                moveIn = snapshot.getValue(String.class);
                System.out.println("_____________________________ "+moveIn);
                if(moveIn != null){
                    String player = moveIn.split(" ")[4];
                    System.out.println("----------------- "+ player);
                    if(!player.equals(firstPlayerName)){
                        updatePosition(moveIn);
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

}