
package MethodologyProject;

        import MethodologyProject.KeywordSearch;
        import MethodologyProject.Recipe;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

//testing
//this class deals with the list of all recipes, including adding and removing recipes
public class RecipeManager {
    private ArrayList<MethodologyProject.Recipe> recipes;

    //constructor
    public RecipeManager(){
        recipes = new ArrayList<>();
    }

    public void addRecipe(MethodologyProject.Recipe recipe){
        recipes.add(recipe);
    }

    public ArrayList<MethodologyProject.Recipe> getAllRecipes(){
        return recipes;
    }

    // Add methods for searching, editing, and deleting recipes
    public void deleteRecipe(MethodologyProject.Recipe recipe){
        recipes.remove(recipe);
    }

    //method to retrieve recipe based on the name of the recipe passed in. It searches the array for requested recipe
    public Recipe getRecipeByName(String recipeName) throws FileNotFoundException {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                return recipe;
            }
        }
        return null;
    }

    public ArrayList<String> searchRecipesByIngredient(String ingredient){
        ArrayList<String> recipesWithIngredients = new ArrayList<String>();

        for (Recipe recipe : recipes) {
            for (String ingr : recipe.getIngredients()) {
                if (ingr.contains(ingredient)) {
                    recipesWithIngredients.add(recipe.getName());
                    break;
                }
            }
        }
        return recipesWithIngredients;
    }

}