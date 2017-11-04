package assignment.mangaholic.presenter.asynctasks;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import assignment.mangaholic.view.MangaDetail;
import assignment.mangaholic.util.AsyncHelper;

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
