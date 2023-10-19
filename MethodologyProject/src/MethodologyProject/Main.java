
package MethodologyProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String name;
		int number;
		Scanner keyboard = new Scanner(System.in);
		  System.out.println("Please enter the name of the recipe: ");
			name=keyboard.nextLine();
			
			System.out.println("How many ingredients does this recipe require?");
			number=keyboard.nextInt();
			 List<String> ingredientsList = new ArrayList<>();

	       //for loop to get the ingredients and add to list
			   keyboard.nextLine();
	        for (int i = 1; i <= number; i++) {
	        	System.out.println("Enter ingredient " + i + ":");
	        	ingredientsList.add(keyboard.next());
	        }
	        
	        System.out.println("How many instructions does the recipe require?");
	        number = keyboard.nextInt();
	        List<String> instructionsList = new ArrayList<>();
	        
	        //for loop to get the instructions and add to list
	        keyboard.nextLine(); 
	        for (int i = 1; i <= number; i++) {
	        	System.out.println("Enter instruction " + i + ":");
	            instructionsList.add(keyboard.nextLine());
	        }

			//TEST COMMENT BY CHAYKI KANEVSKI
		//create the object and pass to constructor
		Recipe recipe = new Recipe( name, ingredientsList, instructionsList);
			
		System.out.println();
		System.out.println(recipe.toString());
		
		//add the recipe to list of recipes using recipeManager
		RecipeManager addRecipeObj = new RecipeManager();
			addRecipeObj.addRecipe(recipe);
	
}
}
