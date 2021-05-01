package com.nokhrin.corners.levels.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LevelsDb extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "levelsDb";
    public static final String TABLE_LEVELS = "levels";
    public static final String TABLE_POSITIONS = "positions";
    public static final String KEY_ID = "_id";
    public static final String KEY_NUMBER_LEVEL = "number_level";
    public static final String KEY_SIZE_FIELD = "size_field";
    public static final String KEY_COUNT_MOVE = "count_move";
    public static final String KEY_COUNT_POINT = "count_point";
    public static final String KEY_WHITE_I = "white_i";
    public static final String KEY_WHITE_J = "white_j";
    public static final String KEY_STONE_I = "stone_i";
    public static final String KEY_STONE_J = "stone_j";
    public static final String KEY_POINT_I = "point_i";
    public static final String KEY_POINT_J = "point_j";


    /*public static final String COLUMN_SIZE_FIELD = "size_field";
    public static final String COLUMN_COUNT_MOVE = "count_move";
    public static final String COLUMN_COUNT_POINT = "count_point";
    public static final String SIZE_FIELD = "sizeOfField";
    private static String DB_PATH;
    private static String DB_NAME = "levels.db";
    private Context myContext;*/

    public LevelsDb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        /*DB_PATH = context.getFilesDir().getPath() + DB_NAME;
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD DB_PATH "+DB_PATH );
        this.myContext = context;*/
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_LEVELS + "(" +
                KEY_ID + " integer primary key," +
                KEY_NUMBER_LEVEL + " integer," +
                KEY_SIZE_FIELD + " integer," +
                KEY_COUNT_MOVE + " integer," +
                KEY_COUNT_POINT + " integer" + ")");

        db.execSQL("create table " + TABLE_POSITIONS + "(" +
                KEY_ID + " integer primary key," +
                KEY_NUMBER_LEVEL + " integer," +
                KEY_WHITE_I + " integer," +
                KEY_WHITE_J + " integer," +
                KEY_STONE_I + " integer," +
                KEY_STONE_J + " integer," +
                KEY_POINT_I + " integer," +
                KEY_POINT_J + " integer" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_LEVELS);
        onCreate(db);
    }

//    public void createDB(){
//        try(InputStream myInput =myContext.getAssets().open(DB_NAME);
//            OutputStream myOutput =new FileOutputStream(DB_PATH);) {
//            File file = new File(DB_PATH);
//            System.out.println("111111111111111111111111111111111111111");
//            if (true) {
//                System.out.println("111111111111111111111111111111111111111");
//                byte[] buffer = new byte[1024];
//                int length;
//                while ((length = myInput.read(buffer)) > 0) {
//                    myOutput.write(buffer, 0, length);
//                }
//
//                myOutput.flush();
//            }
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//    public SQLiteDatabase open()throws SQLException {
//        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
//    }
}
