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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.example.graphics.scene.Tree;

/**
 *
 * @author Alonso del Arte
 */
public class TreePanel extends JPanel implements MouseListener, 
        MouseMotionListener {
    
    private byte numberOfTrees;
    
    private boolean hasTreeSelected = false;
    
    private Point lastRecordedMousePosition = new Point(-1, -1);
    
    private Point offset = new Point(0, 0);
    
    private Tree selectedTree = null;
    
    final List<Tree> listOfTrees;
    
    private void addTree() {
        //
    }
    
    byte getNumberOfTrees() {
        return this.numberOfTrees;
    }
    
    void setNumberOfTrees(byte treeCount) {
        // TODO: Write tests for this
    }
    
    void addListeners() {
        // TODO: Write tests for this
    }
    
    void removeListeners() {
        // TODO: Write tests for this
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        //
    }

    @Override
    public void mouseExited(MouseEvent event) {
        //
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // TODO: Enable start of dragging
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO: Clear tree selection
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        //
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        // TODO: Reposition selected tree
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    // TODO: Write tests for this
    public TreePanel(byte initialNumberOfTrees) {
        this.numberOfTrees = initialNumberOfTrees;
        this.listOfTrees = new ArrayList<>(this.numberOfTrees);
    }
    
}
