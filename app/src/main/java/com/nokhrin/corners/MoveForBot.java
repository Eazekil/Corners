package com.nokhrin.corners;

import static com.nokhrin.corners.EvaluationFunction.endPositions;
import static com.nokhrin.corners.EvaluationFunction.minOfFunction;
import static com.nokhrin.corners.EvaluationFunction.targetPositionI;
import static com.nokhrin.corners.EvaluationFunction.targetPositionJ;
import static com.nokhrin.corners.MainActivity.sizeOfField;
import static com.nokhrin.corners.GameMatrix.checkersPositions;
import static com.nokhrin.corners.Move.jumpBottom;
import static com.nokhrin.corners.Move.jumpLeft;
import static com.nokhrin.corners.Move.jumpRight;
import static com.nokhrin.corners.Move.jumpTop;
import static com.nokhrin.corners.Move.setCurrentIJ;
import static com.nokhrin.corners.Move.stepBottom;
import static com.nokhrin.corners.Move.stepLeft;
import static com.nokhrin.corners.Move.stepRight;
import static com.nokhrin.corners.Move.stepTop;

public class MoveForBot {
    static int countH=1;


    //start here
    public static void setPositions() {
        //check target position and mark
        markEndPositions();

        minOfFunction = 999;

        //find positions all black checkers
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                if(checkersPositions[i][j] == -1){
                    moveSteps(i,j);
                }
            }
        }





        //upgrade positions after bot go move
        for(int i=1;i<sizeOfField;i++){
            for(int j=1;j<sizeOfField;j++){
                checkersPositions[i][j] = endPositions[i][j];
            }
        }




    }

    public static void markEndPositions(){
        if(checkersPositions[targetPositionI][targetPositionJ] == -1){
            checkersPositions[targetPositionI][targetPositionJ] = 3;

            //upgrade values for evaluation function
            if(targetPositionJ+1 < 5){
                targetPositionJ++;
                markEndPositions();
            }else{
                if(targetPositionI-1 > 5){
                    targetPositionI--;
                    targetPositionJ = 1;
                    markEndPositions();
                }
            }


        }
    }


    //find all move for this checker
    public static void moveSteps(int i, int j){

        //add choice checker
        setCurrentIJ(i,j);

        //find all move for choice checker
        stepRight(i,j);
        stepLeft(i,j);
        stepBottom(i,j);
        stepTop(i,j);

        jumpRight(i,j);
        jumpLeft(i,j);
        jumpBottom(i,j);
        jumpTop(i,j);

    }

}
