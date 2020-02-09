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
public final class Coupon {

    String id;
    double minprice;
    double discount;
    DiscountType discountType;

    public Coupon() {
        setId(UUID.randomUUID().toString());
    }

    public Coupon(double minprice, double discount, DiscountType discountType) {
        setId(UUID.randomUUID().toString());
        setDiscount(discount);
        setMinprice(minprice);
        setDiscountType(discountType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMinprice() {
        return minprice;
    }

    public void setMinprice(double minprice) {
        this.minprice = minprice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
