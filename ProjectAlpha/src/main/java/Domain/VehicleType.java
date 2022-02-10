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
public class VehicleType {

    private int id;
    private String description;
    private byte numberOfTires;
    private float fee;

    public VehicleType(int id, String description, byte numberOfTires, float fee) {
        this.id = id;
        this.description = description;
        this.numberOfTires = numberOfTires;
        this.fee = fee;
    }

    public VehicleType() {
         
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the numberOfTires
     */
    public byte getNumberOfTires() {
        return numberOfTires;
    }

    /**
     * @param numberOfTires the numberOfTires to set
     */
    public void setNumberOfTires(byte numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    /**
     * @return the fee
     */
    public float getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(float fee) {
        this.fee = fee;
    }

}
