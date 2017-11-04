package assignment.mangaholic.presenter.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import assignment.mangaholic.presenter.eventhandlers.MangaList;
import assignment.mangaholic.util.AllMangaList;
import assignment.mangaholic.view.FragmentAllList;
import core.Manga;

import java.util.ArrayList;

public class LoadAllMangaToListViewTask extends AsyncTask<Void, Void, ArrayList<Manga>> {
    private Context context;

    public LoadAllMangaToListViewTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        FragmentAllList.hideAllView();
    }

    @Override
    protected ArrayList<Manga> doInBackground(Void... voids) {
        ArrayList<Manga> mangaArr = null;
        while(true) {
            Log.i("STATUS", AllMangaList.getStatus() + "");
            if (AllMangaList.getStatus() == 1) {
                mangaArr = AllMangaList.getMangaList();
                break;
            }
            // get all manga and return
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return mangaArr;
    }

    @Override
    protected void onPostExecute(ArrayList<Manga> mangas) {
        super.onPostExecute(mangas);
        final MangaList mangaListAdapter = new MangaList(context, mangas);

        FragmentAllList.mangaListview.setOnItemClickListener(mangaListAdapter);
        FragmentAllList.mangaListview.setAdapter(mangaListAdapter);
        FragmentAllList.txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mangaListAdapter.getFilter().filter(editable.toString());
            }
        });
        FragmentAllList.showAllView();
    }
}
