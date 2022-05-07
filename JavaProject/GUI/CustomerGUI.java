package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class CustomerGUI extends JPanel {
	private JTextField id;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public CustomerGUI() {
		setBackground(new Color(152, 251, 152));
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(66, 72, 49, 31);
		add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(222, 73, 598, 34);
		add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý Khách Hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(423, 25, 165, 21);
		add(lblNewLabel_1);
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(57, 130, 78, 31);
		add(lblFullName);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(57, 185, 78, 31);
		add(lblGender);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(57, 226, 78, 31);
		add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(57, 283, 78, 31);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(57, 324, 78, 31);
		add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(222, 131, 598, 34);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(222, 227, 598, 34);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(222, 281, 598, 34);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(222, 325, 598, 34);
		add(textField_4);
		
		table = new JTable();
		table.setBounds(65, 409, 1, 1);
		add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Full Name", "Gender", "Phone", "Email", "Address"},
				{"", null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				" ID", "Full Name", "Gender", "Phone", "Email", "Address"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(0).setMinWidth(30);
		table_1.setBounds(0, 436, 1050, 112);
		add(table_1);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog("hgjhj");
			}
		});
		btnNewButton.setBounds(460, 379, 93, 31);
		add(btnNewButton);
		
		JButton btnFix = new JButton("DELETE");
		btnFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnFix.setBounds(282, 379, 93, 31);
		add(btnFix);
		
		JButton btnMore = new JButton("UPDATE");
		btnMore.setBounds(635, 379, 93, 31);
		add(btnMore);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Nam");
		chckbxNewCheckBox.setBounds(225, 190, 60, 24);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Nữ");
		chckbxNewCheckBox_1.setBounds(306, 190, 60, 24);
		add(chckbxNewCheckBox_1);

	}
}
