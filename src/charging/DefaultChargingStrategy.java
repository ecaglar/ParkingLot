package charging;

public class DefaultChargingStrategy implements ChargingStrategy{
    @Override
    public int getCharge(int parkingHours) {
        return 0;
    }
}
