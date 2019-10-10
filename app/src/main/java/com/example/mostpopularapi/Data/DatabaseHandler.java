package com.example.mostpopularapi.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mostpopularapi.Model.Result;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEI_ID + " INTEGER PRIMARY KEY,"
                + Util.KEI_TITLE + " TEXT,"
                + Util.KEY_URL + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        onCreate(db);
    }

    public  void  addResult(Result result){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEI_TITLE, result.getTitle());
        contentValues.put(Util.KEY_URL, result.getUrl());

        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
    }

    public Result getResult(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEI_ID,
                Util.KEI_TITLE, Util.KEY_URL}, Util.KEI_ID + "=?", new String[]
                {String.valueOf(id)},null,null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        Result result = new Result(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return result;

    }

    public List<Result> getAllResult(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<Result> resultsList = new ArrayList<>();

        String selectAllResult = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllResult, null);
        if(cursor.moveToFirst()){
            do{
                Result result = new Result();
                result.setId(Integer.parseInt(cursor.getString(0)));
                result.setTitle(cursor.getString(1));
                result.setUrl(cursor.getString(2));

                resultsList.add(result);
            }while (cursor.moveToNext());
        }
        return  resultsList;
    }
}
