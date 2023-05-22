package com.example.proiectandroid;

public class Item {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public Item(String mImageUrl, String mCreator, int mLikes) {
        this.mImageUrl = mImageUrl;
        this.mCreator = mCreator;
        this.mLikes = mLikes;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public int getLikes() {
        return mLikes;
    }
}
