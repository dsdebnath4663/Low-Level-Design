package org.lld.easy.vendingmachine;

public class VendingMachine {

    private static VendingMachine vendingMachineInstance;
    private Inventory inventory;
    private Product selectedProduct;


    private double totalPayment;
    private VendingmachineState state;

    VendingMachine() {
        inventory = new Inventory();
        state = new IdleState();
    }

    public synchronized static VendingMachine getInstance() {
        if (vendingMachineInstance == null) {
            vendingMachineInstance = new VendingMachine();
        }
        return vendingMachineInstance;
    }

    public void setState(VendingmachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void addPayment(double amount) {
        totalPayment += amount;
    }

    public void returnChange() {
        if (selectedProduct != null && totalPayment > selectedProduct.getPrice()) {
            double change = totalPayment - selectedProduct.getPrice();
            System.out.println("Returning change: $ " + change);

        }
        totalPayment = 0;
    }

    public void insertCoin(Coin coin) {
        state.insertCoin(this, coin);
    }

    public void insertNote(Note note) {
        state.insertNote(this, note);
    }

    public void selectProduct(Product product) {
        state.selectProduct(this, product);
    }

    public void dispenseProduct() {
//        state.dispenseProduct(this);
        // Checking if the selected product is affordable before dispensing
        if (selectedProduct != null && totalPayment >= selectedProduct.getPrice()) {
            state.dispenseProduct(this);
        } else {
            System.out.println("Insufficient funds. Please insert more coins or notes.");
        }
    }

    public double getTotalPayment() {
        return totalPayment;
    }
}
