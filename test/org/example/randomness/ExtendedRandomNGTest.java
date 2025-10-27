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
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.testframe.api.Asserters.assertInRange;
import static org.testframe.api.Asserters.assertMinimum;
import static org.testframe.api.Asserters.assertPositive;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the ExtendedRandom class.
 * @author Alonso del Arte
 */
public class ExtendedRandomNGTest {
    
    private static enum Direction {
        
        NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST, 
        STATIONARY
        
    }
    
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
     * Test of the nextColor function, of the ExtendedRandom class.
     */
    @Test
    public void testNextColor() {
        System.out.println("nextColor");
        int minimum = 224;
        Set<DownsampledColor> colors = new HashSet<>(minimum);
        int numberOfCalls = 4096;
        for (int i = 0; i < numberOfCalls; i++) {
            Color color = ExtendedRandom.nextColor();
            DownsampledColor downsampled = new DownsampledColor(color);
            colors.add(downsampled);
        }
        int actual = colors.size();
        String msg = "Expected at least " + minimum 
                + " downsampled colors, got " + actual;
        System.out.println(msg);
        assertMinimum(minimum, actual, msg);
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
    
    @Test
    public void testNextDimensionIsPositive() {
        Dimension dimension = ExtendedRandom.nextDimension();
        String msg = "Dimension " + dimension.toString() 
                + " should have positive height and width";
        assertPositive(dimension.height, msg);
        assertPositive(dimension.width, msg);
    }
    
    @Test
    public void testNextDimension() {
        System.out.println("nextDimension");
        int initialCapacity = RANDOM.nextInt(32) + 128;
        Set<Dimension> dimensions = new HashSet<>(initialCapacity);
        int numberOfCalls = initialCapacity * 2;
        for (int i = 0; i < numberOfCalls; i++) {
            dimensions.add(ExtendedRandom.nextDimension());
        }
        int minimum = 3 * numberOfCalls / 5;
        int actual = dimensions.size();
        String msg = "After " + numberOfCalls 
                + " calls, there should be at least " + minimum 
                + " distinct dimensions";
        assertMinimum(minimum, actual, msg);
    }
    
    @Test
    public void testNextDimensionVariesWidthAndHeight() {
        int initialCapacity = RANDOM.nextInt(32) + 128;
        Set<Integer> heights = new HashSet<>(initialCapacity);
        Set<Integer> widths = new HashSet<>(initialCapacity);
        int numberOfCalls = initialCapacity * 2;
        for (int i = 0; i < numberOfCalls; i++) {
            Dimension dimension = ExtendedRandom.nextDimension();
            heights.add(dimension.height);
            widths.add(dimension.width);
        }
        int minimum = 3 * numberOfCalls / 5;
        String msg = "After " + numberOfCalls 
                + " calls, there should be at least " + minimum 
                + " distinct heights and distinct widths";
        int actualWidths = widths.size();
        assertMinimum(minimum, actualWidths, msg);
        int actualHeights = heights.size();
        assertMinimum(minimum, actualHeights, msg);
    }
    
    private static Direction determineDirection(Dimension prevDim, 
            Dimension currDim) {
        int x = Integer.signum(prevDim.height - currDim.height) << 2;
        int y = Integer.signum(prevDim.width - currDim.width);
        int dir = x + y;
        return switch (dir) {
            case -5 -> Direction.NORTHWEST;
            case -4 -> Direction.NORTH;
            case -3 -> Direction.NORTHEAST;
            case -1 -> Direction.WEST;
            case 1 -> Direction.EAST;
            case 3 -> Direction.SOUTHWEST;
            case 4 -> Direction.SOUTH;
            case 5 -> Direction.SOUTHEAST;
            default -> Direction.STATIONARY;
        };
    }
    
    @Test
    public void testNextDimensionVariesDirectionOfBottomRightCorner() {
        Direction[] expDirs = {Direction.NORTHEAST, Direction.SOUTHEAST, 
            Direction.SOUTHWEST, Direction.NORTHWEST};
        Set<Direction> expected = new HashSet<>(4);
        expected.addAll(Arrays.asList(expDirs));
        int initialCapacity = Direction.values().length;
        Set<Direction> actual = new HashSet<>(initialCapacity);
        int numberOfCalls = 16 * initialCapacity + RANDOM.nextInt(32);
        Dimension prevDim = ExtendedRandom.nextDimension();
        for (int i = 0; i < numberOfCalls; i++) {
            Dimension currDim = ExtendedRandom.nextDimension();
            actual.add(determineDirection(prevDim, currDim));
            prevDim = currDim;
        }
        String msg = "After " + numberOfCalls + " calls, expecting " 
                + actual.toString() + " to contain " + expected.toString();
        System.out.println("Actual directions were " + actual.toString());
        assert actual.containsAll(expected): msg;
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
        
        DownsampledColor(Color color) {
            int r = (color.getRed() / 64) << 4;
            int g = (color.getGreen() / 64) << 2;
            int b = (color.getBlue() / 64);
            int a = (color.getAlpha() / 64) << 6;
            this.value = (byte) (a + r + g + b);
        }
        
    }
    
}
