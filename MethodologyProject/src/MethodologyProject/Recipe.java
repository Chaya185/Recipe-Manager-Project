package MethodologyProject;

import java.util.ArrayList;
import java.util.List;

//this class is used to create recipe objects. It holds the recipe name, list of ingredients, and list of instructions
public class Recipe {
    private String name;
    private ArrayList<String> ingredients;
    private String instructions;
    private  int rating;
    //private recipeObject recipe;

    //constructor
    public Recipe(String name, ArrayList<String> ingredients, String instructions){
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
    //empty constructor 
    public Recipe() {
    }
    	
    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setIngredients(ArrayList<String> ingredients){
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions){
        this.instructions = instructions;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public  int getRating() {return rating; }
    //getters
    public String getName(){
        return name;
    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public String getInstructions(){
        return instructions;
    }
    
    //toString
    @Override
    public  String toString() {
        //sb.append("\nHere is the recipe: " );
        String sb = "\nRecipe Name: " + getName() +
                "\nIngredients: " + getIngredients() +
                "\nInstructions: " + getInstructions() +
                "\nRating: " + getRating();
    	return sb;
    	}
}
