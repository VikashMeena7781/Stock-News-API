package com.example.using_api.Model;

public class MainNews {
    private String title;
    private String link;
    private String pubDate;
    private String source;
    private String guid;

    public MainNews(){}
    public MainNews(String title, String link, String pubDate,String source , String guid){
        this.title=title;
        this.link=link;
        this.pubDate=pubDate;
        this.source=source;
        this.guid=guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
