package core;

import java.util.ArrayList;
import java.util.List;

public class Manga {
    private String name;
    private String url;
    private double rating;
    private String status;
    private String mangaThumbnail;
    private List<String> authors;
    private List<String> tags;
    private List<Chapter> chapters;

    public Manga() {
        this("", "");
    }

    public Manga(String name, String url) {
        this.name = name;
        this.url = url;
        authors = new ArrayList<>();
        tags = new ArrayList<>();
        rating = 0;
        status = "Empty";
        mangaThumbnail = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
