/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.dao;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author LuffythePhoenix
 */
public class ShoppingCart {

    private HashMap<Product, Integer> items;
    private double discount;

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

    public void applyDiscounts(List<Double> cList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getCampaignDiscount(Campaign campaign) {
        return 0;
    }

    public double getCouponDiscount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getDeliveryCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getTotalAmountsAfterDiscounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
