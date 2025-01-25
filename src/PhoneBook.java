import java.util.*;

 class PhoneBook {
    private final Map<String, List<String>> phoneBook;

    // Конструктор
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String surname, String phoneNumber) {
        phoneBook.putIfAbsent(surname, new ArrayList<>());
        phoneBook.get(surname).add(phoneNumber);
    }

    // Метод для получения номеров телефонов по фамилии
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptyList());
    }
}
