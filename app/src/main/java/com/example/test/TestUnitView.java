package com.example.test;

public class TestUnitView {
    private String title;
    private String lastMessage;
    private int imageId;

    public TestUnitView(String title, String lastMessage, int imageId) {
        this.title = title;
        this.lastMessage = lastMessage;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
