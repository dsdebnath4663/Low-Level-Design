package org.lld.easy.parkinglot;

public class Car extends Vechile{
    public Car(String licensePlate, VehicleType vehicleType) {
        super(licensePlate, vehicleType);
    }

    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
