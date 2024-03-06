package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Time;

public class TriangleTest {
    @Test
    public void testGetArea(){
        assertEquals(6.0, new Triangle(3.0, 4.0, 5.0).getArea(), 0.0001);
        assertNotEquals(3.0, new Triangle(3.0, 7.0, 8.0).getArea());
    }


    @Test
    public void testIsEquilateral(){
        // all sides are equal -> true
        assertTrue(new Triangle(3.0, 3.0, 3.0).isEquilateral());

        // Scalene is not Equilateral -> false
        assertFalse(new Triangle(3.0, 4.0, 5.0).isEquilateral());

        // Isolesces is not Equilateral -> false
        assertFalse(new Triangle(3.0, 5.0, 3.0).isEquilateral());
    }


    @Test
    public void testIsIsolesces(){
        // two sides are equal -> true
        assertTrue(new Triangle(3.0, 4.0, 3.0).isIsosceles());

        // Isolesces is not Equilateral -> false
        assertFalse(new Triangle(3.0, 3.0, 3.0).isIsosceles());

        // Isolesces it not Scalene -> false
        assertFalse(new Triangle(3.0, 4.0, 5.0).isIsosceles());
    }


    @Test
    public void testIsScalene(){
        // all sides are different -> true
        assertTrue(new Triangle(5.0, 3.0, 4.0).isScalene());

        // Scalene is not Equilateral -> false
        assertFalse(new Triangle(3.0, 3.0, 3.0).isScalene());

        // Scalene is not Isolesces -> false
        assertFalse(new Triangle(5.0, 8.0, 5.0).isScalene());
    }


    @Test
    public void testCreateTriangle(){
        // negative sides
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(3.0, -5.0, 3.0);
        });

        // Data is not instance of Double
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(2.0, "s", 5.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(2.0, new Validator(new Triangle(2.0, 3.0, 4.0)), 5.0);
        });
    }
}
