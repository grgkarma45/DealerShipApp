package org.example;

public class SalesContract extends Contract {
    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = 0;
        double totalPrice = 0;
        Vehicle vehicleSold = getVehicle(); // Assuming the vehicleSold is the one passed to the constructor
        vehiclePrice = vehicleSold.getPrice();

        // Processing fee
        if (vehiclePrice < 10000) {
            totalPrice = vehiclePrice + 295;
        } else {
            totalPrice = vehiclePrice + 495;
        }

        totalPrice = totalPrice + 100;
        totalPrice = totalPrice + (vehiclePrice * 0.05);
        return totalPrice;
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
