package MethodologyProject;

/*
This class hardcodes in recipes for option 5 - view popular recipe, based off time of year
 */
public class PopularRecipes {

    //instantiates the variable names
    private static String soupRecipe = createSoupObject(); ;
    private static String smoothieRecipe = createSmoothieObject();
    private static String hotChocolateRecipe = createHotChocolateObject();
    private static String lemonadeRecipe = createLemonadeObject();

    //GETTERS TO RETURN THE OBJECTS
    public static String getSoupRecipe() {
        return soupRecipe;
    }

    public static String getSmoothieRecipe() {
        return smoothieRecipe;
    }

    public static String getHotChocolateRecipe() {
        return hotChocolateRecipe;
    }

    public static String getLemonadeRecipe() {
        return lemonadeRecipe;
    }

//HARDCODED RECIPE DETAILS
    private static String createSoupObject() {
        String recipeName = "Lentil Soup";
        String [] recipeIngredients = {"1 cup dried green or brown lentils, rinsed and drained\n" +
                "1 onion, diced\n" +
                "2 carrots, diced\n" +
                "2 celery stalks, diced\n" +
                "2 cloves garlic, minced\n" +
                "6 cups vegetable or chicken broth\n" +
                "1 teaspoon cumin\n" +
                "1 teaspoon paprika\n" +
                "Salt and pepper to taste\n" +
                "Fresh parsley for garnish (optional)"};

        String recipeInstructions = "1. In a large soup pot, heat some oil over medium heat. " +
                "Add the onion, carrots, and celery and cook until softened, about 5 minutes.\n" +
                "2. Add the garlic, cumin, and paprika, and cook for an additional 1-2 minutes.\n" +
                "3. Stir in the lentils and broth. Bring to a boil, then reduce the heat, cover, and simmer for about 25-30 minutes or until the lentils are tender.\n" +
                "4. Season with salt and pepper to taste.\n" +
                "5. Serve hot, garnished with fresh parsley if desired.";

        //combines it together
        soupRecipe = recipeName + "\n\nIngredients:\n" + String.join("\n", recipeIngredients) + "\n\nInstructions:\n" + recipeInstructions;
        return soupRecipe;
    }

    private static String createSmoothieObject() {
        String recipeName = "Smoothie";
        String [] recipeIngredients = {"1 mango, skin removed, cut into 1-inch dice, frozen\n" +
                "5 strawberries, cut half, frozen\n" +
                "1 cup diced pineapple\n" +
                "1 cup orange juice"};

        String smoothieInstructions = "Combine all ingredients in a blender and puree until smooth, about 2 to 3 minutes. Drink immediately.";

        //combines it together
        smoothieRecipe = recipeName + "\n\nIngredients:\n" + String.join("\n", recipeIngredients) + "\n\nInstructions:\n" + smoothieInstructions;
        return smoothieRecipe;
    }

    private static String createHotChocolateObject() {
        String recipeName = "Hot Chocolate";

        String[] recipeIngredients = {"4 cups milk (preferably whole or 2%)\n" +
                "¼ cup unsweetened cocoa powder\n" +
                "¼ cup granulated sugar\n" +
                "½ cup bittersweet or semisweet chocolate chips or chopped chocolate bar\n" +
                "¼ teaspoon pure vanilla extract"};

        String hotChocolateInstructions = "1. Place milk, cocoa powder and sugar in a small saucepan. \n2. Heat over medium/medium-low heat, " +
                "whisking frequently, until warm (but not boiling). \n3. Add chocolate chips and whisk constantly until the chocolate chips " +
                "melt and distribute evenly into the milk. \n4. Whisk in vanilla extract, serve immediately.";

        //combines it together
        hotChocolateRecipe = recipeName + "\n\nIngredients:\n" + String.join("\n", recipeIngredients) + "\n\nInstructions:\n" + hotChocolateInstructions;
        return hotChocolateRecipe;
    }

    private static String createLemonadeObject() {
        String recipeName = "Lemonade";
        //Lemonade (summer)
        String[] lemonadeIngredients = {"6 cups water divided\n" +
                "1 cup granulated sugar\n" +
                "1 cup fresh-squeezed lemon juice\n"};

        String lemonadeInstructions = "1. Combine 1 cup water and 1 cup sugar in a small saucepan. \n2. Place over medium-low heat and stir until " +
                "sugar is dissolved. \n3. Remove from heat and set aside, allow to cool for 10 minutes.\n" +
                "\n4. Pour 1 cup fresh-squeezed lemon juice into a pitcher. Add sugar/water mixture (simple syrup).\n" +
                "\n5. Add remaining 5 cups water and stir well. \n6. Pour over ice and serve, or transfer to refrigerator and allow to chill " +
                "several hours before serving.";

        //combines it together
        lemonadeRecipe = recipeName + "\n\nIngredients:\n" + String.join("\n", lemonadeIngredients) + "\n\nInstructions:\n" + lemonadeInstructions;
        return lemonadeRecipe;
    }
}
