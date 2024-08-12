import charging.ChargingStrategyManager;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;
import payment.PaymentGateway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot implements IParking{


    private List<ParkingSpot> parkingSpots;

    public ParkingLot(int numberOf2Wheels, int numberOf4Wheels){

        parkingSpots = new ArrayList<>(numberOf2Wheels + numberOf4Wheels);

        int spotNumber = 0;

        for(int i  = 0 ; i < numberOf2Wheels ; i++){
            parkingSpots.add(new ParkingSpot(spotNumber, VehicleType.TWOWHEELS));
            ++spotNumber;
        }
        for(int i  = 0 ; i < numberOf4Wheels ; i++){
            parkingSpots.add(new ParkingSpot(spotNumber,VehicleType.FOURWHEELS));
            ++spotNumber;
        }
    }

    public ParkingSpot getNextAvailableSpot(VehicleType type) throws ParkingFullException {

        Optional<ParkingSpot> availableSlot = parkingSpots.stream().filter(parkingSpot -> parkingSpot.getSpotType() == type)
                .filter(parkingSpot -> parkingSpot.isAvailable() == true).findFirst();
        if(availableSlot.isEmpty()){
            throw new ParkingFullException("Parking Full");
        }
        return availableSlot.get();
    }

    @Override
    public synchronized Ticket parkIn(Vehicle vehicle) throws ParkingFullException {
       ParkingSpot availableSpot =  getNextAvailableSpot(vehicle.getType());
       availableSpot.setAvailable(false);

        System.out.println("Vehicle " + vehicle.getVehicleNumber() + " parked to spot: " + availableSpot.getSpotNumber());

        return new Ticket(vehicle.getVehicleNumber(),
               availableSpot.getSpotNumber(),
               vehicle.getType(),
               LocalDateTime.now(),
               null);

    }

    @Override
    public int unPark(Ticket ticket) {
            ticket.setEndTime(LocalDateTime.now());
        int spotNumber = ticket.getSpotNumber();
        ParkingSpot spot = parkingSpots.stream().filter(parkingSpot -> parkingSpot.getSpotNumber() == spotNumber).findFirst().get();
        int charge = ChargingStrategyManager.calculateCharge(ticket);

        if(PaymentGateway.makePayment(ticket.getVehicleNumber(),charge)){
            //
        }
        spot.setAvailable(true);

        System.out.println("Vehicle " + ticket.getVehicleNumber() + " unparked from spot: " + ticket.getSpotNumber());

        return charge;
    }
}
