/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author jodas
 */
public class ParkingLotData {
    
     public LinkedList<ParkingLot> parkingLots;
    static int parkingLotId = 1;

    public ParkingLotData() {

        parkingLots = new LinkedList<>();
    }

    public ParkingLot registerParkingLot(String name, Space spaces[]) {

        ParkingLot parkingLot = new ParkingLot();
        parkingLotId++;
        parkingLot.setId(parkingLotId);
        parkingLot.setName(name);
        parkingLot.setSpaces(spaces);

        return parkingLot;

    }

    public int registerVehicleInParkingLot(Vehicle vehicle, ParkingLot parkingLot) {

        ArrayList<Vehicle> vehiclesInParkingLot = parkingLot.getVehicles();
        Space spaces[] = parkingLot.getSpaces();
        int spaceId = 0;
        //recorre la lista de vehículos para ver en qué posición
        //podemos ingresar al vehículo actual
        for (int i = 0; i < vehiclesInParkingLot.size(); i++) {

            if (vehiclesInParkingLot.get(i) == null) {

                //preguntamos si el cliente presenta una capacidad particular
                //y requiere de un espacio adaptado
                if (vehicle.getOwner().isDisabilityPresented()) {

                    if (spaces[i].isDisabilityAdaptation()) {

                        //compara el tipo de vehículo del espacio y del vehículo que se va a 
                        //estacionar (tipos: moto, automóvil, bus, etc)
                        if (spaces[i].getVehicleType().getId() == vehicle.getVehicleType().getId()) {
                            vehiclesInParkingLot.add(vehicle);
                            spaces[i].setSpaceTaken(true);
                            //este es el número del espacio que se va a retornar
                            spaceId = spaces[i].getId();
                            break;
                        }

                    }

                } else {
                    //compara el tipo de vehículo del espacio y del vehículo que se va a 
                    //estacionar (tipos: moto, automóvil, bus, etc)
                    if (spaces[i].getVehicleType().getId() == vehicle.getVehicleType().getId()) {

                        vehiclesInParkingLot.add(vehicle);
                        spaces[i].setSpaceTaken(true);
                        //este es el número del espacio que se va a retornar
                        spaceId = spaces[i].getId();
                        break;
                    }
                }

            }

        }

        //*************actualizamos los espacios tomados
        //y los vehículos registrados en el parqueo
        parkingLot.setSpaces(spaces);
        parkingLot.setVehicles(vehiclesInParkingLot);

        return spaceId;

    }
    
    public void removeVehicleFromParkingLot(Vehicle vehicle, ParkingLot parkingLot) {

        ArrayList<Vehicle> vehiclesInParkingLot = parkingLot.getVehicles();
        Space spaces[] = parkingLot.getSpaces();
        //recorre la lista de vehículos para ver en qué posición
        //debemos retirar al vehículo actual
        for (int i = 0; i < vehiclesInParkingLot.size(); i++) {

            if (vehiclesInParkingLot.get(i) == vehicle) {

                vehiclesInParkingLot.remove(vehicle);
                spaces[i].setSpaceTaken(false);
                break;
            }

        }
        //*************actualizamos los espacios liberados
        //y los vehículos registrados en el parqueo

        parkingLot.setSpaces(spaces);
        parkingLot.setVehicles(vehiclesInParkingLot);

    }
    
}
