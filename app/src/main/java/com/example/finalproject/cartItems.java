package com.example.finalproject;

public class cartItems {
    int id2;
    private String groceryNames2;
    private Double groceryPrice2;
    private Double groceryQuantitynumber;

    public cartItems(String groceryNames2, double groceryPrice2, double groceryQuantitynumber){
        this.groceryNames2 = groceryNames2;
        this.groceryPrice2 = groceryPrice2;
        this.groceryQuantitynumber = groceryQuantitynumber;
    }

    public cartItems(){

    }

    public String getGroceryNames2() {
        return groceryNames2;
    }

    public Double getGroceryPrice2(){
        return groceryPrice2;
    }

    public Double getGroceryQuantitynumber() {
        return groceryQuantitynumber;
    }

    public void setGroceryNames2(String groceryNames2) {
        this.groceryNames2 = groceryNames2;
    }

    public void setGroceryPrice2(Double groceryPrice2) {
        this.groceryPrice2 = groceryPrice2;
    }

    public void setGroceryQuantity(Double groceryQuantitynumber) {
        this.groceryQuantitynumber = groceryQuantitynumber;
    }
}
