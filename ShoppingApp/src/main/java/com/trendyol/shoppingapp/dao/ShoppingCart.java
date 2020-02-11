/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.dao;

import com.trendyol.shoppingapp.enums.DiscountType;
import com.trendyol.shoppingapp.utils.DeliveryCostCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author LuffythePhoenix
 */
public final class ShoppingCart {
    
    private Map<Product, Integer> items;
    private double price;
    private double cmpDiscount;
    private double cpnDiscount;
    
    public ShoppingCart() {
        price = 0;
        cmpDiscount = 0;
        cpnDiscount = 0;
        items = new HashMap<>();
    }
    
    public Map<Product, Integer> getItems() {
        return items;
    }
    
    public void addItem(Product p, Integer count) {
        price += p.getPrice() * count;
        if (items.get(p) == null) {
            items.put(p, count);
        } else {
            count += items.get(p);
            items.replace(p, count);
        }
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getCmpDiscount() {
        return cmpDiscount;
    }
    
    public void setCmpDiscount(double cmpDiscount) {
        this.cmpDiscount = cmpDiscount;
    }
    
    public double getCpnDiscount() {
        return cpnDiscount;
    }
    
    public void setCpnDiscount(double cpnDiscount) {
        this.cpnDiscount = cpnDiscount;
    }
    
    public void applyDiscounts(List<Double> cList) {
        for (Double d : cList) {
            if (d > cmpDiscount) {
                cmpDiscount = d;
            }
        }
    }
    
    public void applyCoupon(Coupon coupon) {
        if (price - cmpDiscount >= coupon.getMinprice()) {
            if (coupon.getDiscountType() == DiscountType.Amount) {
                cpnDiscount = coupon.getDiscount();
            } else {
                cpnDiscount = price * coupon.getDiscount() / 100;
            }
        }
    }
    
    public double getCampaignDiscount(Campaign campaign) {
        int count = 0;
        for (Product product : items.keySet()) {
            if (product.getCategory() == campaign.getCategory()) {
                count++;
            }
        }
        if (count < campaign.getMinItem()) {
            return 0;
        } else {
            if (campaign.getDiscountType() == DiscountType.Amount) {
                return campaign.getDiscount();
            } else {
                return price * campaign.getDiscount() / 100;
            }
        }
    }
    
    public double getCouponDiscount(Coupon coupon) {
        if (price - cmpDiscount >= coupon.getMinprice()) {
            if (coupon.getDiscountType() == DiscountType.Amount) {
                return coupon.getDiscount();
            } else {
                return price * coupon.getDiscount() / 100;
            }
        }
        return 0;
    }
    
    public double getDeliveryCost() {
        DeliveryCostCalculator dcc = new DeliveryCostCalculator();
        return dcc.calculateFor(this);
    }
    
    public double getTotalAmountsAfterDiscounts() {
        return price - cmpDiscount - cpnDiscount;
    }
    
    public void print() {
        List<Product> products = items.keySet().stream().sorted(Comparator.comparing(Product::getCategory)).collect(Collectors.toList());
        for (Product p : products) {
            System.out.println(p.getCategory().getTitle() + "\t" + p.getTitle() + "\t" + items.get(p) + "\t" + p.getPrice());
        }
        System.out.println(getPrice() + "\t" + getTotalAmountsAfterDiscounts());
    }
}
