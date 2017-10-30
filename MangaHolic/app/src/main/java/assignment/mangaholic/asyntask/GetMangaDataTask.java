package assignment.mangaholic.asyntask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import assignment.mangaholic.listview.ChapterList;
import assignment.mangaholic.MangaDetail;
import assignment.mangaholic.listview.ImageList;
import core.Manga;
import core.truyentranh8.TruyenTranh8;

import java.util.ArrayList;

public class GetMangaDataTask extends AsyncTask<String, Void, Manga> {
    TruyenTranh8 tt8;
    private Context context;
    private ImageList imageList;

    public GetMangaDataTask(Context c) {
        context = c;
        tt8 = new TruyenTranh8();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MangaDetail.hideAllView();
    }

    @Override
    protected Manga doInBackground(String... strings) {
        Manga manga = null;

        try{
            manga = tt8.getMangaInfo(strings[0]);
        } catch (NullPointerException e) {
            Log.e("EXCEPTION", e.getMessage());
        }
        return manga;
    }

    @Override
    protected void onPostExecute(Manga manga) {
        super.onPostExecute(manga);

        TextView txtName = MangaDetail.txtName;

        if (manga == null) {
            txtName.setText("Manga đã bị xóa vì lú do bản quyền");
            return;
        }

        // prepare view
        ListView chapterList = MangaDetail.chapterList;
        TextView txtRating = MangaDetail.txtRating;
        TextView txtAuthor = MangaDetail.txtAuthor;
        TextView txtTag = MangaDetail.txtTag;
        TextView txtStatus = MangaDetail.txtStatus;
        android.support.v7.widget.Toolbar toolbar = MangaDetail.toolbar;

        // prepare strings
        StringBuilder authos = new StringBuilder("");
        StringBuilder tags = new StringBuilder("");
        for(String author : manga.getAuthors()) {
            authos.append(author + ", ");
        }

        // remove last ", "
        int uselessCommandIndex = authos.lastIndexOf(", ");
        if (uselessCommandIndex != -1)
            authos.replace(uselessCommandIndex , authos.length(), "");
        for(String tag : manga.getTags()) {
            tags.append(tag + ", ");
        }
        tags.replace(tags.lastIndexOf(", "), tags.length(), "");

        // set info
        txtName.setText("Truyện: " + manga.getName());
        txtRating.setText("Đánh giá: " + manga.getRating() + "");
        txtAuthor.setText("Tác giả: " + authos);
        txtTag.setText("Thể loại: " + tags);
        txtStatus.setText("Trạng thái: " + manga.getStatus());
        toolbar.setTitle(manga.getName());
        // done set info
        MangaDetail.showMangaInfo();

        // show chapter list
        ChapterList cl = new ChapterList(context, (ArrayList) manga.getChapters());
        chapterList.setOnItemClickListener(cl);
        chapterList.setAdapter(cl);
        MangaDetail.showChapterList();

        // download thumbnail
        DownloadMangaThumbnailTask downloadThumbnailTask = new DownloadMangaThumbnailTask();
        downloadThumbnailTask.execute(manga.getMangaThumbnail());

    }
}
