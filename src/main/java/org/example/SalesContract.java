package org.example;

public class SalesContract extends Contract {
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }


    @Override
    public double getTotalPrice() {
        double vehiclePrice = 0;
        double totalPrice = 0;
        Vehicle vehilceSold = null;
        vehiclePrice = vehilceSold.getPrice();
        // this is the processing fee
        if(vehiclePrice < 10000) {
            totalPrice = vehiclePrice + 295;
        }
        else{
            totalPrice = vehiclePrice +495;
        }
        totalPrice = totalPrice +100;
        totalPrice = totalPrice + (vehiclePrice *0.05);
        return totalPrice;
    }
    @Override
    public double getMonthlyPayment(){
        return 0;
    }
    @Override
    public String getPersistenceString(){
        return null;
    }


}
