package BUS;

import java.util.ArrayList;

import DAL.ReceiptDetailDAL;
import DTO.Customer;
import DTO.Employee;
import DTO.Merchandise;
import DTO.Receipt;

public class ReceiptDetailBUS {

	ReceiptDetailDAL recDetailDAL = new ReceiptDetailDAL();
	public ArrayList<Customer> getAllCustomer() {
		return recDetailDAL.getAllCustomer();
	}
	
	public ArrayList<Merchandise> getAllMerchandise() {
		return recDetailDAL.getAllMerchandise();
	}
	
	public Customer getByFullName(String fullName) {
		return recDetailDAL.getByFullName(fullName);
	}
	
	public Merchandise getByMerchandiseName(String name) {
		return recDetailDAL.getByMerchandiseName(name);
	}
	
	public String addOrder(Employee emp, Merchandise mer, String cusId, String recId, int quantity) {
		if(recDetailDAL.addOrder(emp, cusId, recId)) {
			if(recDetailDAL.addMerchandiseOrder(mer,recId, quantity)) {
				return "Thành công";
			} else {
				return "Thất bại";
			}
		} else {
			return "Đặt hàng không thành công";
		}
	}
	
	public boolean deleteOrder(String id) {
		if(recDetailDAL.deleteOrder(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int compareInventory(String merId) {
		return recDetailDAL.compareInventory(merId);
	}
}
