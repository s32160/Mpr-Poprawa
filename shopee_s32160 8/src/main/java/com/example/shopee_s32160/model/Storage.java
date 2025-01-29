package com.example.shopee_s32160.model;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Double> products = new HashMap<>();

    static {
        products.put("mleko", 2.5);
        products.put("piwo", 5.0);
        products.put("chleb", 3.0);
    }

    public static Double getPrice(String item) {
        return products.getOrDefault(item, null);
    }
}
