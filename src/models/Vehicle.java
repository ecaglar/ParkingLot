package models;

public class Vehicle {

    private VehicleType type;
    private int vehicleNumber;

    public Vehicle(VehicleType type, int vehicleNumber) {
        this.type = type;
        this.vehicleNumber = vehicleNumber;

        System.out.println(" Vehicle created with type: " + type + " and number: " + vehicleNumber);
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}
