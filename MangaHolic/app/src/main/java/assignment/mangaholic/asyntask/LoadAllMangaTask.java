package assignment.mangaholic.asyntask;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import assignment.mangaholic.FragmentAllList;
import assignment.mangaholic.R;
import assignment.mangaholic.listview.MangaList;
import core.Manga;
import core.truyentranh8.TruyenTranh8;

import java.util.ArrayList;

public class LoadAllMangaTask extends AsyncTask<Void, Void, ArrayList<Manga>>{
    private Context context;

    public LoadAllMangaTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        FragmentAllList.hideAllView();
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
