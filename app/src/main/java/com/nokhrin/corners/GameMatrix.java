package com.nokhrin.corners;

import static com.nokhrin.corners.DrawField.drawField;
import static com.nokhrin.corners.MainActivity.sizeOfField;
import static com.nokhrin.corners.MainActivity.touchI;
import static com.nokhrin.corners.MainActivity.touchJ;
import static com.nokhrin.corners.MoveForBot.setPositions;
import static com.nokhrin.corners.PossibleMoves.possibleMoves;


public class GameMatrix {
    public static int[][] checkersPositions = new int[sizeOfField][sizeOfField];//positions all checkers on field
    public static boolean playerMove;//can player to move
    public static int choiceI = 0;//coordinate I of player's chosen checker
    public static int choiceJ = 0;//coordinate J of player's chosen checker


    //add checkers on a start positions
    public static void startPositions() {

        //added checkers position like 0
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                checkersPositions[i][j]=0;
            }
        }

        //start white(1) checkers position
        for(int i=6;i<sizeOfField;i++){
            for(int j=1;j<5;j++){
                checkersPositions[i][j]=1;
            }
        }

        //start black(-1) checkers position
        for(int i=1;i<4;i++){
            for(int j=5;j<sizeOfField;j++){
                checkersPositions[i][j]=-1;
            }
        }

        //player can move
        playerMove = true;

    }


    //start move on the field
    public static void touchOnField() {

        //check can player move
        if(playerMove){

            //check player choice checker
            if(choiceI != 0 && choiceJ != 0){

                //check player update chosen checker
                if(checkersPositions[touchI][touchJ] == 1){

                    //update chosen checker
                    checkersPositions[touchI][touchJ] = 2;

                    //update old chosen
                    checkersPositions[choiceI][choiceJ] = 1;

                    //update chosen coordinate
                    choiceI = touchI;
                    choiceJ = touchJ;
                }

                //check can move on touch coordinate
                if(possibleMoves(touchI,touchJ)){

                    //update checkers positions on field
                    checkersPositions[touchI][touchJ] = 1;
                    checkersPositions[choiceI][choiceJ] = 0;

                    //clear chosen coordinate
                    choiceI = 0;
                    choiceJ = 0;

                    //mark player can not move
                    playerMove = false;

                    //bot start move
                    new BotThread().start();

                }


            }else if(checkersPositions[touchI][touchJ] == 1){

                //mark chosen checker
                checkersPositions[touchI][touchJ] = 2;

                //update chosen coordinate
                choiceI = touchI;
                choiceJ = touchJ;

            }

            //update draw field
            drawField();

        }
    }


    //bot start move
    public static class BotThread extends Thread{
        @Override
        public void run() {

            //find best move for bot
            setPositions();

            //create game pause
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //player can move
            playerMove = true;

            //draw field
            drawField();
        }
    }

}
