package org.example;
public class Main {

    public static void main(String[] args) {
        DealerShipFileManager Dfm = new DealerShipFileManager();
        DealerShip d = Dfm.getDealership();
        d.getAllVehicles();
        UserInterface ui = new UserInterface();
        ui.display();
    }
}