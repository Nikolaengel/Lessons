import java.util.*;

public class UniqueWords {
    // Метод для обработки массива слов и вывода уникальных слов с их количеством
    public static void processWords(String[] words) {
        // Создаем словарь для подсчета количества повторений
        Map<String, Integer> wordCount = new HashMap<>();

        // Подсчитываем количество вхождений каждого слова
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Выводим список уникальных слов
        System.out.println("Список уникальных слов:");
        for (String word : wordCount.keySet()) {
            System.out.println(word);
        }

        // Выводим количество вхождений каждого слова
        System.out.println("\nКоличество вхождений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
