package com.trendyol.shoppingapp;

import com.trendyol.shoppingapp.dao.Campaign;
import com.trendyol.shoppingapp.dao.Category;
import com.trendyol.shoppingapp.dao.Coupon;
import com.trendyol.shoppingapp.dao.Product;
import com.trendyol.shoppingapp.dao.ShoppingCart;
import com.trendyol.shoppingapp.enums.DiscountType;
import com.trendyol.shoppingapp.utils.DeliveryCostCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingAppApplicationTests {

    @Test
    public void categoryTests() {
        Category tester = new Category();
        Category tester2 = new Category("food");
        Assertions.assertEquals(-4, tester.compareTo(tester2), "food comes 4 laterfrom new string!");
        Category tester3 = new Category("shoes");
        Assertions.assertEquals(-13, tester2.compareTo(tester3), "food comes before shoes!");
    }

    @Test
    public void shoppingCartandDCCTests() {
        ShoppingCart tester1 = new ShoppingCart();
        DeliveryCostCalculator dcc = new DeliveryCostCalculator();

        Category food = new Category("food");
        Category technology = new Category("technology");

        Coupon coupon = new Coupon(130, 10, DiscountType.Amount);
        Product apple = new Product("apple", 5, food);
        Product pear = new Product("pear", 10, food);
        Product grapes = new Product("grapes", 10, food);
        Campaign foodCamp = new Campaign(food, 10, 3, DiscountType.Amount);

        Product tv = new Product("tv", 70, technology);
        Product notebook = new Product("notebook", 100, technology);
        Campaign techCamp = new Campaign(technology, 10, 2, DiscountType.Rate);
        List<Double> discounts = new ArrayList<>();

        tester1.addItem(apple, 10);
        Assertions.assertEquals(50, tester1.getPrice(), "50 smurf berries(sb)");
        tester1.addItem(pear, 2);
        Assertions.assertEquals(70, tester1.getPrice(), "70 smurf berries(sb)");
        tester1.addItem(pear, 3);
        Assertions.assertEquals(100, tester1.getPrice(), "100 smurf berries(sb)");
        Assertions.assertEquals(0, tester1.getCampaignDiscount(foodCamp), "foodCamp is applicable for at least 3 different foods!");
        tester1.addItem(grapes, 3);
        Assertions.assertEquals(10, tester1.getCampaignDiscount(foodCamp), "congrats! You got 10 sb discount!");
        discounts.add(tester1.getCampaignDiscount(foodCamp));
        tester1.applyDiscounts(discounts);
        Assertions.assertEquals(10, tester1.getCmpDiscount(), "congrats! You got 10 sb discount!");
        tester1.applyCoupon(coupon);
        Assertions.assertEquals(0, tester1.getCouponDiscount(coupon), "10sb discount makes total price 120sb, thus no coupon discount!");
        tester1.addItem(tv, 1);
        tester1.addItem(notebook, 1);
        discounts.add(tester1.getCampaignDiscount(techCamp));
        tester1.applyDiscounts(discounts);
        Assertions.assertEquals(30, tester1.getCmpDiscount(), "congrats! You got 30 sb discount!");
        tester1.applyCoupon(coupon);
        Assertions.assertEquals(260, tester1.getTotalAmountsAfterDiscounts(), "Your cart worths 260sb!");
        Assertions.assertEquals((double) 17.99, Double.parseDouble(String.format(Locale.ENGLISH, "%.2f", tester1.getDeliveryCost())), "Your delivery worths 17.99sb!");
    }
}
