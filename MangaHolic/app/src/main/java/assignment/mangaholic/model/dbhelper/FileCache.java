package assignment.mangaholic.model.dbhelper;

import android.content.Context;
import android.util.Log;

import java.io.File;

/**
 * Created by PhatDV on 08/11/2017.
 */

public class FileCache {
    private File cacheDir;

    public FileCache(Context context){
        //Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            cacheDir=new File(android.os.Environment.getExternalStorageDirectory(),"TTImages_cache");
        else
            cacheDir=context.getCacheDir();
        if(!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url){
        // convert url to hardCode
        String filename=String.valueOf(url.hashCode());

        // String filename = URLEncoder.encode(url);
        Log.d("GetFile:",filename);
        File f = new File(cacheDir, filename);
        return f;

    }

    public void clear(){
        File[] files=cacheDir.listFiles();
        Log.d("DELETE_FILE","Ffdddd");
        if(files==null)
            return;
        for(File f:files)
            f.delete();
    }
}
