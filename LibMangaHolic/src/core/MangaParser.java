package core;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public interface MangaParser {
    ArrayList<String> parseAuthor(Element authorElement);
    ArrayList<String> parseTag(Element tagElement);
    ArrayList<Chapter> parseChapter(Element chapterElement);
    double parseRating(Element ratingElement);
    String parseStatus(Element statusElement);
    String parseThumbnailURL(Element thumbnailElement);
    ArrayList<String> parseChapterImage(String url);
}
