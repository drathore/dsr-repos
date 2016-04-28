package com.app;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartCheckout {

    public String checkout(List<String> listOfItems) {
        BigDecimal sum = new BigDecimal("0.00");

        for (String item : listOfItems) {
            if (item.equals("Apple")){
                sum =  sum.add(new BigDecimal("0.60"));
            } else {
                sum = sum.add(new BigDecimal("0.25"));
            }
        }


        return "£"+sum.toString();
    }
}
