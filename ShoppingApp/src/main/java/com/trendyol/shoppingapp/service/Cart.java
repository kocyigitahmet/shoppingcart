/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.service;

import com.trendyol.shoppingapp.dao.Campaign;
import com.trendyol.shoppingapp.dao.Category;
import com.trendyol.shoppingapp.dao.Coupon;
import com.trendyol.shoppingapp.dao.Product;
import com.trendyol.shoppingapp.dao.ShoppingCart;
import com.trendyol.shoppingapp.enums.DiscountType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuffythePhoenix
 */
public class Cart {

    public double calcDeliveryCost(ShoppingCart cart) {

        Category food = new Category("food");
        Product apple = new Product("Apple", 100.0, food);
        Product almond = new Product("Almond", 150.0, food);
        Campaign c1 = new Campaign(food, 2.5, 4, DiscountType.Amount);
        List<Double> discounts = new ArrayList();
        Coupon cup1 = new Coupon(100, 10, DiscountType.Rate);
        cart.addItem(apple, 5);
        cart.addItem(almond, 3);
        double price = cart.getTotalAmountsAfterDiscounts();
        double cDisc = cart.getCouponDiscount(c1);
        double cmDisc = cart.getCampaignDiscount();
        double dCost = cart.getDeliveryCost();
        return apple.getPrice() * cart.getItems().get(apple) - c1.getDiscount();
    }
}
