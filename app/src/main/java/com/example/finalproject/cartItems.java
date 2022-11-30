package com.example.finalproject;

public class cartItems {
    int id2;
    private String groceryNames2;
    private Double groceryPrice2;
    private Double groceryQuantity;

    public cartItems(String groceryNames2, double groceryPrice2, double groceryQuantity){
        this.groceryNames2 = groceryNames2;
        this.groceryPrice2 = groceryPrice2;
        this.groceryQuantity = groceryQuantity;
    }

    public cartItems(){

    }

    public String getGroceryNames2() {
        return groceryNames2;
    }

    public Double getGroceryPrice2(){
        return groceryPrice2;
    }

    public Double getGroceryQuantity() {
        return groceryQuantity;
    }

    public void setGroceryNames2(String groceryNames2) {
        this.groceryNames2 = groceryNames2;
    }

    public void setGroceryPrice2(Double groceryPrice2) {
        this.groceryPrice2 = groceryPrice2;
    }

    public void setGroceryQuantity(Double groceryQuantity) {
        this.groceryQuantity = groceryQuantity;
    }
}
