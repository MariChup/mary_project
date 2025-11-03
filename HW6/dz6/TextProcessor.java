package org.example.dz6;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class TextProcessor {


        private final Path filePath;

        public TextProcessor(String fileName) {
            this.filePath = Path.of(fileName);
        }

        
        public List<String> readWords() {
            List<String> words = new ArrayList<>();
            try {
              
                String text = Files.readString(filePath);

                
                text = text.toLowerCase();


                text = text.replaceAll("[^a-zа-яё0-9\\s]", " ");

               
                String[] parts = text.split("\\s+");

                for (String w : parts) {
                    if (!w.isBlank()) {
                        words.add(w);
                    }
                }

            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
            }

            return words;
        }

       
        public List<String> sortWords(List<String> words) {
            return words.stream()
                    .sorted(Comparator
                            .comparingInt(String::length)
                            .reversed()
                            .thenComparing(String::compareTo))
                    .toList();
        }

        
        public Map<String, Long> countWords(List<String> words) {
            Map<String, Long> frequency = new LinkedHashMap<>();

            words.stream()
                    .forEach(word -> frequency.put(word, frequency.getOrDefault(word, 0L) + 1));

            return frequency;
        }

        
        public List<String> findLongestWords(List<String> words) {
            int maxLength = words.stream()
                    .mapToInt(String::length)
                    .max()
                    .orElse(0);

            return words.stream()
                    .filter(w -> w.length() == maxLength)
                    .distinct()
                    .toList();
        }
    }

