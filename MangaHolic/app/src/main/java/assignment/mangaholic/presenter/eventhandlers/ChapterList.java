package assignment.mangaholic.presenter.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import assignment.mangaholic.R;
import assignment.mangaholic.view.ViewManga;
import core.Chapter;

import java.util.ArrayList;

public class ChapterList extends BaseAdapter implements Filterable, AdapterView.OnItemClickListener {
    private Context context;
    public static ArrayList<Chapter> chapterList;
    private ArrayList<Chapter> fChapterList;
    private ChapterListFilter filter;

    public ChapterList(Context context, ArrayList chapterList) {
        this.context = context;
        this.chapterList = chapterList;
        this.fChapterList = chapterList;
    }

    @Override
    public int getCount() {
        return fChapterList.size();
    }

    @Override
    public Object getItem(int i) {
        return fChapterList.get(i);
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
        final Chapter chapter= fChapterList.get(i);

        //set name
        name.setText(chapter.getChapterName());

        return vi;
    }

    @Override
    public Filter getFilter() {
        if(filter == null)
            filter = new ChapterListFilter();
        return filter;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Chapter curChapter = fChapterList.get(i);
        int curChapterIndex = chapterList.indexOf(curChapter);
        Intent intent = new Intent(context, ViewManga.class);
        intent.putExtra("indexChapter", curChapterIndex);
        context.startActivity(intent);
    }

    public class ChapterListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String searchStr = charSequence.toString().toLowerCase().trim();
            FilterResults result = new FilterResults();
            final ArrayList<Chapter> resultList = new ArrayList<>();

            for(Chapter m : chapterList) {
                if (m.getChapterName().toLowerCase().contains(searchStr))
                    resultList.add(m);
            }

            result.values = resultList;
            result.count = resultList.size();
            return result;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            fChapterList = (ArrayList<Chapter>) results.values;
            notifyDataSetChanged();
        }
    }
}
