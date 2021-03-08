package com.nokhrin.corners.levels;




import static com.nokhrin.corners.levels.ActivityLevels.checkersPositions;
import static com.nokhrin.corners.levels.ActivityLevels.countToMove;
import static com.nokhrin.corners.levels.ActivityLevels.gameOver;
import static com.nokhrin.corners.levels.ActivityLevels.touchI;
import static com.nokhrin.corners.levels.ActivityLevels.touchJ;
import static com.nokhrin.corners.levels.DrawFieldLevel.drawField;
import static com.nokhrin.corners.levels.PossibleMoves.possibleMoves;
import static com.nokhrin.corners.levels.PossibleMoves.possibleStep;

public class PlayerMove {
    public static boolean playerMove;//can player to move
    public static int choiceI = 0;//coordinate I of player's chosen checker
    public static int choiceJ = 0;//coordinate J of player's chosen checker


    //add checkers on a start positions
    public static void playerStartMove() {
        //player can move
        playerMove = true;

        //mark game to start
        gameOver = false;


    }


    //start move on the field
    public static void touchOnField() {

        //check can player move
        if (countToMove > 0 && !gameOver) {

            //check player choice checker
            if (choiceI != 0 && choiceJ != 0) {

                //check player update chosen checker
                if (checkersPositions[touchI][touchJ] == 1) {

                    //update chosen checker
                    checkersPositions[touchI][touchJ] = 2;

                    //update old chosen
                    checkersPositions[choiceI][choiceJ] = 1;

                    //update chosen coordinate
                    choiceI = touchI;
                    choiceJ = touchJ;

                    //find all move for choice checker
                    possibleStep();
                } else {

                    //check can move on touch coordinate
                    if (possibleMoves(touchI, touchJ)) {

                        //update checkers positions on field
                        checkersPositions[touchI][touchJ] = 1;
                        checkersPositions[choiceI][choiceJ] = 0;

                        //clear chosen coordinate
                        choiceI = 0;
                        choiceJ = 0;


                        //countMove.setText("Осталось ходов : "+(--countToMove));


                        //updateText();



                    }

                }


            } else if (checkersPositions[touchI][touchJ] == 1) {

                //mark chosen checker
                checkersPositions[touchI][touchJ] = 2;

                //update chosen coordinate
                choiceI = touchI;
                choiceJ = touchJ;

                //find all move for choice checker
                possibleStep();

            }

            //update draw field
            drawField();

        }

    }


}
