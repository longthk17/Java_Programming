package BUS;

import java.util.ArrayList;

import DAL.ReceiptDetailDAL;
import DTO.Customer;
import DTO.Employee;
import DTO.Merchandise;
import DTO.Receipt;
import DTO.ReceiptDetail;

public class ReceiptDetailBUS {

	ReceiptDetailDAL recDetailDAL = new ReceiptDetailDAL();
	
	public ArrayList<ReceiptDetail> getReceiptDetailById(String recId) {
		return recDetailDAL.getReceiptDetailById(recId);
	}
	
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
	
	public String insertDetail(String merId, String recId, int quantity, long amount) {
		if(recDetailDAL.hasMerchandiseDetail(merId)) {
			
			if(recDetailDAL.updateDetail(merId, quantity, amount)) {
				return "Thêm thành công";
			} else {
				return "Thêm thất bại";
			}
		} else {
			if(recDetailDAL.insertDetail(merId, recId, quantity, amount)) {
				return "Thêm thành công";
			} else {
				return "Thêm thất bại";
			}	
		}
	}
	
	public int getMerchandiseQuantity(String merId) {
		return recDetailDAL.getMerchandiseQuantity(merId);
	}
	
	public int compareInventory(String merId) {
		return recDetailDAL.compareInventory(merId);
	}
}
