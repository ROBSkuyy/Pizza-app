package com.example.pizzaorderapp;
public class Pizza {
    private String name;
    private String details;
    private String rating;
    private String deliveryFee;
    private String deliveryTime;
    private int imageResId;

    public Pizza(String name, String details, String rating, String deliveryFee, String deliveryTime, int imageResId) {
        this.name = name;
        this.details = details;
        this.rating = rating;
        this.deliveryFee = deliveryFee;
        this.deliveryTime = deliveryTime;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() { return name; }
    public String getDetails() { return details; }
    public String getRating() { return rating; }
    public String getDeliveryFee() { return deliveryFee; }
    public String getDeliveryTime() { return deliveryTime; }
    public int getImageResId() { return imageResId; }
}
