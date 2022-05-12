package DTO;

import javax.swing.DefaultComboBoxModel;

public class CustomerModel extends DefaultComboBoxModel<Customer> {
    public CustomerModel(Customer[] items) {
        super(items);
    }
}