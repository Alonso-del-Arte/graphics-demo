/*
 * Copyright (C) 2025 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.example.randomness;

import java.awt.Color;
import java.awt.Point;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.testframe.api.Asserters.assertInRange;
import static org.testframe.api.Asserters.assertMinimum;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the ExtendedRandom class.
 * @author Alonso del Arte
 */
public class ExtendedRandomNGTest {
    
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    
    /**
     * Test of the nextInt function, of the ExtendedRandom class.
     */
    @Test
    public void testNextInt() {
        System.out.println("nextInt");
        int capacity = 2048;
        Set<Integer> numbers = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            numbers.add(ExtendedRandom.nextInt());
        }
        int expected = 15 * capacity / 16;
        int actual = numbers.size();
        String msg = "Expected at least " + expected
                + " distinct integers out of " + capacity + ", got " + actual;
        System.out.println(msg);
        assert actual >= expected : msg;
    }

    /**
     * Another test of the nextInt function, of the ExtendedRandom class.
     */
    @Test
    public void testNextIntBounded() {
        int bound = RANDOM.nextInt(2048) + 512;
        int numberOfCalls = 24 * bound;
        Set<Integer> numbers = new HashSet<>(bound);
        for (int i = 0; i < numberOfCalls; i++) {
            int actual = ExtendedRandom.nextInt(bound);
            assertInRange(0, actual, bound);
            numbers.add(actual);
        }
        int minimum = 15 * bound / 16;
        int actual = numbers.size();
        String msg = "Expected at least " + minimum
                + " distinct integers after " + numberOfCalls + " calls, got " 
                + actual;
        System.out.println(msg);
        assertMinimum(minimum, actual, msg);
    }

    /**
     * Test of nextColor method, of class ExtendedRandom.
     */
//    @Test
    public void testNextColor() {
        System.out.println("nextColor");
        Color expResult = null;
        Color result = ExtendedRandom.nextColor();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextPoint method, of class ExtendedRandom.
     */
//    @Test
    public void testNextPoint() {
        System.out.println("nextPoint");
        Point expResult = null;
        Point result = ExtendedRandom.nextPoint();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    private final static class DownsampledColor {
        
        private final byte value;
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (obj instanceof DownsampledColor other) {
                return this.value == other.value;
            } else return false;
        }
        
        @Override
        public int hashCode() {
            return this.value;
        }
        
        private DownsampledColor(Color color) {
            int r = color.getRed() / 64;
            int g = color.getGreen() / 64;
            int b = color.getBlue() / 64;
            int a = color.getAlpha();
            this.value = (byte) (a + (r << 4) + (g << 2) + b);
        }
        
    }
    
}
