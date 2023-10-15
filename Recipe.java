package MethodologyProject;

import java.util.List;

//this class is used to create recipe objects. It holds the recipe name, list of ingredients, and list of instructions
public class Recipe {
    private String name;
    private List<String> ingredients;
    private List<String> instructions;

    //constructor
    public Recipe(String name, List<String> ingredients, List<String> instructions){
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

    public void setIngredients(List<String> ingredients){
        this.ingredients = ingredients;
    }

    public void setInstructions(List<String> instructions){
        this.instructions = instructions;
    }

    //getters
    public String getName(){
        return name;
    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public List<String> getInstructions(){
        return instructions;
    }
    
    //toString
    @Override
    public  String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\nHere is the recipe for the information you provided: " );
    	sb.append("\nName of recipe: " + getName());
    	sb.append("\nIngredients: " + getIngredients());
    	sb.append("\nInstructions: " + getInstructions());;
    	return sb.toString();
    	}
}
