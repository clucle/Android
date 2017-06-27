package com.devandroid.clucle.recyclerview_tutor.view.item;

public class Item {
    private int imageSrc;
    private String imageTitle;

    public int getImage(){
        return imageSrc;
    }
    public String getImageTitle() {
        return imageTitle;
    }

    public Item(int imageSrc, String imageTitle)
    {
        this.imageSrc = imageSrc;
        this.imageTitle = imageTitle;
    }
}
