package com.example.no8;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {
    String TAG = SQLiteDataBaseHelper.class.getSimpleName();
    private static final String DB_NAME = "MyList.db";
    private final String TABLE_NAME = "MyTable";
    private static final int DB_VERSION = 1;

    public SQLiteDataBaseHelper(@Nullable Context context,
                                @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, String TABLE_NAME) {
        super(context, DB_NAME, factory, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQLTable = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+
                "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "Comment TEXT, "+
                "LikeNum INTEGER"+
                ")";
        sqLiteDatabase.execSQL(SQLTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(SQL);
    }



}
