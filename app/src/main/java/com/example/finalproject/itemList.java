package com.example.finalproject;

public class itemList {
    private String groceryNames;
    private double groceryPrice;

    public itemList(String groceryNames, double groceryPrice){
        this.groceryNames = groceryNames;
        this.groceryPrice = groceryPrice;
    }

    public itemList() {

    }

    public String getGroceryNames() {
        return groceryNames;
    }

    public double getGroceryPrice() {
        return groceryPrice;
    }

    public void setGroceryNames(String groceryNames){
        this.groceryNames = groceryNames;
    }

    public void setGroceryPrice(double groceryPrice) {
        this.groceryPrice = groceryPrice;
    }
}
