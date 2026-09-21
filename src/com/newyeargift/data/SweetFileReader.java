package com.newyeargift.data;

import com.newyeargift.model.sweet.Sweet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads sweets from a text file.
 */
public class SweetFileReader {

    private static final String COMMENT_PREFIX = "#";

    private final SweetCreator sweetCreator;

    public SweetFileReader(SweetCreator sweetCreator) {
        this.sweetCreator = sweetCreator;
    }

    public List<Sweet> readSweets(Path file) throws IOException {
        List<Sweet> sweets = new ArrayList<>();
        for (String line : Files.readAllLines(file)) {
            if (isDataLine(line)) {
                sweets.add(sweetCreator.createSweet(line));
            }
        }
        return sweets;
    }

    private boolean isDataLine(String line) {
        return !line.isBlank() && !line.startsWith(COMMENT_PREFIX);
    }
}