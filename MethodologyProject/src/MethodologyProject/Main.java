package MethodologyProject;
		import java.time.LocalDate;
		import java.util.ArrayList;
		import java.util.Scanner;
		import java.io.*;

public class Main {
	public static ArrayList<String> recipeNameList;
	static File myFile = new File("Recipes");

	static KeywordSearch kws = new KeywordSearch();
	static RecipeManager recipeManager = new RecipeManager();
	static IngredientSearch ingredientSearchObj = new IngredientSearch();

	public static void main(String[] args) throws IOException {
		//open the recipe file that contains all the recipes and their info
		String filename = "Recipes";
		FileWriter fwriter = new FileWriter(filename, true);

		Scanner keyboard = new Scanner(System.in);
		//Add to recipes list from the file
		recipeNameList = addRecipeNamesToList(false);
		for (String recName : recipeNameList){
			//make a Recipe object and add it to the recipe list
			Recipe rec = new Recipe();
			rec.setName(recName);
			rec.setIngredients(kws.FindIngredientsForRecipe(myFile, recName));
			rec.setInstructions(kws.FindInstructionsForRecipe(myFile, recName));
			rec.setAllRatings(kws.FindRatingsForRecipe(myFile, recName));
			recipeManager.addRecipe(rec);
		}


		//do while loop to display menu so long as user wants to repeat menu options
		String repeat;
		do {
			menu(keyboard, fwriter);
			keyboard.nextLine();//consumes buffer 
			System.out.println("Would you like to view the menu again?  ('yes/no')");
			repeat = keyboard.nextLine();

		} while (repeat.equalsIgnoreCase("yes"));

		//close the recipe text file
		fwriter.close();
	}//closes main method

	public static void menu(Scanner keyboard, FileWriter fwriter) throws IOException {

		System.out.println("Please enter your choice below: ('1' or '2' or '3' or '4') \n1. "
				+ "find recipes \n2. submit recipes \n3. Find recipes by specific ingredient. \n4. Rate a recipe. \n5. View Popular Recipes. ");
		int choice = keyboard.nextInt();

		if (choice == 1) {
			printAllRecipes();
			FindRecipe(keyboard);

			//findRecipes(keyboard, recipeManager);
		} else if (choice == 2) {
			submitRecipes(keyboard, fwriter);
		} else if (choice == 3) {
			findRecipesByIngredient(keyboard);
		} else if (choice == 4) {
			rateRecipe(keyboard);
		} else if (choice == 5) {
			viewPopularRecipes(keyboard);
		}else {
			System.out.println("\nERROR! Invalid Choice! Choose Again");
			menu(keyboard, fwriter);
		}
	}// closes menu

	private static void FindRecipe(Scanner keyboard) throws FileNotFoundException {
		System.out.println("Which recipe would you like to look for?");
		keyboard.nextLine();
		String recName = keyboard.nextLine();
		Recipe recipe = recipeManager.getRecipeByName(recName);
		System.out.println(recipe);
		System.out.println("press enter to continue...");
	}

	private static void printAllRecipes() {
		for(Recipe recipe : recipeManager.getAllRecipes()){
			System.out.println(recipe.getName());
		}
	}


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
					System.out.println("Error! Please enter a number for amount of ingredients.");
				}
			} else {
				System.out.println("Error! Please enter a number for amount of ingredients.");
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
		recipeManager.addRecipe(recipe);

		System.out.println("Recipe is getting submitted!");

//need code here that will access a recipe method that adds this newly created recipe to the recipe array list

	}//closes submitRecipes method


	public static void findRecipesByIngredient(Scanner keyboard) throws IOException {
		System.out.println("Enter ingredient to find recipes");
		String ingredient = keyboard.next();
		ArrayList<String> matchingRecipes = recipeManager.searchRecipesByIngredient(ingredient);
		for(String recipe : matchingRecipes){
			System.out.print(recipe + " | ");
		}
		System.out.println();
		//create a recipe manager object
		//RecipeManager recipeManager = new RecipeManager();
		/*recipeNameList = addRecipeNamesToList(true);
		ingredientSearchObj.body(recipeNameList);*/
		/*String again;
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
		}*/
	}

	public static void rateRecipe (Scanner keyboard) throws IOException {
		//create a recipe manager object
		printAllRecipes();
		System.out.println("Which recipe below would you like to rate? ");
		keyboard.nextLine();
		String recipeGettingRated = keyboard.nextLine();

		System.out.println("Rate the recipe from 1-5 ");
		int rating = keyboard.nextInt();
		while (rating < 1 || rating > 10) {
			System.out.println("Error! invalid rating number");
			System.out.println("Rate the recipe from 1-5 ");
			rating = keyboard.nextInt();
		}
		Recipe recipeToSetRating = recipeManager.getRecipeByName(recipeGettingRated);
		if (recipeToSetRating == null) {
			System.out.println("Sorry, you entered an invalid name for recipe. Try again. ");
			recipeToSetRating = recipeManager.getRecipeByName(recipeGettingRated);
		}
		recipeToSetRating.setRating(rating);
	}

	private static void viewPopularRecipes(Scanner keyboard) {
		//get the current date
		LocalDate currentDate = LocalDate.now();

		//determine the season based on the current date
		String season = getSeason(currentDate);
		System.out.println("Current season: " + season);


		//reads the recipe based on the season
		String recipe = getRecipeForSeason(season);

		//print the popular recipe
		if (recipe != null) {
			System.out.println("Popular Recipe for " + season + ": " + recipe);
		} else {
			System.out.println("No popular recipe available for the current season.");
		}

	}

	//This method determines what season it is based off of the local date/time.
	//depending on calendar guidelines is when the season is
	private static String getSeason(LocalDate date) {
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();

		if ((month == 3 && day >= 20) || (month > 3 && month < 6) || (month == 6 && day < 21)) {
			return "spring";
		} else if ((month == 6 && day >= 21) || (month > 6 && month < 9) || (month == 9 && day < 22)) {
			return "summer";
		} else if ((month == 9 && day >= 22) || (month > 9 && month < 12) || (month == 12 && day < 21)) {
			return "fall";
		} else {
			return "winter";
		}
	}

	//method to print out the prespecified recipe based off of time of year
	private static String getRecipeForSeason(String season) {
		String recipe;

		if ("fall".equalsIgnoreCase(season)) {
			recipe = PopularRecipes.getSoupRecipe();
		} else if ("winter".equalsIgnoreCase(season)) {
			recipe = PopularRecipes.getHotChocolateRecipe();
		} else if ("spring".equalsIgnoreCase(season)) {
			recipe = PopularRecipes.getSmoothieRecipe();
		} else if ("summer".equalsIgnoreCase(season)) {
			recipe = PopularRecipes.getLemonadeRecipe();
		} else {
			return null;
		}

		return recipe;
	}


	//method that reads through file to add all the recipe names to a list
	//needs to be called - everytime menu is called
	public static ArrayList<String> addRecipeNamesToList (boolean printRecipe) throws IOException {
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
				if (printRecipe)
					System.out.println(separator);
				//add the recipe name to the arrayList
				recipeNamesList.add(separator);
			}
		}

		//close the reader
		reader.close();

		//prints
		/*System.out.println("Recipe Names:");
		for (String names : recipeNamesList) {
			System.out.println(names);
		}*/
		return recipeNamesList;
	}
}
