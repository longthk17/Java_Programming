package winform_ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RadioButtonDemo extends JFrame implements ActionListener {
	private JRadioButton rb1, rb2, rb3, rb4, rb5;
	private ImageIcon fish, cat, dog, pig, rabbit;
	private JLabel lb;
	
	public RadioButtonDemo(String title) {
		initGUI(title);
	}
	
	private void initGUI(String title) {
		setTitle(title);
		setBounds(500,80,500,300);
		setLayout(null);
		
		
		fish = new ImageIcon("C:/Users/admin/Desktop/Image/fish.jpg");
		cat = new ImageIcon("C:/Users/admin/Desktop/Image/cat.jpg");
		dog = new ImageIcon("C:/Users/admin/Desktop/Image/dog.jfif");
		pig = new ImageIcon("C:/Users/admin/Desktop/Image/pig.jfif");
		rabbit = new ImageIcon("C:/Users/admin/Desktop/Image/rabbit.png");
		lb = new JLabel("");
		lb.setBounds(200,10,250,250);
		
		rb1 = new JRadioButton("Fish");
		rb1.setBounds(100,50,100,30);
		rb2 = new JRadioButton("Cat");
		rb2.setBounds(100,80,100,30);
		rb3 = new JRadioButton("Dog");
		rb3.setBounds(100,110,100,30);
		rb4 = new JRadioButton("Rabbit");
		rb4.setBounds(100,140,100,30);
		rb5 = new JRadioButton("Pig");
		rb5.setBounds(100,170,100,30);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		bg.add(rb5);
		add(rb1);
		add(rb2);
		add(rb3);
		add(rb4);
		add(rb5);
		
		add(lb);
		
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		rb4.addActionListener(this);
		rb5.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(rb1.isSelected()) {
			lb.setIcon(fish);
		}if(rb2.isSelected()) {
			lb.setIcon(cat);
		}if(rb3.isSelected()) {
			lb.setIcon(dog);
		}if(rb4.isSelected()) {
			lb.setIcon(rabbit);
		}if(rb5.isSelected()) {
			lb.setIcon(pig);
		}
	}

}
