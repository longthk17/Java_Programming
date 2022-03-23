package winform_ex2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class SimpleCalculator extends JFrame implements ActionListener {
	private JLabel label1, label2, result_label;
	private JTextField tf1, tf2, result;
	private JPanel panel1;
	private JButton divide, add, subtract, multiply;
	public SimpleCalculator(String title) {
		initGUI(title);
	}
	
	private void initGUI(String title) {
		setTitle(title);
//		setSize(300,200);
		setBounds(500,80, 300, 200);
		setResizable(false);

		panel1 = new JPanel();
		
		label1 = new JLabel("Num1:");
		label2 = new JLabel("Num2:");
		result_label = new JLabel("Result:");
		
		panel1.setBounds(40,80,200,200);
		panel1.setLayout(new GridLayout(3,3,0,0));
		
		tf1 = new JTextField(11);
		tf2 = new JTextField(11);
		result = new JTextField(11);
		result.setEditable(false);
		
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		
		
		add(panel1);
		panel1.add(label1);
		panel1.add(tf1);
		panel1.add(label2);
		panel1.add(tf2);
		panel1.add(result_label);
		panel1.add(result);
		add(add);
		add(subtract);
		add(multiply);
		add(divide);
		
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			String checktf1 = tf1.getText();
			String checktf2 = tf2.getText();
			if(checktf1!=null && !checktf1.trim().equals("") && checktf2!=null && !checktf2.trim().equals(""));
			try {
				int num1 = Integer.parseInt(checktf1);
				int num2 = Integer.parseInt(checktf2);
				int sum = num1 + num2;
				
				String kq = Integer.toString(sum);
				
				result.setText(kq);
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu");
			}
		}
		
		if(e.getSource() == subtract) {
			String checktf1 = tf1.getText();
			String checktf2 = tf2.getText();
			if(checktf1!=null && !checktf1.trim().equals("") && checktf2!=null && !checktf2.trim().equals(""));
			try {
				int num1 = Integer.parseInt(checktf1);
				int num2 = Integer.parseInt(checktf2);
				int sum = num1 - num2;
				
				String kq = Integer.toString(sum);
				
				result.setText(kq);
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu");
			}
		}
		
		if(e.getSource() == multiply) {
			String checktf1 = tf1.getText();
			String checktf2 = tf2.getText();
			if(checktf1!=null && !checktf1.trim().equals("") && checktf2!=null && !checktf2.trim().equals(""));
			try {
				int num1 = Integer.parseInt(checktf1);
				int num2 = Integer.parseInt(checktf2);
				int sum = num1 * num2;
				
				String kq = Integer.toString(sum);
				
				result.setText(kq);
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu");
			}
		}
		
		if(e.getSource() == divide) {
			String checktf1 = tf1.getText();
			String checktf2 = tf2.getText();
			if(checktf1!=null && !checktf1.trim().equals("") && checktf2!=null && !checktf2.trim().equals(""));
			try {
				int num1 = Integer.parseInt(checktf1);
				int num2 = Integer.parseInt(checktf2);
				int sum = num1 / num2;
				
				String kq = Integer.toString(sum);
				
				result.setText(kq);
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu");
			}
		}
		
	}

}