package org.wandikafp.rule;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class LongWordIndexingRuleTest {
    @Test
    public void testIndexFile() {
        LongWordIndexingRule indexingRule = new LongWordIndexingRule();
        File file = new File("testFiles/testLongWords.txt");

        indexingRule.rule(file);
        // Expected long words in the test file: "elephant", "giraffe", "crocodile", "hippopotamus"
        assertEquals(4, indexingRule.getLongWordCount());
    }
}