package MethodologyProject;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KeywordSearch {
	public static void main(String[] args) throws FileNotFoundException {
		//String filePath = "/Users/saracousin/git/MethodologyProject/MethodologyProject/src/MethodologyProject/ChocChipCookies";
		//try {
		File myFile = new File("Recipes");

		Scanner fileScanner = new Scanner(myFile);
		// int numWinners = 104;
		//create the array
		// String[] names = new String[numWinners];

		// while loop to set the array values
		// int i = 0;
		//while (fileScanner.hasNextLine() && i < names.length) {
		//names[i] = fileScanner.nextLine();
		//i++;
		searchForRecipesInFile(myFile);
	}

	private static void searchForRecipesInFile(File myFile) {
		String[] keywords = AskRecipe();
		String breakline = "---";
		boolean shouldPrint = false;

		Printrecipe(myFile, keywords, breakline, shouldPrint);
	}

	private static void Printrecipe(File myFile, String[] keywords, String breakline, boolean shouldPrint) {
		try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
			String line;

			while ((line = br.readLine()) != null) {

				if (line.contains(breakline)) {
					// Found the "STOP" keyword, stop printing
					shouldPrint = false;
				}
				for (String keyword : keywords) {
					if (line.equalsIgnoreCase(keyword)) {
						// Found the "cookies" keyword, start printing
						shouldPrint = true;
						break;
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

	private static String[] AskRecipe() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("what recipe would you like to look for?");
		String recipeRequest = scanner.nextLine();
		String[] keywords = {recipeRequest};
		return keywords;
	}

	//this method is used to read through the file and find all the recipe names. It displays the recipe names and adds them to an arrayList
	private static void FindAndPrintRecipeName(File myFile) {
		String separator = "---";
		ArrayList<String> recipeNames = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
			String line;

			while ((line = br.readLine()) != null) {

				if (line.contains(separator)) {
					// Found the separator, print the next line which is a recipe name
					line = br.readLine();
					System.out.println(line);
					//add the recipe name to the arrayList
					recipeNames.add(line);
				}

			}
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
	}
}