package ui;

import java.io.FileNotFoundException;

// Main Class 

public class Main {
    public static void main(String[] args) throws Exception {      
        try {
            new TamaHandler();
            
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}