package service;

import model.Food;

public class ShoppingCart {
    private final Food[] items;

    public ShoppingCart(Food[] items) {
        this.items = items;
    }

    public double getTotalPriceWithoutDiscount() {
        double sum = 0;
        for (Food item : items) {
            sum = sum + item.getAmount() * item.getPrice();
        }
        return sum;
    }

    public double getTotalPriceWithDiscount() {
        double sum = 0;
        for (Food item : items) {
            double discount = item.getDiscount();
            double priceWithDiscount = item.getPrice() * (1 - discount / 100);
            sum = sum + item.getAmount() * priceWithDiscount;
        }
        return sum;
    }

    public double getVegetarianFoodPriceWithoutDiscount() {
        double sum = 0;
        for (Food item : items) {
            if (item.isVegetarian()) {
                sum = sum + item.getAmount() * item.getPrice();
            }
        }
        return sum;
    }
}