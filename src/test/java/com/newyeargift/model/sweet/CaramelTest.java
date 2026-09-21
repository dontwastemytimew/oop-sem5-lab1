package com.newyeargift.model.sweet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CaramelTest {

    @Test
    void isHard_returnsFalseForSoftCaramel() {
        Caramel caramel = new Caramel("Toffee", 8, 70, "vanilla", false);

        assertFalse(caramel.isHard());
    }

    @Test
    void isHard_returnsTrueForHardCaramel() {
        Caramel caramel = new Caramel("Fruit Drop", 6, 85, "strawberry", true);

        assertTrue(caramel.isHard());
    }

    @Test
    void getCategory_returnsCaramel() {
        Caramel caramel = new Caramel("Toffee", 8, 70, "vanilla", false);

        assertEquals("Caramel", caramel.getCategory());
    }

    @Test
    void toString_mentionsHardnessOfCaramel() {
        Caramel soft = new Caramel("Toffee", 8, 70, "vanilla", false);
        Caramel hard = new Caramel("Fruit Drop", 6, 85, "strawberry", true);

        assertTrue(soft.toString().contains("soft"));
        assertTrue(hard.toString().contains("hard"));
    }
}