package assignment.mangaholic.presenter.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import assignment.mangaholic.view.FragmentHome;
import assignment.mangaholic.presenter.eventhandlers.MangaList;
import core.Manga;
import core.truyentranh8.TruyenTranh8;

import java.util.ArrayList;

public class GetHomePageTask extends AsyncTask<String, Void, ArrayList<Manga>> {
    private TruyenTranh8 tt8;
    private Context c;

    public GetHomePageTask(Context c) {
        this.c = c;
        tt8 = new TruyenTranh8();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        FragmentHome.hideAllView();
    }

    @Override
    protected ArrayList<Manga> doInBackground(String... strings) {
        String url = strings[0];
        return tt8.getMangaList(url);
    }

    @Override
    protected void onPostExecute(ArrayList<Manga> mangas) {
        super.onPostExecute(mangas);
        Log.i("MANGA :" , mangas.toString());
        MangaList ml = new MangaList(c, mangas);
        FragmentHome.mangaListview.setAdapter(ml);
        FragmentHome.mangaListview.setOnItemClickListener(ml);
        FragmentHome.showAllView();
    }
}
