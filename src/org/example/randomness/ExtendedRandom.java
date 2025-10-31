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
    
    public static int nextPowerOfTwo() {
        int shift = nextInt(31);
        return 1 << shift;
    }
    
    public static Color nextColor() {
        return new Color(nextInt(), true);
    }
    
    // TODO: Write tests for this
    public static Point nextPoint() {
        return new Point();
    }
    
    public static Dimension nextDimension() {
        int height = RANDOM.nextInt(1, 4096);
        int width = RANDOM.nextInt(1, 4096);
        return new Dimension(width, height);
    }
    
    public static Dimension nextDimension(Dimension bound) {
        int height = RANDOM.nextInt(1, bound.height);
        int width = RANDOM.nextInt(1, bound.width);
        return new Dimension(width, height);
    }
    
}
