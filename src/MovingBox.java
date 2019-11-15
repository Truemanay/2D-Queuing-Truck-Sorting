/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The MovingBox class creates a box with certain parameters
 * that will be loaded into our Truck
 * @author Truman Emmings, Radhika Tandon, Alexis Delgato, Faiza Jama
 */
public class MovingBox {
    
    protected int referenceN;
    protected String dest;
    protected double weight;
    
    /**
     * full parameter constructor
     * @param referenceN An int for the reference number of the box
     * @param dest A String for the name of the destination of the box
     * @param weight A double for the weight of the box
     */
    public MovingBox(int referenceN, String dest, double weight) {
        this.referenceN = referenceN;
        this.dest = dest;
        this.weight = weight;
        
        
    }
    /**
     * a Getter for getting the reference number of the box.
     * @return and int
     */
    public int getReferenceN() {
        return referenceN;
    }
    /**
     * Getter for getting the name of the destination of where the box is going
     * @return a string
     */
    public String getDest() {
        return dest;
    }
    /**
     * Getter for getting the weight of the box
     * @return a double 
     */
    public double getWeight() {
        return weight;
    }
    /**
     * Setter for the reference number of the box
     * @param referenceN the reference number of the box
     */
    public void setReferenceN(int referenceN) {
        this.referenceN = referenceN;
    }
    /**
     * Setter for setting the name of the destination a box is going to
     * @param dest A name for the destination
     */
    public void setDest(String dest) {
        this.dest = dest;
    }
    /**
     * A setter for setting the weight of the box 
     * @param weight a double
     */
    public void setWeight(double weight){
        this.weight = weight;
        
    }
    /**
     * A toString method used for creating a readable string of data
     * @return Returns a readable string of data
     */
    @Override
    public String toString() {
        //return "MovingBox " + "Reference #: " + referenceN + ", Destination: " + dest + ", Weight:" + weight;
        return "Ref#: " + referenceN + ", Dest: " + dest + ", Weight: " + weight;
    }
    
    
    
    
    
    
    
}
