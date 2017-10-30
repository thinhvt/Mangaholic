package assignment.mangaholic.util;

import android.content.Context;
import assignment.mangaholic.R;
import core.Manga;
import core.truyentranh8.TruyenTranh8;

import java.util.ArrayList;

/**
 * Singleton to prevent read a single file multiple times
 * Why I prevent program to read file multiple times?
 * Because it's big! OvOb
 * Logic ya?
 */
public class AllMangaList {
    private static ArrayList<Manga> mangaList = null;

    private AllMangaList(Context context) {
        TruyenTranh8 tt8 = new TruyenTranh8();
        mangaList = tt8.getMangaList(context.getResources().openRawResource(R.raw.manga_list));
    }

    public static ArrayList<Manga> getAllManga(Context context) {
        if (mangaList == null) {
            new AllMangaList(context);
        }
        return mangaList;
    }
}
