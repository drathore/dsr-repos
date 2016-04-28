package com.app;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartCheckout {

    private static final BigDecimal APPLE_PRICE = new BigDecimal("0.60");
    private static final BigDecimal ORANGE_PRICE = new BigDecimal("0.25");
    private static final String CURRENCY_SYMBOL = "£";

    public String checkout(List<String> listOfItems) {
        BigDecimal sum = BigDecimal.ZERO;

        for (String item : listOfItems) {
            if (item.equals("Apple")){
                sum =  sum.add(APPLE_PRICE);
            } else {
                sum = sum.add(ORANGE_PRICE);
            }
        }


        return CURRENCY_SYMBOL +sum.toString();
    }
}
