package assignment.mangaholic.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import assignment.mangaholic.R;
import assignment.mangaholic.presenter.asynctasks.LoadAllMangaToListViewTask;
import assignment.mangaholic.presenter.asynctasks.LoadFavoriteMangaTask;

public class FragmentFavoriteManga extends android.app.Fragment {
    private View fragFavorite;
    public static ListView favoriteListView;
    public static ProgressBar progressBar;

    public static void hideAllView() {
        favoriteListView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    public static void showAllView() {
        favoriteListView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public void initView(View all) {
        favoriteListView = (ListView) all.findViewById(R.id.favorite_list);
        progressBar = (ProgressBar) all.findViewById(R.id.favorite_progress_bar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragFavorite = inflater.inflate(R.layout.fragment_favorite_manga, container, false);
        initView(fragFavorite);
        (new LoadFavoriteMangaTask(fragFavorite.getContext())).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return fragFavorite;
    }

    @Override
    public void onResume() {
        super.onResume();
        (new LoadFavoriteMangaTask(fragFavorite.getContext())).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
