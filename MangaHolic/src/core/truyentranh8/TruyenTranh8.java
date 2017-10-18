package core.truyentranh8;

import core.Manga;
import core.MangeGetter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TruyenTranh8 implements MangeGetter {
    private final static String MANGA_LIST_URL_FORMAT = "http://truyentranh8.net/search.php?act=search&sort=ten&page=%d&view=list";

    @Override
    public List getMangaList(InputStream is) {
        return null;
    }

    @Override
    public List getMangaList(String filename) {
        return null;
    }

    /**
     * Prevent to call this at much as possible
     * Due to getting data from internet may slowing down the application performance
     * @return list of manga
     */
    @Override
    public List getMangaList() {
        Document doc;
        ArrayList mangaListParsed = new ArrayList();
        int i = 1; // first page
        System.out.println("Fetching manga from TruyenTranh8");
        while(true) {
            System.out.println("Fetching page " + i);
            String requestUrl = String.format(MANGA_LIST_URL_FORMAT, i);

            // try to connect to website
            try {
                doc = Jsoup.connect(requestUrl).get();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            // get row in table
            Elements mangaList = doc.getElementsByTag("tr");

            // break if there is no manga found
            if (mangaList.size() == 0) {
                break;
            }

            // get each manga info in table
            for (Element manga : mangaList) {
                Elements row = manga.select("td a");
                Element column = row.first();
                if (column != null) {
                    String mangaName = column.html().trim();
                    if (mangaName.length() == 0) continue;
                    String mangaUrl = column.attr("href");
                    mangaListParsed.add(new Manga(mangaName, mangaUrl));
                }
            }
            i++;
            break; // debug
        }
        System.out.println(mangaListParsed.size() + " mangas have been fetched");
        return mangaListParsed;
    }

    @Override
    public Manga getMangaInfo(Manga manga) {
        if (manga == null)
            return null;
        String url = manga.getUrl();
        Manga newManga = getMangaInfo(url);
        return newManga;
    }

    @Override
    public Manga getMangaInfo(String url) throws NullPointerException {
        Document doc = null;
        Manga manga;
        TruyenTranh8MangaParser parser = new TruyenTranh8MangaParser();

        // try to connect to website
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // page is error or blocked
        if (doc == null)
            return null;

        Element mangaInfo = doc.select(".mangainfo").first();
        Element chapterList = doc.select("ul#ChapList").first();
        Element thumbnail = doc.select("img.center-block.thumbnail.img-responsive").first();
        Elements info = mangaInfo.getElementsByTag("li");
        String mangaName = doc.select(".TitleH2").first().html();

        manga = defaultManga(mangaName, url);

        for(Element e : info) {
            Element eleSection = e.select("b").first();
            if (eleSection != null) {
                String section = eleSection.html();
                switch (section.toLowerCase()) {
                    case "đánh giá:": {
                        manga.setRating(parser.parseRating(e));
                        break;
                    }
                    case "tác giả:": {
                        manga.setAuthors(parser.parseAuthor(e));
                        break;
                    }
                    case "thể loại:": {
                        manga.setTags(parser.parseTag(e));
                        break;
                    }
                    case "tình trạng:": {
                        manga.setStatus(parser.parseStatus(e));
                    }
                } // end switch
            } // end if
        }

        manga.setChapters(parser.parseChapter(chapterList));
        manga.setMangaThumbnail(thumbnail.attr("src"));
        return manga;
    }

    //default manga. Prevent some case that manga doesn't have enough information
    private Manga defaultManga(String name, String url) {
        Manga manga = new Manga(name, url);
        manga.setRating(0.0);
        manga.setStatus("Unknown");
        manga.setTags(new ArrayList<>());
        manga.setChapters(new ArrayList<>());
        manga.setAuthors(new ArrayList<>());
        manga.setMangaThumbnail("");

        return manga;
    }
}
