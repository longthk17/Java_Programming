package BUS;

import java.util.ArrayList;

import DAL.ReceiptDAL;
import DTO.Employee;
import DTO.Receipt;

public class ReceiptBUS {
	
	ReceiptDAL recDAL = new ReceiptDAL();
	
	public ArrayList<Receipt> getAllReceipt() {
		return recDAL.getAllReceipt();
	}
	
	public String addReceipt(Employee emp, String cusId, String recId) {
		if(recDAL.addReceipt(emp, cusId, recId)) {
			return "Mời chọn thông tin hóa đơn";
		} else {
			return "Không thành công";
		}
	}
	

	public boolean deleteReceipt(String id) {
		if(recDAL.deleteReceipt(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Receipt> getByIdSearch(String recId) {
		return recDAL.getByIdSearch(recId);
	}
	
	public ArrayList<Receipt> getByEmployeeDetailSearch(String name) {
		return recDAL.getByEmployeeDetailSearch(name);
	}
	
	public ArrayList<Receipt> getByCustomerDetailSearch(String name) {
		return recDAL.getByCustomerDetailSearch(name);
	}
	
	public boolean hasReceiptId(String id) {
		if(recDAL.hasReceiptId(id)) {
			return true;
		} else return false;
	}

}
