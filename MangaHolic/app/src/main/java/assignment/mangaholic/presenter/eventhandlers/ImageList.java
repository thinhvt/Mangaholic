package assignment.mangaholic.presenter.eventhandlers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import assignment.mangaholic.R;
import core.Chapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ImageList extends BaseAdapter {
    private Context context;
    private ArrayList<Bitmap> imageList;

    public ImageList(Context c, ArrayList<Bitmap> imageList) {
        context = c;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int i) {
        return imageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addItem(Bitmap b) {
        imageList.add(b);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vi = view;
        if (vi == null)
            vi = inflater.inflate(R.layout.layout_image_list, viewGroup, false);
        ImageView image = vi.findViewById(R.id.image);
        final Bitmap b= imageList.get(i);

        //set name
        image.setImageBitmap(b);

        return vi;
    }

}
