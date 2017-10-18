package core;

public class Chapter {
    private String chapterName;
    private String chapterURL;

    public Chapter(String chapterName, String chapterURL) {
        this.chapterName = chapterName;
        this.chapterURL = chapterURL;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterURL() {
        return chapterURL;
    }

    public void setChapterURL(String chapterURL) {
        this.chapterURL = chapterURL;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterName='" + chapterName + '\'' +
                ", chapterURL='" + chapterURL + '\'' +
                '}';
    }
}
