package payment;

public class PaymentGateway {

    public  static boolean makePayment(int vehicleNumber, int amount){
        System.out.println("Payment done for vehicle: " + vehicleNumber + " amount: "+ amount);
        return true;
    }
}
