package org.example;
import org.example.DealerShip;
import org.example.Vehicle;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private DealerShip dealership;
    private Scanner scanner;

    private void init() {
        DealerShipFileManager fileManager = new DealerShipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {

            System.out.println("Welcome to the Cars Dealership");
            System.out.println("[1] - Search By Price");
            System.out.println("[2] - Search By Make/Model");
            System.out.println("[3] - Search By Year");
            System.out.println("[4] - Search By Color");
            System.out.println("[5] - Search By Mileage");
            System.out.println("[6] - Search By Type");
            System.out.println("[7] - Show All Vehicles");
            System.out.println("[8] - Add Vehicle");
            System.out.println("[9] - Remove Vehicle");
            System.out.println("[x] - Exit");
            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    processGetByPriceRequests();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequests();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Have a nice Day");
                    System.exit(0);

                default:
                    System.out.println("Please Enter a Valid Option");
            }
        } while (input != 0);
    }

    //Case 1
    private void processGetByPriceRequests() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the minimum price");
        int min = scanner.nextInt();
        System.out.println("Please Enter your maximum price");
        int max = scanner.nextInt();
        this.dealership.getVehiclesByPrice(min, max);

    }

    //Case 2
    private void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Make of the car");
        String make = scanner.nextLine();
        System.out.println("Please Enter the model of the vehicle");
        String model = scanner.nextLine();
        this.dealership.getVehiclesByMakeModel(make, model);

    }

    //Case 3
    private void processGetByYearRequests() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the minimum year of the vehicle");
        int min = scanner.nextInt();
        System.out.println("Please Enter the maximum year of the vehicle");
        int max = scanner.nextInt();
        this.dealership.getVehiclesByYear(min, max);

        // Implementation for searching vehicles by year
    }

    //Case 4
    private void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the color of the vehicle");
        String color = scanner.nextLine();
        //System.out.println("Please Enter your maximum price");
        //int max = scanner.nextInt();
        this.dealership.getVehiclesByColor(color);

        // Implementation for searching vehicles by color
    }

    //Case 5
    private void processGetMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the minimum mileage of the vehicle");
        int min = scanner.nextInt();
        System.out.println("Please Enter your maximum mileage of the vehicle");
        int max = scanner.nextInt();
        this.dealership.getVehiclesByMileage(min, max);

        // Implementation for searching vehicles by mileage
    }

    //Case 6
    private void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the type of vehicle");
        String type = scanner.nextLine();
        this.dealership.getVehiclesByType(type);

        // Implementation for searching vehicles by type
    }

    //Case7


    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    // Implementation for retrieving all vehicle

    //Case 8

    private void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the vin of the vehicle: ");
        int vin = scanner.nextInt();
        System.out.println("Please enter the year of the vehicle: ");
        int year = scanner.nextInt();
        System.out.println("Please enter the make of the vehicle: ");
        String make = scanner.next();
        System.out.println("Please enter the model of the vehicle: ");
        String model = scanner.next();
        System.out.println("Please enter the type of the vehicle: ");
        String vehicleType = scanner.next();
        System.out.println("Please enter the color of the vehicle: ");
        String color = scanner.next();
        System.out.println("Please enter the odometer of the vehicle: ");
        int odometer = scanner.nextInt();
        System.out.println("Please enter the price of the vehicle: ");
        double price = scanner.nextDouble();
        System.out.println(" \n Vehicle added successfully. Thank You!");
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);

        DealerShipFileManager DFM = new DealerShipFileManager();
        DFM.saveDealership(dealership);


    }
    // Implementation for adding a vehicle

    //Case 9
    private void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the vin of the vehicle that you would like to remove: ");
        int vin = scanner.nextInt();
        Vehicle vehicleEntered = null;
        for (Vehicle v : dealership.getAllVehicles())
            if (v.getVin() == vin) {
                vehicleEntered = v;
                break;
            }
        if (vehicleEntered != null) {
            dealership.removeVehicle(vehicleEntered);
            System.out.println("Vehicle removed successfully. Thank You!");
            DealerShipFileManager DFM = new DealerShipFileManager();
            DFM.saveDealership(dealership);
        } else {
            System.out.println("No match");
        }
    }


    //Implementation for removing a vehicle

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("List of Vehicles available:");
            for (Vehicle v : vehicles) {
                System.out.printf("%-20d %-7d %-15s %-15s %-10s %-10s %-20d %-20.2f \n",
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice());
            }
        }
    }
}
