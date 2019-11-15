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
public class Truck {
    
    private MovingBox[][] stack; //first for up down, second for side to side

    private int column = 0;
    protected int hieght = 0;
    
    /**
     * Constructor for the Truck parameters
     * @param hieght of the truck
     * @param length of the truck
     */  
    public Truck( int hieght, int length) { // truck parameters
        stack = new MovingBox[hieght][length];
    }
        
    /**
     * A method for loading the truck that does not allow you to load a box on 
     * top of one that is lighter then the one you are lading
     * @param box the box that is being loaded
     * @return true if the box has successfully been loaded, False if it was not
     */
    public boolean load(MovingBox box) {
        
        
        for(column = 0; column < stack.length; column++ ){ //moving rows once inbetted for loop is done
            for(int j = 0; j < stack[0].length; j++){ //inbetted for loop to add the the callums
                if (j == 0 && (stack[column][j] == null)){
                     stack[column][j] = box;
                     return true;
                }
                if((j != 0) && (stack[column][j - 1] != null) && 
                   (box.getWeight() <= (stack[column][j - 1].getWeight())) && 
                   (stack[column][j] == null)/*Moving box wieght !> box weight*/){ //What box we should put in(limiting factors)
                        stack[column][j] = box;
                        return true;
                }

            }
        }
        return false; //the box we loaded
    }
      
    /**
     * A method for un loading the truck
     * @return true if successful
     */
    public boolean unLoad(){
        boolean temp = true;
            for(int i = stack.length - 1; i >= 0; i-- ){ //Starting from the top row and holding tell second for loop goes through
                for(int j = stack[0].length - 1; j >= 0; j--){ // going through the end calum starting from the top
                    System.out.println(stack[i][j]);
                    stack[i][j] = null;
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
        for(int j = stack[0].length - 1; j >= 0; j--){
            for(column = 0; column < stack.length; column++ ){ 
                
                Object temp = (stack[column][j]);
                truck = truck + temp + "\t";
                
                
            }
            truck = truck + "\n";
        }
    
       return truck;
    }  
}
