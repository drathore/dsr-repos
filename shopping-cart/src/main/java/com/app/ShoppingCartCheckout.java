package com.app;

import java.util.List;

public class ShoppingCartCheckout {
    public String checkout(List<String> listOfItems) {

        String item = listOfItems.stream().findFirst().get();
        if (item.equals("Apple"))
            return "£0.60";

        return "£0.25";
    }
}
