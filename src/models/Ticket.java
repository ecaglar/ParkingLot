package models;

import java.time.LocalDateTime;

public class Ticket {

    private int spotNumber;
    private int vehicleNumber;
    private VehicleType vehicleType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ticket() {
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Ticket(int spotNumber, int vehicleNumber, VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime) {
        this.spotNumber = spotNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.startTime = startTime;
        this.endTime = endTime;
        System.out.println("Ticket created for vehicle: "+ vehicleNumber + " vehicle type: "+
                vehicleType + " and start time: "+  startTime.toString());
    }

    public int getParkingHours(){
        return endTime.getHour() - startTime.getHour();
    }
}
