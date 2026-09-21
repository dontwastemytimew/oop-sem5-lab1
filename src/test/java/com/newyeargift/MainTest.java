package com.newyeargift;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream capturedOut =
            new ByteArrayOutputStream();

    @BeforeEach
    void redirectConsoleOutput() {
        System.setOut(new PrintStream(capturedOut));
    }

    @AfterEach
    void restoreConsoleOutput() {
        System.setOut(originalOut);
    }

    @Test
    void main_printsTotalWeightOfGiftFromFile() throws IOException {
        Main.main(new String[0]);

        assertTrue(capturedOut.toString().contains("Total weight: 71.0 g"));
    }

    @Test
    void main_printsSweetsFoundInSugarRange() throws IOException {
        Main.main(new String[0]);

        String output = capturedOut.toString();
        assertTrue(output.contains("Sugar content 40.0-60.0%:"));
        assertTrue(output.contains("Milk Delight"));
    }
}