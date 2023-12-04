
package MethodologyProject;

import java.util.ArrayList;
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

		createRecipeList(recipeManager); //call the method to create all recipes objects

		//createRecipeList(); //call method to add all hardcoded recipes to an arraylist
		Scanner keyboard = new Scanner(System.in);

		//do while loop to display menu so long as user wants to repeat menu options
		String repeat;
		do {
//ADD CODE TO display list of recipes
			menu(keyboard, recipeManager, fwriter, listRecipes);
			System.out.println("Would you like to find another recipe, submit a recipe or rate a recipe?  ('yes/no') ");
			repeat = keyboard.nextLine();
			
		} while (repeat.equalsIgnoreCase("yes"));

		//close the recipe text file
		fwriter.close();
	}//closes main method

	public static void menu(Scanner keyboard, RecipeManager recipeManager, FileWriter fwriter, ArrayList<String> listRecipes) throws IOException {

		System.out.println("Please enter your choice below: ('1' or '2' or '3') \n1. "
				+ "find recipes \n2. submit recipes \n3. Find recipes by specific ingredient. \n4. Rate a recipe. ");
		int choice = keyboard.nextInt();

		if (choice == 1) {
			findRecipes(keyboard, recipeManager);
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

	private static void rateRecipe(Scanner keyboard, RecipeManager recipeManager) {
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
		System.out.println("Would you like to find another ingredient ");
		again = keyboard.nextLine();
		if (again.equalsIgnoreCase("yes")) {
			System.out.println("enter an ingredient to find recipes");
			 ingredient2= keyboard.next();
			}
		
		
		ArrayList<String> recipes = recipeManager.searchRecipesByIngredient(ingredient, ingredient2 );
		System.out.println("Recipes with " + ingredient +" or " + ingredient2 +" ingredient: " + String.join(",", recipes));
	}
		
		
	public static void findRecipes(Scanner keyboard, RecipeManager recipeManager) {
		Recipe requestedRecipe = getRecipeFromList(keyboard, recipeManager);

		if (requestedRecipe == null) {
			System.out.println("Error! Can't find that recipe in the list");
		} else {
			System.out.println(requestedRecipe.toString());
		}

		//call the method to turn the array of recipes into an arrayList.
		//ArrayList listOfRecipes = StringArrayList(listRecipes);



//need to add code that will find certain recipes in the array list and print them 
		
		}//closes findRecipes method

	private static Recipe getRecipeFromList(Scanner keyboard, RecipeManager recipeManager) {
		//add the names of the recipes to an array list
		ArrayList<String> listRecipes = new ArrayList<>();
		listRecipes.add("Omelet");
		listRecipes.add("Pasta");
		listRecipes.add("Chicken");
		listRecipes.add("Smoothie");
		listRecipes.add("Biscotti");
		// Using a for loop to display the strings in the array
		for (int i = 0; i < listRecipes.size(); i++) {
			System.out.println(listRecipes.get(i));
		}
		keyboard.nextLine();
		System.out.println("Choose from the above recipes: (type the word) ");
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
			listRecipes.add(name);
			
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
		System.out.println(recipe.toString());

		//add the recipe to the file using the toString method
		PrintWriter outputFile = new PrintWriter(fwriter);
		outputFile.println(recipe);
		outputFile.println("\n----------------");
		
		//add the recipe to list of recipes using recipeManager
		RecipeManager addRecipeObj = new RecipeManager();
			addRecipeObj.addRecipe(recipe);
			
			System.out.println("recipe is getting submitted!");
			
//need code here that will access a recipe method that adds this newly created recipe to the recipe array list


		}//closes submitRecipes method 


	public static void createRecipeList(RecipeManager recipeManager) {
		//hardcode Recipe objects


		//OMELET
		// Create an Array with the ingredients
		String[] omeletIngredients = {"2 large eggs",
				"Salt and pepper to taste",
				"1/4 cup diced bell peppers",
				"1/4 cup diced onions",
				"1/4 cup diced tomatoes",
				"1/4 cup shredded cheese (e.g., cheddar or mozzarella)",
				"Cooking oil or butter for the pan"};

		//call the method to turn the array of ingredients into an arrayList.
		ArrayList ingredients1 = StringArrayList(omeletIngredients);
		Recipe omelet = new Recipe("Omelet", ingredients1, ("1. In a bowl, whisk the eggs and season with salt and pepper.\n" +
				"2. Heat a non-stick skillet over medium heat and add a little oil or butter.\n" +
				"3. Add the diced vegetables and sauté until they are tender.\n" +
				"4. Pour the whisked eggs over the vegetables and cook, swirling the pan to spread the eggs evenly.\n" +
				"5. When the edges start to set, sprinkle the shredded cheese on one half of the omelet.\n" +
				"6. Gently fold the other half of the omelet over the cheese and cook for a minute or two until the cheese melts.\n" +
				"\n"));

		//add the recipe to the list of recipes using recipeManager class
		recipeManager.addRecipe(omelet);


		//PASTA
		// Create an Array with the ingredients
		String[] pastaIngredients = {"1 box of pasta",
				"Salt to taste",
				"1/4 cup mozzarella cheese",
				"1/4 cup marinara sauce",
				"1 tsp butter",
				"2 tbs milk ",
				"1/2 tsp red pepper flakes",
				"1/2 tsp basil"};

		//call the method to turn the array of ingredients into an arrayList.
		ArrayList ingredients2 = StringArrayList(pastaIngredients);

		//create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
		Recipe pasta = new Recipe("Pasta", ingredients2, ("1. Boil a pot of water.\n" +
				"2. Add some salt and once boiled, add your pasta.\n" +
				"3. Cook pasta for about 11 minutes on medium flame.\n" +
				"4. Once cooked, drain your pasta and pour cold water over it.\n" +
				"5. Now add your marinara sauce, cheese, butter, milk, red pepper flakes, basil and salt.\n" +
				"6. Mix until the cheese melts.\n" +
				"\n"));

		//add the recipe to the list of recipes using recipeManager class
		recipeManager.addRecipe(pasta);

		//CHICKEN
		// Create an Array with the ingredients
		String[] chickenIngredients = {"4 boneless chicken breasts",
				"2 cups crushed pretzels",
				"1 cup all purpose flour",
				"2 eggs, beaten",
				"Salt and Pepper to taste",
				"cooking oil",
				"cooked rice for serving"};

		//call the method to turn the array of ingredients into an arrayList.
		ArrayList ingredients3 = StringArrayList(chickenIngredients);

		//create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
		Recipe chicken = new Recipe("Chicken", ingredients3, ("1. Preheat your oven to 375 F.\n"+
				"2. Season the chicken breasts with salt and pepper\n"+
				"3. Dredge each chicken breast in flour, dip in eggs, and coat with crushed pretzels\n" +
				"4. Heat some cooking oil in a large oven-safe skillet over medium-high heat.\n"+
				"5. Add the chicken breasts and cook for 2-3 minutes on each side, or until they are golden brown.\n" +
				"6. Transfer the skillet to the preheated oven and bake for about 20 minutes, or until the chicken is cooked through.\n" +
				"7. Serve the pretzel-crusted chicken over cooked rice.\n" +
				"\n"));

		//add the recipe to the list of recipes using recipeManager class
		recipeManager.addRecipe(chicken);

		//SMOOTHIE
		// Create an Array with the ingredients
		String[] smoothieIngredients = {"1 mango, skin removed, cut into 1-inch dice, frozen\n" +
				"5 strawberries, cut half, frozen\n" +
				"1 cup diced pineapple\n" +
				"1 cup orange juice" };

		//call the method to turn the array of ingredients into an arrayList.
		ArrayList ingredients4 = StringArrayList(smoothieIngredients);

		//create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
		Recipe smoothie = new Recipe("Smoothie", ingredients4, ("Combine all ingredients in a blender and puree until smooth, about 2 to 3 minutes.\n" +
				"Drink immediately.\n") );

		//add the recipe to the list of recipes using recipeManager class
		recipeManager.addRecipe(smoothie);

		//BISCOTTI
		// Create an Array with the ingredients
		String [] biscottiIngredients = {"2 cups all-purpose flour\n" +
				"1 1/2 teaspoons baking powder\n" +
				"1/4 teaspoon salt\n" +
				"1/2 cup unsalted butter, softened\n" +
				"1 cup granulated sugar\n" +
				"2 large eggs\n" +
				"1 teaspoon vanilla extract\n" +
				"1 cup chopped nuts or dried fruits (e.g., almonds, pistachios, cranberries, or chocolate chips)"};

		//call the method to turn the array of ingredients into an arrayList.
		ArrayList ingredients5 = StringArrayList(biscottiIngredients);

		//create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
		Recipe biscotti = new Recipe("Biscotti", ingredients5, ("1. Preheat your oven to 350°F (175°C) and line a baking sheet with parchment paper.\n" +
				"2. In a bowl, whisk together the flour, baking powder, and salt.\n" +
				"3. In another bowl, beat the softened butter and sugar together until light and fluffy.\n" +
				"4. Beat in the eggs one at a time, followed by the vanilla extract.\n" +
				"5. Gradually add the dry ingredients and mix until well combined.\n" +
				"6. Stir in the nuts or dried fruits.\n" +
				"7. Divide the dough in half and shape each half into a log, about 12 inches long.\n" +
				"8. Place the logs on the prepared baking sheet and bake for about 25-30 minutes or until they are firm to the touch.\n" +
				"9. Let the logs cool for a few minutes, then slice them into biscotti about 1/2 inch thick.\n" +
				"10. Lay the biscotti on their sides and bake for an additional 10-12 minutes or until they're golden brown and crisp.\n" +
				"11. Allow the biscotti to cool completely before enjoying with your favorite hot beverage.\n" +
				"\n"));

		//add the recipe to the list of recipes using recipeManager class
		recipeManager.addRecipe(biscotti);

	}//closes the method create recipe list




	//this method accepts an array of strings, converts it to an arrayList and return the arrayList if prompted AKA what the find recipe method is technically doing.
	//method is used to create hardcoded recipes
	public static ArrayList StringArrayList(String[] stringArray) {
		ArrayList<String> stringList;
		stringList = new ArrayList<>();
		for (String str : stringArray) {
			stringList.add(str);
		}
		return stringList;
	}
		

}//closes class
		
