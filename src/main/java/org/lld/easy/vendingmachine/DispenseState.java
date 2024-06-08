package org.lld.easy.vendingmachine;

public class DispenseState implements VendingmachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Please wait, dispensing product.");
    }

    @Override
    public void insertNote(VendingMachine vendingMachine, Note note) {
        System.out.println("Please wait, dispensing product.");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product) {
        System.out.println("Product already selected.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        try {
            vendingMachine.getInventory().removeProduct(vendingMachine.getSelectedProduct(),1);
            System.out.println("Dispensing product:"+ vendingMachine.getSelectedProduct().getName());
            vendingMachine.returnChange();
            vendingMachine.setState(new IdleState());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            vendingMachine.returnChange();
            vendingMachine.setState(new IdleState());
        }
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("Please wait, dispensing product.");

    }
}