/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.UserBusiness;
import Domain.User;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author jodas
 */
public class VehicleData {

    private static String currentVehiclePlate;
    final String JSONFILEPATH = "C:\\Users\\jodas\\Desktop\\ProyectoGit\\ProyectoPrograII\\ProjectAlpha\\Vehicles.json";
//    final String JSONFILEPATH = "C:\\Users\\Fabio\\Desktop\\Progra 2\\Laboratorios Esteban\\ProyectoPrograII\\ProjectAlpha\\Vehicles.json";

    public void insertVehicle(Vehicle vehicle)
            throws IOException {
        JSONObject vehicleObject = new JSONObject();
        vehicleObject.put("plate", vehicle.getPlate());
        vehicleObject.put("color", vehicle.getColor());
        vehicleObject.put("brand", vehicle.getBrand());
        vehicleObject.put("model", vehicle.getModel());
        vehicleObject.put("owner", vehicle.getOwner().getUsername());
        vehicleObject.put("vehicleType", vehicle.getVehicleType().getDescription());

        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(JSONFILEPATH, true)) {
            file.write(vehicleObject.toJSONString() + "\n");
        }

        //Input and Output operations: Happens when there is a failure during reading, writing, and searching file or directory operations.
        //Throws maneja la excepción pero sigue corriendo el programa aún saltando esa excepción.
    }

    public LinkedList<Vehicle> getAllVehicles() throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        LinkedList<Vehicle> vehicles = new LinkedList<>();
        JSONObject jsonObject;

// This will reference one line at a time
        String line = null;
// FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(JSONFILEPATH);
// Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            jsonObject = (JSONObject) new JSONParser().parse(line);

            Vehicle vehicle = new Vehicle();
            vehicle.setPlate(jsonObject.get("plate").toString());
            vehicle.setColor(jsonObject.get("color").toString());
            vehicle.setBrand(jsonObject.get("brand").toString());
            vehicle.setModel(jsonObject.get("model").toString());
            vehicle.setOwner((User) jsonObject.get("owner"));
            vehicle.setVehicleType((VehicleType) jsonObject.get("vehicleType"));
            System.out.println(vehicle.toString());
            vehicles.add(vehicle);
        }
// Always close files.
        bufferedReader.close();

// Or we could just do this:
// ex.printStackTrace();
        return vehicles;
    }

    public LinkedList<Vehicle> getAllVehiclesParked() throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        LinkedList<Vehicle> vehicles = new LinkedList<>();
        JSONObject jsonObject;

// This will reference one line at a time
        String line = null;
// FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(JSONFILEPATH);
// Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            jsonObject = (JSONObject) new JSONParser().parse(line);

            Vehicle vehicle = new Vehicle();
            vehicle.setPlate(jsonObject.get("plate").toString());
            vehicle.setParkingName(jsonObject.get("parkingName").toString());
            vehicle.setSpaceParked(jsonObject.get("spaceParked").toString());
            vehicle.setParkingTime(jsonObject.get("parkingTime").toString());
            vehicles.add(vehicle);
        }
// Always close files.
        bufferedReader.close();

