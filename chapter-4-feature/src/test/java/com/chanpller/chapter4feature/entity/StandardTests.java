package com.chanpller.chapter4feature.entity;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class StandardTests {

    @BeforeAll
    static void initAll() {
        // Initialization code for all tests
    }

    @BeforeEach
    void init() {
        // Setup code before each test
    }

    @DisplayName("😱 ")
    @Test
    void succeedingTest() {
        // Test that succeeds
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // This test is disabled and will not be executed
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        // Cleanup code after each test
    }

    @AfterAll
    static void tearDownAll() {
        // Cleanup code after all tests
    }
}