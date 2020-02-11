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
public final class Category implements Comparable<Category> {

    private String title;
    private Category parentCategory;

    public Category() {
        parentCategory = null;
        title = new String();
    }

    public Category(String title) {
        parentCategory = null;
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public int compareTo(Category otherC) {
        return this.getTitle().compareTo(otherC.getTitle());
    }
}
