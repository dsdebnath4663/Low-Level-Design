package org.lld.easy.parkinglot;

public class ParkingSpot {

    private boolean available;
    private Vechile vechile;//ParkingSpot has-a Vechile
    private final VehicleType vehicleType;//ParkingSpot has-a VehicleType


    public ParkingSpot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public boolean isAvailable(){
        return available;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public void parkVechile(Vechile vechile){
        //TODO
    }

    public void removeVechile(){

    }


}
