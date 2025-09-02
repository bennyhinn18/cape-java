package com.cistron.training.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NetworkUtil {

	
	
	public void downloadWebPage(String websiteURL, String outputFilename) {
		
		try {

			URL url = new URL(websiteURL);
	      
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
			String line;
			  
			while ((line = reader.readLine()) != null) {
			   System.out.println(line);
			   writer.write(line);
			   writer.newLine();
			}
			reader.close();
			writer.close();
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
		
	}
	
	
	public void advancedDownload(String websiteURL, String outputFilename) {

	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(websiteURL))
	                .GET()
	                .build();

	        try {
	            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
	            if (response.statusCode() == 200) {
	                try (InputStream in = response.body();
	                     FileOutputStream fileOutputStream = new FileOutputStream(outputFilename)) {
	                    byte[] dataBuffer = new byte[1024];
	                    int bytesRead;
	                    while ((bytesRead = in.read(dataBuffer)) != -1) {
	                        fileOutputStream.write(dataBuffer, 0, bytesRead);
	                    }
	                    System.out.println("Website downloaded to: " + outputFilename);
	                }
	            } else {
	                System.err.println("Failed to download website. HTTP Status Code: " + response.statusCode());
	            }
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }		
	}
	
	
}
