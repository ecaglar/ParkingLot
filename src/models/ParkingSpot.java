package models;

public class ParkingSpot {

    private int spotNumber;
    private VehicleType spotType;

    private boolean isAvailable;

    public ParkingSpot(int spotNumber, VehicleType spotType, boolean isAvailable) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isAvailable = isAvailable;
        System.out.println("Parking spot created with spot number: "+ spotNumber + " spot type: "+ spotType);
    }

    public ParkingSpot(int spotNumber, VehicleType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        isAvailable = true;
        System.out.println("Parking spot created with spot number: "+ spotNumber + " spot type: "+ spotType);

    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public void setSpotType(VehicleType spotType) {
        this.spotType = spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
