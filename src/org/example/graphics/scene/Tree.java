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

/**
 *
 * @author Alonso del Arte
 */
public class Tree {
    
    /**
     * The default color for the tree leaves. This is the brightest green.
     */
    public static final Color DEFAULT_LEAF_COLOR = Color.GREEN;
    
    /**
     * The default color for the tree trunk. This is a brown, 50% red, 25% green 
     * and 0% blue.
     */
    public static final Color DEFAULT_TRUNK_COLOR = new Color(128, 64, 0);
    
    private static final Point DEFAULT_POSITION = new Point(0, 0);
    
    private final Color upperColor, lowerColor;
    
    private final Dimension area;
    
    private Point position = new Point();
    
    private final int lowLeafLevel;
    
    public Color getLeafColor() {
        return this.upperColor;
    }
    
    public Color getTrunkColor() {
        return this.lowerColor;
    }
    
    // TODO: Write tests for this
    public Dimension getDimension() {
        return this.area;
    }
    
    // TODO: Write tests for this
    public Point getPosition() {
        return DEFAULT_POSITION;
    }
    
    // TODO: Write tests for this
    public void setPosition(Point relocated) {
        this.position = DEFAULT_POSITION;
    }
    
    // TODO: Write tests for this
    public boolean contains(Point point) {
        return false;
    }

    public void paint(Graphics g) {
        // TODO: Write tests for this
    }

    /**
     * Auxiliary constructor. {@link #DEFAULT_LEAF_COLOR} and {@link 
     * #DEFAULT_TRUNK_COLOR} are filled in for the leaf and trunk colors.
     * @param size The dimension of the tree. Both height and width need to be 
     * positive.
     * @throws IllegalArgumentException If either the height or the width of 
     * {@code size} is 0 or negative.
     */
    public Tree(Dimension size) {
        this(DEFAULT_LEAF_COLOR, DEFAULT_TRUNK_COLOR, size);
    }
    
    /**
     * Auxiliary constructor. {@link #DEFAULT_TRUNK_COLOR} is filled in for the 
     * trunk color.
     * @param leafColor The color for the leaves. For example, a medium dark 
     * green.
     * @param size The dimension of the tree. Both height and width need to be 
     * positive.
     * @throws IllegalArgumentException If either the height or the width of 
     * {@code size} is 0 or negative.
     */
    public Tree(Color leafColor, Dimension size) {
        this(leafColor, DEFAULT_TRUNK_COLOR, size);
    }
    
    /**
     * Primary constructor.
     * @param leafColor The color for the leaves. For example, a medium light 
     * green.
     * @param trunkColor The color for the trunk. For example, a dark brown.
     * @param size The dimension of the tree. Both height and width need to be 
     * positive.
     * @throws IllegalArgumentException If either the height or the width of 
     * {@code size} is 0 or negative.
     */
    public Tree(Color leafColor, Color trunkColor, Dimension size) {
        if (size.width < 1 || size.height < 1) {
            String excMsg = size.toString() + " is not valid";
            throw new IllegalArgumentException(excMsg);
        }
        this.upperColor = leafColor;
        this.lowerColor = trunkColor;
        this.lowLeafLevel = -3;
        this.area = size;
    }
    
}
