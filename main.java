import java.io.*;
import java.io.IOException;
import javax.swing.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public class main{
public static void main(String[] args) {
    Bee [][] Hive=new Bee[10][10];// The Hive array holds the Bee objects // 10000 Bees
    double beeTotal = (double) (Hive.length * Hive[0].length);
    double avgInfection =0.0,variance =0.0,infectedBees=0.0,stdev =0.0,bsum=0.0,bsum2=0.0,sickbees=0.0,average=0.0;
    int count=0;
    for (int k = 0; k < Hive.length; k++) {
        for (int k2 = 0; k2 < Hive[k].length; k2++) {
            Hive[k][k2] = new Bee(k,k2); // Fill our Hive with Bees
        }
    }
    for (int k = 0; k < 5; k++) {
        int x,y;
        x = (int) (Math.random() * Hive.length);
        y = (int) (Math.random() * Hive[0].length); // Randomly choose 5 Bees to start as Infected;
        Hive[x][y].infected = true; 
        System.out.println("Infected Bee at x " + x +" y " + y);
    }
    System.out.println(5 + " Infected Bees Added");


    // Print out a Visual Of our Hive First
    System.out.println("First Day Hive");
    for(int w = 0; w<Hive.length; w++){ 
        for(int l = 0; l<Hive[w].length; l++){
            if(Hive[w][l].infected){ // Row by Row
                System.out.print("X");
                System.out.print("\t");
            }
            else
            {
                //System.out.print("" + w +"" +l);
                System.out.print("O");
                System.out.print("\t");       
            }
        }
        System.out.println("");
    }


   for(int i=0; i<7; i++){ // Time step through 7 Days
    infectedBees = 0;
       System.out.println("After Night " + (i+1));
        for(int w = 0; w<Hive.length; w++){ 
            for(int l = 0; l<Hive[w].length; l++){
                if(Hive[w][l].infected){ // Row by Row
                    System.out.print("X");
                    infectedBees++;
                    System.out.print("\t");
                }
                else {
                Hive[w][l].updateHealth(Hive, w, l);
                System.out.print("O");
                //System.out.print(""+w +"" +l);
                System.out.print("\t");
                }
            }
            System.out.println("");
        }
        // Calculate Stats
        sickbees=infectedBees-5;
        bsum+=sickbees;
        bsum2+=sickbees*sickbees;
        count++;
        average=bsum/count;
        variance=bsum2/count-average*average;
        stdev=Math.sqrt(variance);

        System.out.println("There were " + infectedBees +" Infected Bees");
        System.out.println((average)+" AVG Bees Infected per Night");      // not as accurate in a short time period because we start with 5 infected Bees.
        System.out.println("Variance:" +variance);                         
  }
        System.out.println("");
        System.out.println("*** After 7 Nights ***");
        System.out.println("There were " + infectedBees +" Infected Bees");
        System.out.println((average)+" AVG Bees Infected per Night");
        System.out.println("Variance:" +variance);
        
    } // end of main method
} // end of class main