package com.example.shopee_s32160.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
