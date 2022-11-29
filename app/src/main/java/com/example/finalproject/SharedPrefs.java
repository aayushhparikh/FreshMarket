package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    private  static SharedPreferences shoppingCart;
    public static final String prefName = "shopping_cart";
    public static final String itemKey = "item";

    private SharedPrefs() {}

    public static void init(Context context){
        if(shoppingCart == null){
            shoppingCart = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }
    }

    public static String getString(String key, String val) {
        return shoppingCart.getString(key, val);
    }

    public static void putString(String key, String val) {
        SharedPreferences.Editor shoppingCartEdit = shoppingCart.edit();
        shoppingCartEdit.putString(key, val);
        shoppingCartEdit.commit();
    }

    public static Integer getInteger(String key, int val) {
        return shoppingCart.getInt(key, val);
    }

    public static void putInteger(String key, Integer val){
        SharedPreferences.Editor shoppingCartEdit = shoppingCart.edit();
        shoppingCartEdit.putInt(key, val);
        shoppingCartEdit.commit();
    }

    public static void clearPref(Context context){
        shoppingCart.edit().clear().commit();
    }
}
