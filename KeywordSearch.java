package MethodologyProject;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class KeywordSearch {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\goldp\\OneDrive\\Documents\\semester 3 (Fall 23)\\Computer Methodology\\compMeth\\bin\\MethodologyProject\\ChocChipCookies.txt";
        //hello
        String[] keywords = {"cookies ", "sugar", "eggs"};

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Keyword found in this line, process accordingly
                        System.out.println("Line containing keyword '" + keyword + "': " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
