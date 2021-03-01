package com.nokhrin.corners;

import java.util.ArrayList;

public class MoveForBot {
    private int positions[][];
    private int result[] = new int[4];
    private int currentI;
    private int currentJ;
    private int newPositions[][] = new int [9][9];
    private int sumPositions[][] = new int [20][5];
    private int sumAllPositions[][] = new int [30][5];
    private int countMove;
    private int countCheckers;
    private ArrayList<int[][]> resultArr;
    private int positionsToMove[][] = new int [9][9];

    public int[][] getPositionsToMove() {
        System.out.println("DDDDDDDDDDDDDDDDD  "+numberArr);

        return resultArr.get(resultArr.size()-1);
    }

    public int[] getResult() {
        return result;
    }

    //start here
    public void setPositions(int[][] positions) {
        this.positions = positions;
        countCheckers = 0;


        resultArr = new ArrayList();

        //clear sumAllPositions
        for(int i=0;i<30;i++){
            for(int j=0;j<5;j++){
                sumAllPositions[i][j]=0;
            }
        }

        int min = 9999;
        int numberA = 9999;

        //find positions all black checkers
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(positions[i][j] == -1){
                    moveAdd(i,j);
                }
            }
        }

        //find best move
        for(int a=0;a<countCheckers;a++){
            if(sumAllPositions[a][4] < min){
                min = sumPositions[a][4];
                numberA = a;
            }
        }

        /*//added result move from current I to new I...
        result[0] = sumAllPositions[numberA][0];//current positions I
        result[1] = sumAllPositions[numberA][1];//current positions J
        result[2] = sumAllPositions[numberA][2];//new positions I
        result[3] = sumAllPositions[numberA][3];//new positions J
        System.out.println("************************************");
        System.out.println(result[0]+","+result[1]);
        System.out.println(result[2]+","+result[3]);
        System.out.println(sumAllPositions[numberA][4]);*/

    }



    int minEvF = 9999999;
    int numberArr = 0;

    public int evaluationFunction(int positions[][]){
        int result=0;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(positions[i][j] == -1){
                    result = result + Math.abs(8-i)+Math.abs(1-j);
                }
            }
        }
        if(result < minEvF){
            System.out.println("_______________ result = "+result);
            resultArr.add(positions);
            minEvF = result;
            numberArr++;
        }

        return result;
    }

    public void copyPositions(int positionsCopy[][]){
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                newPositions[i][j] = positionsCopy[i][j];
            }
        }
    }

    int minForAdd = 9999999;
    int numberAForAdd =888;
    public void moveAdd(int i, int j){

        //clear sumPositions
        for(int ii=0;ii<20;ii++){
            for(int jj=0;jj<5;jj++){
                sumPositions[ii][jj] = 0;
            }
        }

        countMove = 0;
        currentI = i;
        currentJ = j;


        right(i, j+1);
        left(i, j-1);
        top(i-1, j);
        bottom(i+1,j);

        //find best move
       /* for(int a=0;a<countMove;a++){
            if(sumPositions[a][2] < minForAdd){
                minForAdd = sumPositions[a][2];
                numberAForAdd = a;
            }
        }*/


        /*sumAllPositions[countCheckers][0] = currentI;//current positions I
        sumAllPositions[countCheckers][1] = currentJ;//current positions J
        sumAllPositions[countCheckers][2] = sumPositions[numberAForAdd][0];//new positions I
        sumAllPositions[countCheckers][3] = sumPositions[numberAForAdd][1];//new positions J
        sumAllPositions[countCheckers][4] = sumPositions[numberAForAdd][2];//evaluation Function this move
        countCheckers++;*/

    }

    public void right(int i, int j){
        if(j<9){
            if(positions[i][j] == 0){
                copyPositions(positions);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
                /*sumPositions[countMove][0] = i;//new positions I
                sumPositions[countMove][1] = j;//new positions J
                sumPositions[countMove][2] = evaluationFunction(newPositions);//evaluation Function this move
                countMove++;*/

                if(j+2 < 9){
                    if(positions[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
                if(i-2 >0){
                    if(positions[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(i+2 < 9){
                    if(positions[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
            }else{
                if(j+1 < 9){
                    if(positions[i][j+1] == 0){
                        right(i,j+1);
                    }
                }
            }
        }
    }

    public void left(int i, int j){
        if(j>0){
            if(positions[i][j] == 0){
                copyPositions(positions);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
                /*sumPositions[countMove][0] = i;
                sumPositions[countMove][1] = j;
                sumPositions[countMove][2] = evaluationFunction(newPositions);
                countMove++;*/

                if(j-2 > 0){
                    if(positions[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(i-2 >0){
                    if(positions[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(i+2 < 9){
                    if(positions[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
            }else{
                if(j-1 > 0){
                    if(positions[i][j-1] == 0){
                        left(i, j-1);
                    }
                }
            }
        }
    }

    public void top(int i, int j){
        if(i>0){
            if(positions[i][j] == 0){
                copyPositions(positions);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
                /*sumPositions[countMove][0] = i;
                sumPositions[countMove][1] = j;
                sumPositions[countMove][2] = evaluationFunction(newPositions);
                countMove++;*/

                if(i-2 >0){
                    if(positions[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(j-2 > 0){
                    if(positions[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(j+2 < 9){
                    if(positions[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
            }else{
                if(i-1 > 0){
                    if(positions[i-1][j] == 0){
                        top(i-1, j);
                    }
                }
            }
        }
    }

    public void bottom(int i, int j){
        if(i<9){
            if(positions[i][j] == 0){
                copyPositions(positions);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
               /* sumPositions[countMove][0] = i;
                sumPositions[countMove][1] = j;
                sumPositions[countMove][2] = evaluationFunction(newPositions);
                countMove++;*/

                if(i+2 < 9){
                    if(positions[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
                if(j-2 > 0){
                    if(positions[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(j+2 < 9){
                    if(positions[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
            }else{
                if(i+1 < 9){
                    if(positions[i+1][j] == 0){
                        bottom(i+1,j);
                    }
                }
            }
        }
    }



}
