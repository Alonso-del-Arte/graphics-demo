/*
 * (c) 2026 AL
 */
package org.example.graphics.demo;

import java.awt.*;

import javax.swing.*;

/**
 *
 * @author Alonso del Arte
 */
public final class GraphicsDemo extends JFrame {
    
    public static final byte DEFAULT_NUMBER_OF_TREES = 31;
    
    private final JTextField numberField = new JTextField(5);

    public GraphicsDemo() {
        this(DEFAULT_NUMBER_OF_TREES);
    }

    public GraphicsDemo(byte initialNumberOfTrees) {
        this.add(new JLabel("Number of trees"));
        this.add(this.numberField);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphicsDemo demo = new GraphicsDemo();
        demo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        demo.pack();
        demo.setVisible(true);
    }
    
}
