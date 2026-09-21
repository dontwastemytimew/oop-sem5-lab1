package com.newyeargift.service;

import com.newyeargift.model.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds sweets whose sugar content falls into a given range.
 */
public class SugarRangeSearcher {

    /**
     * Both bounds are inclusive.
     */
    public List<Sweet> findBySugarContentRange(List<Sweet> sweets,
                                               double minPercent, double maxPercent) {
        List<Sweet> found = new ArrayList<>();
        for (Sweet sweet : sweets) {
            double sugar = sweet.getSugarContentPercent();
            if (sugar >= minPercent && sugar <= maxPercent) {
                found.add(sweet);
            }
        }
        return found;
    }
}