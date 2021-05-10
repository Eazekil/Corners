package com.nokhrin.corners.levels.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static com.nokhrin.corners.levels.database.LevelsDb.KEY_COUNT_MOVE;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_COUNT_POINT;
import static com.nokhrin.corners.levels.database.LevelsDb.KEY_COUNT_STARS;
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
import static com.nokhrin.corners.levels.database.LevelsDb.TABLE_PROGRESS;
import static com.nokhrin.corners.resources.Constants.TAG;

public class ReadDb {
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
    private ArrayList<Integer> progress;

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

        String[] columns = {KEY_SIZE_FIELD, KEY_COUNT_MOVE,KEY_NUMBER_LEVEL, KEY_COUNT_POINT};
        String selection = KEY_NUMBER_LEVEL+" =?";
        String[] selectionArgs = {Integer.toString(numberLevel)};
        Cursor cursor = database.query(TABLE_LEVELS, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            level = cursor.getInt(cursor.getColumnIndex(KEY_NUMBER_LEVEL));
            sizeField = cursor.getInt(cursor.getColumnIndex(KEY_SIZE_FIELD));
            countMove = cursor.getInt(cursor.getColumnIndex(KEY_COUNT_MOVE));
            countPoint = cursor.getInt(cursor.getColumnIndex(KEY_COUNT_POINT));
        }
        cursor.close();

        String[] columns2 = {KEY_NUMBER_LEVEL, KEY_WHITE_I, KEY_WHITE_J, KEY_STONE_I, KEY_STONE_J, KEY_POINT_I, KEY_POINT_J};
        cursor = database.query(TABLE_POSITIONS, columns2, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {

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
                    pointI.add(ss);
                }
                if (cursor.getColumnIndex(KEY_POINT_J) > 0) {
                    pointJ.add(cursor.getInt(cursor.getColumnIndex(KEY_POINT_J)));
                }

            } while (cursor.moveToNext());

        }
        cursor.close();
        database.close();
    }

    public ArrayList<Integer> readCountStars(){
        database = levelsDb.getWritableDatabase();
        progress = new ArrayList<>();
        String[] columns = {KEY_NUMBER_LEVEL, KEY_COUNT_STARS};
        //String selection = KEY_NUMBER_LEVEL+" =?";
        //String[] selectionArgs = {Integer.toString(numberLevel)};
        Cursor cursor = database.query(TABLE_PROGRESS, columns, null, null, null, null, null);

        if (cursor.moveToFirst()) progress.add(cursor.getInt(cursor.getColumnIndex(KEY_COUNT_STARS)));
        do {
            progress.add(cursor.getInt(cursor.getColumnIndex(KEY_COUNT_STARS)));
        }while (cursor.moveToNext());

        cursor.close();
        database.close();
        return progress;
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


