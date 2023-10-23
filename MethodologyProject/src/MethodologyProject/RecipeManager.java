package MethodologyProject;


import java.util.ArrayList;
import java.util.List;
//testing
//this class deals with the list of all recipes, including adding and removing recipes
public class RecipeManager {
    private List<Recipe> recipes = new ArrayList<>();

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }

    public List<Recipe> getAllRecipes(){
        return recipes;
    }

    // Add methods for searching, editing, and deleting recipes
    public void deleteRecipe(Recipe recipe){
        recipes.remove(recipe);
    }

}
