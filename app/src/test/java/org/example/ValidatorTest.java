package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void testValidateTriangle(){
        // Equilateral
        assertEquals("Equilateral", 
            new Validator(new Triangle(5.0, 5.0, 5.0)).validateTriangle());

        // Isolesces
        assertEquals("Isolesces", 
            new Validator(new Triangle(6.0, 6.0, 9.0)).validateTriangle());

        // Scalene
        assertEquals("Scalene", 
            new Validator(new Triangle(5.0, 6.0, 9.0)).validateTriangle());

        // NotTriangle
        assertEquals("NotTriangle", 
            new Validator(new Triangle(4.0, 3.0, 8.0)).validateTriangle());
    }
}
