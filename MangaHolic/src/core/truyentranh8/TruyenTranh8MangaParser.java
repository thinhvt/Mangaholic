package core.truyentranh8;

import core.Chapter;
import core.MangaParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TruyenTranh8MangaParser implements MangaParser {
    @Override
    public ArrayList<String> parseAuthor(Element authorElement) {
        ArrayList<String> authorList = new ArrayList<>();
        Elements rawAuthorList = authorElement.getElementsByTag("span");
        for(Element author : rawAuthorList) {
            authorList.add(Jsoup.parse(author.html()).text());
        }
        return authorList;
    }

    @Override
    public ArrayList<String> parseTag(Element tagElement) {
        ArrayList<String> tagList = new ArrayList<>();
        Elements rawTagList = tagElement.getElementsByTag("a");
        for(Element tag : rawTagList) {
            tagList.add(tag.html());
        }
        return tagList;
    }

    private String getChapterName(String rawChapterName) {
        Pattern p = Pattern.compile("(chap\\s+[0-9]+)");   // the pattern to search for
        Matcher m = p.matcher(rawChapterName.toLowerCase());
        if (m.find())
            return m.group(1);
        return "";
    }

    @Override
    public ArrayList<Chapter> parseChapter(Element chapterElement) {
        Elements rawChapterList = chapterElement.select("a");
        ArrayList<Chapter> chapterList = new ArrayList<>();
        for(Element chapterInfo : rawChapterList) {
            String chapterUrl = chapterInfo.attr("href");
            String chapterName = getChapterName(chapterInfo.select("h3").html().trim());
            chapterList.add(new Chapter(chapterName, chapterUrl));
        }
        return chapterList;
    }

    @Override
    public double parseRating(Element ratingElement) {
        String ratingStr = ratingElement.select("[itemprop=\"ratingValue\"]").html();
        double rating = 0.0;
        try {
            rating = Double.parseDouble(Jsoup.parse(ratingStr).text()); //remove html character code
        } catch (NumberFormatException e) {
            System.err.println("Invalid rating format");
        }
        return rating;
    }

    @Override
    public String parseStatus(Element statusElement) {
        String statusStr = statusElement.select("a").html();
        return Jsoup.parse(statusStr).text(); //remove html character code
    }

    @Override
    public String parseThumbnailURL(Element thumbnailElement) {
        return thumbnailElement.attr("src");
    }

    @Override
    public List<String> parseChapterImage(String html) {
//        final String query = "div[id^='image_']";
        final String query = "img.lazy";
        Document doc = null;
        ArrayList<String> imageList = new ArrayList<>();
        doc = Jsoup.parse(html);

        if (doc == null)
            return imageList;
        Elements imageElementList = doc.select(query);
        for(Element imageElement : imageElementList) {
            imageList.add(imageElement.attr("src"));
        }
        return imageList;
    }
}
