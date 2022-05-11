package BUS;

import DAL.ReceiptDAL;
import DTO.Employee;

public class ReceiptBUS {
	
	ReceiptDAL recDAL = new ReceiptDAL();
	
	public String addOrder(Employee emp, String cusId, String recId) {
		if(recDAL.addOrder(emp, cusId, recId)) {
			return "Mời chọn thông tin hóa đơn";
		} else {
			return "Không thành công";
		}
	}

}
