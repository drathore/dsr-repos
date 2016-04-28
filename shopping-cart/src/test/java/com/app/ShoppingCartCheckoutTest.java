package com.app;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ShoppingCartCheckoutTest {

    private ShoppingCartCheckout shoppingCartCheckout;

    @Before
    public void setup(){
        shoppingCartCheckout = new ShoppingCartCheckout();
    }

    @Test
    public void whenCheckoutSentAListContainingAnAppleItsPriceReturnedAsTotalPrice(){

        List<String> listOfItems = Arrays.asList("Apple");
        String totalPriceString = shoppingCartCheckout.checkout(listOfItems);

        assertThat("Should have returned the price of an apple", totalPriceString, is("£0.60"));
    }


    @Test
    public void whenCheckoutSentAListContainingAnOrangeItsPriceReturnedAsTotalPrice(){

        List<String> listOfItems = Arrays.asList("Orange");
        String totalPriceString = shoppingCartCheckout.checkout(listOfItems);

        assertThat("Should have returned the price of an orange", totalPriceString, is("£0.25"));
    }

    @Test
    public void whenCheckoutSentAListContainingAnAppleAndOrangeSumOfTheirPriceReturnedAsTotalPrice(){

        List<String> listOfItems = Arrays.asList("Apple","Orange");
        String totalPriceString = shoppingCartCheckout.checkout(listOfItems);

        assertThat("Should have returned the total price of apple and orange", totalPriceString, is("£0.85"));
    }

    @Test
    public void whenCheckoutSentAListContainingMultipleApplesAndOrangesSumOfTheirPriceReturnedAsTotalPrice(){

        List<String> listOfItems = Arrays.asList("Apple","Orange","Apple","Apple","Orange", "Apple");
        String totalPriceString = shoppingCartCheckout.checkout(listOfItems);

        assertThat("Should have returned the total price of 2 apples(Buy 1 get 1 free) and 2 oranges", totalPriceString, is("£1.70"));
    }
}
