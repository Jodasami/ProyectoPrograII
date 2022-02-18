/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author jodas
 */
public class ParkingLotData {

    //    final String JSONFILEPATH = "C:\\Users\\jodas\\Desktop\\ProyectoGit\\ProyectoPrograII\\ProjectAlpha\\ParkingLots.json";
    final String JSONFILEPATH = "C:\\Users\\Fabio\\Desktop\\Progra 2\\Laboratorios Esteban\\ProyectoPrograII\\ProjectAlpha\\ParkingLots.json";

    public LinkedList<ParkingLot> parkingLots;
    ArrayList<ArrayList> vehiclesOfParkingLot = new ArrayList<>();

    public ParkingLotData() {

        parkingLots = new LinkedList<>();
    }

    public ParkingLot registerParkingLot(ParkingLot parkingLot) throws IOException {

        JSONObject parkingLotObject = new JSONObject();
        parkingLotObject.put("id", parkingLot.getId());
        parkingLotObject.put("name", parkingLot.getName());
        parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());

        try (FileWriter file = new FileWriter(JSONFILEPATH, true)) {
            file.write(parkingLotObject.toJSONString() + "\n");
        }

        return parkingLot;

    }

    public ParkingLot getParkingLot(String id) throws FileNotFoundException, IOException, ParseException {
        ParkingLot parkingLot = new ParkingLot();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;
        FileReader fileReader = null;

        // FileReader reads text files in the default encoding.
        if (new File(JSONFILEPATH).exists()) {

            fileReader = new FileReader(JSONFILEPATH);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);

                if (jsonObject.get("id").toString().equals(id)) {
                    parkingLot.setId(jsonObject.get("id").toString());
                    parkingLot.setName(jsonObject.get("name").toString());
                    parkingLot.setNumberOfSpaces(Integer.parseInt(jsonObject.get("numberOfSpaces").toString()));
                    parkingLot.setNumberOfSpacesWithDisabiltyAdaptation(Integer.parseInt(jsonObject.get("numberOfSpacesWithDisabiltyAdaptation").toString()));
                    Space[] spaces = new Space[parkingLot.getNumberOfSpaces()];
                    spaces = configureSpaces(spaces, parkingLot.getNumberOfSpacesWithDisabiltyAdaptation());

                    //Obtenemos de un ArrayList que guarda todos los vehículos parqueados de cada parqueo, sus vehículos parqueados con el id del parqueo
                    ArrayList<Vehicle> vehicles = vehiclesOfParkingLot.get(Integer.parseInt(id));

                    parkingLot.setSpaces(spaces);
                    parkingLot.setVehicles(vehicles);

                }

            }
            // Always close files.
            bufferedReader.close();
        } else {
            //Crea archivo
            FileWriter file = new FileWriter(JSONFILEPATH);
            file.close();

        }
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
    
      public Space[] configureSpaces(Space[] spaces, int numberOfSpacesWithDisabilityAdaptation) {

        if (numberOfSpacesWithDisabilityAdaptation <= spaces.length) {
            for (int i = 0; i < numberOfSpacesWithDisabilityAdaptation; i++) {
                Space space = new Space();

                space.setId(i);
                space.setDisabilityAdaptation(true);
                space.setVehicleType(configureVehicleTypeOfSpaces(i, true));

                spaces[i] = space;
            }

            for (int i = numberOfSpacesWithDisabilityAdaptation; i < spaces.length; i++) {
                Space space = new Space();

                space.setId(i);
                space.setDisabilityAdaptation(false);
                space.setVehicleType(configureVehicleTypeOfSpaces(i, false));

                spaces[i] = space;
            }

        } else {

            JOptionPane.showMessageDialog(null, "El número de espacios seleccionados sobrepasa el máximo configurado para este parqueo");
        }

        return spaces;
    }

    private VehicleType configureVehicleTypeOfSpaces(int position, boolean disabilityPresented) {

        String[] types = {"Tipos de vehículo", "1)moto", "2)liviano", "3)pesado", "4)bicicleta", "5)otro"};
        byte[] tires = {0, 2, 4, 8, 12, -1};

        String allTypes = "";
        for (String type : types) {

            allTypes += type + "\n";
        }
        VehicleType vehicleType = new VehicleType();

        byte typeNumber;
        typeNumber = Byte.parseByte(JOptionPane.showInputDialog(allTypes + "\n" + "Ingrese el número del tipo de vehículo del espacio # " + position + " ¿Discapacidad?=" + (disabilityPresented ? "Sí" : "No")));
        vehicleType.setId(typeNumber);
        vehicleType.setDescription(types[typeNumber]);
        vehicleType.setNumberOfTires(tires[typeNumber]);

        return vehicleType;
    }

}
