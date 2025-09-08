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
	
	     String data = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In a dui ut urna eleifend sodales quis ut augue. Donec fringilla venenatis diam, ut vehicula ligula viverra sit amet. Phasellus rutrum id sapien consectetur hendrerit. Aliquam vel porttitor lorem. Nulla venenatis nulla sed lobortis mattis. Sed scelerisque dictum nisi sed rutrum. Aliquam erat volutpat. Phasellus lectus enim, elementum vel nunc ac, rutrum accumsan eros. Donec mattis fermentum ex, non lacinia felis. Quisque vehicula finibus nibh ut maximus. Fusce ultrices justo non dignissim viverra. Aenean nec ultrices turpis. Mauris eu nisi ut mauris pulvinar facilisis eget quis urna. Cras ut aliquam purus.\r\n" + //
						"\r\n" + //
						"In hac habitasse platea dictumst. Ut mollis sapien in egestas ultricies. Pellentesque porta magna in elementum luctus. Mauris bibendum rhoncus lorem sed scelerisque. Proin eget nibh sed velit dapibus consectetur. Suspendisse fringilla quam ut felis fringilla molestie. Quisque sollicitudin arcu augue, quis finibus tortor rhoncus in. Nullam urna quam, auctor a elementum in, sollicitudin a purus. Nulla porta tincidunt felis et suscipit. Nullam porttitor, magna vel vehicula lobortis, nisi nulla gravida dolor, vel elementum felis nibh eget velit. Nam in turpis non lectus congue sollicitudin quis et metus. Phasellus egestas nisl ac justo porttitor condimentum. Vestibulum a tincidunt lacus. Morbi eget pulvinar orci. Pellentesque nisi diam, pellentesque vitae aliquam id, blandit et felis.\r\n" + //
						"\r\n" + //
						"Duis erat turpis, aliquet et augue quis, gravida pulvinar nulla. Maecenas non orci ut ipsum pretium fermentum quis vitae mi. Aliquam vel libero eget arcu porta faucibus sit amet vel lectus. Nam suscipit ex eget convallis commodo. Nunc sed metus nibh. Curabitur vehicula ornare ipsum, pellentesque pretium nulla ultrices ac. Ut egestas odio in elit ultrices venenatis. Fusce sem elit, rutrum eu leo nec, vehicula pulvinar magna. Donec blandit eros et augue tempor, in luctus justo rhoncus. Proin vulputate tempor lacus in pellentesque. Sed semper sollicitudin risus quis pretium. Integer ac libero vulputate, mattis tortor vel, vehicula mi. Nullam bibendum est nisl, eget mattis massa accumsan vel. Aliquam tincidunt ligula at pulvinar mattis. Curabitur luctus quam nisl, quis scelerisque nulla eleifend non.\r\n" + //
						"\r\n" + //
						"Ut vehicula, nibh et ultricies interdum, risus lacus tempus ex, id ornare urna mi at nunc. Morbi condimentum sem non auctor semper. Nunc vestibulum nisl tristique dignissim euismod. Ut turpis est, gravida et lacinia ac, fringilla id turpis. Fusce porttitor pulvinar mauris. Nam ornare urna non odio imperdiet convallis. Aliquam molestie massa magna, sit amet sollicitudin odio rhoncus a. Quisque laoreet libero sem, vitae molestie quam consectetur sit amet. Pellentesque faucibus lacus purus, sed scelerisque enim pharetra in. Nulla facilisi. Vivamus sed tellus et sapien volutpat placerat non ullamcorper lorem. Sed eu elit tempor, condimentum sem eget, ultrices nunc. Sed at mauris et erat feugiat blandit. Donec lacinia magna non malesuada tristique. Pellentesque ac dapibus risus, in elementum sapien.\r\n" + //
						"\r\n" + //
						"Nullam quis sem nec augue vehicula pretium ac sit amet lorem. Duis et dapibus felis, et laoreet turpis. Nam rutrum nibh lectus. Ut id dapibus neque. Fusce fermentum blandit sapien, lacinia congue dolor mattis sit amet. Maecenas diam mauris, consectetur eu vehicula vitae, vestibulum sit amet nisi. Integer aliquam semper dolor, fringilla tincidunt nulla dignissim nec. Donec quis turpis lacus. Suspendisse pretium ullamcorper sem, ac convallis diam egestas nec. Sed sollicitudin nisl rutrum blandit porta. Duis non elementum libero. Vestibulum egestas eleifend tellus, mattis feugiat nunc finibus sed. Integer magna nibh, volutpat quis eros vel, consequat posuere quam. Etiam ac consectetur tortor, non posuere ante.";
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
