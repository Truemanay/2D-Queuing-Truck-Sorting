/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The Truck class which creates a truck and allows you to add moving boxes
 * and remove moving boxes from it.
 * @author Truman Emmings, Radhika Tandon, Alexis Delgato, Faiza Jama
 */
public class DequeTruck {
    
    private MovingBox[][] stack; //first for up down, second for side to side

    private int column = 0;
    protected int hieght = 0;
    
    /**
     * Constructor for the Truck parameters
     * @param hieght of the truck
     * @param length of the truck
     */  
    public DequeTruck( int hieght, int length) { // truck parameters
        stack = new MovingBox[hieght][length];
    }
        
    /**
     * A method for loading the truck that does not allow you to load a box on 
     * top of one that is lighter then the one you are lading
     * @param box the box that is being loaded
     * @return true if the box has successfully been loaded, False if it was not
     */
    public boolean enqueueBack(MovingBox box) {
        
        //System.out.println("Boxes" + box);
        for(column = 0; column < stack[0].length; column++ ){ //moving rows once inbetted for loop is done
            for(int j = 0; j < stack.length; j++){ //inbetted for loop to add the the callums
                //System.out.println("HERE: At index: y " +j +" " + " x " + column);
                if (column == 0 && (stack[j][column] == null)){
                     
                     
                    boolean path = true;
                    
                    
                    for (int p = column ; p < stack[0].length; p++){
                        if (stack[j][p] != null)
                            path = false;
                            //System.out.println("FAIL");
                            //System.out.println("IN THROW CHECK: At index: y " +j +" " + " x " + p);
                    }
                    if (path){
                        stack[j][column] = box;
                        return true;
                    }
                     
                }
                if((column != 0) && (stack[j][column - 1] != null) && 
                   (box.getWeight() <= (stack[j][column - 1].getWeight())) && 
                   (stack[j][column] == null)/*Moving box wieght !> box weight*/){
                    //Check path to open location
                    boolean path = true;
                    
                    for (int p = column ; p < stack[0].length; p++){
                        if (stack[j][p] != null){
                            path = false;
                            //System.out.println("FAIL");
                            //System.out.println("IN THROW CHECK: At index: y " +j +" " + " x " + p);
                        }
                    }
                    if (path)
                    {
                        stack[j][column] = box;
                        return true;
                    }
                }

            }
        }
        return false; //the box we loaded
    }
    /**
     * 
     * @param box
     * @return 
     */
    public boolean enqueueFront(MovingBox box){
        for(column = stack[0].length - 1; column >= 0; column--){ //Starting from the top row and holding tell second for loop goes through
            for(int j = 0; j < stack.length; j++){//inbetted for loop to add the the callums
                //System.out.println("HERE: At index: y " +j +" " + " x " + column);
                if (j == 0 && (stack[j][column] == null)){
                    boolean path = true;
                    for (int p = column ; p >= 0; p--){
                         //System.out.println("IN THROW CHECK: At index: y " +j +" " + " x " + p);
                        if (stack[j][p] != null)
                        {
                            path = false;
                            System.out.println("FAIL");
                        }
                    }
                    if (path)
                    {
                        stack[j][column] = box;
                        return true;
                    }
                    
                }
                if((j != 0) && (stack[j - 1][column] != null) && 
                   (box.getWeight() <= (stack[j - 1][column].getWeight())) && 
                   (stack[j][column] == null)/*Moving box wieght !> box weight*/){
                    //Check path to open location
                    boolean path = true;
                    
                    for (int p = column ; p >= 0; p--){
                        //System.out.println("IN THROW CHECK: At index: y " +j +" " + " x " + p);
                        if (stack[j][p] != null)
                            path = false;
                            System.out.println("FAIL");
                    }
                    if (path)
                    {
                        stack[j][column] = box;
                        return true;
                    }
                }

            }
        }
        return false;
    }
      
    /**
     * A method for un loading the truck
     * @return true if successful
     */
    public boolean dequeueBack(){
        boolean temp = true;
            for(int i = stack[0].length - 1; i >= 0; i-- ){ //Starting from the top row and holding tell second for loop goes through
                for(int j = stack.length - 1; j >= 0; j--){ // going through the end calum starting from the top
               
                    stack[j][i] = null;
                    System.out.println(toString());
                }
            }
        
        return temp; 
    }
    /**
     * 
     * @return 
     */
    public boolean dequeueFront(){
      boolean temp = true;
            for(int i = 0; i < stack[0].length; i++){ //Starting from the top row and holding tell second for loop goes through
                for( int j = stack.length - 1; j >= 0; j--){ // going through the end calum starting from the top
                    //System.out.println("HERE: At index: y " + j +" " + " x " + i);
                    //System.out.println("Removed Box: " + stack[j][i]);
                    stack[j][i] = null;
                    System.out.println(toString());
                    
                }
            }
        
        return temp; 
    }
    
    
    /**
     * A toString method used for creating a readable string of data for the truck
     * @return Returns a readable string of data
     */
    public String toString() {
        String truck = "\n";
        for(int j = stack.length - 1; j >= 0; j--){
               
            for(column = 0; column < stack[0].length; column++ ){ 
                
                Object temp = (stack[j][column]);
                truck = truck + temp + "\t";
                
                
            }
            truck = truck + "\n";
        }
    
       return truck;
    }  
}
