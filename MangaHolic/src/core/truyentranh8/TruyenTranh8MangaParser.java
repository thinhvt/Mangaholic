package core.truyentranh8;

import core.Chapter;
import core.MangaParser;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class TruyenTranh8MangaParser implements MangaParser {
    @Override
    public ArrayList<String> parseAuthor(Element authorElement) {
        ArrayList<String> authorList = new ArrayList<>();
        Elements rawAuthorList = authorElement.getElementsByTag("span");
        for(Element author : rawAuthorList) {
            authorList.add(author.html());
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

    @Override
    public ArrayList<Chapter> parseChapter(Element chapterElement) {
        Elements rawChapterList = chapterElement.select("a");
        ArrayList<Chapter> chapterList = new ArrayList<>();
        for(Element chapterInfo : rawChapterList) {
            String chapterUrl = chapterInfo.attr("href");
            String chapterName = chapterInfo.select("strong").html().trim();
            chapterList.add(new Chapter(chapterName, chapterUrl));
        }
        return chapterList;
    }

    @Override
    public double parseRating(Element ratingElement) {
        String ratingStr = ratingElement.select("[itemprop=\"ratingValue\"]").html();
        double rating = 0.0;
        try {
            rating = Double.parseDouble(ratingStr);
        } catch (NumberFormatException e) {
            System.err.println("Invalid rating format");
        }
        return rating;
    }

    @Override
    public String parseStatus(Element statusElement) {
        String statusStr = statusElement.select("a").html();
//        System.out.println(statusStr);
        return statusStr;
    }

    @Override
    public String parseThumbnailURL(Element thumbnailElement) {
        return null;
    }
}
