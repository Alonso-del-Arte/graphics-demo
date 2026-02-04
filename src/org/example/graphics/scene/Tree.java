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

/**
 *
 * @author Alonso del Arte
 */
public class Tree {
    
    public static final Point DEFAULT_POSITION = new Point();
    
    private final Color upperColor;
    
    private final Dimension dimension;
    
    private Point position;
    
    private final int lowLeafLevel;
    
    public Color getLeafColor() {
        return this.upperColor;
    }
    
    // In the main branch, rewrite to leak field before refactoring with copy
    // constructor
    public Dimension getDimension() {
        return new Dimension(this.dimension);
    }
    
    // In the main branch, rewrite to leak field before refactoring with copy
    // constructor
    public Point getPosition() {
        return new Point(this.position);
    }
    
    public void setPosition(Point relocated) {
        this.position = relocated;
    }
    
    public void paint(Graphics g) {
        g.setColor(this.upperColor);
        int vertexX = this.position.x + this.dimension.width / 2;
        int[] xPoints = {vertexX, this.position.x, this.position.x 
                + this.dimension.width};
        int lowCornerY = this.position.y + this.lowLeafLevel;
        int[] yPoints = {this.position.y, lowCornerY, lowCornerY};
        g.drawPolygon(xPoints, yPoints, 3);
    }
    
    public Tree(Color leafColor, Dimension size) {
        this(leafColor, size, DEFAULT_POSITION);
    }
    
    public Tree(Color leafColor, Dimension size, Point originalPosition) {
        this.upperColor = leafColor;
        this.dimension = size;
        this.position = originalPosition;
        this.lowLeafLevel = 3 * this.dimension.height / 4;
    }
    
}
