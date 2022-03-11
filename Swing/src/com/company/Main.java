package com.company;

import java.awt.*;
import javax.swing.*;

public class Main {

    public Main(){
        JFrame f = new JFrame("HelloWorld");
        JButton b1 = new JButton("Clear");
        JButton b2 = new JButton("Submit");
        JButton b3 = new JButton("Exit");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JLabel l1 = new JLabel("Enter your name");
        JLabel l2 = new JLabel("Enter your city");
        b1.setBounds(150,50,100,50);

        f.setSize(250,200);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();

    }
}
