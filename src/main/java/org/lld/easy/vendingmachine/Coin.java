package org.lld.easy.vendingmachine;

public enum Coin {
    PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25);

    private final double value;

    Coin(double v) {
        this.value = v;
    }
    public double getValue(){
        return value;
    }
}
