package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealerShipFileManager {
    public DealerShip getDealership(){
        DealerShip dealerShip = null;
        try { //we're creating filereader and bufferreader and passing the inventory.csv file into it.
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            input = bufferedReader.readLine();
            String[] details = input.split("\\|");
            String name = details[0];
            String address = details[1];
            String phone = details[2];
            dealerShip = new DealerShip(name, address, phone);

            while ((input = bufferedReader.readLine())!= null){
                details = input.split("\\|");
                String vin = details[0];
                int year =Integer.parseInt( details[1]);
                String make = details[2];
                String model = details[3];
                 String vehicleType = details[4];
                String color = details[5];
                int odometer = Integer.parseInt(details[6]);
                double price =Double.parseDouble(details[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType,color, odometer, price);
                dealerShip.addVehicle(vehicle);



            }

        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        return dealerShip;
    }

        public static void saveDealership(DealerShip dealerShip){
            try (FileWriter fileWriter = new FileWriter("inventory.csv")) {
                for (Vehicle v : dealerShip.getAllVehicles()) {
                    String vehicle = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                            v.getVin(),
                            v.getYear(),
                            v.getMake(),
                            v.getModel(),
                            v.getVehicleType(),
                            v.getColor(),
                            v.getOdometer(),
                            v.getPrice());
                    fileWriter.write(vehicle);
                }
                fileWriter.close();

                System.out.println("Changes have been saved to file: " );
            } catch (IOException e) {
                System.err.println("Error saving dealership inventory");
            }

        }

    }