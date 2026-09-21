package com.newyeargift.service;

import com.newyeargift.model.sweet.Sweet;

import java.util.Comparator;

/**
 * Ready-made strategies for ordering sweets by a single parameter.
 */
public final class SweetComparators {

    public static final Comparator<Sweet> BY_NAME =
            Comparator.comparing(Sweet::getName);

    public static final Comparator<Sweet> BY_WEIGHT =
            Comparator.comparingDouble(Sweet::getWeightInGrams);

    public static final Comparator<Sweet> BY_SUGAR_CONTENT =
            Comparator.comparingDouble(Sweet::getSugarContentPercent);

    private SweetComparators() {
    }
}