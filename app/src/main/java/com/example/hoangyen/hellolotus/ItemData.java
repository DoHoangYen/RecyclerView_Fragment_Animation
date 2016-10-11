package com.example.hoangyen.hellolotus;

public class ItemData {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    private int imageUrl;

    public ItemData(String title,String Price, int imageUrl){

        this.name = title;
        this.price = Price;
        this.imageUrl = imageUrl;
    }
    // getters & setters
}
