package org.example;

public class LeaseContract extends Contract {
    private Vehicle vehicleSold;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.vehicleSold = vehicleSold;
    }
    public Vehicle getVehicleSold() {
        return vehicleSold;
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



    double endingValueAndLeaseFee() {
        double vehiclePrice = vehicleSold.getPrice();
        double endingValue = vehiclePrice / 2;
        double leaseFee = vehiclePrice * 0.07;
        return endingValue + leaseFee;
    }

    double getexpectedEndingValue() {
        double vehiclePrice = vehicleSold.getPrice();
        double endingValue = vehiclePrice / 2;
        return endingValue;
    }

    double getLeaseFee() {
        double vehiclePrice = vehicleSold.getPrice();
        double leaseFee = vehiclePrice * 0.07;
        return leaseFee;
    }
    @Override
    public String getPersistenceString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LEASE").append("|");
        builder.append(getDate()).append("|");
        builder.append(getCustomerName()).append("|");
        builder.append(getCustomerEmail()).append("|");
        builder.append(getVehicleSold().getVin()).append("|");
        builder.append(getVehicleSold().getYear()).append("|");
        builder.append(getVehicleSold().getMake()).append("|");
        builder.append(getVehicleSold().getModel()).append("|");
        builder.append(getVehicleSold().getVehicleType()).append("|");
        builder.append(getVehicleSold().getColor()).append("|");
        builder.append(getVehicleSold().getOdometer()).append("|");
        builder.append(getVehicleSold().getPrice()).append("|");
        builder.append(getexpectedEndingValue()).append("|");
        builder.append(getLeaseFee()).append("|");
        builder.append(getTotalPrice()).append("|");
        builder.append(getMonthlyPayment()).append("|");

        return builder.toString();
    }
}
