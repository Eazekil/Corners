package com.nokhrin.corners;

import static com.nokhrin.corners.GameMatrix.checkersPositions;
import static com.nokhrin.corners.MainActivity.sizeOfField;

public class EvaluationFunction {
    private int resultOfFunction = 0;
    private int minOfFunction = 999;
    private static int endPositions[][] = new int [sizeOfField][sizeOfField];
    private static int newPositions[][] = new int [sizeOfField][sizeOfField];

    public void setNewPositions(int[][] oldPositions, int currentI, int currentJ, int newI, int newJ) {
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                newPositions[i][j] = oldPositions[i][j];
            }
        }

        //update old positions
        newPositions[newI][newJ] = -1;
        //update new positions
        newPositions[currentI][currentJ] = 0;


        /*//add start value
        resultOfFunction = 0;
        minOfFunction = 999;*/

        //find all black checkers
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                if(newPositions[i][j] == -1){
                    //sum of length to point(8,1)
                    resultOfFunction = resultOfFunction + Math.abs(8-i)+Math.abs(1-j);
                }
            }
        }


        //find minimum of evaluation function
        if(resultOfFunction < minOfFunction){
            minOfFunction = resultOfFunction;

            //save result positions in endPositions
            for(int i=1;i<sizeOfField;i++){
                for(int j=1;j<sizeOfField;j++){
                    endPositions[i][j] = newPositions[i][j];
                }
            }
        }

    }

    public static void addResultPositions(){
        for(int i=1;i<sizeOfField;i++){
            System.out.println();
            for(int j=1;j<sizeOfField;j++){
                System.out.print(endPositions[i][j]+"   ");
                checkersPositions[i][j] = endPositions[i][j];
            }
        }
    }


}
