package com.newyeargift.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.newyeargift.model.sweet.Caramel;
import com.newyeargift.model.sweet.ChocolateCandy;
import com.newyeargift.model.sweet.Cookie;

import org.junit.jupiter.api.Test;

class SweetCreatorTest {

    private final SweetCreator creator = new SweetCreator();

    @Test
    void createSweet_buildsChocolateCandyFromChocolateLine() {
        ChocolateCandy candy = assertInstanceOf(ChocolateCandy.class,
                creator.createSweet("CHOCOLATE;Milk Delight;12;45;milk;30"));

        assertEquals("Milk Delight", candy.getName());
        assertEquals(12, candy.getWeightInGrams(), 0.001);
        assertEquals(45, candy.getSugarContentPercent(), 0.001);
        assertEquals("milk", candy.getFlavor());
        assertEquals(30, candy.getCocoaContentPercent(), 0.001);
    }

    @Test
    void createSweet_buildsCaramelFromCaramelLine() {
        Caramel caramel = assertInstanceOf(Caramel.class,
                creator.createSweet("CARAMEL;Fruit Drop;6;85;strawberry;true"));

        assertEquals("Fruit Drop", caramel.getName());
        assertEquals("strawberry", caramel.getFlavor());
        assertTrue(caramel.isHard());
    }

    @Test
    void createSweet_buildsCookieFromCookieLine() {
        Cookie cookie = assertInstanceOf(Cookie.class,
                creator.createSweet("COOKIE;Butter Round;15;30;false"));

        assertEquals("Butter Round", cookie.getName());
        assertEquals(15, cookie.getWeightInGrams(), 0.001);
        assertFalse(cookie.isFilled());
    }

    @Test
    void createSweet_acceptsTypeInAnyLetterCase() {
        assertInstanceOf(Cookie.class,
                creator.createSweet("cookie;Butter Round;15;30;false"));
    }

    @Test
    void createSweet_ignoresSpacesAroundSeparators() {
        Cookie cookie = assertInstanceOf(Cookie.class,
                creator.createSweet("COOKIE ; Choco Bite ; 20 ; 35 ; true"));

        assertEquals("Choco Bite", cookie.getName());
        assertTrue(cookie.isFilled());
    }

    @Test
    void createSweet_throwsExceptionForUnknownType() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> creator.createSweet("JELLY;Bear;5;40;true"));

        assertTrue(exception.getMessage().contains("JELLY"));
    }

    @Test
    void createSweet_throwsExceptionWhenNumberIsNotANumber() {
        assertThrows(NumberFormatException.class,
                () -> creator.createSweet("COOKIE;Broken;heavy;35;true"));
    }
}