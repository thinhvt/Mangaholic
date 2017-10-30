package assignment.mangaholic.asyntask;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import assignment.mangaholic.listview.ImageList;
import assignment.mangaholic.util.AsyncHelper;

public class DownloadMangaImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageList imageList;

    public DownloadMangaImageTask(ImageList imageList) {
        this.imageList = imageList;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {

        return AsyncHelper.downloadImage(strings[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageList.addItem(bitmap);
    }
}
