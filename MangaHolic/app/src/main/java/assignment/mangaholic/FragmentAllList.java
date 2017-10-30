package assignment.mangaholic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import assignment.mangaholic.asyntask.LoadAllMangaTask;

public class FragmentAllList extends android.app.Fragment {

    public static ListView mangaListview;
    public static EditText txtSearch;
    public static ProgressBar progressBar;

    public static void hideAllView() {
        mangaListview.setVisibility(View.GONE);
        txtSearch.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    public static void showAllView() {
        mangaListview.setVisibility(View.VISIBLE);
        txtSearch.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public void initView(View all) {
        mangaListview = (ListView) all.findViewById(R.id.all_manga_list);
        txtSearch = (EditText) all.findViewById(R.id.txtSearch);
        progressBar = (ProgressBar) all.findViewById(R.id.load_all_progress_bar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragAllList = inflater.inflate(R.layout.fragment_all_manga_list, container, false);
        initView(fragAllList);
        (new LoadAllMangaTask(fragAllList.getContext())).execute();
        return fragAllList;
    }
}
