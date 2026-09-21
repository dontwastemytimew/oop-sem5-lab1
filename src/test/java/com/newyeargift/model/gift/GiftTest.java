package com.newyeargift.model.gift;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.newyeargift.model.sweet.Cookie;
import com.newyeargift.model.sweet.Sweet;
import com.newyeargift.service.SweetComparators;

import org.junit.jupiter.api.Test;

class GiftTest {

    private final Gift gift = new Gift();

    @Test
    void calculateTotalWeightInGrams_returnsZeroForEmptyGift() {
        assertEquals(0, gift.calculateTotalWeightInGrams(), 0.001);
    }

    @Test
    void calculateTotalWeightInGrams_sumsWeightsOfAllSweets() {
        gift.addSweet(new Cookie("First", 12, 40, false));
        gift.addSweet(new Cookie("Second", 8, 40, false));
        gift.addSweet(new Cookie("Third", 20, 40, true));

        assertEquals(40, gift.calculateTotalWeightInGrams(), 0.001);
    }

    @Test
    void addSweet_putsSweetIntoGift() {
        Sweet sweet = new Cookie("Choco Bite", 20, 35, true);

        gift.addSweet(sweet);

        assertEquals(1, gift.getSweets().size());
        assertTrue(gift.getSweets().contains(sweet));
    }

    @Test
    void getSweets_returnsListThatCannotBeModified() {
        Sweet sweet = new Cookie("Choco Bite", 20, 35, true);

        assertThrows(UnsupportedOperationException.class,
                () -> gift.getSweets().add(sweet));
    }

    @Test
    void sortSweets_ordersSweetsByGivenComparator() {
        Sweet heavy = new Cookie("Heavy", 30, 40, false);
        Sweet light = new Cookie("Light", 5, 40, false);
        Sweet medium = new Cookie("Medium", 15, 40, false);
        gift.addSweet(heavy);
        gift.addSweet(light);
        gift.addSweet(medium);

        gift.sortSweets(SweetComparators.BY_WEIGHT);

        assertEquals(light, gift.getSweets().get(0));
        assertEquals(medium, gift.getSweets().get(1));
        assertEquals(heavy, gift.getSweets().get(2));
    }
}