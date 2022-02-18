/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author jodas
 */
public class ParkingLot {

    private String id;
    private String name;
    private int numberOfSpaces;
    private int numberOfSpacesWithDisabiltyAdaptation;
    private ArrayList<Vehicle> vehicles;
    private Space[] spaces;

    public ParkingLot(String id, String name, int numberOfSpaces, int numberOfSpacesWithDisabiltyAdaptation, ArrayList<Vehicle> vehicles, Space[] spaces) {
        this.id = id;
        this.name = name;
        this.numberOfSpaces = numberOfSpaces;
        this.numberOfSpacesWithDisabiltyAdaptation = numberOfSpacesWithDisabiltyAdaptation;
        this.vehicles = vehicles;
        this.spaces = spaces;
    }

    public ParkingLot(String id, String name, int numberOfSpaces, int numberOfSpacesWithDisabiltyAdaptation) {
        this.id = id;
        this.name = name;
        this.numberOfSpaces = numberOfSpaces;
        this.numberOfSpacesWithDisabiltyAdaptation = numberOfSpacesWithDisabiltyAdaptation;
    }
    
    public ParkingLot() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public void setNumberOfSpaces(int numberOfSpaces) {
        this.numberOfSpaces = numberOfSpaces;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Space[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Space[] spaces) {
        this.spaces = spaces;
    }

    public int getNumberOfSpacesWithDisabiltyAdaptation() {
        return numberOfSpacesWithDisabiltyAdaptation;
    }

    public void setNumberOfSpacesWithDisabiltyAdaptation(int numberOfSpacesWithDisabiltyAdaptation) {
        this.numberOfSpacesWithDisabiltyAdaptation = numberOfSpacesWithDisabiltyAdaptation;
    }

    

}
