package MethodologyProject;


import java.util.ArrayList;
import java.util.List;
//testing
//this class deals with the list of all recipes, including adding and removing recipes
public class RecipeManager {
    private ArrayList<Recipe> recipes = new ArrayList<>();

    //constructor
    public RecipeManager(){
        recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }

    public ArrayList<Recipe> getAllRecipes(){
        return recipes;
    }

    // Add methods for searching, editing, and deleting recipes
    public void deleteRecipe(Recipe recipe){
        recipes.remove(recipe);
    }

    //method to retrieve recipe based on the name of the recipe passed in. It searches the array for requested recipe
    public Recipe getRecipeByName(String recipeName) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                return recipe;
            }
        }
        return null; // Recipe not found
    }

}
