import java.util.*;

public class TextAnalyzer {
    public static void main(String[] args) {
        System.out.println("Welcome to text Analyzer");
        String paragraph = "Education is evolving rapidly in the digital age. Online learning platforms, interactive tools, and virtual classrooms have expanded access to knowledge beyond traditional boundaries. Students can now learn at their own pace, collaborate across borders, and explore subjects in dynamic ways. Despite these advancements, challenges remain — including screen fatigue, uneven access, and the need for self-discipline. As education continues to adapt, finding ways to support meaningful engagement is more important than ever.";

        countWords(paragraph);
        findMostFrequentWord(paragraph);
        getWordFrequencyMap(paragraph);
        findFirstUniqueWord(paragraph);

    }

    static void countWords(String text) {
        text = text.trim();
        if (text.isEmpty()) {
            System.out.println("No words found");
            return;
        }
        String[] words = text.split("\\s+");
        System.out.println("word count: " + words.length);
    }

    static void findMostFrequentWord(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z\\s]", "");
        String words[] = text.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        System.out.println("Most frequent word: " + mostFrequentWord + " (" + maxCount + " times)");

    }

    static void getWordFrequencyMap(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z\\s]", "");

        String words[] = text.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
    }

    static void findFirstUniqueWord(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z\\s]", "");
        String words[] = text.split("\\s+");

        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First unique word: " + entry.getKey());
                break;
            }
        }

    }
}
