package com.cr.customlistview;

/**
 * Created by yadu on 9/12/16.
 */

public class SampleModel {
    private String name, description, date;
    private  String img_url;


    public SampleModel(String name, String description, String date, String img_url) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.img_url = img_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
