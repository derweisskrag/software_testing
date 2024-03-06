package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test void testGetArea(){
        assertEquals(6.0, new Triangle(3.0, 4.0, 5.0).getArea(), 0.0001);
    }
}
