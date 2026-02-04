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
import java.util.*;

import javax.swing.*;

import org.example.graphics.scene.*;

/**
 *
 * @author Alonso del Arte
 */
public class TreePanel extends JPanel {
    
    private byte numberOfTrees;
    
    private final java.util.List<Tree> listOfTrees;
    
    void addTree() {
        this.listOfTrees.add(new Tree(Color.GREEN, new Dimension( 50, 100)));
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

    public TreePanel(byte initialNumberOfTrees) {
        this.numberOfTrees = initialNumberOfTrees;
        this.listOfTrees = new ArrayList<>(this.numberOfTrees);
    }
    
}
