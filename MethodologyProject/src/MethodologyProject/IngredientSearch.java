package MethodologyProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IngredientSearch {
	public static void body(ArrayList<String> recipeNameList) throws FileNotFoundException {

		File myFile = new File("Recipes");

		Scanner fileScanner = new Scanner(myFile);
		searchForIngredientsInFile(myFile, recipeNameList);
	}
	public static void searchForIngredientsInFile(File myFile, ArrayList<String> recipeNameList) {

		ArrayList<String> ingredientsArray = AskIngredient();
		String breakline = "---";
		boolean shouldPrint = false;

		FindAndPrintrecipe(myFile, ingredientsArray, breakline, shouldPrint, recipeNameList);
	}
	public static void FindAndPrintrecipe(File myFile, ArrayList<String> ingredientsArray, String breakline,
			boolean shouldPrint, ArrayList<String> recipeNameList) {

		try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
			String line;
			shouldPrint = false;
			String currentRecipe = null;

			ArrayList<String> recipesWithIngredient1 = new ArrayList<>();
			ArrayList<String> recipesWithIngredient2 = new ArrayList<>();
			ArrayList<String> recipesWithBothIngredients = new ArrayList<>();

			while ((line = br.readLine()) != null) {
				line = line.trim();

				if (recipeNameList.contains(line)) {
					// Found a recipe from the list, start processing
					shouldPrint = true;
					currentRecipe = line;
				} else if (line.isEmpty()) {
					// Empty line indicates the end of a recipe
					shouldPrint = false;
				}

				if (shouldPrint) {
					for (String ingredient : ingredientsArray) {
						if (line.equalsIgnoreCase(ingredient)) {
							if (ingredient.equalsIgnoreCase("ingredient1")) {
								recipesWithIngredient1.add(currentRecipe);
							} else if (ingredient.equalsIgnoreCase("ingredient2")) {
								recipesWithIngredient2.add(currentRecipe);
							}
						}
					}

					System.out.println("Recipes with Ingredient 1:");
					System.out.println(recipesWithIngredient1);

					System.out.println("Recipes with Ingredient 2:");
					System.out.println(recipesWithIngredient2);

				}
			}
		}

		catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
	}

	public static ArrayList<String> AskIngredient() {
		String again;
		String ingredient2 = "";

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an ingredient to find in recipes:");
		String ingredient = keyboard.next();
		keyboard.nextLine();
		ArrayList<String> ingredientsArray = new ArrayList<>();
		ingredientsArray.add(ingredient);

		System.out.println("Would you like to find another ingredient? ('yes'/'no')");
		again = keyboard.nextLine();
		if (again.equalsIgnoreCase("yes")) {
			System.out.println("Enter a second ingredient to find in recipes:");
			ingredient2 = keyboard.nextLine();
			ingredientsArray.add(ingredient2);

		}
		return ingredientsArray;
	}

}
