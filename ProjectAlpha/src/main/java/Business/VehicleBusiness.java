/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.UserData;
import Data.VehicleData;
import Domain.User;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jodas
 */
public class VehicleBusiness {
    
      VehicleData vehicleData;

    public VehicleBusiness() {
        vehicleData = new VehicleData();
    }

    public String insertVehicle(Vehicle vehicle) throws IOException, ParseException, java.text.ParseException {

        String success = "";

        //ToDo regla de negocio
        if (vehicleData.getVehicle(vehicle.getPlate()).getPlate()== null) {

            vehicleData.insertVehicle(vehicle);

            success = "yes";

        }

        return success;

    }

    public LinkedList<Vehicle> getAllVehicles() throws ParseException, java.text.ParseException, IOException {
        return vehicleData.getAllVehicles();
    }

    public Vehicle getVehicle(String plate, String color) throws ParseException, IOException, java.text.ParseException {

        return vehicleData.getVehicle(plate, color);
    }
    
    public Vehicle getVehicle(String plate) throws ParseException, IOException, java.text.ParseException {

        return vehicleData.getVehicle(plate);
    }
    
     public void modifyVehicle(String vehiclePlate, Vehicle vehicle) throws IOException, ParseException, java.text.ParseException {

        vehicleData.modifyVehicleFromFile(vehiclePlate, vehicle);

    }
     
       public Vehicle getVehicleByCustomerUsername(String username) throws ParseException, IOException, java.text.ParseException {

        return vehicleData.getVehicleByCustomerUsername(username);
    }

    public void deleteVehicle(String vehiclePlate) throws IOException, ParseException, java.text.ParseException {

        vehicleData.deleteVehicle(vehiclePlate);

    }
    
     public VehicleType getVechileType(String vType){
        
       String[] types = {"Tipos de vehículo", "moto", "liviano", "pesado", "bicicleta", "otro"};
        byte[] tires = {0, 2, 4, 8, 12, -1};

        String allTypes = "";
        for (String type : types) {

            allTypes += type + "\n";
        }
        VehicleType vehicleType = new VehicleType();

        byte typeNumber;
        typeNumber = Byte.parseByte(vType);
        vehicleType.setId(typeNumber);
        vehicleType.setDescription(types[typeNumber]);
        vehicleType.setNumberOfTires(tires[typeNumber]);

        return vehicleType;
    }
    
}
