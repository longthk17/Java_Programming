package winform_ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountClick extends JFrame implements ActionListener {
	private JButton b;
	private JLabel l;
	int count = 0;
	public CountClick(String title) {
		initGUI(title);
	}
	
	private void initGUI(String title) {
		b = new JButton("Click me!");
		l = new JLabel("Click count: " + count);
		b.setBounds(50,50,100,40);
		l.setBounds(160,50,100,30);
		add(b);
		add(l);
		b.addActionListener(this);
		
		setTitle(title);
		setBounds(500,80, 300, 200);
		setLayout(null);
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b) {
			count++;
			l.setText("Click count: " + count);
		}
	}
}
