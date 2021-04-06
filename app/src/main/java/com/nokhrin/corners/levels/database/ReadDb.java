package com.nokhrin.corners.levels.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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

    public void setLevelsDb(LevelsDb levelsDb) {
        this.levelsDb = levelsDb;
    }

    public void read(int numberLevel){
        database = levelsDb.getWritableDatabase();
        whiteI = new ArrayList<>();
        whiteJ = new ArrayList<>();
        stoneI = new ArrayList<>();
        stoneJ = new ArrayList<>();
        pointI = new ArrayList<>();
        pointJ = new ArrayList<>();

        //String table = "levels as LV inner join positions as PS on LV.number_level = PS.number_level";
        //String[] columns = {"LV.number_level as level", "LV.size_field as field", "LV.count_move as move", "LV.count_point as point", "PS.white_i as Y", "PS.white_j as X", "PS.stone_i", "PS.stone_j", "PS.point_i", "PS.point_j"};

        String table ="levels";
        String[] columns = {"number_level", "size_field", "count_move", "count_point"};
        String selection = "number_level =?";
        String[] selectionArgs = {Integer.toString(numberLevel)};
        Cursor cursor = database.query(table, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            level = cursor.getInt(cursor.getColumnIndex("number_level"));
            sizeField = cursor.getInt(cursor.getColumnIndex("size_field"));
            countMove= cursor.getInt(cursor.getColumnIndex("count_move"));
            countPoint = cursor.getInt(cursor.getColumnIndex("count_point"));

            do {
                System.out.println("__________________________________");
                System.out.println(level);
                System.out.println(sizeField);
                System.out.println(countMove);
                System.out.println(countPoint);
                System.out.println("__________________________________");

            } while (cursor.moveToNext());
        }
        cursor.close();

        String table2 ="positions";
        String[] columns2 = {"white_i", "white_j"};
        cursor =database.query(table2, columns2, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {


            /*stoneI = cursor.getInt(cursor.getColumnIndex("stone_i"));
            stoneJ = cursor.getInt(cursor.getColumnIndex("stone_j"));
            pointI = cursor.getInt(cursor.getColumnIndex("point_i"));
            pointJ = cursor.getInt(cursor.getColumnIndex("point_j"));*/

            do {

                whiteI.add(cursor.getInt(cursor.getColumnIndex("white_i")));
                whiteJ.add(cursor.getInt(cursor.getColumnIndex("white_j")));
                stoneI.add(cursor.getInt(cursor.getColumnIndex("stone_i")));
                stoneJ.add(cursor.getInt(cursor.getColumnIndex("stone_j")));
                pointI.add(cursor.getInt(cursor.getColumnIndex("point_i")));
                pointJ.add(cursor.getInt(cursor.getColumnIndex("point_j")));
                /*System.out.println("***************************************");
                System.out.println(whiteI);
                System.out.println(whiteJ);
                System.out.println("***************************************");*/

            } while (cursor.moveToNext());

        }

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


