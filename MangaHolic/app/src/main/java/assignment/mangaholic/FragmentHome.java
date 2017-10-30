package assignment.mangaholic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import assignment.mangaholic.asyntask.GetHomePageTask;
import core.truyentranh8.TruyenTranh8;


public class FragmentHome extends android.app.Fragment {
    public static ListView mangaListview;
    public static TextView title;
    public static ProgressBar progressBar;

    public static void hideAllView() {
        mangaListview.setVisibility(View.GONE);
        title.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    public static void showAllView() {
        mangaListview.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    public void initView(View home) {
        mangaListview = (ListView) home.findViewById(R.id.manga_list);
        title = (TextView) home.findViewById(R.id.txtTitle);
        progressBar = (ProgressBar) home.findViewById(R.id.home_progress_bar);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragHome = inflater.inflate(R.layout.fragment_home, container, false);
        initView(fragHome);
        GetHomePageTask task = new GetHomePageTask(fragHome.getContext());
        task.execute(TruyenTranh8.TRUYEN_TRANH_8_HOME);
        return fragHome;
    }
}
