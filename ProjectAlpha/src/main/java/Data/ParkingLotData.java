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
import java.io.PrintWriter;
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
    
    public static ArrayList<ArrayList<Vehicle>> parkingLotsVehicles = new ArrayList<>();
    public static ArrayList<Space[]> spacesParkingLots = new ArrayList<>();
    
    public ParkingLot registerParkingLot(ParkingLot parkingLot) throws IOException {
        
        JSONObject parkingLotObject = new JSONObject();
        parkingLotObject.put("id", parkingLot.getId());
        parkingLotObject.put("name", parkingLot.getName());
        parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());
        parkingLotObject.put("numberOfSpacesWithDisabiltyAdaptation", parkingLot.getNumberOfSpacesWithDisabiltyAdaptation());
        
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

                    //Obtenemos de un ArrayList que guarda todos los vehículos parqueados de cada parqueo, sus vehículos parqueados con el id del parqueo
                    ArrayList<Vehicle> vehicles = parkingLotsVehicles.get(Integer.parseInt(id) - 1);
                    Space[] spaces = spacesParkingLots.get(Integer.parseInt(id) - 1);
                    
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
    
    public int parkVehicleInParkingLot(Vehicle vehicle, ParkingLot parkingLot) {
        
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
    
    public LinkedList<ParkingLot> getAllparkingLots() throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        LinkedList<ParkingLot> parkingLots = new LinkedList<>();
        JSONObject jsonObject;

        // This will reference one line at a time
        String line = null;
        // FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(JSONFILEPATH);
        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            jsonObject = (JSONObject) new JSONParser().parse(line);
            
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setId(jsonObject.get("id").toString());
            parkingLot.setName(jsonObject.get("name").toString());
            parkingLot.setNumberOfSpaces(Integer.parseInt(jsonObject.get("numberOfSpaces").toString()));
            parkingLot.setNumberOfSpacesWithDisabiltyAdaptation(Integer.parseInt(jsonObject.get("numberOfSpacesWithDisabiltyAdaptation").toString()));
            System.out.println(parkingLot.toString());
            parkingLots.add(parkingLot);
        }
// Always close files.
        bufferedReader.close();

// Or we could just do this:
// ex.printStackTrace();
        return parkingLots;
        
    }
    
    public void deleteParkingLot(String id) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        
        JSONObject userObject;
        
        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("ParkingLots.json");
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {
                
                userObject = (JSONObject) new JSONParser().parse(line);
                
                if (!userObject.get("id").toString().equals(id)) {
                    
                    printWriter.println(line);
                    printWriter.flush();
                }
            }
            parkingLotsVehicles.remove(Integer.parseInt(id));
            
            bufferedReader.close();
        }

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);
        
    }
    
    public void modifyParkingLot(String id, ParkingLot parkingLot) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        
        JSONObject parkingLotObject;
        
        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("ParkingLots.json");
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));
        
        String line = null;

        //Read from the original file and write to the new 
        //unless content matches data to be removed.
        while ((line = bufferedReader.readLine()) != null) {
            
            parkingLotObject = (JSONObject) new JSONParser().parse(line);
            
            if (!parkingLotObject.get("id").toString().equals(id)) {
                
                printWriter.println(line);
                printWriter.flush();
            } else {
                
                parkingLotObject.put("id", parkingLot.getId());
                parkingLotObject.put("name", parkingLot.getName());
                parkingLotObject.put("numberOfSpaces", parkingLot.getNumberOfSpaces());
                parkingLotObject.put("numberOfSpacesWithDisabiltyAdaptation", parkingLot.getNumberOfSpacesWithDisabiltyAdaptation());
                
                ArrayList<Vehicle> vehicles = new ArrayList<>();
                parkingLotsVehicles.add(Integer.parseInt(parkingLot.getId()), vehicles);
                
                printWriter.println(parkingLotObject.toJSONString());
            }
        }
        
        bufferedReader.close();
        printWriter.close();

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);
    }
    
  
    
    public Space[] configureSpacesForDisabiltityAdaptation(Space[] spaces, int numberOfSpacesWithDisabilityAdaptation, String vehicleTypeDisability) {
        
        if (numberOfSpacesWithDisabilityAdaptation <= spaces.length) {
            
            for (int i = 0; i < numberOfSpacesWithDisabilityAdaptation; i++) {
                Space space = new Space();
                
                space.setId(i);
                space.setDisabilityAdaptation(true);
                space.setVehicleType(configureVehicleTypeOfSpaces(vehicleTypeDisability));
                
                spaces[i] = space;
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null, "El número de espacios seleccionados sobrepasa el máximo configurado para este parqueo");
        }
        
        return spaces;
    }
    
    public Space[] configureSpaces(Space[] spaces, int numberOfSpacesWithDisabilityAdaptation, int motorcycle, int ligthVehicles, int heavyVehicles, int bike, int other) {
        
        for (int i = numberOfSpacesWithDisabilityAdaptation; i < spaces.length; i++) {
            Space space = new Space();
            
            while (motorcycle != 0) {
                
                space.setId(i);
                space.setDisabilityAdaptation(false);
                space.setVehicleType(configureVehicleTypeOfSpaces("1"));
                
                spaces[i] = space;
                motorcycle--;
            }
            
            while (ligthVehicles != 0) {
                
                space.setId(i);
                space.setDisabilityAdaptation(false);
                space.setVehicleType(configureVehicleTypeOfSpaces("2"));
                
                spaces[i] = space;
                ligthVehicles--;
            }
            
            while (heavyVehicles != 0) {
                
                space.setId(i);
                space.setDisabilityAdaptation(false);
                space.setVehicleType(configureVehicleTypeOfSpaces("3"));
                
                spaces[i] = space;
                heavyVehicles--;
            }
            
            while (bike != 0) {
                
                space.setId(i);
                space.setDisabilityAdaptation(false);
                space.setVehicleType(configureVehicleTypeOfSpaces("4"));
                
                spaces[i] = space;
                bike--;
            }
            
            while (other != 0) {
                
                space.setId(i);
                space.setDisabilityAdaptation(false);
                space.setVehicleType(configureVehicleTypeOfSpaces("5"));
                
                spaces[i] = space;
                other--;
            }
        }
        
        return spaces;
    }
    
    private VehicleType configureVehicleTypeOfSpaces(String vT) {
        
        String[] types = {"Tipos de vehículo", "motorcycle", "ligthVehicles", "heavyVehicles", "bike", "other"};
        byte[] tires = {0, 2, 4, 8, 12, -1};
        
        String allTypes = "";
        for (String type : types) {
            
            allTypes += type + "\n";
        }
        VehicleType vehicleType = new VehicleType();
        
        byte typeNumber;
        typeNumber = Byte.parseByte(vT);
        vehicleType.setId(typeNumber);
        vehicleType.setDescription(types[typeNumber]);
        vehicleType.setNumberOfTires(tires[typeNumber]);
        
        return vehicleType;
    }
    
    public static void createParkingLotItems() {
        for (int i = 0; i < 10; i++) {
            parkingLotsVehicles.add(new ArrayList<>());
        }
        
        for (int i = 0; i < 10; i++) {
            spacesParkingLots.add(new Space[10]);
        }
        
    }
    
}
