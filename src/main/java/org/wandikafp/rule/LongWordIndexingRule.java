package org.wandikafp.rule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LongWordIndexingRule implements IndexingRule {
    public int getLongWordCount() {
        return longWordCount;
    }

    private int longWordCount;
    @Override
    public void rule(File file) {
        longWordCount = 0;
        System.out.println("Words longer than 5 characters:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > 5) {
                        longWordCount++;
                        System.out.println(word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
