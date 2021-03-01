package com.nokhrin.corners;

import android.graphics.Point;

public class GameMatrix {
    private static Point size;
    public static  int widthDisplay=0;
    public static int heightDisplay=0;
    public static int stepOnField; // step on chess field and size of checkers
    public static int top; //indent of thr top of the display
    public static int[][] checkersPositions = new int[9][9];
    private static int touchX;
    private static int touchY;
    private static int[][] possibleMoves = new int[9][9];
    public static boolean playerMove;
    int choiceI = 0;
    int choiceJ = 0;
    public static MoveForBot moveForBot = new MoveForBot();

    //add start position
    public void setSize(Point size) {
        this.size = size;
        widthDisplay = size.x;
        heightDisplay = size.y;
        stepOnField = (widthDisplay)/8;
        top=heightDisplay/20;

        //added checkers position like 0
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                checkersPositions[i][j]=0;
            }
        }

        //start white checkers position
        for(int i=6;i<9;i++){
            for(int j=1;j<5;j++){
                checkersPositions[i][j]=1;
            }
        }

        //start black checkers position
        for(int i=1;i<4;i++){
            for(int j=5;j<9;j++){
                checkersPositions[i][j]=-1;
            }
        }
        playerMove = true;
    }


    public  void setTouch(int touchX, int touchY) {
        this.touchX = touchX;
        this.touchY = touchY;
        int touchI = touchY/stepOnField+1;
        int touchJ = touchX/stepOnField+1;

        if(playerMove){

            //check can a move
            if(choiceI != 0 && choiceJ != 0){

                if(checkersPositions[touchI][touchJ] == 1){
                    checkersPositions[touchI][touchJ] = 2;//choice checker
                    checkersPositions[choiceI][choiceJ] = 1;
                    choiceI = touchI;
                    choiceJ = touchJ;
                    for(int i=1;i<9;i++) {
                        for (int j = 1; j < 9; j++) {
                            possibleMoves[i][j] = 0;
                        }
                    }
                    moveAdd(choiceI, choiceJ);
                }

                if(possibleMoves[touchI][touchJ] == 1){
                    checkersPositions[touchI][touchJ] = 1;
                    checkersPositions[choiceI][choiceJ] = 0;
                    choiceI = 0;
                    choiceJ = 0;
                    for(int i=1;i<9;i++) {
                        for (int j = 1; j < 9; j++) {
                            possibleMoves[i][j] = 0;
                        }
                    }
                    playerMove = false;
                    //botMove();
                    new BotThread().start();

                }

            }else if(checkersPositions[touchI][touchJ] == 1){
                checkersPositions[touchI][touchJ] = 2;//choice checker
                choiceI = touchI;
                choiceJ = touchJ;
                moveAdd(choiceI, choiceJ);
            }

            MainActivity.drawField();
            //MainActivity.checkMark.setVisibility(View.INVISIBLE);
            /*System.out.println("touchX = "+touchX+"   touchY = "+touchY+"   step = "+stepOnField);
            System.out.println("my j = "+touchJ+"    i = "+touchI);*/
        }
    }


    public void moveAdd(int i, int j){

        right(i, j+1);
        left(i, j-1);
        top(i-1, j);
        bottom(i+1,j);
    }

    public void right(int i, int j){
        if(j<9){
            if(checkersPositions[i][j] == 0){
                possibleMoves[i][j] = 1;
                if(j+2 < 9){
                    if(checkersPositions[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
                if(i-2 >0){
                    if(checkersPositions[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(i+2 < 9){
                    if(checkersPositions[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
            }else{
                if(j+1 < 9){
                    if(checkersPositions[i][j+1] == 0){
                        right(i,j+1);
                    }
                }
            }
        }
    }

    public void left(int i, int j){
        if(j>0){
            if(checkersPositions[i][j] == 0){
                possibleMoves[i][j] = 1;
                if(j-2 > 0){
                    if(checkersPositions[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(i-2 >0){
                    if(checkersPositions[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(i+2 < 9){
                    if(checkersPositions[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
            }else{
                if(j-1 > 0){
                    if(checkersPositions[i][j-1] == 0){
                        left(i, j-1);
                    }
                }
            }
        }
    }

    public void top(int i, int j){
        if(i>0){
            if(checkersPositions[i][j] == 0){
                possibleMoves[i][j] = 1;
                if(i-2 >0){
                    if(checkersPositions[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(j-2 > 0){
                    if(checkersPositions[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(j+2 < 9){
                    if(checkersPositions[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
            }else{
                if(i-1 > 0){
                    if(checkersPositions[i-1][j] == 0){
                        top(i-1, j);
                    }
                }
            }
        }
    }

    public void bottom(int i, int j){
        if(i<9){
            if(checkersPositions[i][j] == 0){
                possibleMoves[i][j] = 1;
                if(i+2 < 9){
                    if(checkersPositions[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
                if(j-2 > 0){
                    if(checkersPositions[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(j+2 < 9){
                    if(checkersPositions[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
            }else{
                if(i+1 < 9){
                    if(checkersPositions[i+1][j] == 0){
                        bottom(i+1,j);
                    }
                }
            }
        }
    }


    public static class BotThread extends Thread{
        @Override
        public void run() {


            moveForBot.setPositions(checkersPositions);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




            int newPos[][] = moveForBot.getPositionsToMove();

            for(int i=1;i<9;i++){
                for(int j=1;j<9;j++){
                    checkersPositions[i][j] = newPos[i][j];
                }
            }






            /*if(checkersPositions[1][5] == -1){
                checkersPositions[1][4] = -1;
                checkersPositions[1][5] = 0;
            }else{
                checkersPositions[1][4] = 0;
                checkersPositions[1][5] = -1;
            }*/

            playerMove = true;
            MainActivity.drawField();
        }
    }







   /* public void botMove(){
        *//*MainActivity.drawField();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*//*
        new BotThread().start();
        if(checkersPositions[1][5] == -1){
            checkersPositions[1][4] = -1;
            checkersPositions[1][5] = 0;
        }else{
            checkersPositions[1][4] = 0;
            checkersPositions[1][5] = -1;
        }
        playerMove = true;
    }*/

}
