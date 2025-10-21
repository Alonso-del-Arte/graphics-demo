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
package org.example.graphics.scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import static org.example.randomness.ExtendedRandom.nextColor;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the Tree class.
 * @author Alonso del Arte
 */
public class TreeNGTest {
    
    private static final int DEFAULT_WIDTH = 50;
    
    private static final int DEFAULT_HEIGHT = 100;
    
    private static final Dimension DEFAULT_DIMENSION 
            = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    
    @Test
    public void testGetLeafColor() {
        Color expected = nextColor();
        Tree instance = new Tree(expected, DEFAULT_DIMENSION);
        Color actual = instance.getLeafColor();
        assertEquals(actual, expected);
    }
    
}
