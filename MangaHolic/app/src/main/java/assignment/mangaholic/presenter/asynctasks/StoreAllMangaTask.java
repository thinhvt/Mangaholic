package assignment.mangaholic.presenter.asynctasks;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import assignment.mangaholic.R;
import assignment.mangaholic.util.AllMangaList;
import core.Manga;
import core.truyentranh8.TruyenTranh8;

import java.util.ArrayList;

public class StoreAllMangaTask extends AsyncTask<Void, Void, ArrayList<Manga>>{
    private Context context;

    public StoreAllMangaTask(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<Manga> doInBackground(Void... voids) {
        Resources res = context.getResources();
        ArrayList<Manga> mangaArr = new TruyenTranh8().getMangaList(res.openRawResource(R.raw.manga_list));

        return mangaArr;
    }

    @Override
    protected void onPostExecute(ArrayList<Manga> mangas) {
        super.onPostExecute(mangas);
        AllMangaList.updateMangaList(mangas);
        // use executeOnExecutor so that this async task is not blocked another async task
        (new InsertAllMangasToDBTask(context)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, mangas.toArray(new Manga[mangas.size()]));
    }
}
