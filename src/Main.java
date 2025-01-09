//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        // Проверяем бег и плавание
        dogBobik.run(400);
        dogBobik.swim(5);

        catMurzik.run(150);
        catMurzik.swim(5);

        // Создаем миску и добавляем еду
        FoodBowl bowl = new FoodBowl(20);
        bowl.addFood(10);

        // Коты кушают из миски
        Cat[] cats = {catMurzik, catBarsik};
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl);
        }

        // Выводим информацию о сытости котов
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        // Выводим статистику
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());

    }
}