/*
 * Copyright (C) 2026 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.example.graphics.demo;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import org.example.graphics.scene.*;

/**
 *
 * @author Alonso del Arte
 */
public final class TreePanel extends JPanel implements MouseListener, 
        MouseMotionListener {
    
    private byte numberOfTrees;
    
    private boolean hasTreeSelected = false;
    
    private Point lastRecordedMousePosition = new Point(-1, -1);
    
    private Point offset = new Point(0, 0);
    
    private Tree selectedTree = null;
    
    private final java.util.List<Tree> listOfTrees;
    
    void addTree() {
        this.listOfTrees.add(new Tree(Color.GREEN, new Dimension(50, 100)));
    }
    
    void changeNumberOfTrees(byte treeCount) {
        this.numberOfTrees = treeCount;
        while (this.listOfTrees.size() > treeCount) {
            this.listOfTrees.remove(0);
        }
        while (this.listOfTrees.size() < treeCount) {
            this.addTree();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.listOfTrees.forEach((tree) -> {
            tree.paint(g);
        });
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
        int x = event.getX();
        int y = event.getY();
        Point point = new Point(x, y);
        for (Tree tree : this.listOfTrees) {
            if (tree.contains(point)) {
                this.hasTreeSelected = true;
                this.selectedTree = tree;
                Point corner = tree.getPosition();
                this.offset = new Point(corner.x - point.x, corner.y - point.y);
                this.lastRecordedMousePosition = point;
                return;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        this.hasTreeSelected = false;
        this.selectedTree = null;
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        //
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (this.hasTreeSelected) {
            Point treePos = this.selectedTree.getPosition();
            Point relocated = new Point(event.getX(), event.getY());
            this.lastRecordedMousePosition = relocated;
//            relocated.move(this.offset.x, this.offset.y);
            this.selectedTree.setPosition(relocated);
            this.repaint();
        }
    }

    public TreePanel(byte initialNumberOfTrees) {
        this.numberOfTrees = initialNumberOfTrees;
        this.listOfTrees = new ArrayList<>(this.numberOfTrees);
        while (this.listOfTrees.size() < this.numberOfTrees) {
            this.addTree();
        }
        Dimension preferredSize = new Dimension(500, 200);
        this.setPreferredSize(preferredSize);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
}
