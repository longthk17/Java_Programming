package BUS;

import java.util.ArrayList;

import DAL.ReceiptDetailDAL;
import DTO.Customer;
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
	
	public String addMerchandiseOrder(Merchandise mer, String recId, int quantity) {
		if(recDetailDAL.addMerchandiseOrder(mer, recId, quantity)) {
			return "Thành công";
		} else {
			return "Thất bại";
		}
	}
	
	public int compareInventory(String merId) {
		return recDetailDAL.compareInventory(merId);
	}
}
