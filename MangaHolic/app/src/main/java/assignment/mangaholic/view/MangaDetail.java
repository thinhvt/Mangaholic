package assignment.mangaholic.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import assignment.mangaholic.R;
import assignment.mangaholic.presenter.asynctasks.GetMangaDataTask;

public class MangaDetail extends AppCompatActivity {
    public static ListView chapterList;
    public static TextView txtName;
    public static TextView txtRating;
    public static TextView txtAuthor;
    public static TextView txtTag;
    public static TextView txtStatus;
    public static ImageView thumbnail;
    public static Toolbar toolbar;
    public static EditText txtSearchChapter;

    private static ProgressBar thumbnailPB;
    private static ProgressBar infoPB;
    private static ProgressBar chapterPB;

    public static void hideAllView() {
        chapterList.setVisibility(View.GONE);
        txtName.setVisibility(View.GONE);
        txtRating.setVisibility(View.GONE);
        txtAuthor.setVisibility(View.GONE);
        txtTag.setVisibility(View.GONE);
        txtStatus.setVisibility(View.GONE);
        thumbnail.setVisibility(View.GONE);

        // show progress bar
        thumbnailPB.setVisibility(View.VISIBLE);
        chapterPB.setVisibility(View.VISIBLE);
        infoPB.setVisibility(View.VISIBLE);
    }

    public static void showMangaInfo() {
        infoPB.setVisibility(View.GONE);
        txtName.setVisibility(View.VISIBLE);
        txtRating.setVisibility(View.VISIBLE);
        txtAuthor.setVisibility(View.VISIBLE);
        txtTag.setVisibility(View.VISIBLE);
        txtStatus.setVisibility(View.VISIBLE);
    }

    public static void showChapterList() {
        chapterPB.setVisibility(View.GONE);
        chapterList.setVisibility(View.VISIBLE);
    }

    public static void showThumbnail() {
        thumbnailPB.setVisibility(View.GONE);
        thumbnail.setVisibility(View.VISIBLE);
    }

    private void initView() {
        chapterList = (ListView) findViewById(R.id.chapter_list);
        txtName = (TextView) findViewById(R.id.txtName);
        txtRating = (TextView) findViewById(R.id.txtRating);
        txtAuthor = (TextView) findViewById(R.id.txtAuthor);
        txtTag = (TextView) findViewById(R.id.txtTag);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        thumbnail = (ImageView) findViewById(R.id.thumbnail);
        thumbnailPB = (ProgressBar) findViewById(R.id.thumbnail_progress_bar);
        infoPB = (ProgressBar) findViewById(R.id.manga_info_progress_bar);
        chapterPB = (ProgressBar) findViewById(R.id.chapter_progress_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        txtSearchChapter = (EditText) findViewById(R.id.search_chapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_detail);

        initView();
        String url = getIntent().getExtras().getString("url");
        GetMangaDataTask task = new GetMangaDataTask(this);
        task.execute(url);
    }
}
