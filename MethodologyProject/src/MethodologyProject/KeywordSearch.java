package MethodologyProject;

		import java.io.BufferedReader;
		import java.io.File;
		import java.io.FileReader;
		import java.io.IOException;
		import java.util.Scanner;

public class KeywordSearch {
    /*public static void main(String[] args) throws FileNotFoundException {
        File myFile = new File("Recipes");

        Scanner fileScanner = new Scanner(myFile);
        searchForRecipesInFile(myFile);
    } */

	public void searchForRecipesInFile(File myFile) {
		String[] keywords = AskRecipe();
		String breakline = "---";
		boolean shouldPrint = false;

		FindAndPrintrecipe(myFile, keywords, breakline, shouldPrint);
	}

	public void FindAndPrintrecipe(File myFile, String[] keywords, String breakline, boolean shouldPrint) {
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

	public String[] AskRecipe() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("what recipe would you like to look for?");
		String recipeRequest = scanner.nextLine();
		String[] keywords = {recipeRequest};
		return keywords;
	}


}
