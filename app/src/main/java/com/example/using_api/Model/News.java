package com.example.using_api.Model;

public class News {
    private String title,description,link, publish_date;

    public News(String title, String description, String link, String publish_date) {
        this.title = title;
        this.description = description;
//        this.link = link;
        this.publish_date = publish_date;
    }

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getLink() {
//        return link;
//    }

//    public void setLink(String link) {
//        this.link = link;
//    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }
}
