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
    private final static String MANGA_LIST_URL_FORMAT = "http://m.truyentranh8.net/all/page=%d";
    public final static String TRUYEN_TRANH_8_HOT = "http://m.truyentranh8.net/truyen_xem_nhieu/";

    @Override
    public List getMangaList(InputStream is) {
        return null;
    }

    @Override
    public List getMangaList(String url) {
        Document doc;
        ArrayList mangaListParsed = new ArrayList();
        System.out.println("Fetching manga from TruyenTranh8");

        // try to connect to website
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return mangaListParsed;
        }

        // get row in table
        Elements mangaList = doc.select("a.post");
        // break if there is no manga found
        if (mangaList.size() == 0) {
            return mangaListParsed;
        }

        // get each manga info in table
        for (Element manga : mangaList) {
            String mangaName = manga.select("div.title").first().html().trim();
            mangaName = Jsoup.parse(mangaName).text();
            if (mangaName.length() == 0) continue;
            String mangaUrl = manga.attr("href");
            mangaListParsed.add(new Manga(mangaName, mangaUrl));
        }
        System.out.println(mangaListParsed.size() + " mangas have been fetched");
        return mangaListParsed;
    }

    @Override
    public List getMangaListFromFile(String filename) {
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
            Elements mangaList = doc.select("a.post");
            // break if there is no manga found
            if (mangaList.size() == 0) {
                break;
            }

            // get each manga info in table
            for (Element manga : mangaList) {
                String mangaName = manga.select("div.title").first().html().trim();
                mangaName = Jsoup.parse(mangaName).text();
                if (mangaName.length() == 0) continue;
                String mangaUrl = manga.attr("href");
                mangaListParsed.add(new Manga(mangaName, mangaUrl));
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

        Element mangaInfo = doc.select(".MangaInfo").first();
        Element chapterList = doc.select("ol").first();
        Element thumbnail = doc.select("img.centered.img-responsive").first();
        Elements info = mangaInfo.getElementsByTag("li");
        String mangaName = mangaInfo.select("h1").first().html();

        manga = defaultManga(mangaName, url);
        manga.setRating(parser.parseRating(mangaInfo));
        for(Element e : info) {
            Element eleSection = e.select("b").first();
            if (eleSection != null) {
                String section = eleSection.html();
                switch (section.toLowerCase()) {
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
        manga.setMangaThumbnail(parser.parseThumbnailURL(thumbnail));
        return manga;
    }

    @Override
    public List<String> getChapterImageList(String html) {
        TruyenTranh8MangaParser parser = new TruyenTranh8MangaParser();
        return parser.parseChapterImage(html);
    }

    //default manga. Prevent some case that manga doesn't have enough information
    private Manga defaultManga(String name, String url) {
        Manga manga = new Manga(name, url);
        return manga;
    }
}
