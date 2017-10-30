package assignment.mangaholic.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import assignment.mangaholic.MangaDetail;
import assignment.mangaholic.R;
import assignment.mangaholic.ViewManga;
import core.Chapter;
import core.Manga;

import java.io.Serializable;
import java.util.ArrayList;

public class ChapterList extends BaseAdapter implements Filterable, AdapterView.OnItemClickListener {
    private Context context;
    public static ArrayList<Chapter> chapterList;

    public ChapterList(Context context, ArrayList chapterList) {
        this.context = context;
        this.chapterList = chapterList;
    }

    @Override
    public int getCount() {
        return chapterList.size();
    }

    @Override
    public Object getItem(int i) {
        return chapterList.get(i);
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
        final Chapter chapter= chapterList.get(i);

        //set name
        name.setText(chapter.getChapterName());

        return vi;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(context, ViewManga.class);
        intent.putExtra("indexChapter",i);
        context.startActivity(intent);
    }
}
