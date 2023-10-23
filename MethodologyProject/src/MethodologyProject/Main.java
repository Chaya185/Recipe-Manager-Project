
package MethodologyProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		menu();
	}//closes main method 
	
	public static void menu () {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter your choice below: ");
		System.out.println("1. find recipes \n2. submit recipes  ");
		int choice = keyboard.nextInt();
		
		if (choice ==1) {
			findRecipes(keyboard);
		}
		else if (choice ==2) {
			submitRecipes(keyboard);
		}
		else {
			System.out.println("\nERROR! INVALID CHOICE.");
			menu();
		}
	}//closes menu 
		
		
		public static void findRecipes(Scanner keyboard) {
		//hardcode Recipe objects
		// Create an Array with the ingredients
		String[] recipeList1 = {"2 large eggs",
				"Salt and pepper to taste",
				"1/4 cup diced bell peppers",
				"1/4 cup diced onions",
				"1/4 cup diced tomatoes",
				"1/4 cup shredded cheese (e.g., cheddar or mozzarella)",
				"Cooking oil or butter for the pan"};

		//call the method to turn the array of ingredients into an arrayList.
		ArrayList ingredients1 = StringArrayList(recipeList1);

		//create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
		Recipe recipe1 = new Recipe("Vegetable Omelet", ingredients1, ("1. In a bowl, whisk the eggs and season with salt and pepper.\n" +
				"2. Heat a non-stick skillet over medium heat and add a little oil or butter.\n" +
				"3. Add the diced vegetables and sauté until they are tender.\n" +
				"4. Pour the whisked eggs over the vegetables and cook, swirling the pan to spread the eggs evenly.\n" +
				"5. When the edges start to set, sprinkle the shredded cheese on one half of the omelet.\n" +
				"6. Gently fold the other half of the omelet over the cheese and cook for a minute or two until the cheese melts.\n" +
				"\n"));

//need to add code that will find certain recipes in the array list and print them 
		
		}//closes findRecipes method 
		
		
		
		
		public static void submitRecipes(Scanner keyboard) {
		String name;
		int number;
		
		//consume buffer
		keyboard.nextLine();
		  System.out.println("Please enter the name of the recipe: ");
			name=keyboard.nextLine();
			
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
		
		//add the recipe to list of recipes using recipeManager
		RecipeManager addRecipeObj = new RecipeManager();
			addRecipeObj.addRecipe(recipe);
			
			System.out.println("recipe is getting submitted!");
			
//need code here that will access a recipe method that adds this newly created recipe to the recipe array list 
			
			
		}//closes submitRecipes method 


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
		
