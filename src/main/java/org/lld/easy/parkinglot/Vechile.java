package org.lld.easy.parkinglot;


//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
public abstract class Vechile {

    protected String licensePlate;
    protected  VehicleType vehicleType;

    public Vechile(String licensePlate,VehicleType vehicleType){
        this.licensePlate=licensePlate;
        this.vehicleType=vehicleType;
    }


//    public void setLicensePlate(String licensePlate){
//        this.licensePlate=licensePlate;
//    }

    public String getLicensePlate() {
        return licensePlate;
    }

//    public void setVehicleType(VehicleType vehicleType){
//        this.vehicleType=vehicleType;
//    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
}
