/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.dao;

import com.trendyol.shoppingapp.enums.DiscountType;
import java.util.UUID;

/**
 *
 * @author LuffythePhoenix
 */
public final class Campaign {

    private String id;
    private Category category;
    private double discount;
    private int minItem;
    private DiscountType discountType;

    public Campaign() {
        setId(UUID.randomUUID().toString());
    }

    public Campaign(Category category, double discount, int minItem, DiscountType discountType) {
        setId(UUID.randomUUID().toString());
        setCategory(category);
        setDiscount(discount);
        setMinItem(minItem);
        setDiscountType(discountType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getMinItem() {
        return minItem;
    }

    public void setMinItem(int minItem) {
        this.minItem = minItem;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
