package core;

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
     * Prevent do this at much as possible
     * Due to getting data from internet
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
                    String mangaName = column.html();
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

    private ArrayList<String> parseAuthor(Element authorElement) {
        ArrayList<String> authorList = new ArrayList<>();
        Elements rawAuthorList = authorElement.getElementsByTag("span");
        for(Element author : rawAuthorList) {
            authorList.add(author.html());
        }
        return authorList;
    }

    private ArrayList<String> parseTag(Element tagElement) {
        ArrayList<String> tagList = new ArrayList<>();
        Elements rawTagList = tagElement.getElementsByTag("a");
        for(Element tag : rawTagList) {
            tagList.add(tag.html());
        }
        return tagList;
    }

    private double parseRating(Element ratingElement) {
        String ratingStr = ratingElement.select("[itemprop=\"ratingValue\"]").html();
        double rating = 0.0;
        try {
            rating = Double.parseDouble(ratingStr);
        } catch (NumberFormatException e) {
            System.err.println("Invalid rating format");
        }
        return rating;
    }

    private String parseStatus(Element statusElement) {
        String statusStr = statusElement.select("a").html();
        System.out.println(statusStr);
        return statusStr;
    }

    @Override
    public Manga getMangaInfo(String url) {
        Document doc = null;
        Manga manga;
        url = "http://truyentranh8.net/bungaku-shoujo-to-shi-ni-tagari-no-douke/";

        // try to connect to website
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // page is error
        if (doc == null)
            return null;

        Element mangaInfo = doc.select(".mangainfo").first();
        Elements info = mangaInfo.getElementsByTag("li");

        String mangaName = doc.select(".TitleH2").first().html();

        manga = new Manga(mangaName, url);

        manga.setRating(parseRating(info.first()));
        manga.setAuthors(parseAuthor(info.get(4)));
        manga.setTags(parseTag(info.get(5)));
        manga.setStatus(parseStatus(info.get(6)));

        return manga;
    }
}
