package org.lld.easy.vendingmachine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Adding products to inventory

        Product chips = new Product("Lays", 5);
        Product colDrink = new Product("7Up", 10);
        Product icecream = new Product("Amul Icecream", 1);

        vendingMachine.getInventory().addProduct(chips, 1);
        vendingMachine.getInventory().addProduct(colDrink, 4);
        vendingMachine.getInventory().addProduct(icecream, 6);


        // Start a transaction
//        vendingMachine.insertNote(Note.FIVE);
        vendingMachine.insertCoin(Coin.NICKEL);


        //selecting product
        vendingMachine.selectProduct(chips);

        vendingMachine.dispenseProduct();


    }
}
