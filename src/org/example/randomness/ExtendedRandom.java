/*
 * Copyright (C) 2026 Alonso del Arte
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
import java.util.Random;

/**
 * Provides some pseudorandom items, as well as pseudorandom 32-bit integers. 
 * All of these functions are static, so it's not necessary to instantiate this 
 * class like with {@code java.util.Random}.
 * @author Alonso del Arte
 */
public class ExtendedRandom {
    
    private static final Random RANDOM = new Random();
    
    public static int nextInt() {
        return RANDOM.nextInt();
    }
    
    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }
    
    /**
     * Provides a pseudorandom integer between a specified origin and bound. 
     * Since {@code Random} in Java 8 does not provide such a function, this 
     * function is not a simple static wrapper like the other two {@code 
     * nextInt()} functions.
     * @param origin The smallest integer that may be returned. May be 0, but 
     * preferably a positive integer. For example, 128. Negative integers may 
     * also be used. For example, &minus;128.
     * @param bound One more than the maximum integer that may be returned. For 
     * example, 256. Must not be equal to nor less than {@code origin}.
     * @return An integer, at least {@code origin} but less than {@code bound}. 
     * With the example parameters, this function may return values such as 241, 
     * 155, 184, 204, 203, 248, 133. The values 128 and 255 may come up, but 256 
     * should not. With the example {@code origin} of &minus;128, this function 
     * may also return values such as 104, &minus;3, 170, &minus;6, &minus;108, 
     * 95. In this example, &minus;128 may come up, as well as 255, but not 256.
     * @throws IllegalArgumentException If {@code origin} is greater than {@code 
     * bound}, or equal. For example, an {@code origin} of 256 with a {@code 
     * bound} of 128 will trigger this exception.
     */
    public static int nextInt(int origin, int bound) {
        int adjBound = bound - origin;
        return origin + RANDOM.nextInt(adjBound);
    }
    
    public static int nextPowerOfTwo() {
        int shift = nextInt(31);
        return 1 << shift;
    }
    
    private static int nextGrayscaleValue() {
        return RANDOM.nextInt(256);
    }
    
    public static Color nextColor() {
        return new Color(nextInt(), true);
    }
    
    public static Color nextColor(Color origin, Color bound) {
        int originR = origin.getRed();
        int boundR = bound.getRed();
        int r = originR;
        if (originR != boundR) {
            r = nextInt(originR, boundR);
        }
        int originG = origin.getGreen();
        int boundG = bound.getGreen();
        int g = originG;
        if (originG != boundG) {
            g = nextInt(originG, boundG);
        }
        int originB = origin.getBlue();
        int boundB = bound.getBlue();
        int b = originB;
        if (originB != boundB) {
            b = nextInt(originB, boundB);
        }
        return new Color(r, g, b);
    }
    
    public static Point nextPoint() {
        return new Point(RANDOM.nextInt(), RANDOM.nextInt());
    }
    
    public static Point nextPoint(Dimension bound) {
        return new Point(RANDOM.nextInt(bound.width), 
                RANDOM.nextInt(bound.height));
    }
    
    public static Dimension nextDimension() {
        int height = RANDOM.nextInt(4096) + 1;
        int width = RANDOM.nextInt(4096) + 1;
        return new Dimension(width, height);
    }
    
    public static Dimension nextDimension(Dimension bound) {
        int height = RANDOM.nextInt(bound.height) + 1;
        int width = RANDOM.nextInt(bound.width) + 1;
        return new Dimension(width, height);
    }
    
}
