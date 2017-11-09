package assignment.mangaholic.presenter.asynctasks;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import assignment.mangaholic.model.dbhelper.FileCache;
import assignment.mangaholic.presenter.eventhandlers.ImageList;
import assignment.mangaholic.util.AsyncHelper;

public class DownloadMangaImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageList imageList;
    private FileCache fileCache;
    public DownloadMangaImageTask(ImageList imageList, FileCache fileCache) {
        this.imageList = imageList;
        this.fileCache = fileCache;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {

        return AsyncHelper.downloadImageTest(strings[0], fileCache);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageList.addItem(bitmap);
    }
}
