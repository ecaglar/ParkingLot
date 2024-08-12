import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;

public interface IParking {

    public ParkingSpot getNextAvailableSpot(VehicleType type) throws ParkingFullException;
    public Ticket parkIn(Vehicle vehicle) throws ParkingFullException;
    public int unPark(Ticket ticket);

}
