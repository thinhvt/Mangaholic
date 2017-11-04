package assignment.mangaholic.presenter.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import assignment.mangaholic.model.dbhelper.DatabaseHelper;
import assignment.mangaholic.model.dbhelper.MangaTable;
import core.Manga;

import java.util.ArrayList;

public class InsertAllMangasToDBTask extends AsyncTask<Manga, Void, Void> {
    private Context context;

    public InsertAllMangasToDBTask(Context context) {
        this.context = context;
    }


    @Override
    protected Void doInBackground(Manga... mangas) {
        for(Manga m : mangas)
            MangaTable.addNewManga(m, DatabaseHelper.getHelper(context));
        return null;
    }
}
