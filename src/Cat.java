public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eatFromBowl(FoodBowl bowl) {
        if (bowl.getFoodAmount() >= 10) {
            bowl.decreaseFood(10);
            isFull = true;
            System.out.println(name + " покушал и теперь сыт.");
        } else {
            System.out.println(name + " не смог покушать, так как еды недостаточно.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}