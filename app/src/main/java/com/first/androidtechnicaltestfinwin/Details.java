package com.first.androidtechnicaltestfinwin;

public class Details {
    private String title,turl,thumburl;
    private Integer id;

    public Details(Integer id,String title, String turl, String thumburl) {
        this.title = title;
        this.turl = turl;
        this.thumburl = thumburl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
