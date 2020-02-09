/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendyol.shoppingapp.dao;

import com.trendyol.shoppingapp.dao.Campaign;
import com.trendyol.shoppingapp.dao.Category;
import com.trendyol.shoppingapp.enums.DiscountType;

/**
 *
 * @author LuffythePhoenix
 */
public class Discounts {

    Category cat1 = new Category();
    Campaign cmp1 = new Campaign(cat1, 20.0, 3, DiscountType.Rate);
}
