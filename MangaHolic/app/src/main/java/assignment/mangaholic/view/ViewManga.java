package assignment.mangaholic.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import assignment.mangaholic.R;
import assignment.mangaholic.presenter.asynctasks.DownloadMangaImageTask;
import assignment.mangaholic.presenter.eventhandlers.ChapterList;
import assignment.mangaholic.presenter.eventhandlers.ImageList;
import core.Chapter;

import java.util.ArrayList;

public class ViewManga extends AppCompatActivity {

    public static ListView imageList;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_manga);
        getSupportActionBar().hide();


        ArrayList<Chapter> chapterList = ChapterList.chapterList;
        final int indexChapter = getIntent().getExtras().getInt("indexChapter");
        Chapter chapter = chapterList.get(indexChapter);
        TextView txtChapter = (TextView) findViewById(R.id.txtChapter);
        txtChapter.setText(chapter.getChapterName());
        imageList = (ListView) findViewById(R.id.image_list);
        final WebView wb = (WebView) findViewById(R.id.pre_load);

        final ImageList imgList = new ImageList(this, new ArrayList<Bitmap>());
        imageList.setAdapter(imgList);

        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setDomStorageEnabled(true);
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                if (url.contains("imgmax=0")) {
                    Log.i("IMAGE", url);
                    DownloadMangaImageTask downloadMangaImageTask = new DownloadMangaImageTask(imgList);
                    downloadMangaImageTask.execute(url);
                }
            }
        });
        wb.loadUrl(chapter.getChapterURL());
        Button nextButton = (Button) findViewById(R.id.btNext);
        Button previousButton = (Button) findViewById(R.id.btPrevious);
        if (indexChapter == chapterList.size()-1){
            nextButton.setVisibility(View.INVISIBLE);
        }
        else {
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent nextChapter = new Intent(getApplicationContext(), ViewManga.class);
                    nextChapter.putExtra("indexChapter",indexChapter + 1);
                    finish();
                    startActivity(nextChapter);
                }
            });
        }
        if (indexChapter == 0) {
            previousButton.setVisibility(View.INVISIBLE);
        }
        else {
            previousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent previousChapter = new Intent(getApplicationContext(), ViewManga.class);
                    previousChapter.putExtra("indexChapter",indexChapter - 1);
                    finish();
                    startActivity(previousChapter);
                }
            });
        }
    }
}
