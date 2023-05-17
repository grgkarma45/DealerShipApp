
package org.example;

import java.util.Scanner;

public class UserInterface {
    private DealerShip dealership;
    private Scanner scanner;

    private void init() {
        dealership = new DealerShip();
        System.out.println("Dealership initialized");
        scanner = new Scanner(System.in);
        // DealerShipFileManager DFM = new DealerShipFileManager();
        //DealerShip dealership = DFM.getDealership();
    }

    public static void display() { // creating a method called showReports() to display the reprots menu
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("Welcome to your Reports ledger ");
            System.out.println(("Reports Menu: "));
            System.out.println("[1] - Search By Price");
            System.out.println("[2] - Search By Make/Model");
            System.out.println("[3] - Search Bu Year");
            System.out.println("[4] - Search By Color");
            System.out.println("[5] - Search By Mileage");
            System.out.println("[6] - Search By Type");
            System.out.println("[7] - Show All Vehicles");
            System.out.println("[8] - Add Vehicle");
            System.out.println("[9] - Remove Vehicle");
            System.out.println("[x] - Exit");
            switch (scanner) {


                case "1":
                    processGetByPriceRequests();
                case "2":
                    processGetByMakeModelRequest();
                case "3":
                    processGetByYearRequests();
                case "4":
                    processGetByColorRequest();
                case "5":
                    processGetMileageRequest();
                case "6":
                    processGetByVehicleTypeRequest();
                case "7":
                    processGetAllVehiclesRequest();
                case "8":
                    processAddVehicleRequest();
                case "9":
                    processRemoveVehicleRequest();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + scanner);
            }

            return;
        }
    }



    private static void processRemoveVehicleRequest() {

    }

    private static void processAddVehicleRequest() {

    }

    private static void processGetAllVehiclesRequest() {

    }

    private static void processGetByVehicleTypeRequest() {

    }

    private static void processGetMileageRequest() {

    }

    private static void processGetByColorRequest() {

    }

    private static void processGetByYearRequests() {

    }

    private static void processGetByMakeModelRequest() {

    }

}

    private static void processGetByPriceRequests() {

    }
}
//    case "A":
//    processGetByPriceRequests();
//               case "B":
//    processGetByMakeModelRequest();
//               case "C":
//    processGetByYearRequests();
//               case "D":
//    processGetByColorRequest();
//               case "E":
//    processGetMileageRequest();
//               case "F":
//    processGetByVehicleTypeRequest();
//               case "G":
//    processGetAllVehiclesRequest();
//               case "H":
//    processAddVehicleRequest();
//               case "I":
//    processRemoveVehicleRequest();
//
//
