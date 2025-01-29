package com.example.shopee_s32160.service;

import com.example.shopee_s32160.model.Cart;
import com.example.shopee_s32160.model.Client;
import com.example.shopee_s32160.model.Storage;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    public String finalizePurchase(Client client, Cart cart) {
        double totalCost = 0;
        for (String item : cart.getItems()) {
            Double price = Storage.getPrice(item);
            if (price != null) {
                totalCost += price;
            }
        }

        if (client.canAfford(totalCost)) {
            client.deductBalance(totalCost);
            return "✅ ZAKUP UDANY: Nowe saldo = " + client.getBalance();
        }
        return "❌ ZAKUP ODRZUCONY: Brak środków!";
    }
}
