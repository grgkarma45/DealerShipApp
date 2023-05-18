package org.example;

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

    private void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Make of the car");
        String make= scanner.nextLine();
        System.out.println("Please Enter the model of the vehicle");
        String model = scanner.nextLine();
        this.dealership.getVehiclesByMakeModel(make,model);

    }

    private void processGetByPriceRequests() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the minimum price");
        int min = scanner.nextInt();
        System.out.println("Please Enter your maximum price");
        int max = scanner.nextInt();
        this.dealership.getVehiclesByPrice(min, max);

    }

    private void processRemoveVehicleRequest() {
        // Implementation for removing a vehicle
    }

    private void processAddVehicleRequest() {
        // Implementation for adding a vehicle
    }

    private void processGetAllVehiclesRequest() {
        // Implementation for retrieving all vehicles
    }

    private void processGetByVehicleTypeRequest() {
        // Implementation for searching vehicles by type
    }

    private void processGetMileageRequest() {
        // Implementation for searching vehicles by mileage
    }

    private void processGetByColorRequest() {
        // Implementation for searching vehicles by color
    }

    private void processGetByYearRequests() {
        // Implementation for searching vehicles by year
    }
    }