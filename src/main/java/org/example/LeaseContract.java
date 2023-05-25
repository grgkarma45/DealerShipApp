package org.example;

public class LeaseContract extends Contract {
    private Vehicle vehicleSold;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.vehicleSold = vehicleSold;
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = vehicleSold.getPrice();
        return vehiclePrice;
    }

    @Override
    public double getMonthlyPayment() {
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
        return null; // or implement the logic to return a string representation
    }
}
