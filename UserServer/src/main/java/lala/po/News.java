package lala.po;

public class News {
    private Integer newsId;
    private String newsImage;
    private String newsTitle;
    private String newsDescribe;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescribe() {
        return newsDescribe;
    }

    public void setNewsDescribe(String newsDescribe) {
        this.newsDescribe = newsDescribe;
    }
}
