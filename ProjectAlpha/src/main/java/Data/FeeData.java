/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Domain.Fee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fabio
 */
public class FeeData {

    //    final String JSONFILEPATH = "C:\\Users\\jodas\\Desktop\\ProyectoGit\\ProyectoPrograII\\ProjectAlpha\\Users.json";
    final String JSONFILEPATH = "C:\\Users\\Fabio\\Desktop\\Progra 2\\Laboratorios Esteban\\ProyectoPrograII\\ProjectAlpha\\Fees.json";

    public void registerFee(Fee fee)
            throws IOException {
        JSONObject feeObject = new JSONObject();
        feeObject.put("fee", fee.getFee());
        feeObject.put("vehicleType", fee.getVehicleType());
        //true allows multiple insertions in the file
        try (FileWriter file = new FileWriter(JSONFILEPATH, true)) {
            file.write(feeObject.toJSONString() + "\n");
        }

        //Input and Output operations: Happens when there is a failure during reading, writing, and searching file or directory operations.
        //Throws maneja la excepción pero sigue corriendo el programa aún saltando esa excepción.
    }

    public LinkedList<Fee> getAllFees() throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        LinkedList<Fee> users = new LinkedList<>();
        JSONObject jsonObject;

// This will reference one line at a time
        String line = null;
// FileReader reads text files in the default encoding.
        FileReader fileReader = new FileReader(JSONFILEPATH);
// Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            jsonObject = (JSONObject) new JSONParser().parse(line);

            Fee fee = new Fee();
            fee.setFee(jsonObject.get("fee").toString());
            fee.setVehicleType(jsonObject.get("vehicleType").toString());
            users.add(fee);
        }
// Always close files.
        bufferedReader.close();

// Or we could just do this:
// ex.printStackTrace();
        return users;
    }

    public Fee getFee(String vehicleType) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        Fee fee = new Fee();
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

                if (jsonObject.get("vehicleType").toString().equals(vehicleType)) {
                    fee.setFee(jsonObject.get("fee").toString());
                    fee.setVehicleType(jsonObject.get("vehicleType").toString());
                }

            }
            // Always close files.
            bufferedReader.close();
        } else {
            //Crea archivo
            FileWriter file = new FileWriter(JSONFILEPATH);
            file.close();

        }
        return fee;
    }

    public void deleteFee(String vehicleType) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        JSONObject feeObject;

        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("Fees.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile))) {
            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = bufferedReader.readLine()) != null) {

                feeObject = (JSONObject) new JSONParser().parse(line);

                if (!feeObject.get("vehicleType").toString().equals(vehicleType)) {

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

    public void modifyUserFromFile(String vehicleType, Fee fee) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {

        JSONObject feeObject;

        File file = new File(JSONFILEPATH);

        //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File("Fees.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(JSONFILEPATH));
        PrintWriter printWriter = new PrintWriter(new FileWriter(tempFile));

        String line = null;

        //Read from the original file and write to the new 
        //unless content matches data to be removed.
        while ((line = bufferedReader.readLine()) != null) {

            feeObject = (JSONObject) new JSONParser().parse(line);

            if (!feeObject.get("vehicleType").toString().equals(vehicleType)) {

                printWriter.println(line);
                printWriter.flush();
            } else {

                feeObject.put("fee", fee.getFee());
                feeObject.put("vehicleType", fee.getVehicleType());

                printWriter.println(feeObject.toJSONString());
            }
        }

        bufferedReader.close();
        printWriter.close();

        //Delete the original file
        file.delete();

        //Rename the new file to the filename the original file had.
        tempFile.renameTo(file);
    }

}
