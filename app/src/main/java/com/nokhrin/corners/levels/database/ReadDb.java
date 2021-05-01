package com.nokhrin.corners.levels.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static com.nokhrin.corners.levels.database.LevelsDb.KEY_COUNT_MOVE;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_COUNT_POINT;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_NUMBER_LEVEL;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_POINT_I;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_POINT_J;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_SIZE_FIELD;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_STONE_I;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_STONE_J;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_WHITE_I;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_WHITE_J;
import static com.nokhrin.corners.levels.database.LevelsDb.TABLE_LEVELS;
import static com.nokhrin.corners.levels.database.LevelsDb.TABLE_POSITIONS;

public class ReadDb {
    private static final String TAG = "myTaG";
    private LevelsDb levelsDb;
    private SQLiteDatabase database;
    private int level;
    private int sizeField;
    private int countMove;
    private int countPoint;
    private ArrayList<Integer> whiteI;
    private ArrayList<Integer> whiteJ;
    private ArrayList<Integer> stoneI;
    private ArrayList<Integer> stoneJ;
    private ArrayList<Integer> pointI;
    private ArrayList<Integer> pointJ;

    public void setLevelsDb(LevelsDb levelsDb) {
        this.levelsDb = levelsDb;
    }

    public void read(int numberLevel) {
        database = levelsDb.getWritableDatabase();
        whiteI = new ArrayList<>();
        whiteJ = new ArrayList<>();
        stoneI = new ArrayList<>();
        stoneJ = new ArrayList<>();
        pointI = new ArrayList<>();
        pointJ = new ArrayList<>();

        //String table = "levels as LV inner join positions as PS on LV.number_level = PS.number_level";
        //String[] columns = {"LV.number_level as level", "LV.size_field as field", "LV.count_move as move", "LV.count_point as point", "PS.white_i as Y", "PS.white_j as X", "PS.stone_i", "PS.stone_j", "PS.point_i", "PS.point_j"};


        String[] columns = {KEY_SIZE_FIELD, KEY_COUNT_MOVE,KEY_NUMBER_LEVEL, KEY_COUNT_POINT};
        String selection = KEY_NUMBER_LEVEL+" =?";
        String[] selectionArgs = {Integer.toString(numberLevel)};
        Cursor cursor = database.query(TABLE_LEVELS, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            level = cursor.getInt(cursor.getColumnIndex("number_level"));
            sizeField = cursor.getInt(cursor.getColumnIndex("size_field"));
            countMove = cursor.getInt(cursor.getColumnIndex("count_move"));
            countPoint = cursor.getInt(cursor.getColumnIndex("count_point"));
            System.out.println("sdsdffsdfnms  " + level + " " + sizeField + " " + countMove + " " + countPoint);
        }
        cursor.close();

        String[] columns2 = {KEY_NUMBER_LEVEL, KEY_WHITE_I, KEY_WHITE_J, KEY_STONE_I, KEY_STONE_J, KEY_POINT_I, KEY_POINT_J};
        cursor = database.query(TABLE_POSITIONS, columns2, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            /*stoneI = cursor.getInt(cursor.getColumnIndex("stone_i"));
            stoneJ = cursor.getInt(cursor.getColumnIndex("stone_j"));
            pointI = cursor.getInt(cursor.getColumnIndex("point_i"));
            pointJ = cursor.getInt(cursor.getColumnIndex("point_j"));*/

            do {

                if (cursor.getColumnIndex(KEY_WHITE_I) > 0) {
                    whiteI.add(cursor.getInt(cursor.getColumnIndex(KEY_WHITE_I)));
                }
                if (cursor.getColumnIndex(KEY_WHITE_J) > 0) {
                    whiteJ.add(cursor.getInt(cursor.getColumnIndex(KEY_WHITE_J)));
                }
                if (cursor.getColumnIndex(KEY_STONE_I) > 0) {
                    stoneI.add(cursor.getInt(cursor.getColumnIndex(KEY_STONE_I)));
                }
                if (cursor.getColumnIndex(KEY_STONE_J) > 0) {
                    stoneJ.add(cursor.getInt(cursor.getColumnIndex(KEY_STONE_J)));
                }
                if (cursor.getColumnIndex(KEY_POINT_I) > 0) {
                    int ss =cursor.getInt(cursor.getColumnIndex(KEY_POINT_I));
                    Log.d(TAG, "read: ss = "+ss);
                    pointI.add(ss);
                }
                if (cursor.getColumnIndex(KEY_POINT_J) > 0) {
                    pointJ.add(cursor.getInt(cursor.getColumnIndex(KEY_POINT_J)));
                }
                /*System.out.println("***************************************");
                System.out.println(whiteI);
                System.out.println(whiteJ);
                System.out.println("***************************************");*/

            } while (cursor.moveToNext());

        }
        cursor.close();
        database.close();

    }

    public int getSizeField() {
        return sizeField;
    }

    public int getCountMove() {
        return countMove;
    }

    public int getCountPoint() {
        return countPoint;
    }

    public ArrayList<Integer> getWhiteI() {
        return whiteI;
    }

    public ArrayList<Integer> getWhiteJ() {
        return whiteJ;
    }

    public ArrayList<Integer> getStoneI() {
        return stoneI;
    }

    public ArrayList<Integer> getStoneJ() {
        return stoneJ;
    }

    public ArrayList<Integer> getPointI() {
        return pointI;
    }

    public ArrayList<Integer> getPointJ() {
        return pointJ;
    }
}


