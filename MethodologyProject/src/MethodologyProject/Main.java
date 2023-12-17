package MethodologyProject;
		import java.util.ArrayList;
		import java.util.Scanner;
		import java.io.*;

public class Main {
	public static ArrayList<String> recipeNameList;
	public static void main(String[] args) throws IOException {
		//open the recipe file that contains all the recipes and their info
		String filename = "Recipes";
		FileWriter fwriter = new FileWriter(filename, true);

		Scanner keyboard = new Scanner(System.in);

		//do while loop to display menu so long as user wants to repeat menu options
		String repeat;
		do {
			menu(keyboard, fwriter);
			System.out.println("Would you like to view the menu again?  ('yes/no')");
			repeat = keyboard.nextLine();

		} while (repeat.equalsIgnoreCase("yes"));

		//close the recipe text file
		fwriter.close();
	}//closes main method

	public static void menu(Scanner keyboard, FileWriter fwriter) throws IOException {

		System.out.println("Please enter your choice below: ('1' or '2' or '3' or '4') \n1. "
				+ "find recipes \n2. submit recipes \n3. Find recipes by specific ingredient. \n4. Rate a recipe. ");
		int choice = keyboard.nextInt();

		if (choice == 1) {
			System.out.println();
			recipeNameList = addRecipeNamesToList();
			keyboard.nextLine();

			//findRecipes(keyboard, recipeManager);
		} else if (choice == 2) {
			submitRecipes(keyboard, fwriter);
		} else if (choice == 3) {
			findRecipesByIngredient(keyboard);
		} else if (choice == 4) {
			rateRecipe(keyboard);
		} else {
			System.out.println("\nERROR! INVALID CHOICE.");
			menu(keyboard, fwriter);
		}
	}// closes menu

	public static void submitRecipes(Scanner keyboard, FileWriter fwriter) throws IOException {
		String name;
		int number = 0; //initialize with a default value
		boolean validInput = false;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		//consume buffer
		keyboard.nextLine();
		System.out.println("Please enter the name of the recipe: ");
		name = keyboard.nextLine();
//maybe we can add the recipe name to Rina's arrayList created in her new method?
		//listRecipes.add(name);

		//input validation, only an int is entered
		while (!validInput) {
			System.out.println("How many ingredients does this recipe require?");
			if (keyboard.hasNextInt()) {
				number = keyboard.nextInt();
				if (number > 0) {
					validInput = true;
				} else {
					System.out.println("Error! Please enter an int for number of ingredients.");
				}
			} else {
				System.out.println("Error! Please enter an int for number of ingredients.");
				keyboard.nextLine(); // consume the invalid input
			}
		}
		ArrayList<String> ingredientsList = new ArrayList<>();

		//for loop to get the ingredients and add to list
		keyboard.nextLine();
		for (int i = 1; i <= number; i++) {
			System.out.println("Enter ingredient " + i + ":");
			ingredientsList.add(buf.readLine()); //used the buffer so that it doesnt truncate an ingredient with several words
		}

		System.out.println("Enter the recipe instructions: ");
		String instructions = keyboard.nextLine();

		//create the object and pass to constructor
		Recipe recipe = new Recipe(name, ingredientsList, instructions);

		System.out.println();
		System.out.println(recipe);

		//add the recipe to the file using the toString method
		PrintWriter outputFile = new PrintWriter(fwriter);
		outputFile.println("\n---------");
		outputFile.println(recipe);

		//add the recipe to list of recipes using recipeManager
		RecipeManager addRecipeObj = new RecipeManager();
		addRecipeObj.addRecipe(recipe);

		System.out.println("Recipe is getting submitted!");

//need code here that will access a recipe method that adds this newly created recipe to the recipe array list

	}//closes submitRecipes method


	public static void findRecipesByIngredient(Scanner keyboard) {
		//create a recipe manager object
		RecipeManager recipeManager = new RecipeManager();

		String again;
		String ingredient2 = "";
		System.out.println("Enter an ingredient to find in recipes:");
		String ingredient = keyboard.next();
		keyboard.nextLine();
		System.out.println("Would you like to find another ingredient? ('yes'/'no')");
		again = keyboard.nextLine();
		if (again.equalsIgnoreCase("yes")) {
			System.out.println("Enter a second ingredient to find in recipes:");
			ingredient2 = keyboard.nextLine();
			ArrayList<String> recipes = recipeManager.searchRecipesByIngredient(ingredient, ingredient2);
			System.out.println("Recipes with " + ingredient + " and " + ingredient2 + " ingredient: " + String.join(",", recipes));
			keyboard.nextLine();
		} else {
//ENABLE SEARCH FOR 1 RECIPE
			//ArrayList<String> recipes = recipeManager.searchRecipesByIngredient(ingredient);
			//System.out.println("Recipes with ingredient: " + ingredient  + String.join(",", recipes));
			keyboard.nextLine();
		}
	}

	public static void rateRecipe (Scanner keyboard) throws FileNotFoundException {
		//create a recipe manager object
		RecipeManager recipeManager = new RecipeManager();

//USE THE SAME ALGORITHM THAT DISPLAYS THE LIST OF RECIPES FROM THE RECIPE FILE TO DISPLAY THE OPTIONS
		System.out.println("Which recipe would you like to rate? ");
		String recipeGettingRated = keyboard.nextLine();
		System.out.println("Rate the recipe from 1-10 ");
		int rating = keyboard.nextInt();
		while (rating < 1 || rating > 10) {
			System.out.println("Error! invalid rating number");
			System.out.println("Rate the recipe from 1-10 ");
			rating = keyboard.nextInt();
		}
		//commented out becuase it's an error
		//requestedRecipe.setRating(rating);
		keyboard.nextLine();
	}

	//method that reads through file to add all the recipe names to a list
	//needs to be called - everytime menu is called
	public static ArrayList<String> addRecipeNamesToList () throws IOException {
		String filePath = "Recipes";

		//initialize ArrayList
		ArrayList<String> recipeNamesList = new ArrayList<>();

		//opens file
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		//flag to indicate breakpoint
		boolean foundBreakPoint = false;

		//reads each line
		String separator;
		while ((separator = reader.readLine()) != null) {

			if (separator.contains("-----")) {
				// Found the separator, read and print the next line which is a recipe name
				separator = reader.readLine();
				System.out.println(separator);
				//add the recipe name to the arrayList
				recipeNamesList.add(separator);
			}
		}

		//close the reader
		reader.close();

		//prints
		System.out.println("Recipe Names:");
		for (String names : recipeNamesList) {
			System.out.println(names);
		}
		return recipeNamesList;
	}
}