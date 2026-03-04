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
    
    /**
     * Provides a pseudorandom integer. If an integer that is not negative is 
     * desired, it might be preferable to use {@link #nextInt(int) 
     * nextInt(bound)}. For an integer between a specified origin and a 
     * specified bound, use {@link #nextInt(int, int) nextInt(origin, bound)}.
     * @return Some 32-bit integer. Examples: &minus;1432737928, 224929558, 
     * &minus;1362698030, 1644402551. The values &minus;2<sup>31</sup>, 0 and 
     * 2<sup>31</sup> &minus; 1 are possible but unlikely.
     */
    public static int nextInt() {
        return RANDOM.nextInt();
    }
    
    /**
     * Provides a pseudorandom nonnegative integer between 0 and a specified 
     * positive bound. If any 32-bit integer is acceptable, use {@link 
     * #nextInt() nextInt()} (no parameters). For an integer between a specified 
     * origin and a specified bound, use {@link #nextInt(int, int) 
     * nextInt(origin, bound)}.
     * @param bound One more than the maximum integer that may be returned. Must 
     * be positive. For example, 256. The value 1 is acceptable but kind of 
     * pointless, since in that case this function can only return 0.
     * @return A pseudorandom integer, at least 0 but less than {@code bound}. 
     * Examples: 151, 250, 196, 20, 53, 126, 177. In this example, 255 might 
     * come up, but 256 should not.
     * @throws IllegalArgumentException If {@code bound} is 0 or a negative 
     * integer.
     */
    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }
    
    /**
     * Provides a pseudorandom integer between a specified origin and bound. If 
     * the origin is 0, it might be preferable to use {@link #nextInt(int) 
     * nextInt(bound)}. If any 32-bit integer is acceptable, use {@link 
     * #nextInt() nextInt()} (no parameters).
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
        return RANDOM.nextInt(origin, bound);
    }
    
    public static int nextPowerOfTwo() {
        int shift = nextInt(31);
        return 1 << shift;
    }
    
    public static Color nextColor() {
        return new Color(nextInt(), true);
    }
    
    // TODO: Write tests for this
    public static Color nextColor(Color floor, Color ceiling) {
        return Color.BLACK;
    }
    
    public static Point nextPoint() {
        return new Point(RANDOM.nextInt(), RANDOM.nextInt());
    }
    
    public static Point nextPoint(Dimension bound) {
        return new Point(RANDOM.nextInt(bound.width), 
                RANDOM.nextInt(bound.height));
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
