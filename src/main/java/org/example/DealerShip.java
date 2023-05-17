package org.example;

import java.util.ArrayList;

public class DealerShip {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

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

    public DealerShip() {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public void getVehiclesByPrice(int min,int max){

    }
    public void getVehiclesByMakeModel(String make, String model){

    }
    public void getVehiclesByYear(int min, int max){

    }
    public void getVehiclesByColor(String color){

    }
    public void getVehiclesByMileage(int min, int max){

    }
    public void getVehiclesByType(String type){

    }
    public void getAllVehicles(){
        for (Vehicle v : inventory){
            System.out.println(v.getVin()+ " " + v.getYear() + " " + v.getMake() + " "
                    + v.getModel() + " " + v.getVehicleType() + " " + v.getColor() + " " +
                    v.getOdometer() + " " + v.getPrice());

        }
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }
    public void removeVehicle(String vehicle){
        inventory.remove(vehicle);

    }
}
