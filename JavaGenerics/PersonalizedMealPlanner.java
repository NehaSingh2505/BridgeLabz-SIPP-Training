
interface MealPlan {
    String getMealType();
}

// Subclasses
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }
}

// Generic Meal Container
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public String getMealDescription() {
        return "Meal Plan: " + meal.getMealType();
    }
}

// Utility class
class MealPlanUtil {
    public static <T extends MealPlan> Meal<T> generatePlan(T mealType) {
        return new Meal<>(mealType);
    }
}

// Main class
public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegPlan = MealPlanUtil.generatePlan(new VegetarianMeal());
        Meal<VeganMeal> veganPlan = MealPlanUtil.generatePlan(new VeganMeal());
        Meal<KetoMeal> ketoPlan = MealPlanUtil.generatePlan(new KetoMeal());

        System.out.println(vegPlan.getMealDescription());
        System.out.println(veganPlan.getMealDescription());
        System.out.println(ketoPlan.getMealDescription());
    }
}
