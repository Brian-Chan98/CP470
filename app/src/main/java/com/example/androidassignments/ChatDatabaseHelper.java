package com.example.androidassignments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ChatDatabaseHelper extends SQLiteOpenHelper {

    protected final static String ACTIVITY_NAME = "ChatWindowActivity";
    static final String DATABASE_NAME = "BriansPersonalDatabase.db";
    static int VERSION_NUM = 2;
    static final String TABLE_NAME = "MESSAGE";
    static final String KEY_ID = "ID";
    static final String KEY_MESSAGE = "MESSAGES";

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(ACTIVITY_NAME, "Calling onCreate");
        db.execSQL(DATABASE_CREATE);
    }

    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "(" + KEY_ID + " integer primary key autoincrement, "
            + KEY_MESSAGE + " text not null);";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(ACTIVITY_NAME, "calling on Upgrade, oldVersion=" + oldVersion + " newVersion=" + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
