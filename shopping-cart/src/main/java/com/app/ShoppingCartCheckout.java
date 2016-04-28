package com.app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String, List<String>> groupedByName = listOfItems.stream().collect(Collectors.groupingBy(i -> i));
        BigDecimal totalApplePrice = BigDecimal.ZERO;
        BigDecimal offer = BigDecimal.ONE;
        List<String> apples = groupedByName.get(Item.APPLE.name);
        if(apples != null){
            BigDecimal totalNumberOfApples = new BigDecimal(apples.size()+"");
            BigDecimal[] bigDecimals = totalNumberOfApples.divideAndRemainder(new BigDecimal(2));
            if(bigDecimals[1] == BigDecimal.ZERO){
                offer = new BigDecimal("0.5");
            }
            totalApplePrice = totalNumberOfApples.multiply(Item.APPLE.price).multiply(offer).setScale(2);
        }

        List<String> oranges = groupedByName.get(Item.ORANGE.name);
        BigDecimal totalOrangePrice = BigDecimal.ZERO;
        if(oranges != null){
            totalOrangePrice = ORANGE_PRICE.multiply(new BigDecimal(oranges.size()));
        }


        return CURRENCY_SYMBOL +totalOrangePrice.add(totalApplePrice).toString();

    }
}
