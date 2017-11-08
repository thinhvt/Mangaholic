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

import assignment.mangaholic.model.dbhelper.FileCache;

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
    public static Bitmap downloadImageTest(String imageUrl,FileCache fileCache) {
        Bitmap b = null;
        if (imageUrl.equals(""))
            return b;
        File f = fileCache.getFile(imageUrl);

        //from SD cache
        b = decodeFile(f);

        if (b != null) {
            Log.d("GET_FROM_CACHE","11111111");
            return b;
        }
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
            Log.d("PUSH_INTO_CACHE","11111111");
            is = con.getInputStream();
            OutputStream out = new FileOutputStream(f);
            copyStream(is,out);
            Bitmap myBitmap =decodeFile(f);
            return myBitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    private static Bitmap decodeFile(File f) {
        try {
            //decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            Log.d("DECODE_FILE","FILE");
            //Find the correct scale value. It should be the power of 2.
            final int REQUIRED_SIZE = 720;
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE)
                    break;
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }
            Log.d("DECODE_FILE","tester");
            //decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            Log.d("DECODE_FILE","FIALS");
        }
        Log.d("DECODE_FILE","FAASD");
        return null;
    }
    private static void copyStream(InputStream input , OutputStream output) throws IOException {
        int n;
        byte[] buffer = new byte[16384];
        while((n = input.read(buffer)) > -1) {
            output.write(buffer, 0, n);   // Don't allow any extra bytes to creep in, final write
        }
        output.close ();
    }

}