// Or we could just do this:
// ex.printStackTrace();
        return vehicles;
    }

    public Vehicle getVehicle(String plate) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        Vehicle vehicle = new Vehicle();
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
                if (jsonObject.get("plate") != null) {
                    if (jsonObject.get("plate").toString().equals(plate)) {
                        vehicle.setPlate(jsonObject.get("plate").toString());
                        vehicle.setColor(jsonObject.get("color").toString());
                        vehicle.setBrand(jsonObject.get("brand").toString());
                        vehicle.setModel(jsonObject.get("model").toString());

                        UserBusiness userBussines = new UserBusiness();
                        User user = userBussines.getUser(jsonObject.get("owner").toString());

                        vehicle.setOwner(user);

                        VehicleType vehicleType = new VehicleType();
                        vehicleType.setDescription(jsonObject.get("vehicleType").toString());

                        vehicle.setVehicleType(vehicleType);
                    }

                }
            }
            // Always close files.
            bufferedReader.close();
        } else {
            //Crea archivo
            FileWriter file = new FileWriter(JSONFILEPATH);
            file.close();

        }
        return vehicle;
    }

    public Vehicle getVehicleToPark(String plate) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        Vehicle vehicle = new Vehicle();
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
                if (jsonObject.get("plate") != null) {
                    if (jsonObject.get("plate").toString().equals(plate)) {
                        vehicle.setPlate(jsonObject.get("plate").toString());
                        vehicle.setColor(jsonObject.get("color").toString());
                        vehicle.setBrand(jsonObject.get("brand").toString());
                        vehicle.setModel(jsonObject.get("model").toString());

                        UserBusiness userBussines = new UserBusiness();
                        User user = userBussines.getUser(jsonObject.get("owner").toString());

                        vehicle.setOwner(user);

                        VehicleType vehicleType = new VehicleType();
                        vehicleType.setDescription(jsonObject.get("vehicleType").toString());

                        vehicle.setVehicleType(vehicleType);

                        vehicle.setParkingTime(jsonObject.get("parkingName").toString());
                        vehicle.setParkingTime(jsonObject.get("spaceParked").toString());
                        vehicle.setParkingTime(jsonObject.get("parkingTime").toString());

                    }

                }
            }
            // Always close files.
            bufferedReader.close();
        } else {
            //Crea archivo
            FileWriter file = new FileWriter(JSONFILEPATH);
            file.close();

        }
        return vehicle;
    }

    public Vehicle getVehicleByCustomerUsername(String username) throws org.json.simple.parser.ParseException, IOException, java.text.ParseException {
        Vehicle vehicle = new Vehicle();
        JSONObject jsonObject;//THIRD PARTY

        // This will reference one line at a time
        String line = null;

        if (new File(JSONFILEPATH).exists()) {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(JSONFILEPATH);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {

                jsonObject = (JSONObject) new JSONParser().parse(line);
                if (jsonObject.get("owner") != null) {
                    if (jsonObject.get("owner").toString().equals(username)) {
                        vehicle.setPlate(jsonObject.get("plate").toString());
                        vehicle.setColor(jsonObject.get("color").toString());
                        vehicle.setBrand(jsonObject.get("brand").toString());
                        vehicle.setModel(jsonObject.get("model").toString());
                        vehicle.setOwner(vehicle.getOwner());
                        vehicle.setVehicleType(vehicle.getVehicleType());

                    } else {
                        System.out.println("");
                    }
                } else {
                    vehicle = null;
                    break;
                }
            }
            // Always close files.
            bufferedReader.close();
        } else {
            vehicle = null;
        }

        return vehicle;
    }

    public void deleteVehicle(String plate) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        JSONObject vehicleObject;

        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("Vehicles.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                vehicleObject = (JSONObject) new JSONParser().parse(line);

                if (!vehicleObject.get("plate").toString().equals(plate)) {

                    printWriter.println(line);
                    printWriter.flush();
                }
            }

            bufferedReader.close();
        }

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);

    }

    public void modifyVehicleFromFile(String plate, Vehicle vehicle) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        JSONObject vehicleObject;

        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("Vehicles.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

        String line = null;

        //Read from the original file and write to the new 
        //unless content matches data to be removed.
        while ((line = bufferedReader.readLine()) != null) {

            vehicleObject = (JSONObject) new JSONParser().parse(line);

            if (!vehicleObject.get("plate").toString().equals(plate)) {

                printWriter.println(line);
                printWriter.flush();
            } else {

                vehicleObject.put("plate", vehicle.getPlate());
                vehicleObject.put("color", vehicle.getColor());
                vehicleObject.put("brand", vehicle.getBrand());
                vehicleObject.put("model", vehicle.getModel());
                vehicleObject.put("owner", vehicle.getOwner().getUsername());
                vehicleObject.put("vehicleType", vehicle.getVehicleType().getDescription());

                printWriter.println(vehicleObject.toJSONString());
            }
        }

        bufferedReader.close();
        printWriter.close();

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);
    }

    public void modifyVehicleToPark(String plate, Vehicle vehicle) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        JSONObject vehicleObject;

        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("Vehicles.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

        String line = null;

        //Read from the original file and write to the new 
        //unless content matches data to be removed.
        while ((line = bufferedReader.readLine()) != null) {

            vehicleObject = (JSONObject) new JSONParser().parse(line);

            if (!vehicleObject.get("plate").toString().equals(plate)) {

                printWriter.println(line);
                printWriter.flush();
            } else {

                vehicleObject.put("plate", vehicle.getPlate());
                vehicleObject.put("color", vehicle.getColor());
                vehicleObject.put("brand", vehicle.getBrand());
                vehicleObject.put("model", vehicle.getModel());
                vehicleObject.put("owner", vehicle.getOwner().getUsername());
                vehicleObject.put("vehicleType", vehicle.getVehicleType().getDescription());
                vehicleObject.put("parkingName", vehicle.getParkingTime());
                vehicleObject.put("spaceParked", vehicle.getParkingTime());
                vehicleObject.put("parkingTime", vehicle.getParkingTime());

                printWriter.println(vehicleObject.toJSONString());
            }
        }

        bufferedReader.close();
        printWriter.close();

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);
    }

    public static String getCurrentVehiclePlate() {
        return currentVehiclePlate;
    }

    public static void setCurrentVehiclePlate(String currentVehiclePlate) {
        VehicleData.currentVehiclePlate = currentVehiclePlate;
    }

}
