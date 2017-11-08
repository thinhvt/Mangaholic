package assignment.mangaholic.presenter.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import assignment.mangaholic.view.MangaDetail;
import assignment.mangaholic.R;
import core.Manga;

import java.util.ArrayList;

public class MangaList extends BaseAdapter implements Filterable, AdapterView.OnItemClickListener {
    private Context context;
    private ArrayList<Manga> mangaList;
    private ArrayList<Manga> fMangaList;
    private MangaListFilter filter;

    public MangaList(Context context, ArrayList mangaList) {
        this.context = context;
        this.mangaList = mangaList;
        this.fMangaList = mangaList;
    }

    @Override
    public int getCount() {
        return fMangaList.size();
    }

    @Override
    public Object getItem(int i) {
        return fMangaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vi = view;
        if (vi == null)
            vi = inflater.inflate(R.layout.layout_manga_list, viewGroup, false);
        TextView name = vi.findViewById(R.id.txtName);
        final Manga manga= fMangaList.get(i);

        //set name
        name.setText(manga.getName());

        return vi;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new MangaListFilter();
        }
        return filter;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Bundle b = new Bundle();
        b.putString("url", fMangaList.get(i).getUrl());
        Intent intent = new Intent(context, MangaDetail.class);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    public class MangaListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String searchStr = charSequence.toString().toLowerCase().trim();
            FilterResults result = new FilterResults();
            final ArrayList<Manga> resultList = new ArrayList<>();

            for(Manga m : mangaList) {
                if (m.getName().toLowerCase().contains(searchStr))
                    resultList.add(m);
            }

            result.values = resultList;
            result.count = resultList.size();
            return result;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            fMangaList = (ArrayList<Manga>) results.values;
            notifyDataSetChanged();
        }
    }
}
