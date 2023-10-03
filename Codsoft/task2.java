import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text or provide a file path:");
        String userInput = sc.nextLine();

        String[] words = null;
        int wordCount = 0;

        if (userInput.isEmpty()) {
            System.out.println("Input is empty. Please provide text or a file path.");
        } else if (userInput.endsWith(".txt")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(userInput))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append(" ");
                }
                words = text.toString().split("[\\s\\p{Punct}]+");
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            words = userInput.split("[\\s\\p{Punct}]+");
        }

        if (words != null) {
            wordCount = words.length;
            System.out.println("Total words: " + wordCount);

            // To count unique words, you can use a Set
            Set<String> uniqueWords = new HashSet<>();
            for (String word : words) {
                uniqueWords.add(word.toLowerCase());
            }
            System.out.println("Unique words: " + uniqueWords.size());
            sc.close();
        }
    }
}