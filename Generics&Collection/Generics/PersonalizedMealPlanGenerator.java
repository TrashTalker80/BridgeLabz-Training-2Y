import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getPlanType();
    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    private String dishName;

    public VegetarianMeal(String dishName) {
        this.dishName = dishName;
    }

    public String getPlanType() {
        return "Vegetarian";
    }

    public boolean isValid() {
        return dishName != null && !dishName.isEmpty();
    }

    @Override
    public String toString() {
        return dishName + " [" + getPlanType() + "]";
    }
}

class VeganMeal implements MealPlan {
    private String dishName;

    public VeganMeal(String dishName) {
        this.dishName = dishName;
    }

    public String getPlanType() {
        return "Vegan";
    }

    public boolean isValid() {
        return dishName != null && !dishName.isEmpty();
    }

    @Override
    public String toString() {
        return dishName + " [" + getPlanType() + "]";
    }
}

class KetoMeal implements MealPlan {
    private String dishName;

    public KetoMeal(String dishName) {
        this.dishName = dishName;
    }

    public String getPlanType() {
        return "Keto";
    }

    public boolean isValid() {
        return dishName != null && !dishName.isEmpty();
    }

    @Override
    public String toString() {
        return dishName + " [" + getPlanType() + "]";
    }
}

class HighProteinMeal implements MealPlan {
    private String dishName;

    public HighProteinMeal(String dishName) {
        this.dishName = dishName;
    }

    public String getPlanType() {
        return "High-Protein";
    }

    public boolean isValid() {
        return dishName != null && !dishName.isEmpty();
    }

    @Override
    public String toString() {
        return dishName + " [" + getPlanType() + "]";
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        if (meal.isValid()) {
            meals.add(meal);
            System.out.println("Added: " + meal);
        } else {
            System.out.println("Invalid meal, not added");
        }
    }

    public void displayMeals() {
        System.out.println("Meal Plan:");
        for (T meal : meals) {
            System.out.println(" - " + meal);
        }
    }
}

public class PersonalizedMealPlanGenerator {
    public static <T extends MealPlan> boolean validateMealPlan(Meal<T> mealPlan, int minMeals) {
        return mealPlan != null;
    }

    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal, String planName) {
        System.out.println("\nGenerating " + planName + " meal plan...");
        meal.displayMeals();
        System.out.println("Meal plan generated successfully!");
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianPlan = new Meal<>();
        vegetarianPlan.addMeal(new VegetarianMeal("Vegetable Curry"));
        vegetarianPlan.addMeal(new VegetarianMeal("Paneer Tikka"));
        generateMealPlan(vegetarianPlan, "Vegetarian");

        Meal<VeganMeal> veganPlan = new Meal<>();
        veganPlan.addMeal(new VeganMeal("Tofu Stir-Fry"));
        veganPlan.addMeal(new VeganMeal("Quinoa Salad"));
        generateMealPlan(veganPlan, "Vegan");

        Meal<KetoMeal> ketoPlan = new Meal<>();
        ketoPlan.addMeal(new KetoMeal("Grilled Salmon"));
        ketoPlan.addMeal(new KetoMeal("Avocado Salad"));
        generateMealPlan(ketoPlan, "Keto");

        Meal<HighProteinMeal> proteinPlan = new Meal<>();
        proteinPlan.addMeal(new HighProteinMeal("Chicken Breast"));
        proteinPlan.addMeal(new HighProteinMeal("Egg Whites"));
        generateMealPlan(proteinPlan, "High-Protein");
    }
}
