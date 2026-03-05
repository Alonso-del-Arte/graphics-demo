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
package org.example.graphics.scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import static org.example.randomness.ExtendedRandom.nextColor;
import static org.example.randomness.ExtendedRandom.nextInt;

import static org.testframe.api.Asserters.assertThrows;

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
    public void testDefaultLeafColorConstant() {
        assertEquals(Tree.DEFAULT_LEAF_COLOR, Color.GREEN);
    }
    
    @Test
    public void testDefaultTrunkColorConstant() {
        Color expected = new Color(128, 64, 0);
        assertEquals(Tree.DEFAULT_TRUNK_COLOR, expected);
    }
    
    @Test
    public void testGetLeafColorFromInstanceFrom1ParamConstructor() {
        Tree instance = new Tree(DEFAULT_DIMENSION);
        Color expected = Tree.DEFAULT_LEAF_COLOR;
        Color actual = instance.getLeafColor();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetLeafColor() {
        System.out.println("getLeafColor");
        Color expected = nextColor();
        Tree instance = new Tree(expected, DEFAULT_DIMENSION);
        Color actual = instance.getLeafColor();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetLeafColorFromInstanceFrom3ParamConstructor() {
        Color expected = nextColor();
        Tree instance = new Tree(expected, nextColor(), DEFAULT_DIMENSION);
        Color actual = instance.getLeafColor();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetTrunkColorFromInstanceFrom1ParamConstructor() {
        Tree instance = new Tree(DEFAULT_DIMENSION);
        Color expected = Tree.DEFAULT_TRUNK_COLOR;
        Color actual = instance.getTrunkColor();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetTrunkColorFromInstanceFrom2ParamConstructor() {
        Tree instance = new Tree(nextColor(), DEFAULT_DIMENSION);
        Color expected = Tree.DEFAULT_TRUNK_COLOR;
        Color actual = instance.getTrunkColor();
        assertEquals(actual, expected);
    }
    
    @Test
    public void getTrunkColor() {
        System.out.println("getTrunkColor");
        Color leafColor = new Color(256 + nextInt(256));
        Color expected = nextColor();
        Tree instance = new Tree(leafColor, expected, DEFAULT_DIMENSION);
        Color actual = instance.getTrunkColor();
        assertEquals(actual, expected);
    }
    
    @Test
    public void test1ParamConstructorRejectsDimensionWithNegativeWidth() {
        int width = -nextInt(256) - 1;
        int height = nextInt(256) + 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test1ParamConstructorRejectsDimensionWithNegativeHeight() {
        int width = nextInt(256) + 1;
        int height = -nextInt(256) - 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test1ParamConstructorRejectsDimensionWithZeroWidth() {
        int width = 0;
        int height = nextInt(256) + 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test1ParamConstructorRejectsDimensionWithZeroHeight() {
        int width = nextInt(256) + 1;
        int height = 0;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test2ParamConstructorRejectsDimensionWithNegativeWidth() {
        int width = -nextInt(256) - 1;
        int height = nextInt(256) + 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(nextColor(), size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test2ParamConstructorRejectsDimensionWithNegativeHeight() {
        int width = nextInt(256) + 1;
        int height = -nextInt(256) - 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(nextColor(), size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test2ParamConstructorRejectsDimensionWithZeroWidth() {
        int width = 0;
        int height = nextInt(256) + 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(nextColor(), size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test2ParamConstructorRejectsDimensionWithZeroHeight() {
        int width = nextInt(256) + 1;
        int height = 0;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(nextColor(), size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test3ParamConstructorRejectsDimensionWithNegativeWidth() {
        int width = -nextInt(256) - 1;
        int height = nextInt(256) + 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(nextColor(), nextColor(), size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test3ParamConstructorRejectsDimensionWithNegativeHeight() {
        int width = nextInt(256) + 1;
        int height = -nextInt(256) - 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(nextColor(), nextColor(), size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
    @Test
    public void test3ParamConstructorRejectsDimensionWithZeroWidth() {
        int width = 0;
        int height = nextInt(256) + 1;
        Dimension size = new Dimension(width, height);
        String dimStr = size.toString();
        String msg = dimStr + " should cause exception";
        Throwable t = assertThrows(() -> {
            Tree badResult = new Tree(nextColor(), nextColor(), size);
            System.out.println(msg + ", not given " + badResult.toString());
        }, IllegalArgumentException.class, msg);
        String excMsg = t.getMessage();
        assert excMsg != null : "Exception message should not be null";
        assert !excMsg.isBlank() : "Exception message should not be false";
        String containsMsg = "Exception message should contain \"" + dimStr 
                + "\"";
        assert excMsg.contains(dimStr) : containsMsg;
        System.out.println("\"" + excMsg + "\"");
    }
    
}
