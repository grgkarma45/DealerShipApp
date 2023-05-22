package org.example;

public class LeaseContract extends Contract {
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        Vehicle vehicleSold = getVehicle(); // Assuming the vehicleSold is the one passed to the constructor
        double vehiclePrice = vehicleSold.getPrice();
        double p = vehiclePrice;
        double r;
        double n;
        double t;

        if (vehiclePrice >= 10000) {
            r = 0.0425;
            t = 4;
            n = 12;
        } else {
            r = 0.0525;
            t = 2;
            n = 12;
        }

        double rOverN = r / n;
        double numerator = p * rOverN;
        double onePlusROverN = 1 + rOverN;
        double denominator = Math.pow(onePlusROverN, -t * n);
        return numerator / (1 - denominator);
    }

    @Override
    public String getPersistenceString() {
        return null;
    }
}
