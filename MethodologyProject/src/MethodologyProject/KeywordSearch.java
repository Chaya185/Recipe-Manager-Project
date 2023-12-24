package MethodologyProject;

		import java.io.BufferedReader;
		import java.io.File;
		import java.io.FileNotFoundException;
		import java.io.FileReader;
		import java.io.IOException;
		import java.util.ArrayList;
		import java.util.Scanner;

public class KeywordSearch {
    public static void body() throws FileNotFoundException {
        File myFile = new File("Recipes");

        Scanner fileScanner = new Scanner(myFile);
        searchForRecipesInFile(myFile);
    } 

	public static void  searchForRecipesInFile(File myFile) {
		String[] keywords = AskRecipe();
		String breakline = "---";
		boolean shouldPrint = false;

		FindAndPrintrecipe(myFile, keywords, breakline, shouldPrint);
	}

	public static ArrayList<String> FindIngredientsForRecipe(File myFile, String recipeName){
		try(BufferedReader br = new BufferedReader(new FileReader(myFile))){
			String line;
			ArrayList<String> ingredients = new ArrayList<>();
			boolean foundRecipe = false;
			String newline = System.getProperty("line.separator");
			while ((line = br.readLine()) != null){
				if (line.equalsIgnoreCase(recipeName)){
					foundRecipe = true;
				}
				if (foundRecipe && line.equalsIgnoreCase("Ingredients:")){
					//skip next line
					while(!line.equals("")){
						line = br.readLine();
						if (!line.equals(""))
							ingredients.add(line);
					}
					break;
				}
			}
			return ingredients;

		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
			return new ArrayList<String>();
		}
	}

	public static String FindInstructionsForRecipe(File myFile, String recipeName){
		try(BufferedReader br = new BufferedReader(new FileReader(myFile))){
			String line;
			String instructions = "";
			boolean foundRecipe = false;
			while ((line = br.readLine()) != null){
				if (line.equalsIgnoreCase(recipeName)){
					foundRecipe = true;
				}
				if (foundRecipe && line.equalsIgnoreCase("Instructions:")){
					while(line != null /*&& !line.contains("")*/){
						line = br.readLine();
						if (line != null /*&& !line.contains("")*/)
							instructions += line + "\n";
					}
					break;
				}
			}
			return instructions;

		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
			return "";
		}
	}

	public static ArrayList<Integer> FindRatingsForRecipe(File myFile, String recipeName){
		try(BufferedReader br = new BufferedReader(new FileReader(myFile))){
			String line;
			ArrayList<Integer> ratings = new ArrayList<Integer>();
			boolean foundRecipe = false;
			String newline = System.getProperty("line.separator");
			while ((line = br.readLine()) != null){
				if (line.equalsIgnoreCase(recipeName)){
					foundRecipe = true;
				}
				if (foundRecipe && line.equalsIgnoreCase("Rating:")){
					//skip next line
					while(line != null && !line.contains("---")){
						line = br.readLine();
						if (line != null && !line.contains("---"))
							ratings.add(Integer.parseInt(line));
					}
					break;
				}
			}
			return ratings;

		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
			return new ArrayList<Integer>();
		}
	}

	public static void FindAndPrintrecipe(File myFile, String[] keywords, String breakline, boolean shouldPrint) {
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

	public static String[] AskRecipe() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("what recipe would you like to look for?");
		String recipeRequest = scanner.nextLine();
		String[] keywords = {recipeRequest};
		return keywords;
	}


}
