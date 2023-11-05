package MethodologyProject;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class KeywordSearch {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\goldp\\OneDrive\\Documents\\semester 3 (Fall 23)\\Computer Methodology\\compMeth\\bin\\MethodologyProject\\ChocChipCookies.txt";
    
        String[] keywords = {"Pizza"};
        String breakline = "STOP";
        boolean shouldPrint = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = br.readLine()) != null){// && !line.contains(breakline)) {
            	
            	if (line.contains(breakline)) {
                    // Found the "STOP" keyword, stop printing
                    shouldPrint = false;
                }
            	 for (String keyword : keywords) {
                     if (line.contains(keyword)) {
                         // Found the "cookies" keyword, start printing
                         shouldPrint = true;
                     }
                 }
            	
            	 if (shouldPrint) {
                     System.out.println(line);
                 }
            	 
                }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
