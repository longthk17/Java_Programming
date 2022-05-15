package BUS;

import java.util.ArrayList;


import DAL.CustomerDAL;
import DTO.Customer;
import DAL.ReceiptDetailDAL;

public class CustomerBUS {

	CustomerDAL cusDAL = new CustomerDAL();
	public ArrayList<Customer> getAllCustomer() {
		return cusDAL.getAllCustomer();
	}
	
	public ArrayList<Customer> getByFullNameSearch(String fullName) {
		return cusDAL.getByFullNameSearch(fullName);
	}
	
	public ArrayList<Customer> getByIdSearch(String id) {
		return cusDAL.getByIdSearch(id);
	}
	
	public Customer getByFullName(String fullName) {
		return cusDAL.getByFullName(fullName);
	}
	
	public ArrayList<Customer> getByPhoneSearch(String phone) {
		return cusDAL.getByPhoneSearch(phone);
	}
	
	public String addCustomer(Customer cus) {
		if(cusDAL.hasCustomerId(cus.getId())) {
			return "Mã KH đã tồn tại";
		} else if (cusDAL.addCustomer(cus)) {
			return "Thêm thành công";
		} else {
			return "Thêm thất bại";
		}
	}
	
	public String updateCustomer(Customer cus) {
		if(cusDAL.updateCustomer(cus)) {
			return "Cập nhật thành công";
		} else {
			return "Cập nhật thất bại";
		}
	}
	
	public String deleterCustomer(String id) {
		if(cusDAL.hasCustomerId(id) == false) {
			return "Mã KH không tồn tại";
		} else if(cusDAL.deleteEmployee(id)) {
			return "Xóa thành công";
		} else {
			return "Xóa thất bại";
		}
	}
}
