package com.newyeargift.model.sweet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ChocolateCandyTest {

    private final ChocolateCandy candy =
            new ChocolateCandy("Milk Delight", 12, 45, "milk", 30);

    @Test
    void getters_returnValuesPassedToConstructor() {
        assertEquals("Milk Delight", candy.getName());
        assertEquals(12, candy.getWeightInGrams(), 0.001);
        assertEquals(45, candy.getSugarContentPercent(), 0.001);
        assertEquals("milk", candy.getFlavor());
        assertEquals(30, candy.getCocoaContentPercent(), 0.001);
    }

    @Test
    void getSugarWeightInGrams_returnsShareOfSugarInWeight() {
        assertEquals(5.4, candy.getSugarWeightInGrams(), 0.001);
    }

    @Test
    void getCategory_returnsChocolateCandy() {
        assertEquals("Chocolate candy", candy.getCategory());
    }

    @Test
    void toString_containsNameFlavorAndCategory() {
        String text = candy.toString();

        assertTrue(text.contains("Chocolate candy"));
        assertTrue(text.contains("Milk Delight"));
        assertTrue(text.contains("milk"));
    }
}