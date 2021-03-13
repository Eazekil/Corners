package com.nokhrin.corners.multiplayer.start;




import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.playerMove;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.role;
import static com.nokhrin.corners.multiplayer.ActivityMultiplayerGame.widthDisplay;
import static com.nokhrin.corners.multiplayer.game.PossibleMoves.lastPlayerPositions;
import static com.nokhrin.corners.multiplayer.game.PossibleMoves.resultPossibleMoves;
import static com.nokhrin.corners.resources.Constants.BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.FREE_POSITION_ON_FIELD;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_BLACK_CHECKER;
import static com.nokhrin.corners.resources.Constants.TARGET_POINT_FOR_WHITE_CHECKER;
import static com.nokhrin.corners.resources.Constants.WHITE_CHECKER;

public class StartMultiplayerGame {
    public static int sizeOfField = 9; //size of field +1
    public static int countPointInLevel = 12; //count of checker
    public static int stepOnField; // step on chess field and size of checkers
    public static int touchI;//coordinates of touch on chess field
    public static int touchJ;//coordinates of touch on chess field
    public static int[][] checkersPositions; //= new int[sizeOfField][sizeOfField];//positions all checkers on field
    public static int[][] marksPositions; // = new int[sizeOfField][sizeOfField];//positions all marks on field
    public static int sizePoint;
    public static boolean playerWin;
    public static int choiceI;//coordinate I of player's chosen checker
    public static int choiceJ;//coordinate J of player's chosen checker

    public static void addStartParameters() {
        //update variables for this game
        stepOnField = widthDisplay / (sizeOfField - 1);
        sizePoint = stepOnField / 3;

        //create matrix
        checkersPositions = new int[sizeOfField][sizeOfField];
        marksPositions = new int[sizeOfField][sizeOfField];
        resultPossibleMoves = new boolean[sizeOfField][sizeOfField];
        lastPlayerPositions = new boolean[sizeOfField][sizeOfField];

        //clear field
        for (int i = 1; i < sizeOfField; i++) {
            for (int j = 1; j < sizeOfField; j++) {
                checkersPositions[i][j] = FREE_POSITION_ON_FIELD;
            }
        }

        //add checker on start positions
        //start white(1) checkers position
        //and target position for black checkers
        if(role.equals("host")){
            for (int i = 6; i < sizeOfField; i++) {
                for (int j = 1; j < 5; j++) {
                    checkersPositions[i][j] = WHITE_CHECKER;
                    marksPositions[i][j] = TARGET_POINT_FOR_BLACK_CHECKER;
                }
            }

            //start black(3) checkers position
            //and target position for white checkers
            for (int i = 1; i < 4; i++) {
                for (int j = 5; j < sizeOfField; j++) {
                    checkersPositions[i][j] = BLACK_CHECKER;
                    marksPositions[i][j] = TARGET_POINT_FOR_WHITE_CHECKER;
                }
            }

            //mark player can move
            playerMove = true;
        }else{
            for (int i = 6; i < sizeOfField; i++) {
                for (int j = 1; j < 5; j++) {
                    checkersPositions[i][j] = BLACK_CHECKER;
                    marksPositions[i][j] = TARGET_POINT_FOR_WHITE_CHECKER;
                }
            }

            //start white checkers position
            //and target position for black checkers
            for (int i = 1; i < 4; i++) {
                for (int j = 5; j < sizeOfField; j++) {
                    checkersPositions[i][j] = WHITE_CHECKER;
                    marksPositions[i][j] = TARGET_POINT_FOR_BLACK_CHECKER;
                }
            }
            //mark player can move
            playerMove = false;
        }






    }


}
