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
    private static int status = 0;

    private AllMangaList() {}

    public static void updateMangaList(ArrayList<Manga> mangas) {
        status = 1;
        mangaList = mangas;
    }

    public static int getStatus() {
        return status;
    }

    public static ArrayList<Manga> getMangaList() {
        return mangaList;
    }
}
