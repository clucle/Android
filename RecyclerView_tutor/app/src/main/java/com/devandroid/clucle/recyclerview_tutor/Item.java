package com.devandroid.clucle.recyclerview_tutor;

public class Item {
    private int image;
    private String imageTitle;

    public int getImage(){
        return image;
    }

    public String getImagetitle() {
        return imageTitle;
    }

    public Item(int image, String imagetitle)
    {
        this.image = image;
        this.imageTitle = imagetitle;
    }
}
