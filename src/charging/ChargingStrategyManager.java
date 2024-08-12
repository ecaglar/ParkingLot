package charging;

import models.Ticket;
import models.VehicleType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ChargingStrategyManager {

    public static int calculateCharge(Ticket ticket){

        ChargingStrategy strategy = getChargingStrategy(ticket.getVehicleType(), ticket.getStartTime());
        return strategy.getCharge(ticket.getParkingHours());

    }

    public static ChargingStrategy getChargingStrategy(VehicleType vehicleType, LocalDateTime time){

        if(vehicleType == VehicleType.TWOWHEELS){
            if(isWeekend(time)){
                return new TwoWheelsWeekendChargingStrategy();
            }else{
                return new TwoWheelsWeekdayChargingStrategy();
            }
        }else if(vehicleType == VehicleType.FOURWHEELS){
            if(isWeekend(time)){
                return new FourWheelsWeekendChargingStrategy();
            }else{
                return new FourWheelsWeekdayChargingStrategy();
            }
        }else{
            return new DefaultChargingStrategy();
        }
    }
    private static boolean isWeekend(LocalDateTime time ){
        return (time.getDayOfWeek() == DayOfWeek.SATURDAY || time.getDayOfWeek() == DayOfWeek.SUNDAY);
    }
}
