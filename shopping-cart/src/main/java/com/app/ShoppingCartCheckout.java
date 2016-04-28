package com.app;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartCheckout implements Checkout {

    private static final BigDecimal APPLE_PRICE = new BigDecimal("0.60");
    private static final BigDecimal ORANGE_PRICE = new BigDecimal("0.25");
    private static final String CURRENCY_SYMBOL = "£";

    enum Item{
        APPLE("Apple", APPLE_PRICE),
        ORANGE("Orange", ORANGE_PRICE);

        private final String name;
        private final BigDecimal price;

        Item(String name, BigDecimal price){
            this.name = name;
            this.price = price;
        }
    }

    public String checkout(List<String> listOfItems) {
        return CURRENCY_SYMBOL + listOfItems.stream().map(i -> {
            if(i.equals(Item.APPLE.name)){
                return Item.APPLE.price;
            }
            return Item.ORANGE.price;
        }).reduce(BigDecimal::add).get().toString();
    }
}
