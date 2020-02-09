/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.dao;

import java.util.HashMap;

/**
 *
 * @author LuffythePhoenix
 */
public class ShoppingCart {

    private HashMap<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public HashMap<Product, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Product, Integer> items) {
        this.items = items;
    }

    public void addItem(Product p, Integer count) {
        if (items.get(p) == null) {
            items.put(p, count);
        } else {
            count += items.get(p);
            items.replace(p, count);
        }
    }

}
