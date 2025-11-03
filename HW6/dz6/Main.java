package org.example.dz6;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        TextProcessor processor = new TextProcessor("file_l6.txt");

        // 1. Считываем слова
        List<String> words = processor.readWords();
        if (words.isEmpty()) {
            System.out.println("Файл пуст или не содержит слов.");
            return;
        }

        // 2. Сортируем слова
        List<String> sorted = processor.sortWords(words);
        System.out.println("=== Отсортированные слова ===");
        sorted.forEach(System.out::println);

        // 3. Подсчитываем количество повторений
        System.out.println("\n=== Статистика повторений ===");
        Map<String, Long> count = processor.countWords(words);
        count.forEach((k, v) -> System.out.println(k + " — " + v));

        // 4. Самое длинное слово
        System.out.println("\n=== Самое длинное слово ===");
        List<String> longest = processor.findLongestWords(words);
        longest.forEach(System.out::println);
    }
}
