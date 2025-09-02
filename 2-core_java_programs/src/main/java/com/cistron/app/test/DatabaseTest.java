package com.cistron.app.test;

import com.cistron.training.sample.DataManipulation;

/**
 * Simple test class to demonstrate database operations
 */
public class DatabaseTest {
    
    public static void main(String[] args) {
        System.out.println("=== Database Connectivity Test ===");
        
        DataManipulation dm = new DataManipulation();
        
        try {
            System.out.println("\n1. Testing database read operation:");
            dm.readDataFromDatabase();
            
            System.out.println("\n2. Testing database insert operation:");
            dm.insertDataIntoDatabase();
            System.out.println("Insert operation completed successfully!");
            
            System.out.println("\n3. Reading data again after insert:");
            dm.readDataFromDatabase();
            
        } catch (Exception e) {
            System.err.println("Database operation failed: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n=== Database Test Completed ===");
    }
}
