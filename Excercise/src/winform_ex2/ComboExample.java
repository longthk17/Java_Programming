package winform_ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboExample extends JFrame implements ActionListener {
	private JComboBox cb;
	
	public ComboExample(String title) {
		initGUI(title);
	}
	
	private void initGUI(String title) {
		setTitle(title);
		setBounds(500,80,500,300);
		setLayout(null);
//		getContentPane().setBackground(Color.BLUE);
		
		String combo[] = {"White", "Green", "Blue", "Yellow", "Red"};
		
		cb = new JComboBox(combo);
		cb.setBounds(100,50,100,30);
		
		add(cb);
		cb.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(cb.getSelectedItem() == "White") {
			getContentPane().setBackground(Color.WHITE);
		}
		if(cb.getSelectedItem() == "Green") {
			getContentPane().setBackground(Color.GREEN);
		}
		if(cb.getSelectedItem() == "Blue") {
			getContentPane().setBackground(Color.BLUE);
		}
		if(cb.getSelectedItem() == "Yellow") {
			getContentPane().setBackground(Color.YELLOW);
		}
		if(cb.getSelectedItem() == "Red") {
			getContentPane().setBackground(Color.RED);
		}
	}

}
