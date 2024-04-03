package org.wandikafp.rule;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class UpperCaseWordIndexingRuleTest {
    @Test
    public void testIndexFile() {
        UpperCaseWordIndexingRule indexingRule = new UpperCaseWordIndexingRule();
        File file = new File("testFiles/testUpperCaseWords.txt");

        indexingRule.rule(file);
        // Expected count of words starting with uppercase letter in the test file is 3
        assertEquals(7, indexingRule.getUpperCaseCount());
    }
}