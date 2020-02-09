/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.utils;

import com.trendyol.shoppingapp.dao.Category;
import com.trendyol.shoppingapp.dao.Product;
import com.trendyol.shoppingapp.dao.ShoppingCart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuffythePhoenix
 */
public final class DeliveryCostCalculator {

    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost;

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct,
            double fixedCost) {

        setFixedCost(fixedCost);
        setCostPerDelivery(costPerDelivery);
        setCostPerProduct(costPerProduct);

    }

    public double getCostPerDelivery() {
        return costPerDelivery;
    }

    public void setCostPerDelivery(double costPerDelivery) {
        this.costPerDelivery = costPerDelivery;
    }

    public double getCostPerProduct() {
        return costPerProduct;
    }

    public void setCostPerProduct(double costPerProduct) {
        this.costPerProduct = costPerProduct;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(double fixedCost) {
        this.fixedCost = fixedCost;
    }

    public double calculateFor(ShoppingCart cart) {
        List<Category> deliveries = new ArrayList<>();
        for (Product product : cart.getItems().keySet()) {
            if (!deliveries.contains(product.getCategory())) {
                deliveries.add(product.getCategory());
            }
        }
        int numofDeliveries = deliveries.size();
        int numofProducts = cart.getItems().size();
        return (getCostPerDelivery() * numofDeliveries) + (getCostPerProduct() * numofProducts) + getFixedCost();
    }

}
