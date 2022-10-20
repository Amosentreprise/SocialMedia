package com.hoptech.socialmedia.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteDataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Database.db";
    public static final String TABLE_NAME= "Users";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME";
    public static final String COL_3 = "LASTNAME";
    public static final String COL_4 = "PHONE_NUMBER";
    public static final String COL_5 = "PASSWORD";
     public  static int version = 1;
    public SqliteDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME , null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME TEXT,LASTNAME TEXT,PHONE_NUMBER TEXT ,PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
           db.execSQL("DROP TABLE IF EXISTS TABLE_NAME");
           onCreate(db);
    }
    public  Boolean insertData(String FIRSTNAME, String LASTNAME,String PHONE_NUMBER, String PASSWORD){
         SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,FIRSTNAME);
        contentValues.put(COL_3,LASTNAME);
        contentValues.put(COL_4,PHONE_NUMBER);
        contentValues.put(COL_5,PASSWORD);
      long result=  db.insert(TABLE_NAME,null,contentValues);
      if (result==1){
          return  false;
      } else{
          return  true;
      }


    }
    public  Boolean checkphonenuberpass(String PHONE_NUMBER, String PASSWORD){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor= myDb.rawQuery("select * from Users where PHONE_NUMBER= ? and PASSWORD = ?", new String[] {PHONE_NUMBER, PASSWORD});

        if ( cursor.getCount()>0)
            return true;
            else
                return false;

    }
}
