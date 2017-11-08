package assignment.mangaholic.presenter.asynctasks;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;

import java.util.ArrayList;

import assignment.mangaholic.model.dbhelper.DatabaseHelper;
import assignment.mangaholic.model.dbhelper.MangaTable;
import assignment.mangaholic.presenter.eventhandlers.FavoriteList;
import assignment.mangaholic.view.FragmentFavoriteManga;
import core.Manga;

/**
 * Created by Regera on 11/7/2017.
 */

public class LoadFavoriteMangaTask extends AsyncTask<Void, Void, ArrayList<Manga>> {
    private Context context;
    private FavoriteList favoriteListAdapter;

    public LoadFavoriteMangaTask(Context context)
    {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        FragmentFavoriteManga.hideAllView();
    }

    @Override
    protected ArrayList<Manga> doInBackground(Void... voids) {
        Resources res = context.getResources();
        ArrayList<Manga> mangaArr = MangaTable.findFavorite(DatabaseHelper.getHelper(context));

        return mangaArr;
    }

    @Override
    protected void onPostExecute(ArrayList<Manga> mangas) {
        super.onPostExecute(mangas);
        if(favoriteListAdapter == null) {
            favoriteListAdapter = new FavoriteList(context, mangas);
            FragmentFavoriteManga.favoriteListView.setOnItemClickListener(favoriteListAdapter);
            FragmentFavoriteManga.favoriteListView.setAdapter(favoriteListAdapter);
        }
        else
        {
            favoriteListAdapter.notifyDataSetChanged();
        }

        FragmentFavoriteManga.showAllView();
    }
}
