package com.newyeargift.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.newyeargift.model.sweet.Cookie;
import com.newyeargift.model.sweet.Sweet;

import java.util.List;

import org.junit.jupiter.api.Test;

class SugarRangeSearcherTest {

    private final SugarRangeSearcher searcher = new SugarRangeSearcher();

    private final Sweet lowSugar = new Cookie("Low", 10, 25, false);
    private final Sweet mediumSugar = new Cookie("Medium", 10, 45, false);
    private final Sweet highSugar = new Cookie("High", 10, 80, false);
    private final List<Sweet> sweets = List.of(lowSugar, mediumSugar, highSugar);

    @Test
    void findBySugarContentRange_returnsOnlySweetsInsideRange() {
        List<Sweet> found = searcher.findBySugarContentRange(sweets, 40, 60);

        assertEquals(List.of(mediumSugar), found);
    }

    @Test
    void findBySugarContentRange_includesSweetsOnBothBounds() {
        List<Sweet> found = searcher.findBySugarContentRange(sweets, 25, 80);

        assertEquals(List.of(lowSugar, mediumSugar, highSugar), found);
    }

    @Test
    void findBySugarContentRange_returnsEmptyListWhenNothingMatches() {
        List<Sweet> found = searcher.findBySugarContentRange(sweets, 90, 100);

        assertTrue(found.isEmpty());
    }

    @Test
    void findBySugarContentRange_returnsEmptyListForNoSweets() {
        List<Sweet> found = searcher.findBySugarContentRange(List.of(), 0, 100);

        assertTrue(found.isEmpty());
    }
}