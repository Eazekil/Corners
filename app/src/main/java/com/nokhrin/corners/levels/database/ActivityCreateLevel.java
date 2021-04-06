package com.nokhrin.corners.levels.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nokhrin.corners.R;

import java.util.ArrayList;

public class ActivityCreateLevel extends AppCompatActivity implements View.OnClickListener {
    private Button btnAdd, btnRead, btnClear, btnUpd, btnDel;
    private EditText etSizeField, etCountMove, etNumberLevel, etCountPoint, etPositionWhiteI, etPositionWhiteJ;
    private LevelsDb levelsDb;
    private ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this all for make full screen
        setContentView(R.layout.activity_create_level);
        View startLayout = findViewById(R.id.layoutCreateLevel);
        startLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etSizeField = (EditText) findViewById(R.id.etSizeOfField);
        etCountMove = (EditText) findViewById(R.id.etCountMove);
        etNumberLevel = (EditText) findViewById(R.id.NumberLevel);
        etCountPoint = (EditText) findViewById(R.id.etCountPoint);
        etPositionWhiteI = (EditText) findViewById(R.id.etPositionWhiteI);
        etPositionWhiteJ = (EditText) findViewById(R.id.etPositionWhiteJ);

        btnUpd = (Button) findViewById(R.id.btnUpd);
        btnUpd.setOnClickListener(this);

        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        // находим список
        lvMain = (ListView) findViewById(R.id.lvMain);

        levelsDb = new LevelsDb(this);

        ReadDb readDb = new ReadDb();
        readDb.setLevelsDb(levelsDb);
        readDb.read(1);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        String sizeField = etSizeField.getText().toString();
        String countMove = etCountMove.getText().toString();
        String numberLevel = etNumberLevel.getText().toString();
        String countPoint = etCountPoint.getText().toString();
        String positionWhiteI = etPositionWhiteI.getText().toString();
        String positionWhiteJ = etPositionWhiteJ.getText().toString();

        SQLiteDatabase database = levelsDb.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {

            case R.id.btnAdd:
                contentValues.put(LevelsDb.KEY_SIZE_FIELD, sizeField);
                contentValues.put(LevelsDb.KEY_COUNT_MOVE, countMove);
                contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
                contentValues.put(LevelsDb.KEY_COUNT_POINT, countPoint);
                database.insert(LevelsDb.TABLE_LEVELS, null, contentValues);
                contentValues.clear();

                contentValues.put(LevelsDb.KEY_WHITE_I, positionWhiteI);
                contentValues.put(LevelsDb.KEY_WHITE_J, positionWhiteJ);
                contentValues.put(LevelsDb.KEY_NUMBER_LEVEL, numberLevel);
                database.insert(LevelsDb.TABLE_POSITIONS, null, contentValues);

                break;

            case R.id.btnRead:
                /*String sqlQuery = String.format("select %s, %s, %s, %s from %s inner join %son %s.%s =? %s.%s", LevelsDb.KEY_NUMBER_LEVEL, LevelsDb.KEY_SIZE_FIELD, LevelsDb.KEY_COUNT_MOVE, LevelsDb.KEY_COUNT_POINT, LevelsDb.TABLE_LEVELS, LevelsDb.TABLE_POSITIONS, LevelsDb.TABLE_LEVELS, LevelsDb.KEY_NUMBER_LEVEL, LevelsDb.TABLE_POSITIONS, LevelsDb.KEY_NUMBER_LEVEL);
                Cursor cursor = database.rawQuery(sqlQuery, null);*/
                //Cursor cursor = database.query(LevelsDb.TABLE_LEVELS, null, null, null, null, null, null);
                String table = "levels as LV inner join positions as PS on LV.number_level = PS.number_level";
                String[] columns = {"LV.number_level as level", "LV.size_field as field", "LV.count_move as move", "LV.count_point as point", "PS.white_i as Y", "PS.white_j as X"};
                Cursor cursor = database.query(table, columns, null, null, null, null, null);


                if (cursor.moveToFirst()) {
                    /*int levelIndex = cursor.getColumnIndex(LevelsDb.KEY_NUMBER_LEVEL);
                    int sizeFieldIndex = cursor.getColumnIndex(LevelsDb.KEY_SIZE_FIELD);
                    int countMoveIndex = cursor.getColumnIndex(LevelsDb.KEY_COUNT_MOVE);
                    int countPointIndex = cursor.getColumnIndex(LevelsDb.KEY_COUNT_POINT);

                    int indexWhiteI = cursor.getColumnIndex(LevelsDb.KEY_WHITE_I);
                    int indexWhiteJ = cursor.getColumnIndex(LevelsDb.KEY_WHITE_J);*/

                    int levelIndex = cursor.getColumnIndex("level");
                    int sizeFieldIndex = cursor.getColumnIndex("field");
                    int countMoveIndex = cursor.getColumnIndex("move");
                    int countPointIndex = cursor.getColumnIndex("point");

                    int indexWhiteI = cursor.getColumnIndex("Y");
                    int indexWhiteJ = cursor.getColumnIndex("X");



                    ArrayList<String> levels = new ArrayList<>();
                    do {
                        levels.add("level = " + cursor.getInt(levelIndex) +
                                ", size of field = " + cursor.getString(sizeFieldIndex) +
                                ", count move = " + cursor.getString(countMoveIndex) +
                                ", count point = " + cursor.getString(countPointIndex) +
                                ", position whit Y = " + cursor.getString(indexWhiteI) +
                                ", position whit X = " + cursor.getString(indexWhiteJ));

                    } while (cursor.moveToNext());

                    // создаем адаптер
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1, levels);

                    // присваиваем адаптер списку
                    lvMain.setAdapter(adapter);

                } else {
                    System.out.println("-------------------------------  0 rows");
                }


                cursor.close();
                break;

            case R.id.btnClear:
                //database.delete(LevelsDb.TABLE_LEVELS, null, null);
                break;

            case R.id.btnUpd:
                if (numberLevel.equalsIgnoreCase("")) {
                    break;
                }
                contentValues.put(LevelsDb.KEY_COUNT_MOVE, countMove);
                contentValues.put(LevelsDb.KEY_SIZE_FIELD, sizeField);
                int updCount = database.update(LevelsDb.TABLE_LEVELS, contentValues, LevelsDb.KEY_ID + "= ?", new String[]{numberLevel});

                System.out.println("updates rows count = " + updCount);

            case R.id.btnDel:
                if (numberLevel.equalsIgnoreCase("")) {
                    break;
                }
                int delCount = database.delete(LevelsDb.TABLE_LEVELS, LevelsDb.KEY_ID + "=" + numberLevel, null);

                System.out.println("deleted rows count = " + delCount);
        }
        levelsDb.close();
    }
}