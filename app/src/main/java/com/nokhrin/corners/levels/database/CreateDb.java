package com.nokhrin.corners.levels.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static com.nokhrin.corners.resources.Constants.TAG;

public class CreateDb {
    private LevelsDb levelsDb;
    private SQLiteDatabase database;
    private ContentValues contentValues;

    public void createDbLevels(){
        Log.d(TAG, "createDbLevels: +++++++++++++++++++++");
        addLevel(1, 5,9,2);
        addChecker(1,4,1);
        addChecker(1,4,2);
        addPoint(1,1,3);
        addPoint(1,1,4);

        addLevel(2, 5,10,3);
        addChecker(2,4,1);
        addChecker(2,4,2);
        addChecker(2,3,1);
        addPoint(2,1,3);
        addPoint(2,1,4);
        addPoint(2,2,4);

        addProgress();

        levelsDb.close();
    }

    private void addLevel(int numberLevel, int sizeField, int countMove, int countPoint){

        contentValues.put(LevelsDb.KEY_SIZE_FIELD, sizeField);
        contentValues.put(LevelsDb.KEY_COUNT_MOVE, countMove);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        contentValues.put(LevelsDb.KEY_COUNT_POINT, countPoint);
        database.insert(LevelsDb.TABLE_LEVELS, null, contentValues);
        contentValues.clear();

    }

    private void addChecker(int numberLevel, int i, int j){
        contentValues.put(LevelsDb.KEY_WHITE_I, i);
        contentValues.put(LevelsDb.KEY_WHITE_J, j);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        database.insert(LevelsDb.TABLE_POSITIONS, null, contentValues);
        contentValues.clear();
    }

    private void addStone(int numberLevel, int i, int j){
        contentValues.put(LevelsDb.KEY_STONE_I, i);
        contentValues.put(LevelsDb.KEY_STONE_J, j);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        database.insert(LevelsDb.TABLE_POSITIONS, null, contentValues);
        contentValues.clear();
    }

    private void addPoint(int numberLevel, int i, int j){
        contentValues.put(LevelsDb.KEY_POINT_I, i);
        contentValues.put(LevelsDb.KEY_POINT_J, j);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        database.insert(LevelsDb.TABLE_POSITIONS, null, contentValues);
        contentValues.clear();
    }

    public void setLevelsDb(LevelsDb levelsDb) {
        this.levelsDb = levelsDb;
        contentValues = new ContentValues();
        database = levelsDb.getWritableDatabase();
        createDbLevels();
    }

    private void addProgress(){
        for(int i=1;i<25;i++){
            contentValues.put(LevelsDb.KEY_COUNT_STARS, 0);
            contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, i);
            database.insert(LevelsDb.TABLE_PROGRESS, null, contentValues);
            contentValues.clear();
        }
    }
}
