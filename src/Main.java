import models.Ticket;
import models.Vehicle;
import models.VehicleType;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ParkingLot parkingLot = new ParkingLot(20, 100);

        try {
            Ticket ticket1 = parkingLot.parkIn(new Vehicle(VehicleType.TWOWHEELS, 1));
            Ticket ticket2 = parkingLot.parkIn(new Vehicle(VehicleType.TWOWHEELS, 2));
            Ticket ticket3 = parkingLot.parkIn(new Vehicle(VehicleType.TWOWHEELS, 3));
            Ticket ticket4 = parkingLot.parkIn(new Vehicle(VehicleType.TWOWHEELS, 4));
            Ticket ticket5 = parkingLot.parkIn(new Vehicle(VehicleType.TWOWHEELS, 5));


            parkingLot.unPark(ticket1);
            parkingLot.unPark(ticket2);
            parkingLot.unPark(ticket3);
            parkingLot.unPark(ticket4);
            parkingLot.unPark(ticket5);

        }catch (ParkingFullException e){

        }

    }
}
