package assignment.mangaholic.presenter.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import assignment.mangaholic.R;
import assignment.mangaholic.view.MangaDetail;
import core.Manga;

/**
 * Created by KhangTruong on 11/6/2017.
 */

public class FavoriteList extends BaseAdapter implements Filterable, AdapterView.OnItemClickListener {
    private Context context;
    private ArrayList<Manga> favoriteList;

    public FavoriteList(Context context, ArrayList<Manga> favoriteList) {
        this.context = context;
        this.favoriteList = favoriteList;
    }

    @Override
    public int getCount() {
        return favoriteList.size();
    }

    @Override
    public Object getItem(int position) {
        return favoriteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = convertView;
        if (v == null)
            v = inflater.inflate(R.layout.layout_manga_list, parent, false);
        TextView name = v.findViewById(R.id.txtName);
        final Manga manga= favoriteList.get(position);
        name.setText(manga.getName());
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle b = new Bundle();
        b.putString("url", favoriteList.get(position).getUrl());
        Intent intent = new Intent(context, MangaDetail.class);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
