package org.lld.easy.vendingmachine;

    public class ReadyState implements VendingmachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addPayment(coin.getValue());

    }

    @Override
    public void insertNote(VendingMachine vendingMachine, Note note) {
        vendingMachine.addPayment(note.getValue());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product) {
        if (vendingMachine.getInventory().isProductAvailable(product)){
//            vendingMachine.setSelectedProduct(product);
//            vendingMachine.setState(new DispenseState());
            if (vendingMachine.getTotalPayment() >= product.getPrice()) {
                vendingMachine.setSelectedProduct(product);
                vendingMachine.setState(new DispenseState());
            } else {
                System.out.println("Insufficient funds. Please insert more coins or notes.");
            }
        }else {
            System.out.println("Out of Stock");
        }
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        vendingMachine.dispenseProduct();
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
            vendingMachine.returnChange();
            vendingMachine.setState(new IdleState());
    }
}