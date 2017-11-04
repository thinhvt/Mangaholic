package assignment.mangaholic.model.dbhelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import core.Manga;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class MangaTable {
    private MangaTable() {}

    public static String TableName = "TblManga";

    public static String ID = "ID";
    public static String MangaName = "MangaName";
    public static String MangaURL = "MangaURL";
    public static String isFavourite = "Favourite";

    public static void createMangaTable(SQLiteDatabase db) {
        String SQL_CREATE_MANGA_TABLE =
            "CREATE TABLE " + MangaTable.TableName + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MangaName+ " TEXT NOT NULL," +
                MangaURL+ " TEXT NOT NULL," +
                isFavourite+ " INTEGER NOT NULL" +
            ")";
        db.execSQL(SQL_CREATE_MANGA_TABLE);
    }

    public static void deleteMangaTable(SQLiteDatabase db) {
        String SQL_DELETE_MANGA_TABLE =
            "DROP TABLE IF EXISTS " + MangaTable.TableName;
        db.execSQL(SQL_DELETE_MANGA_TABLE);
    }

    public static void addNewManga(Manga m, SQLiteOpenHelper helper) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(MangaName, m.getName());
        values.put(MangaURL, m.getUrl());
        values.put(isFavourite, 0);

        db.insert(TableName, null, values);
        db.close();
    }

    public static ArrayList<Manga> getAllMangas(SQLiteOpenHelper helper) {
        ArrayList<Manga> mangaList = new ArrayList<Manga>();
        String selectQuery = "SELECT  * FROM " + TableName;

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String url = cursor.getString(2);
                int isFav = cursor.getInt(3);

                Manga m = new Manga(name, url);
                m.setFavourite(isFav == 0 ? false : true);
                mangaList.add(m);
            } while(cursor.moveToNext());
        }
        return mangaList;
    }


}
