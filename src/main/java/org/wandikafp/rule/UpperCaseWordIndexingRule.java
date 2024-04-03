package org.wandikafp.rule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UpperCaseWordIndexingRule implements IndexingRule {
    public int getUpperCaseCount() {
        return upperCaseCount;
    }

    private int upperCaseCount;

    @Override
    public void rule(File file) {
        upperCaseCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
                        upperCaseCount++;
                    }
                }
            }
            System.out.println("Number of words that start with an uppercase letter: " + upperCaseCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
