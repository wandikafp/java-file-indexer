package org.wandikafp;

import org.wandikafp.rule.IndexingRule;
import org.wandikafp.rule.LongWordIndexingRule;
import org.wandikafp.rule.UpperCaseWordIndexingRule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IndexingSystem {
    private final List<IndexingRule> indexingRules = new ArrayList<>();
    public void addIndexingRule(IndexingRule rule) {
        indexingRules.add(rule);
    }
    public void indexFiles(String... filenames) {
        for (String filename : filenames) {
            File file = new File(filename);
            if (!file.exists() || !file.isFile()) {
                System.out.println("File not found: " + filename);
                continue;
            }

            System.out.println("Indexing file: " + filename);
            for (IndexingRule indexingRule : indexingRules) {
                indexingRule.rule(file);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No filename inputted, please follow command like below");
            System.out.println("Usage: java FileIndexer <file1> <file2> ...");
            return;
        }

        IndexingSystem indexingSystem = new IndexingSystem();
        indexingSystem.addIndexingRule(new UpperCaseWordIndexingRule());
        indexingSystem.addIndexingRule(new LongWordIndexingRule());

        indexingSystem.indexFiles(args);
    }
}