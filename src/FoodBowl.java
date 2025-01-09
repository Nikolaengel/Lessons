public class FoodBowl {
    private int foodAmount;

    public FoodBowl(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0); // Защита от отрицательного количества еды
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды.");
        }
    }

    public void decreaseFood(int amount) {
        if (amount > 0 && foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            System.out.println("Еды в миске недостаточно!");
        }
    }
}
