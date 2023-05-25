package org.example;

import java.util.Scanner;

public class SalesContract extends Contract {
    private double salesTax;
    private double processingFee;
    private double recordingFee;
    private boolean financed;

    public double getSalesTax() {
        return salesTax;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public boolean isFinanced() {
        return financed;
    }

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        double vehiclePrice;
        double totalPrice;
        Vehicle vehicleSold = getVehicle();
        vehiclePrice = vehicleSold.getPrice();
        if (vehiclePrice < 10000) {
            totalPrice = vehiclePrice + 295; // processing fee for vehicles under 10,000
        } else {
            totalPrice = vehiclePrice + 495; // processing fee for vehicles over 10,000
        }
        totalPrice = totalPrice + 100; // Adding Recording fee of 100
        totalPrice = totalPrice + (vehiclePrice * 0.05); // 5% sales tax amount
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        Vehicle vehicleSold = getVehicle();
        double vehiclePrice = vehicleSold.getPrice();
        double p = vehiclePrice;
        double r;
        double n;
        double t;
        double payment;
        if (financed) {
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
            double onePlusOverN = 1 + rOverN;
            double power = -t * n;
            double denominator = 1 - Math.pow(onePlusOverN, power);
            payment = numerator / denominator;
            return payment;
        } else {
            return 0;
        }
    }

    @Override
    public String getPersistenceString() {
        return null;
    }
}
