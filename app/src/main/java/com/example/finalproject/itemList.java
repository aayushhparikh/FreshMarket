package com.example.finalproject;

public class itemList {
    int id;
    private String groceryNames;
    private double groceryPrice;

    public itemList(String groceryNames, double groceryPrice){
        this.groceryNames = groceryNames;
        this.groceryPrice = groceryPrice;
    }

    public itemList(int id, String groceryNames, double groceryPrice){
        this.id = id;
        this.groceryNames = groceryNames;
        this.groceryPrice = groceryPrice;
    }

    public itemList(){

    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
