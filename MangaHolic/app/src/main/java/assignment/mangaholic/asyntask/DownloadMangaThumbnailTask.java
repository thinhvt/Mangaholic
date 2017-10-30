package assignment.mangaholic.asyntask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import assignment.mangaholic.MangaDetail;
import assignment.mangaholic.util.AsyncHelper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadMangaThumbnailTask extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {
        return AsyncHelper.downloadImage(strings[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        MangaDetail.thumbnail.setImageBitmap(bitmap);
        MangaDetail.showThumbnail();
    }
}
