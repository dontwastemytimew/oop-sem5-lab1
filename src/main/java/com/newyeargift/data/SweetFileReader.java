package com.newyeargift.data;

import com.newyeargift.model.sweet.Sweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads sweets from a text resource file.
 */
public class SweetFileReader {

    private static final String COMMENT_PREFIX = "#";

    private final SweetCreator sweetCreator;

    public SweetFileReader(SweetCreator sweetCreator) {
        this.sweetCreator = sweetCreator;
    }

    public List<Sweet> readSweets(InputStream fileStream) throws IOException {
        List<Sweet> sweets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(fileStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isDataLine(line)) {
                    sweets.add(sweetCreator.createSweet(line));
                }
            }
        }
        return sweets;
    }

    private boolean isDataLine(String line) {
        return !line.isBlank() && !line.startsWith(COMMENT_PREFIX);
    }
}