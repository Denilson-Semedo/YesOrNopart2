package com.example.yesorno;

public class DashboardItem {
    private int imageResourceId;
    private String title;

    public DashboardItem(int imageResourceId, String imageText) {
        this.imageResourceId = imageResourceId;
        this.title = imageText;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
