package MethodologyProject;

import java.util.ArrayList;

//this class takes the reciped and places them into objects
public class RecipeObjects {

    /*public static void createRecipeList() {
        //hardcode Recipe objects

        //create a recipe manager object
        //RecipeManager recipeManager = new RecipeManager();

        //OMELET
        // Create an Array with the ingredients
        String[] omeletIngredients = {"2 large eggs",
                "Salt and pepper to taste",
                "1/4 cup diced bell peppers",
                "1/4 cup diced onions",
                "1/4 cup diced tomatoes",
                "1/4 cup shredded cheese (e.g., cheddar or mozzarella)",
                "Cooking oil or butter for the pan"};

        //call the method to turn the array of ingredients into an arrayList.
        ArrayList ingredients1 = StringArrayList(omeletIngredients);
        Recipe omelet = new Recipe("Vegetable Omelet", ingredients1, ("1. In a bowl, whisk the eggs and season with salt and pepper.\n" +
                "2. Heat a non-stick skillet over medium heat and add a little oil or butter.\n" +
                "3. Add the diced vegetables and sauté until they are tender.\n" +
                "4. Pour the whisked eggs over the vegetables and cook, swirling the pan to spread the eggs evenly.\n" +
                "5. When the edges start to set, sprinkle the shredded cheese on one half of the omelet.\n" +
                "6. Gently fold the other half of the omelet over the cheese and cook for a minute or two until the cheese melts.\n" +
                "\n"));

        //add the recipe to the list of recipes using recipeManager class
        recipeManager.addRecipe(omelet);


        //PASTA
        // Create an Array with the ingredients
        String[] pastaIngredients = {"1 box of pasta",
                "Salt to taste",
                "1/4 cup mozzarella cheese",
                "1/4 cup marinera sauce",
                "1 tsp butter",
                "2 tbs milk ",
                "1/2 tsp red pepper flakes",
                "1/2 tsp basil"};

        //call the method to turn the array of ingredients into an arrayList.
        ArrayList ingredients2 = StringArrayList(pastaIngredients);

        //create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
        Recipe pasta = new Recipe("Mac and cheese", ingredients2, ("1. Boil a pot of water.\n" +
                "2. Add some salt and once boiled, add your pasta.\n" +
                "3. Cook pasta for about 11 minutes on medium flame.\n" +
                "4. Once cooked, drain your pasta and pour cold water over it.\n" +
                "5. Now add your marinera sauce, cheese, butter, milk, red pepper flakes, basil and salt.\n" +
                "6. Mix until the cheese melts.\n" +
                "\n"));

        //add the recipe to the list of recipes using recipeManager class
        recipeManager.addRecipe(pasta);

        //CHICKEN
        // Create an Array with the ingredients
        String[] chickenIngredients = {"4 boneless chicken breasts",
                "2 cups crushed pretzels",
                "1 cup all purpose flour",
                "2 eggs, beaten",
                "Salt and Pepper to taste",
                "cooking oil",
                "cooked rice for serving"};

        //call the method to turn the array of ingredients into an arrayList.
        ArrayList ingredients3 = StringArrayList(chickenIngredients);

        //create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
        Recipe chicken = new Recipe("Pretzel Chicken", ingredients3, ("1. Preheat your oven to 375 F.\n"+
                "2. Season the chicken breasts with salt and pepper\n"+
                "3. Dredge each chicken breast in flour, dip in eggs, and coat with crushed pretzels\n" +
                "4. Heat some cooking oil in a large oven-safe skillet over medium-high heat.\n"+
                "5. Add the chicken breasts and cook for 2-3 minutes on each side, or until they are golden brown.\n" +
                "6. Transfer the skillet to the preheated oven and bake for about 20 minutes, or until the chicken is cooked through.\n" +
                "7. Serve the pretzel-crusted chicken over cooked rice.\n" +
                "\n"));

        //add the recipe to the list of recipes using recipeManager class
        recipeManager.addRecipe(chicken);

        //SMOOTHIE
        // Create an Array with the ingredients
        String[] smoothieIngredients = {"1 mango, skin removed, cut into 1-inch dice, frozen\n" +
                "5 strawberries, cut half, frozen\n" +
                "1 cup diced pineapple\n" +
                "1 cup orange juice" };

        //call the method to turn the array of ingredients into an arrayList.
        ArrayList ingredients4 = StringArrayList(smoothieIngredients);

        //create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
        Recipe smoothie = new Recipe("Fruit Smoothie", ingredients4, ("Combine all ingredients in a blender and puree until smooth, about 2 to 3 minutes.\n" +
                "Drink immediately.\n") );

        //add the recipe to the list of recipes using recipeManager class
        recipeManager.addRecipe(smoothie);

        //BISCOTTI
        // Create an Array with the ingredients
        String [] biscottiIngredients = {"2 cups all-purpose flour\n" +
                "1 1/2 teaspoons baking powder\n" +
                "1/4 teaspoon salt\n" +
                "1/2 cup unsalted butter, softened\n" +
                "1 cup granulated sugar\n" +
                "2 large eggs\n" +
                "1 teaspoon vanilla extract\n" +
                "1 cup chopped nuts or dried fruits (e.g., almonds, pistachios, cranberries, or chocolate chips)"};

        //call the method to turn the array of ingredients into an arrayList.
        ArrayList ingredients5 = StringArrayList(biscottiIngredients);

        //create new recipe object passing in the recipe name, arrayList of ingredients and String of instructions
        Recipe biscotti = new Recipe("Biscotti", ingredients5, ("1. Preheat your oven to 350°F (175°C) and line a baking sheet with parchment paper.\n" +
                "2. In a bowl, whisk together the flour, baking powder, and salt.\n" +
                "3. In another bowl, beat the softened butter and sugar together until light and fluffy.\n" +
                "4. Beat in the eggs one at a time, followed by the vanilla extract.\n" +
                "5. Gradually add the dry ingredients and mix until well combined.\n" +
                "6. Stir in the nuts or dried fruits.\n" +
                "7. Divide the dough in half and shape each half into a log, about 12 inches long.\n" +
                "8. Place the logs on the prepared baking sheet and bake for about 25-30 minutes or until they are firm to the touch.\n" +
                "9. Let the logs cool for a few minutes, then slice them into biscotti about 1/2 inch thick.\n" +
                "10. Lay the biscotti on their sides and bake for an additional 10-12 minutes or until they're golden brown and crisp.\n" +
                "11. Allow the biscotti to cool completely before enjoying with your favorite hot beverage.\n" +
                "\n"));

        //add the recipe to the list of recipes using recipeManager class
        recipeManager.addRecipe(biscotti);

    }//closes the method create recipe list

*/


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

} //closes whole thing
