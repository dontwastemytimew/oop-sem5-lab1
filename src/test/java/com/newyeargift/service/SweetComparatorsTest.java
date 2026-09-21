package com.newyeargift.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.newyeargift.model.sweet.Cookie;
import com.newyeargift.model.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SweetComparatorsTest {

    private final Sweet apple = new Cookie("Apple", 30, 20, false);
    private final Sweet banana = new Cookie("Banana", 10, 50, false);
    private final Sweet cherry = new Cookie("Cherry", 20, 35, false);

    @Test
    void byName_ordersSweetsAlphabetically() {
        List<Sweet> sweets = new ArrayList<>(List.of(cherry, apple, banana));

        sweets.sort(SweetComparators.BY_NAME);

        assertEquals(List.of(apple, banana, cherry), sweets);
    }

    @Test
    void byWeight_ordersSweetsFromLightestToHeaviest() {
        List<Sweet> sweets = new ArrayList<>(List.of(apple, cherry, banana));

        sweets.sort(SweetComparators.BY_WEIGHT);

        assertEquals(List.of(banana, cherry, apple), sweets);
    }

    @Test
    void bySugarContent_ordersSweetsFromLeastToMostSugar() {
        List<Sweet> sweets = new ArrayList<>(List.of(banana, apple, cherry));

        sweets.sort(SweetComparators.BY_SUGAR_CONTENT);

        assertEquals(List.of(apple, cherry, banana), sweets);
    }
}