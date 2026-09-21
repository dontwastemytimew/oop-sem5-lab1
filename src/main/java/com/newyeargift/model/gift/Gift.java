package com.newyeargift.model.gift;

import com.newyeargift.model.sweet.Sweet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A children's gift that holds a collection of sweets.
 */
public class Gift {

    private final List<Sweet> sweets = new ArrayList<>();

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public List<Sweet> getSweets() {
        return Collections.unmodifiableList(sweets);
    }

    public double calculateTotalWeightInGrams() {
        double totalWeight = 0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.getWeightInGrams();
        }
        return totalWeight;
    }

    public void sortSweets(Comparator<Sweet> comparator) {
        sweets.sort(comparator);
    }
}