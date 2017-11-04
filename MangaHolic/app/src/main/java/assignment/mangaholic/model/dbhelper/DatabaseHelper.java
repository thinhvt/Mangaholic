package assignment.mangaholic.model.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MangaHolicDB.db";
    public static DatabaseHelper helper;

    public static DatabaseHelper getHelper(Context context) {
        if (helper == null) {
            helper = new DatabaseHelper(context);
        }
        return helper;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        MangaTable.createMangaTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        MangaTable.deleteMangaTable(db);
        onCreate(db);
    }
}
