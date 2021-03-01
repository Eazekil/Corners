package com.nokhrin.corners;

import java.util.ArrayList;

public class MoveForBot {
    private int positionsForBot[][];
    private int currentI;
    private int currentJ;
    private int newPositions[][] = new int [9][9];
    private ArrayList<int[][]> resultArr;
    private int resultPositions[][] = new int [9][9];




    //finish here
    public int[][] getPositionsToMove() {



        return resultPositions;
    }

    //start here
    public void setPositions(int[][] positions) {
        this.positionsForBot = positions;
        resultArr = new ArrayList();


        //find positions all black checkers
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(positionsForBot[i][j] == -1){
                    moveAdd(i,j);
                }
            }
        }



    }



    int minEvF = 9999999;

    public int evaluationFunction(int positionsForFunc[][]){
        int result=0;
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(positionsForFunc[i][j] == -1){
                    result = result + Math.abs(8-i)+Math.abs(1-j);
                }
            }
        }






        if(result < minEvF){
            //resultArr.add(positionsForFunc);
            minEvF = result;
            for(int i=1;i<9;i++){
                for(int j=1;j<9;j++){
                    resultPositions[i][j] = positionsForFunc[i][j];
                }
            }

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


    boolean first=false;
    //find all move for this checker
    public void moveAdd(int i, int j){
        currentI = i;
        currentJ = j;


        right(i, j);
        left(i, j-1);
        top(i-1, j);
        bottom(i+1,j);
    }

    public void right(int i, int j){
        if(j<9){
            if(positionsForBot[i][j] == 0){
                copyPositions(positionsForBot);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
                resultArr.add(newPositions);


                if(j+2 < 9){
                    if(positionsForBot[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
                if(i-2 >0){
                    if(positionsForBot[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(i+2 < 9){
                    if(positionsForBot[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
            }else{
                if(j+1 < 9){
                    if(positionsForBot[i][j+1] == 0){
                        right(i,j+1);
                    }
                }
            }
        }
    }

    public void left(int i, int j){
        if(j>0){
            if(positionsForBot[i][j] == 0){
                copyPositions(positionsForBot);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
                resultArr.add(newPositions);

                if(j-2 > 0){
                    if(positionsForBot[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(i-2 >0){
                    if(positionsForBot[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(i+2 < 9){
                    if(positionsForBot[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
            }else{
                if(j-1 > 0){
                    if(positionsForBot[i][j-1] == 0){
                        left(i, j-1);
                    }
                }
            }
        }
    }

    public void top(int i, int j){
        if(i>0){
            if(positionsForBot[i][j] == 0){
                copyPositions(positionsForBot);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
                resultArr.add(newPositions);

                if(i-2 >0){
                    if(positionsForBot[i-1][j] != 0){
                        top(i-1, j);
                    }
                }
                if(j-2 > 0){
                    if(positionsForBot[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(j+2 < 9){
                    if(positionsForBot[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
            }else{
                if(i-1 > 0){
                    if(positionsForBot[i-1][j] == 0){
                        top(i-1, j);
                    }
                }
            }
        }
    }

    public void bottom(int i, int j){
        if(i<9){
            if(positionsForBot[i][j] == 0){
                copyPositions(positionsForBot);
                newPositions[currentI][currentJ] = 0;
                newPositions[i][j] = -1;
                evaluationFunction(newPositions);
                resultArr.add(newPositions);

                if(i+2 < 9){
                    if(positionsForBot[i+1][j] != 0){
                        bottom(i+1, j);
                    }
                }
                if(j-2 > 0){
                    if(positionsForBot[i][j-1] != 0){
                        left(i, j-1);
                    }
                }
                if(j+2 < 9){
                    if(positionsForBot[i][j+1] != 0){
                        right(i,j+1);
                    }
                }
            }else{
                if(i+1 < 9){
                    if(positionsForBot[i+1][j] == 0){
                        bottom(i+1,j);
                    }
                }
            }
        }
    }



}
