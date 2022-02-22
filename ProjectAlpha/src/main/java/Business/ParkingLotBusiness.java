/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.ParkingLotData;
import Domain.ParkingLot;
import Domain.Space;
import Domain.VehicleType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fabio
 */
public class ParkingLotBusiness {

    ParkingLotData parkingLotData = new ParkingLotData();

    public String createParkingLot(ParkingLot parkingLot) throws IOException, ParseException, java.text.ParseException {

        String success = "";

        if (parkingLotData.getParkingLot(parkingLot.getId()).getId() == null) {

            parkingLotData.registerParkingLot(parkingLot);

            success = "yes";

        }
        return success;
    }

    public ParkingLot getParkingLot(String id) throws IOException, FileNotFoundException, ParseException {
        return parkingLotData.getParkingLot(id);
    }

    public Space[] configureSpaces(Space[] spaces, int numberOfSpacesWithDisabilityAdaptation, int motorcycle, int ligthVehicles, int heavyVehicles, int bike, int other) {
        return parkingLotData.configureSpaces(spaces, numberOfSpacesWithDisabilityAdaptation, motorcycle, ligthVehicles, heavyVehicles, bike, other);
    }

    public Space[] configureSpacesForDisabiltityAdaptation(Space[] spaces, int numberOfSpacesWithDisabilityAdaptation, String vehicleTypeDisability) {
        return parkingLotData.configureSpacesForDisabiltityAdaptation(spaces, numberOfSpacesWithDisabilityAdaptation, vehicleTypeDisability);
    }

    public LinkedList<ParkingLot> getAllparkingLots() throws ParseException, org.json.simple.parser.ParseException, FileNotFoundException, IOException {
        return parkingLotData.getAllparkingLots();
    }

}
