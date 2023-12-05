package MethodologyProject;


import java.io.FileNotFoundException;
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
    public Recipe getRecipeByName(String recipeName) throws FileNotFoundException {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                return recipe;
            }
        }
        KeywordSearch key = new KeywordSearch();
    	key.main(null);
        return null; // Recipe not found*/
    	
    	//return recipes ;
    }

    public ArrayList<String> searchRecipesByIngredient(String ingredient, String  ingredient2){
        ArrayList<String> recipesWithIngredients = new ArrayList<String>();

        for (Recipe recipe : recipes) {
            for (String ingr : recipe.getIngredients()) {
                if (ingr.contains(ingredient) ||ingr.contains(ingredient2)) {
                    recipesWithIngredients.add(recipe.getName());
                    break;
                }
            }
        }
        return recipesWithIngredients;
    }

}
