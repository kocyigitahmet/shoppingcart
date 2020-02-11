/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.dao;

/**
 *
 * @author LuffythePhoenix
 */
public final class Product {

    private String title;
    private double price;
    private Category category;

    public Product() {
        title = new String();
        price = 0;
        category = new Category();
    }

    public Product(String title, double price, Category category) {
        setTitle(title);
        setPrice(price);
        setCategory(category);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
