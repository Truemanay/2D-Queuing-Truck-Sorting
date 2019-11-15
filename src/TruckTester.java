/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Truman Emmings, Radhika Tandon, Alexis Delgato, Faiza Jama
 */
public class TruckTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Asking user how big there truck needs to be
        Scanner scan = new Scanner(System.in);
        System.out.println("How big do you need your truck (in terms of boxes)?");
        System.out.println("How Tall? ");
        int height = scan.nextInt();
        System.out.println("How Long? ");
        int length = scan.nextInt();
        System.out.println("Your truck will be " + height + " boxes tall and " + length +  " boxes long");
       
        
        
        //Randomizing boxes
        ArrayList<MovingBox> boxList = new ArrayList<MovingBox>();
        Random ran = new Random();
        int truckDim = length * height;
        
        for(int i = 0; i < truckDim; i++){
            int index = ran.nextInt(100);
            double weight = ran.nextDouble() * 50.00;
            String dest = "Florida";
            MovingBox box = new MovingBox(index, dest, weight);
            boxList.add(box);
        }
        
       
        //Sorting ArrayList
        //By making the ArrayList boxList sorted from greatest to smallest and adding from "bottom right"
        //to "top left" there was no possible way for a heavier box to be placed on a lighter box
        //the moethod sort boxes is below
        //I used the selction sort algerithm to sort the boxes from heaviest to lightest
        sortBoxes(boxList);
              
        
        
        System.out.println("=====================QueueTruck====================== \n");
        QueueTruck chevy = new QueueTruck(height,length);
        
        System.out.println("Truck Loading");
        for(int i = 0; i < boxList.size(); i++ ){
            if(chevy.enqueue(boxList.get(i))){
                System.out.println(chevy.toString());
            }
        }
                
        
         System.out.println("Truck Loaded: \n" + chevy);
          System.out.println("Truck Unloading: \n" + chevy);
         
         //Unload Truck
         chevy.dequeue();
                 

        
         System.out.println("Truck Unloaded/Empty: \n" + chevy);
         
         System.out.println("===================DequeTruck=================");
         
         //Randomizing boxes
        ArrayList<MovingBox> boxList1 = new ArrayList<>();
        Random ran1 = new Random();
        int truckDim1 = length * height;
        
        for(int i = 0; i < truckDim1; i++){
            int index1 = ran1.nextInt(100);
            double weight1 = ran1.nextDouble() * 50.00;
            String dest1 = "Florida";
            MovingBox box = new MovingBox(index1, dest1, weight1);
            boxList1.add(box);
        }
        
        //Sorting ArrayList
        //By making the ArrayList boxList sorted from greatest to smallest and adding from "bottom right"
        //to "top left" there was no possible way for a heavier box to be placed on a lighter box
        //the moethod sort boxes is below
        //I used the selction sort algerithm to sort the boxes from heaviest to lightest
       sortBoxes(boxList1);
       
        
        
        DequeTruck F150 = new DequeTruck(height,length);
        
        System.out.println("Laoding From Back\n");
        for(int i = 0; i < boxList1.size(); i++ ){
            if(F150.enqueueBack(boxList1.get(i))){
                System.out.println(F150.toString());
            }
        }
        System.out.println("Loaded From Back: \n" + F150);
        System.out.println("Unloading From Back: \n");
         
        F150.dequeueBack();
         
        System.out.println("Truck unloaded! \n");
         
        System.out.println("Loading New Truck from Front:\n");
        F150 = new DequeTruck(height,length);
        
        for(int i = 0; i < boxList1.size(); i++ ){
            if(F150.enqueueFront(boxList1.get(i))){
                System.out.println(F150.toString());
            }
        }
        System.out.println("Loaded From Front: \n" + F150);
         System.out.println("Unloading From Front: \n");
         
        F150.dequeueFront();
         
        System.out.println("Truck unloaded! \n");

    
    }
    public static void sortBoxes(ArrayList<MovingBox> input) {
        //implemented selection sort
        for (int i = 0; i < input.size(); i++) {
            double largeW = 0.0;
            int largeI = i;
            for (int j = i; j < input.size(); j++) {

                if (input.get(j).getWeight() > largeW) {
                    largeW = input.get(j).getWeight();
                    largeI = j;
                }

            }
            MovingBox temp = input.get(i);
            input.set(i, input.get(largeI));
            input.set(largeI, temp);
        }
    }
   
}
