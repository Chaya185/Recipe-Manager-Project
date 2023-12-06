package MethodologyProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Main {
	static ArrayList<String> listRecipes = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		//open the recipe file
//ADD THE CORRECT FILE NAME
		String filename = "Recipes";
		FileWriter fwriter = new FileWriter(filename, true);



		//create a recipe manager object
		RecipeManager recipeManager = new RecipeManager();

	//	createRecipeList(recipeManager); //call the method to create all recipes objects

		//createRecipeList(); //call method to add all hardcoded recipes to an arraylist
		Scanner keyboard = new Scanner(System.in);

		//do while loop to display menu so long as user wants to repeat menu options
		String repeat;
		do {
		//ADD CODE TO display list of recipes
			menu(keyboard, recipeManager, fwriter, listRecipes);
			System.out.println("Would you like to view menu again?  ('yes/no') ");
			repeat = keyboard.nextLine();
			
		} while (repeat.equalsIgnoreCase("yes"));

		//close the recipe text file
		fwriter.close();
	}//closes main method

	public static void menu(Scanner keyboard, RecipeManager recipeManager, FileWriter fwriter, ArrayList<String> listRecipes) throws IOException {

		System.out.println("Please enter your choice below: ('1' or '2' or '3' or '4') \n1. "
				+ "find recipes \n2. submit recipes \n3. Find recipes by specific ingredient. \n4. Rate a recipe. ");
		int choice = keyboard.nextInt();

		if (choice == 1) {
			System.out.println();
			getRecipeFromList(keyboard, recipeManager);
			//KeywordSearch key = new KeywordSearch();
	    	//KeywordSearch.main(null);
	    	keyboard.nextLine();
			
			//findRecipes(keyboard, recipeManager);
		} else if (choice == 2) {
			submitRecipes(keyboard, fwriter, Main.listRecipes);
		} else if (choice == 3) {
			findRecipesByIngredient(keyboard, recipeManager);
		}
		else if (choice == 4){
			rateRecipe(keyboard,recipeManager);
		}
		else {
			System.out.println("\nERROR! INVALID CHOICE.");
			menu(keyboard, recipeManager, fwriter, Main.listRecipes);
		}
	}// closes menu

	private static void rateRecipe(Scanner keyboard, RecipeManager recipeManager) throws FileNotFoundException {
		System.out.println("Which recipe would you like to rate? ");
		Recipe requestedRecipe = getRecipeFromList(keyboard, recipeManager);
		System.out.println("Rate the recipe from 1-10 ");
		int rating = keyboard.nextInt();
		while (rating <1 || rating > 10){
			System.out.println("Error! invalid rating number");
			System.out.println("Rate the recipe from 1-10 ");
			rating = keyboard.nextInt();
		}
		requestedRecipe.setRating(rating);
		keyboard.nextLine();
	}

	private static void findRecipesByIngredient(Scanner keyboard, RecipeManager recipeManager) {
		String again;
		String ingredient2="";
		System.out.println("enter an ingredient to find recipes");
		String ingredient = keyboard.next();
		keyboard.nextLine();
		System.out.println("Would you like to find another ingredient ");
		again = keyboard.nextLine();
		if (again.equalsIgnoreCase("yes")) {
			System.out.println("enter an ingredient to find recipes");
			 ingredient2= keyboard.next();
			}


		ArrayList<String> recipes = recipeManager.searchRecipesByIngredient(ingredient, ingredient2 );
		System.out.println("Recipes with " + ingredient +" and " + ingredient2 +" ingredient: " + String.join(",", recipes));
		keyboard.nextLine();
	}


	public static void findRecipes(Scanner keyboard, RecipeManager recipeManager) throws FileNotFoundException {
		 
		Recipe requestedRecipe = getRecipeFromList(keyboard, recipeManager);

		if (requestedRecipe == null) {
			System.out.println("Error! Can't find that recipe in the list");
		} else {
			System.out.println(requestedRecipe);
		}

		//call the method to turn the array of recipes into an arrayList.
		//ArrayList listOfRecipes = StringArrayList(listRecipes);
		//need to add code that will find certain recipes in the array list and print them
		
		}//closes findRecipes method

	private static Recipe getRecipeFromList(Scanner keyboard, RecipeManager recipeManager) throws FileNotFoundException {
		// Read recipes from the file and update listRecipes
		try (Scanner fileScanner = new Scanner(new File("Recipes"))) {
			while (fileScanner.hasNextLine()) {
				String recipeName = fileScanner.nextLine().trim();
				if (!listRecipes.contains(recipeName)) {
					listRecipes.add(recipeName);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: Recipes");
		}

		// Display the recipes
		System.out.println("Choose from the available recipes: ");
		for (String recipe : listRecipes) {
			System.out.println(recipe);
		}

		System.out.println("Enter the name of the recipe: ");
		String choice = keyboard.nextLine();
		Recipe requestedRecipe = recipeManager.getRecipeByName(choice);
		return requestedRecipe;
	}



	public static void submitRecipes(Scanner keyboard, FileWriter fwriter, ArrayList<String> listRecipes) throws IOException {

		String name;
		int number;
		
		//consume buffer
		keyboard.nextLine();
		  System.out.println("Please enter the name of the recipe: ");
			name=keyboard.nextLine();
			Main.listRecipes.add(name);
			
			System.out.println("How many ingredients does this recipe require?");
			number=keyboard.nextInt();
			 ArrayList<String> ingredientsList = new ArrayList<>();

	       //for loop to get the ingredients and add to list
			   keyboard.nextLine();
	        for (int i = 1; i <= number; i++) {
	        	System.out.println("Enter ingredient " + i + ":");
	        	ingredientsList.add(keyboard.next());
	        }
			//consume buffer
			keyboard.nextLine();

	        System.out.println("Enter the recipe instructions: ");
		    String instructions = keyboard.nextLine();


		//create the object and pass to constructor
		Recipe recipe = new Recipe( name, ingredientsList, instructions);
			
		System.out.println();
		System.out.println(recipe);

		//add the recipe to the file using the toString method
		PrintWriter outputFile = new PrintWriter(fwriter);
		outputFile.println(recipe);
		outputFile.println("\n----------------");
		
		//add the recipe to list of recipes using recipeManager
		RecipeManager addRecipeObj = new RecipeManager();
			addRecipeObj.addRecipe(recipe);

		listRecipes.add(name);

		System.out.println("recipe is getting submitted!");
			
//need code here that will access a recipe method that adds this newly created recipe to the recipe array list


		}//closes submitRecipes method 

	//this method accepts an array of strings, converts it to an arrayList and return the arrayList if prompted AKA what the find recipe method is technically doing.
	//method is used to create hardcoded recipes
	public static ArrayList StringArrayList(String[] stringArray) {
		ArrayList<String> stringList;
		stringList = new ArrayList<>();
        Collections.addAll(stringList, stringArray);
		return stringList;
	}
		

}//closes class
