package org.lld.easy.vendingmachine;

import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private ConcurrentHashMap<Product, Integer> inventory;

    public Inventory() {
        this.inventory = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        inventory.put(product, quantity);
    }


    public void removeProduct(Product product, int quantity) throws Exception {
        if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
            inventory.put(product, inventory.get(product) - quantity);
        } else {
            throw new Exception("Product out of stock");

        }
    }

    public int getQuantity(Product product) {
        return inventory.getOrDefault(product, 0);
    }

    public boolean isProductAvailable(Product product) {
        return inventory.containsKey(product);
    }

}
