package com.nokhrin.corners.levels.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class CreateDb {
    private LevelsDb levelsDb;
    private SQLiteDatabase database;
    private ContentValues contentValues;

    public void createDbLevels(){
        addLevel(1, 5,9,2);
        addChecker(1,4,1);
        addChecker(1,4,2);
        addPoint(1,1,3);
        addPoint(1,1,4);

        addLevel(2, 5,10,3);
        addChecker(1,4,1);
        addChecker(1,4,2);
        addChecker(1,3,1);
        addPoint(1,1,3);
        addPoint(1,1,4);
        addPoint(1,2,4);
    }

    private void addLevel(int numberLevel, int sizeField, int countMove, int countPoint){
        database = levelsDb.getWritableDatabase();
        contentValues.put(LevelsDb.KEY_SIZE_FIELD, sizeField);
        contentValues.put(LevelsDb.KEY_COUNT_MOVE, countMove);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        contentValues.put(LevelsDb.KEY_COUNT_POINT, countPoint);
        database.insert(LevelsDb.TABLE_LEVELS, null, contentValues);
        contentValues.clear();
        levelsDb.close();
    }

    private void addChecker(int numberLevel, int i, int j){
        database = levelsDb.getWritableDatabase();
        contentValues.put(LevelsDb.KEY_WHITE_I, i);
        contentValues.put(LevelsDb.KEY_WHITE_J, j);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        database.insert(LevelsDb.TABLE_POSITIONS, null, contentValues);
        contentValues.clear();
        levelsDb.close();
    }

    private void addStone(int numberLevel, int i, int j){
        database = levelsDb.getWritableDatabase();
        contentValues.put(LevelsDb.KEY_STONE_I, i);
        contentValues.put(LevelsDb.KEY_STONE_J, j);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        contentValues.clear();
        levelsDb.close();
    }

    private void addPoint(int numberLevel, int i, int j){
        database = levelsDb.getWritableDatabase();
        contentValues.put(LevelsDb.KEY_POINT_I, i);
        contentValues.put(LevelsDb.KEY_POINT_J, j);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        contentValues.clear();
        levelsDb.close();
    }

    public void setLevelsDb(LevelsDb levelsDb) {
        this.levelsDb = levelsDb;
        contentValues = new ContentValues();
        createDbLevels();
    }
}
