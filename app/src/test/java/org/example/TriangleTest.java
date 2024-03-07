package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(new Triangle(5.0, 5.0, 5.0).isEquilateral());
        assertTrue(new Triangle(77.54, 77.54, 77.54).isEquilateral());
        assertTrue(new Triangle(12.0, 12.0, 12.0).isEquilateral());

        // Scalene is not Equilateral -> false
        assertFalse(new Triangle(3.0, 4.0, 5.0).isEquilateral());
        assertFalse(new Triangle(4.0, 8.0, 5.0).isEquilateral());
        assertFalse(new Triangle(147.5, 54.7, 120.43).isEquilateral());
        assertFalse(new Triangle(44.0, 33.0, 22.0).isEquilateral());

        // Isolesces is not Equilateral -> false
        assertFalse(new Triangle(3.0, 5.0, 3.0).isEquilateral());

        // Not a triangle
        assertFalse(new Triangle(17.0, 65.3, 18.7).isEquilateral());
    }


    @Test
    public void testIsIsolesces(){
        // two sides are equal -> true
        assertTrue(new Triangle(3.0, 4.0, 3.0).isIsosceles());

        // Isolesces is not Equilateral -> false
        assertFalse(new Triangle(3.0, 3.0, 3.0).isIsosceles());

        // Isolesces it not Scalene -> false
        assertFalse(new Triangle(3.0, 4.0, 5.0).isIsosceles());

        // Not a triangle
        assertFalse(new Triangle(17.0, 65.3, 18.7).isEquilateral());
    }


    @Test
    public void testIsScalene(){
        // all sides are different -> true
        assertTrue(new Triangle(5.0, 3.0, 4.0).isScalene());

        // Scalene is not Equilateral -> false
        assertFalse(new Triangle(3.0, 3.0, 3.0).isScalene());

        // Scalene is not Isolesces -> false
        assertFalse(new Triangle(5.0, 8.0, 5.0).isScalene());

        // Not a triangle
        assertFalse(new Triangle(17.0, 65.3, 18.7).isEquilateral());
    }


    @Test
    public void testNotTriangle(){
        // Cannot form a triangle
        assertFalse(new Triangle(5.0, 2.0, 2.0).isTriangle());
        assertFalse(new Triangle(3.0, 2.0, 9.0).isTriangle());
        assertFalse(new Triangle(11.0, 127.0, 55.0).isTriangle());

        // can make a triangle
        assertTrue(new Triangle(11.0, 23.0, 13.6).isTriangle());
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


        assertDoesNotThrow(() -> {
            new Triangle(3.0, 4.0, 5.0);
        });
    }
}
