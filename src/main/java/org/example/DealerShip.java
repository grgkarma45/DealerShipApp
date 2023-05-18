package org.example;

import java.util.ArrayList;
import java.util.List;

public class DealerShip {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> vehicles;

    private ArrayList<Vehicle> inventory = new ArrayList<>();



    public DealerShip(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void getVehiclesByPrice(int min, int max){
        System.out.println("Here are all the vehicles within your selected price range:");
        boolean found = false;
        for (Vehicle v : inventory){
            if( v.getPrice() <= max && v.getPrice() >= min){
                found = true;
                displayVehicles(v);
            }
        }
    }
    public void getVehiclesByMakeModel(String make, String model){
        System.out.println("Here are the vehicles with the selected Make and Model:");
        boolean found = false;
        for( Vehicle v: inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                found = true;
                displayVehicles(v);
            }

        }
    }
    public void getVehiclesByYear(int minYear, int maxYear){
        System.out.println("Here are the vehicles with the selected Year: \n");
        boolean found = false;
        for(Vehicle v : inventory){
            if( v.getYear() <= maxYear && v.getYear() >= minYear){
                found = true;
                displayVehicles(v);

            }

        }

    }
    public void getVehiclesByColor(String color){
        System.out.println("Here are the vehicles with the selected Color: \n");
        boolean found = false;
        for(Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                found = true;
                displayVehicles(v);
            }
        }

    }
    public void getVehiclesByMileage(int min, int max){
        System.out.println("Here are the vehicles with the selected Mileage: \n");
        boolean found = false;
        for(Vehicle v : inventory){
            if(v.getOdometer() <= max && v.getOdometer() >= min){
                found = true;
                displayVehicles(v);
            }
        }

    }
    public void getVehiclesByType(String type){

    }
    public void getAllVehicles(){
        for (Vehicle v : inventory){
            displayVehicles(v);

        }
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }
    public void removeVehicle(String vehicle){
        inventory.remove(vehicle);

    }
    public void displayVehicles(Vehicle v){
        System.out.println(v.getVin()+ " " + v.getYear() + " " + v.getMake() + " "
                + v.getModel() + " " + v.getVehicleType() + " " + v.getColor() + " " +
                v.getOdometer() + " " + v.getPrice());


    }
}