package assignment.mangaholic.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncHelper {
    public static Bitmap downloadImage(String imageUrl) {
        Bitmap b = null;
        if (imageUrl.equals(""))
            return b;
        InputStream is = null;
        URL url = null;
        int response = -1;
        try {
            url = new URL(imageUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setAllowUserInteraction(false);
            con.setInstanceFollowRedirects(true);
            con.setRequestMethod("GET");
            con.connect();
            response = con.getResponseCode();
            is = con.getInputStream();
            b = BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

}
