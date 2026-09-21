package com.newyeargift.data;

import com.newyeargift.model.sweet.Caramel;
import com.newyeargift.model.sweet.ChocolateCandy;
import com.newyeargift.model.sweet.Cookie;
import com.newyeargift.model.sweet.Sweet;

/**
 * Creates the proper sweet.
 */
public class SweetCreator {

    private static final String FIELD_SEPARATOR_REGEX = "\\s*;\\s*";

    public Sweet createSweet(String line) {
        String[] fields = line.trim().split(FIELD_SEPARATOR_REGEX);
        String type = fields[0].toUpperCase();
        return switch (type) {
            case "CHOCOLATE" -> createChocolateCandy(fields);
            case "CARAMEL" -> createCaramel(fields);
            case "COOKIE" -> createCookie(fields);
            default -> throw new IllegalArgumentException(
                    "Unknown sweet type: " + type);
        };
    }

    private ChocolateCandy createChocolateCandy(String[] fields) {
        return new ChocolateCandy(fields[1],
                Double.parseDouble(fields[2]),
                Double.parseDouble(fields[3]),
                fields[4],
                Double.parseDouble(fields[5]));
    }

    private Caramel createCaramel(String[] fields) {
        return new Caramel(fields[1],
                Double.parseDouble(fields[2]),
                Double.parseDouble(fields[3]),
                fields[4],
                Boolean.parseBoolean(fields[5]));
    }

    private Cookie createCookie(String[] fields) {
        return new Cookie(fields[1],
                Double.parseDouble(fields[2]),
                Double.parseDouble(fields[3]),
                Boolean.parseBoolean(fields[4]));
    }
}