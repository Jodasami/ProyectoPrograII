/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author jodas
 */
public class Vehicle {

    private String plate;
    private String color;
    private String brand;
    private String model;
    private User owner;
    private VehicleType vehicleType;
    private int space;
    private User p1;
    private User p2;
    private User p3;
    private User p4;
    private int numberPassengers;

    public Vehicle(String plate, String color, String brand, String model, User owner, VehicleType vehicleType) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.vehicleType = vehicleType;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public Vehicle() {

    }

    public Vehicle(String plate, String color, String brand, String model, User owner, VehicleType vehicleType, int space, int numberPassengers) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.vehicleType = vehicleType;
        this.space = space;
        this.numberPassengers = numberPassengers;
    }

    public Vehicle(String plate, String color, String brand, String model, User owner, User p1, VehicleType vehicleType, int space, int numberPassengers) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.vehicleType = vehicleType;
        this.space = space;
        this.numberPassengers = numberPassengers;
    }

    public Vehicle(String plate, String color, String brand, String model, User owner, User p1, User p2, VehicleType vehicleType, int space, int numberPassengers) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.vehicleType = vehicleType;
        this.space = space;
        this.numberPassengers = numberPassengers;
    }

    public Vehicle(String plate, String color, String brand, String model, User owner, User p1, User p2, User p3, VehicleType vehicleType, int space, int numberPassengers) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.vehicleType = vehicleType;
        this.space = space;
        this.numberPassengers = numberPassengers;
    }

    public Vehicle(String plate, String color, String brand, String model, User owner, User p1, User p2, User p3, User p4, VehicleType vehicleType, int space, int numberPassengers) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.vehicleType = vehicleType;
        this.space = space;
        this.numberPassengers = numberPassengers;
    }

    /**
     * @return the plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * @param plate the plate to set
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * @return the vehicleType
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleType the vehicleType to set
     */
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getNumberPassengers() {
        return numberPassengers;
    }

    public void setNumberPassengers(int numberPassengers) {
        this.numberPassengers = numberPassengers;
    }

}
