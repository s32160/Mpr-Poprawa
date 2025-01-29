package com.example.shopee_s32160.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private double clientBalance = 20.0;
    private String cartItem = null;

    @GetMapping("/")
    @ResponseBody
    public String welcomePage() {
        return "🎉 Witamy w sklepie! Użyj /shop/add?item=mleko aby dodać produkt.";
    }

    @GetMapping("/status")
    @ResponseBody
    public String checkBalance() {
        return "💰 Twoje saldo: " + clientBalance;
    }

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@RequestParam String item) {
        cartItem = item;
        return "🛒 Dodano do koszyka: " + item;
    }

    @PostMapping("/checkout")
    @ResponseBody
    public String checkout() {
        if (cartItem == null) {
            return "🛍️ Koszyk jest pusty!";
        }
        double price = 2.5; // np. mleko kosztuje 2.5
        if (clientBalance >= price) {
            clientBalance -= price;
            cartItem = null;
            return " ZAKUP UDANY! Nowe saldo: " + clientBalance;
        }
        return " BRAK ŚRODKÓW! Doładuj konto.";
    }
}
