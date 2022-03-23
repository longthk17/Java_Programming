package com.company;

import javax.swing.*;

public class CountClick {
    public CountClick() {
        int count = 10;
        String s = Integer.toString(count);
        JFrame f = new JFrame("Counter");
        JButton b = new JButton("Click me!");
        JLabel l = new JLabel("Click count: " + s);
        f.setVisible(true);
    }
}
