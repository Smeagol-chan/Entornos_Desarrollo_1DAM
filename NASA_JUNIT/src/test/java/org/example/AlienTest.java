package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienTest
{
    Alien a1 = new Alien("Zorg", "MARS01");
    Alien a2 = new Alien("Xenomorph", "LV426");
    Alien a3 = new Alien("Zorg", "MARS01");

    @Test
    void getName()
    {
        assertAll(
                () -> assertEquals("Zorg", a1.getName()),
                () -> assertEquals("Xenomorph", a2.getName()),
                () -> assertEquals("Zorg", a3.getName())
        );
    }

    @Test
    void setName()
    {
        a1.setName("Di");
        a2.setName("Lu");
        a3.setName("Ted");

        assertAll(
                () -> assertEquals("Di", a1.getName()),
                () -> assertEquals("Lu", a2.getName()),
                () -> assertEquals("Ted", a3.getName())
        );
    }

    @Test
    void getPlanetId()
    {
        assertAll(
                () -> assertEquals("MARS01", a1.getPlanetId()),
                () -> assertEquals("LV426", a2.getPlanetId()),
                () -> assertEquals("MARS01", a3.getPlanetId())
        );
    }

    @Test
    void setPlanetId()
    {
        a1.setPlanetId("M1");
        a2.setPlanetId("L4");
        a3.setPlanetId("M1");

        assertAll(
                () -> assertEquals("M1", a1.getPlanetId()),
                () -> assertEquals("L4", a2.getPlanetId()),
                () -> assertEquals("M1", a3.getPlanetId())
        );
    }

    @Test
    void testEquals()
    {
        assertAll(
                () -> assertTrue(a1.equals(a3)),
                () -> assertFalse(a1.equals(a2))
        );
    }

    @Test
    void testToString()
    {
        assertAll(
                () -> assertEquals("Zorg MARS01", a1.toString()),
                () -> assertEquals("Xenomorph LV426", a2.toString()),
                () -> assertEquals("Zorg MARS01", a3.toString())
        );
    }

    @Test
    void testToStringFallo()
    {
        assertEquals("Child of Burning Time", a3.toString());
    }
}