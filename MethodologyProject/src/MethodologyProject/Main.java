
package MethodologyProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//hardcode Recipe objects
		// Create an Array with the ingredients
		/*String[] recipe1 = {"2 large eggs",
				"Salt and pepper to taste",
				"1/4 cup diced bell peppers",
				"1/4 cup diced onions",
				"1/4 cup diced tomatoes",
				"1/4 cup shredded cheese (e.g., cheddar or mozzarella)",
				"Cooking oil or butter for the pan"};
		StringArrayList stringArrayList1 = new StringArrayList(recipe1); */

		ArrayList<String> ingredients = new ArrayList<>();
		ingredients.add("2 large eggs");
		ingredients.add("Salt and pepper to taste");
		ingredients.add("1/4 cup diced bell peppers");
		ingredients.add("1/4 cup diced onions");
		ingredients.add("1/4 cup diced tomatoes");
		ingredients.add("1/4 cup shredded cheese (e.g., cheddar or mozzarella)");
		ingredients.add("Cooking oil or butter for the pan");

		Recipe recipe1 = new Recipe("Vegetable Omelet", ingredients, ("1. In a bowl, whisk the eggs and season with salt and pepper.\n" +
				"2. Heat a non-stick skillet over medium heat and add a little oil or butter.\n" +
				"3. Add the diced vegetables and sauté until they are tender.\n" +
				"4. Pour the whisked eggs over the vegetables and cook, swirling the pan to spread the eggs evenly.\n" +
				"5. When the edges start to set, sprinkle the shredded cheese on one half of the omelet.\n" +
				"6. Gently fold the other half of the omelet over the cheese and cook for a minute or two until the cheese melts.\n" +
				"\n"));

		String name;
		int number;
		Scanner keyboard = new Scanner(System.in);
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
	        
	        System.out.println("How many instructions does the recipe require?");
	        number = keyboard.nextInt();
	        
	        //for loop to get the instructions and add to list
		    String instructions = keyboard.nextLine();


		//create the object and pass to constructor
		Recipe recipe = new Recipe( name, ingredientsList, instructions);
			
		System.out.println();
		System.out.println(recipe.toString());
		
		//add the recipe to list of recipes using recipeManager
		RecipeManager addRecipeObj = new RecipeManager();
			addRecipeObj.addRecipe(recipe);
	
}
}
