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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import static org.example.randomness.ExtendedRandom.nextInt;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Tests of the GraphicsDemo class.
 * @author Alonso del Arte
 */
public class GraphicsDemoNGTest {
    
    private enum CloseOperations {
        
        DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE, EXIT_ON_CLOSE
    
    }
    
    private static final CloseOperations[] CLOSE_OPS = CloseOperations.values();
    
    @Test
    public void testDefaultNumberOfTreesConstant() {
        byte expected = 31;
        byte actual = GraphicsDemo.DEFAULT_NUMBER_OF_TREES;
        assertEquals(actual, expected);
    }
    
    @Test
    public void testDefaultCloseOperationZeroParamConstructor() {
        JFrame instance = new GraphicsDemo();
        int expected = WindowConstants.EXIT_ON_CLOSE;
        int actual = instance.getDefaultCloseOperation();
        String message = "Expected " + CLOSE_OPS[expected].toString() + ", got " 
                + CLOSE_OPS[actual].toString();
        assertEquals(actual, expected, message);
    }
    
    @Test
    public void testDefaultCloseOperation() {
        byte initialNumberOfTrees = (byte) nextInt(1, 128);
        JFrame instance = new GraphicsDemo(initialNumberOfTrees);
        int expected = WindowConstants.EXIT_ON_CLOSE;
        int actual = instance.getDefaultCloseOperation();
        String message = "Expected " + CLOSE_OPS[expected].toString() + ", got " 
                + CLOSE_OPS[actual].toString();
        assertEquals(actual, expected, message);
    }
    
    /**
     * Test of main method, of class GraphicsDemo.
     */
    @Test(enabled = false)
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        GraphicsDemo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
