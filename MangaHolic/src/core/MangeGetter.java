package core;

import java.io.InputStream;
import java.util.List;

public interface MangeGetter {
    List getMangaList(InputStream is);
    List getMangaList(String filename);
    List getMangaList();
    Manga getMangaInfo(Manga manga);
    Manga getMangaInfo(String url);

}
