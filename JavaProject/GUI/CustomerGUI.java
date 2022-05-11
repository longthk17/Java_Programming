package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class CustomerGUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public CustomerGUI() {
		setBackground(new Color(240, 255, 240));
		setLayout(null);
		setSize(1050,630);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(41, 10, 206, 36);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 56, 138, 23);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("FULLNAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(41, 121, 138, 23);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PHONE");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(41, 183, 138, 23);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("EMAIL");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(455, 56, 138, 23);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("GENDER");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(455, 121, 138, 23);
		add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(0, 250, 154));
		btnNewButton.setBounds(779, 271, 138, 48);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(126, 56, 206, 23);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 123, 206, 23);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 185, 206, 23);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(566, 58, 206, 23);
		add(textField_3);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "FULLNAME", "PHONE", "EMAIL", "GENDER", "ADDRESS"
			}
		));
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(90, 265, 637, 386);
		add(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBackground(new Color(0, 250, 154));
		btnAdd.setBounds(779, 368, 138, 48);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBackground(new Color(0, 250, 154));
		btnUpdate.setBounds(779, 460, 138, 48);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBackground(new Color(0, 250, 154));
		btnDelete.setBounds(779, 558, 138, 48);
		add(btnDelete);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("MALE");
		chckbxNewCheckBox.setBounds(566, 114, 98, 36);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxFemale = new JCheckBox("FEMALE");
		chckbxFemale.setBounds(666, 114, 98, 36);
		add(chckbxFemale);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ADDRESS");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(455, 183, 138, 23);
		add(lblNewLabel_1_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(566, 185, 206, 23);
		add(textField_4);

	}
}