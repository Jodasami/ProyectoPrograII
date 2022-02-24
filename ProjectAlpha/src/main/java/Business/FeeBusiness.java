/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.FeeData;
import Domain.Fee;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fabio
 */
public class FeeBusiness {

    FeeData feeData = new FeeData();

    public String registerFee(Fee fee) throws java.text.ParseException, ParseException, IOException {

        String success = "";

        if (feeData.getFee(fee.getVehicleType()).getVehicleType() == null) {

            feeData.registerFee(fee);

            success = "yes";

        }
        return success;
    }

    public LinkedList<Fee> getAllFees() throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        return feeData.getAllFees();
    }

    public Fee getFee(String vehicleType) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        return feeData.getFee(vehicleType);
    }

    public void deleteFee(String vehicleType) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        feeData.deleteFee(vehicleType);
    }

    public void modifyUserFromFile(String vehicleType, Fee fee) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        feeData.modifyUserFromFile(vehicleType, fee);
    }
   
}
