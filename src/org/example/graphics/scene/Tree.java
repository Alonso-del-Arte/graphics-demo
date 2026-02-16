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
    
    private static final Point DEFAULT_POSITION = new Point(0, 0);
    
    private final Color upperColor, lowerColor;
    
    private Point position = new Point();
    
    private final int lowLeafLevel;
    
    public Color getLeafColor() {
        return this.upperColor;
    }
    
    // TODO: Write tests for this
    public Color getTrunkColor() {
        return this.lowerColor;
    }
    
    // TODO: Write tests for this
    public Dimension getDimension() {
        return new Dimension(1, 1);
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

    // TODO: Write tests for this
    public Tree(Color leafColor, Dimension size) {
        this.upperColor = leafColor;
        this.lowerColor = Color.BLACK;
        this.lowLeafLevel = -1;
    }
    
    // TODO: Write tests for this
    public Tree(Color leafColor, Color trunkColor, Dimension size) {
        this.upperColor = Color.BLUE;
        this.lowerColor = Color.DARK_GRAY;
        this.lowLeafLevel = -2;
    }
    
}
