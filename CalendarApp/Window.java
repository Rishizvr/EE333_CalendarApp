/*
 * File: Window.java
 * Author: Rishi Zaveri sage0@uab.edu
 * Assignment:  sage0-p5 - EE333 Fall 2019
 * Vers: 1.0.0 11/05/2019 rz - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.sage0.sage0.p5;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Rishi Zaveri sage0@uab.edu
 */
public class Window {
    
    // Properties
    private String filePath = null;
    private int fieldColumn = 0;
    
    // Constructor
    public Window(int width, int height, String title) {
        
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        
        Dimension dim = new Dimension(100, 20);
        Dimension fileLocationFieldDim = new Dimension(500, 20);
        
        // Component settings
        JButton browseButton = new JButton("Browse");
        JButton generateButton = new JButton("Click to Generate");
        JButton exitButton = new JButton("Exit");
        JTextField fileLocationField = new JTextField(260);
        browseButton.setToolTipText("Browse this computer");
        browseButton.setMinimumSize(dim);
        browseButton.setPreferredSize(dim);
        generateButton.setToolTipText("Display formatted calendar");
        generateButton.setMinimumSize(new Dimension(200, 20));
        generateButton.setPreferredSize(new Dimension(200, 20));
        exitButton.setMinimumSize(dim);
        exitButton.setPreferredSize(dim);
        fileLocationField.setMinimumSize(fileLocationFieldDim);
        fileLocationField.setPreferredSize(fileLocationFieldDim);
        fileLocationField.setEditable(false);
        generateButton.setEnabled(false);
        
        
        browseButton.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new java.io.File("."));
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            
            if (fc.showOpenDialog(browseButton) == JFileChooser.APPROVE_OPTION){
                System.out.println("\nFile selected");
                
                fileLocationField.setText(fc.getSelectedFile().getAbsolutePath());
            
                System.out.println("Your file:   " + fc.getSelectedFile().getAbsolutePath() +"\n");
                filePath = fc.getSelectedFile().getAbsolutePath();
            }
            
            
            if (fileLocationField.getText().endsWith(".txt")) {
                generateButton.setEnabled(true);
            }
            if (!fileLocationField.getText().endsWith(".txt")) {
                generateButton.setEnabled(false);
                
            }
            
        });
        
        generateButton.addActionListener(e -> {
            new CalendarPrint(filePath);
        });
        
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        
        addHelp(c, panel);
        
        // Browse button, File location text, Generate button, Exit button, Credits
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(browseButton, c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(fileLocationField, c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(generateButton, c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("*You must have a .txt file to generate a Calendar"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel(" "), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(exitButton, c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel(" "), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Rishi Zaveri, sage0, v1.0"), c);
        
        frame.setVisible(true);
        
    }
    
    private void addHelp(GridBagConstraints c, JPanel panel) {
        // Help Text
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Please enter a comma separated text file."), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Your text file should look like this:"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Year,Month,Role,Description"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Year,Month,Role,Description"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("..."), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel(" "), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("For example:"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("odd,January,Director,Present research on modern electronics"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("each,May/June/July,Student Activities Committee Chair,Plan social events calendar for upcoming year"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("even,November,Treasurer,Review financial charts"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel(" "), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Rules:"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("The year field must be even, odd, or each."), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Multiple months should be separated by forward slashes (/)"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Max Characters: Role 35, Description 120"), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel(" "), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel("Thank you for using my program."), c);
        c.gridx = 0; c.gridy = fieldColumn++;
        panel.add(new JLabel(" "), c);
        
    }
    
}
