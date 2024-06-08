package org.lld.easy.vendingmachine;

public interface VendingmachineState {

    void insertCoin (VendingMachine vendingMachine, Coin coin);
    void insertNote (VendingMachine vendingMachine, Note note);
    void selectProduct (VendingMachine vendingMachine, Product product);
    void dispenseProduct (VendingMachine vendingMachine);
    void returnChange (VendingMachine vendingMachine);
}
