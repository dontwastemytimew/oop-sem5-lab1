package com.newyeargift.model.sweet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CookieTest {

    @Test
    void isFilled_returnsTrueForFilledCookie() {
        Cookie cookie = new Cookie("Choco Bite", 20, 35, true);

        assertTrue(cookie.isFilled());
    }

    @Test
    void isFilled_returnsFalseForPlainCookie() {
        Cookie cookie = new Cookie("Butter Round", 15, 30, false);

        assertFalse(cookie.isFilled());
    }

    @Test
    void getSugarWeightInGrams_returnsShareOfSugarInWeight() {
        Cookie cookie = new Cookie("Choco Bite", 20, 35, true);

        assertEquals(7.0, cookie.getSugarWeightInGrams(), 0.001);
    }

    @Test
    void getCategory_returnsCookie() {
        Cookie cookie = new Cookie("Choco Bite", 20, 35, true);

        assertEquals("Cookie", cookie.getCategory());
    }

    @Test
    void toString_mentionsWhetherCookieIsFilled() {
        Cookie filled = new Cookie("Choco Bite", 20, 35, true);
        Cookie plain = new Cookie("Butter Round", 15, 30, false);

        assertTrue(filled.toString().contains("filled"));
        assertTrue(plain.toString().contains("plain"));
    }
}