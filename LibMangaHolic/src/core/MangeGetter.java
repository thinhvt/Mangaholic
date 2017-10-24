package core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface MangeGetter {
    ArrayList<Manga> getMangaList(InputStream is);
    ArrayList<Manga> getMangaList(String url);
    ArrayList<Manga> getMangaList();
    Manga getMangaInfo(Manga manga);
    Manga getMangaInfo(String url);
    ArrayList<String> getChapterImageList(String chapterUrl);

}
