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

}
