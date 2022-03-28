package winform_ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodOrdering extends JFrame implements ActionListener {
	private JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
	private JLabel label;
	private JButton order;
	
	public FoodOrdering(String title) {
		initGUI(title);
	}
	
	private void initGUI(String title) {
		setTitle(title);
		setBounds(500,80,500,300);
		setLayout(null);
		
		label = new JLabel("Menu");
		label.setBounds(70, 10, 100, 30);
		
		checkBox1 = new JCheckBox("Pizza ($25)");
		checkBox1.setBounds(100,50,100,30);
		checkBox2 = new JCheckBox("Burger ($20)");
		checkBox2.setBounds(100,80,100,30);
		checkBox3 = new JCheckBox("Tea ($5)");
		checkBox3.setBounds(100,110,100,30);
		checkBox4 = new JCheckBox("Coffee ($10)");
		checkBox4.setBounds(100,140,100,30);
		
		order = new JButton("Order");
		order.setBounds(100,200,100,30);
		
		add(label);
		add(checkBox1);
		add(checkBox2);
		add(checkBox3);
		add(checkBox4);
		add(order);
		order.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getSource() == order) {
        	float amount=0;  
            String msg="";

            if(checkBox1.isSelected()){  
                amount+=25;  
                msg="Pizza: $25\n";  
            }  
            if(checkBox2.isSelected()){  
                amount+=20;  
                msg+="Burger: $20\n";  
            }  
            if(checkBox3.isSelected()){  
                amount+=5;  
                msg+="Tea: $5\n";  
            }  
            if(checkBox4.isSelected()){  
                amount+=10;  
                msg+="Coffee: $10\n";  
            }   
            msg+="-----------------\n";  
            JOptionPane.showMessageDialog(this,msg+"Total: $"+ amount);
        }  
	}

}
