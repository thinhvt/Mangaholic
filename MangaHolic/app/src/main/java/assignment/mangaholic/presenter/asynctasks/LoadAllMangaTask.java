package assignment.mangaholic.presenter.asynctasks;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;

import assignment.mangaholic.model.dbhelper.DatabaseHelper;
import assignment.mangaholic.model.dbhelper.MangaTable;
import assignment.mangaholic.util.AllMangaList;
import assignment.mangaholic.view.FragmentAllList;
import assignment.mangaholic.R;
import assignment.mangaholic.presenter.eventhandlers.MangaList;
import core.Manga;
import core.truyentranh8.TruyenTranh8;

import java.util.ArrayList;

public class LoadAllMangaTask extends AsyncTask<Void, Void, ArrayList<Manga>>{
    private Context context;

    public LoadAllMangaTask(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<Manga> doInBackground(Void... voids) {
        Resources res = context.getResources();
        ArrayList<Manga> mangaArr = MangaTable.getAllMangas(DatabaseHelper.getHelper(context));

        return mangaArr;
    }

    @Override
    protected void onPostExecute(ArrayList<Manga> mangas) {
        super.onPostExecute(mangas);
        AllMangaList.updateMangaList(mangas);
    }
}
