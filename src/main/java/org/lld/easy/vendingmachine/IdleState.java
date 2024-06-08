package org.lld.easy.vendingmachine;

//public class IdleState implements VendingmachineState {
//
//    @Override
//    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
//        vendingMachine.addPayment(coin.getValue());
//        vendingMachine.setState(new ReadyState());
//    }
//
//    @Override
//    public void insertNote(VendingMachine vendingMachine, Note note) {
//        vendingMachine.addPayment(note.getValue());
//        vendingMachine.setState(new ReadyState());
//    }
//
//    @Override
//    public void selectProduct(VendingMachine vendingMachine, Product product) {
//        System.out.println("Please insert payment first.");
//    }
//
//    @Override
//    public void dispenseProduct(VendingMachine vendingMachine) {
//        System.out.println("Please insert payment first.");
//
//    }
//
//    @Override
//    public void returnChange(VendingMachine vendingMachine) {
//        System.out.println("No payment made.");
//    }
//
//
//}
class IdleState implements VendingmachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addPayment(coin.getValue());
        vendingMachine.setState(new ReadyState());
    }

    @Override
    public void insertNote(VendingMachine vendingMachine, Note note) {
        vendingMachine.addPayment(note.getValue());
        vendingMachine.setState(new ReadyState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, Product product) {
        System.out.println("Please insert payment first.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Please insert payment first.");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("No payment made.");
    }
}