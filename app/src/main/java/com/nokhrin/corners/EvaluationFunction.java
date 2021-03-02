package com.nokhrin.corners;

import static com.nokhrin.corners.MainActivity.sizeOfField;
import static com.nokhrin.corners.GameMatrix.checkersPositions;

public class EvaluationFunction {
    public static int resultOfFunction = 0;
    private static int minOfFunction = 999;
    public static int endPositions[][] = new int [sizeOfField][sizeOfField];
    private static int newPositions[][] = new int [sizeOfField][sizeOfField];

    public static void setNewPositions( int currentI, int currentJ, int newI, int newJ) {
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                newPositions[i][j] = checkersPositions[i][j];
            }
        }

        //update old positions
        newPositions[newI][newJ] = -1;
        //update new positions
        newPositions[currentI][currentJ] = 0;





        //find all black checkers
        resultOfFunction = 0;
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

            for(int i=1;i<sizeOfField;i++){
                System.out.println();
                for(int j=1;j<sizeOfField;j++){
                    System.out.print(newPositions[i][j]+"   ");
                }
            }
            System.out.println("_______ resultOfFunction = "+ resultOfFunction);

            //save result positions in endPositions
            for(int i=1;i<sizeOfField;i++){
                for(int j=1;j<sizeOfField;j++){
                    endPositions[i][j] = newPositions[i][j];
                }
            }
        }

    }


}
