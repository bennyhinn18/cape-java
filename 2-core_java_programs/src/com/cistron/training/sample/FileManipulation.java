package com.cistron.training.sample;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManipulation {
	
	public FileManipulation() {
		
	}

	public void createFile() {
	    File file = new File("NewFile.txt");
	
	    try {
	
	      boolean value = file.createNewFile();
	
	      if (value) {
	        System.out.println("The new file is created.");
	      }
	      else {
	        System.out.println("The file already exists.");
	      }
	    }
	    catch(Exception e) {
	      e.getStackTrace();
	    }
	}

	
	public void writeFile() {
	
	     String data = "This is the data in the output file";
	     try {
	       // Creates a Writer using FileWriter
	       FileWriter output = new FileWriter("NewFile.txt");

	       // Writes string to the file
	       output.write(data);
	       System.out.println("Data is written to the file.");

	       // Closes the writer
	       output.close();
	     }
	     catch (Exception e) {
	       e.getStackTrace();
	     }
	}


	public void readFile() {
	    char[] array = new char[100];
	    try {
	      // Creates a reader using the FileReader
	      FileReader input = new FileReader("NewFile.txt");

	      // Reads characters
	      input.read(array);
	      System.out.println("Data in the file:");
	      System.out.println(array);

	      // Closes the reader
	      input.close();
	    } catch(Exception e) {
	      e.getStackTrace();
	    }
	}
		

	public void deleteFile() {
			
	    try {		
		    // creates a file object
		    File file = new File("NewFile.txt");
	
		    // deletes the file
		    boolean value = file.delete();
		    if(value) {
		      System.out.println("The File is deleted.");
		    }
		    else {
		      System.out.println("The File is not deleted.");
		    }
	    } catch(Exception e) {
		      e.getStackTrace();
	    }	    

	}
	
}
