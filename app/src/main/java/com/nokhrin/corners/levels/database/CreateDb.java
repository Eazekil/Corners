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
        addLevel(1, 5,10,2,1,2);
        addCheck(1,4,1);
        addCheck(1,4,2);
        addPoint(1,1,3);
        addPoint(1,1,4);

        addLevel(2, 5,13,3,1,2);
        addCheck(2,4,1);
        addCheck(2,4,2);
        addCheck(2,3,1);
        addPoint(2,1,3);
        addPoint(2,1,4);
        addPoint(2,2,4);

        addLevel(3,6,10,4,1,3);
        addCheck(3,5,1);
        addCheck(3,5,2);
        addCheck(3,4,1);
        addCheck(3,4,2);
        addPoint(3,1,4);
        addPoint(3,1,5);
        addPoint(3,2,4);
        addPoint(3,2,5);

        addLevel(4,5,5,1,1,2);
        addCheck(4,4,1);
        addPoint(4,1,4);
        addStone(4,3,2);
        addStone(4,2,3);

        addLevel(5,5,7,1,1,2);
        addCheck(5,4,1);
        addPoint(5,1,4);
        addStone(5,3,1);
        addStone(5,4,2);
        addStone(5,4,3);
        addStone(5,3,3);

        addLevel(6,5,9,2,1,3);
        addCheck(6,4,1);
        addCheck(6,4,4);
        addPoint(6,1,2);
        addPoint(6,1,4);
        addStone(6,1,1);
        addStone(6,2,1);
        addStone(6,3,3);
        addStone(6,3,4);
        addStone(6,2,3);

        addLevel(7,6,11,4,1,3);
        addCheck(7,5,1);
        addCheck(7,5,2);
        addCheck(7,4,1);
        addCheck(7,4,2);
        addPoint(7,1,4);
        addPoint(7,1,5);
        addPoint(7,2,4);
        addPoint(7,2,5);
        addStone(7,3,2);
        addStone(7,4,3);

        addLevel(8,6,15,4,1,2);
        addCheck(8,5,1);
        addCheck(8,5,2);
        addCheck(8,4,1);
        addCheck(8,4,2);
        addPoint(8,1,4);
        addPoint(8,1,5);
        addPoint(8,2,4);
        addPoint(8,2,5);
        addStone(8,3,2);
        addStone(8,4,3);
        addStone(8,3,3);

        addLevel(9,5,7,4,1,2);
        addCheck(9,4,1);
        addCheck(9,4,2);
        addCheck(9,3,2);
        addStone(9,2,3);
        addPoint(9,1,3);
        addPoint(9,1,4);
        addPoint(9,2,3);
        addPoint(9,2,4);

        addLevel(10,5,6,2,1,2);
        addCheck(10,4,1);
        addCheck(10,1,4);
        addPoint(10,2,2);
        addPoint(10,3,3);
        addStone(10,3,2);
        addStone(10,2,3);

        addLevel(11,6,12,4,1,3);
        addCheck(11,5,1);
        addCheck(11,5,2);
        addCheck(11,4,1);
        addCheck(11,4,2);
        addPoint(11,1,4);
        addPoint(11,1,5);
        addPoint(11,2,4);
        addPoint(11,2,5);
        addStone(11,3,3);

        addLevel(12,6,11,2,1,2);
        addCheck(12,5,1);
        addCheck(12,4,1);
        addPoint(12,1,5);
        addPoint(12,2,5);
        addStone(12,1,3);
        addStone(12,1,4);
        addStone(12,2,3);
        addStone(12,2,4);
        addStone(12,3,1);
        addStone(12,3,2);
        addStone(12,3,3);
        addStone(12,3,4);

        addLevel(13,6,5,1,1,2);
        addCheck(13,1,1);
        addCheck(13,1,5);
        addCheck(13,5,5);
        addCheck(13,5,1);
        addPoint(13,3,3);
        addStone(13,2,3);
        addStone(13,3,2);
        addStone(13,4,3);
        addStone(13,3,4);

        addLevel(14,5,8,2,1,2);
        addCheck(14,4,1);
        addCheck(14,4,4);
        addPoint(14,2,2);
        addPoint(14,1,2);
        addStone(14,3,2);
        addStone(14,2,3);

        addLevel(15,6,2,2,0,0);
        addCheck(15,5,1);
        addCheck(15,4,2);
        addPoint(15,1,5);
        addPoint(15,2,4);
        addStone(15,1,2);
        addStone(15,1,4);
        addStone(15,2,1);
        addStone(15,2,3);
        addStone(15,2,5);
        addStone(15,3,2);
        addStone(15,3,4);
        addStone(15,4,1);
        addStone(15,4,3);
        addStone(15,4,5);
        addStone(15,5,2);
        addStone(15,5,4);

        addLevel(16,7,15,4,1,2);
        addCheck(16,5,1);
        addCheck(16,5,2);
        addCheck(16,6,1);
        addCheck(16,6,2);
        addPoint(16,1,5);
        addPoint(16,1,6);
        addPoint(16,2,5);
        addPoint(16,2,6);
        addStone(16,1,2);
        addStone(16,1,4);
        addStone(16,2,1);
        addStone(16,3,5);
        addStone(16,4,1);
        addStone(16,5,6);
        addStone(16,6,5);
        addStone(16,6,3);

        addLevel(17,7,15,3,1,2);
        addCheck(17,1,1);
        addCheck(17,6,1);
        addCheck(17,6,6);
        addPoint(17,1,5);
        addPoint(17,1,6);
        addPoint(17,2,6);
        addStone(17,6,2);
        addStone(17,6,4);
        addStone(17,5,5);
        addStone(17,4,4);
        addStone(17,3,3);
        addStone(17,2,2);

        addLevel(18,7,15,4,1,2);
        addCheck(18,3,3);
        addCheck(18,3,4);
        addCheck(18,4,3);
        addCheck(18,4,4);
        addPoint(18,1,1);
        addPoint(18,1,6);
        addPoint(18,6,1);
        addPoint(18,6,6);
        addStone(18,2,2);
        addStone(18,2,5);
        addStone(18,5,2);
        addStone(18,5,5);

        addLevel(19,7,15,3,1,2);
        addCheck(19,6,1);
        addCheck(19,5,2);
        addCheck(19,4,3);
        addPoint(19,3,4);
        addPoint(19,2,5);
        addPoint(19,1,6);
        addStone(19,2,3);
        addStone(19,3,3);
        addStone(19,4,4);
        addStone(19,4,5);

        addLevel(20,7,15,4,1,2);
        addCheck(20,6,1);
        addCheck(20,5,2);
        addCheck(20,4,3);
        addCheck(20,3,4);
        addPoint(20,1,5);
        addPoint(20,1,6);
        addPoint(20,2,5);
        addPoint(20,2,6);
        addStone(20,5,1);
        addStone(20,4,2);
        addStone(20,3,3);
        addStone(20,6,2);
        addStone(20,5,3);
        addStone(20,4,4);

        addLevel(21,7,15,4,1,2);
        addCheck(21,6,1);
        addCheck(21,6,3);
        addCheck(21,4,3);
        addCheck(21,2,5);
        addPoint(21,5,4);
        addPoint(21,3,2);
        addPoint(21,3,6);
        addPoint(21,1,4);
        addStone(21,5,2);
        addStone(21,5,3);
        addStone(21,3,3);
        addStone(21,3,4);
        addStone(21,1,5);
        addStone(21,1,6);

        addLevel(22,8,20,3,1,2);
        addCheck(22,7,1);
        addCheck(22,6,1);
        addCheck(22,7,2);
        addPoint(22,1,7);
        addPoint(22,1,5);
        addPoint(22,3,7);
        addStone(22,1,6);
        addStone(22,2,6);
        addStone(22,2,7);
        addStone(22,3,4);
        addStone(22,4,4);
        addStone(22,4,5);
        addStone(22,5,2);
        addStone(22,6,2);
        addStone(22,6,3);

        addLevel(23,8,15,4,1,2);
        addCheck(23,1,1);
        addCheck(23,1,7);
        addCheck(23,7,1);
        addCheck(23,7,7);
        addPoint(23,3,4);
        addPoint(23,4,3);
        addPoint(23,4,5);
        addPoint(23,5,4);
        addStone(23,1,4);
        addStone(23,2,4);
        addStone(23,3,3);
        addStone(23,3,5);
        addStone(23,4,1);
        addStone(23,4,2);
        addStone(23,4,4);
        addStone(23,4,6);
        addStone(23,4,7);
        addStone(23,5,3);
        addStone(23,5,5);
        addStone(23,6,4);
        addStone(23,7,4);

        addLevel(24,8,20,6,1,2);
        addCheck(24,5,1);
        addCheck(24,6,1);
        addCheck(24,7,1);
        addCheck(24,6,2);
        addCheck(24,7,2);
        addCheck(24,7,3);
        addPoint(24,1,6);
        addPoint(24,2,7);
        addPoint(24,3,4);
        addPoint(24,4,5);
        addPoint(24,5,2);
        addPoint(24,6,3);
        addStone(24,1,7);
        addStone(24,2,6);
        addStone(24,3,5);
        addStone(24,4,4);
        addStone(24,5,3);
        addStone(24,4,2);
        addStone(24,6,4);

//        addLevel(,,,,,);
//        addChecker(,,);
//        addPoint(,,);
//        addStone(,,);

        addProgress();

        levelsDb.close();
    }

    private void addLevel(int numberLevel, int sizeField, int countMove, int countPoint, int countSilver, int countGold){

        contentValues.put(LevelsDb.KEY_SIZE_FIELD, sizeField);
        contentValues.put(LevelsDb.KEY_COUNT_MOVE, countMove);
        contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
        contentValues.put(LevelsDb.KEY_COUNT_POINT, countPoint);
        contentValues.put(LevelsDb.KEY_COUNT_SILVER, countSilver);
        contentValues.put(LevelsDb.KEY_COUNT_GOLD, countGold);
        database.insert(LevelsDb.TABLE_LEVELS, null, contentValues);
        contentValues.clear();

    }

    private void addCheck(int numberLevel, int i, int j){
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
