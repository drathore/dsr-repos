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

}
