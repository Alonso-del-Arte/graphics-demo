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
package org.example.graphics.demo;

import java.awt.Graphics;

import org.example.randomness.ExtendedRandom;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the TreePanel class.
 * @author Alonso del Arte
 */
public class TreePanelNGTest {
    
    @Test
    public void testGetNumberOfTrees() {
        byte expected = (byte) ExtendedRandom.nextInt(128);
        TreePanel instance = new TreePanel(expected);
        byte actual = instance.getNumberOfTrees();
        assertEquals(actual, expected);
    }
    
    /**
     * Test of changeNumberOfTrees method, of class TreePanel.
     */
    @Test(enabled = false)
    public void testSetNumberOfTrees() {
        System.out.println("setNumberOfTrees");
        byte treeCount = 0;
        TreePanel instance = null;
//        instance.changeNumberOfTrees(treeCount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class TreePanel.
     */
    @Test(enabled = false)
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        TreePanel instance = null;
//        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
