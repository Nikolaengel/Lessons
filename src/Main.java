public class Main {

    public static void main(String[] args) {
        // 1. Задача: Работа с уникальными словами
        System.out.println("Задача 1: Уникальные слова");
        String[] words = {"яблоко", "банан", "яблоко", "груша", "банан", "вишня", "вишня", "персик", "слива", "персик"};
        UniqueWords.processWords(words);

        // Разделитель между задачами
        System.out.println("\n=======================\n");

        // 2. Задача: Телефонный справочник
        System.out.println("Задача 2: Телефонный справочник");
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи в справочник
        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Петров", "234-567");
        phoneBook.add("Сидоров", "345-678");
        phoneBook.add("Иванов", "789-012");

        // Выводим номера телефонов для каждой фамилии
        System.out.println("Номера Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Номера Петрова: " + phoneBook.get("Петров"));
        System.out.println("Номера Сидорова: " + phoneBook.get("Сидоров"));
        System.out.println("Номера Смирнова: " + phoneBook.get("Смирнов")); // Отсутствует в справочнике
    }

}
