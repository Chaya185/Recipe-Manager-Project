package MethodologyProject;

import java.util.List;

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

    //setters
    public void setName(){

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
}
