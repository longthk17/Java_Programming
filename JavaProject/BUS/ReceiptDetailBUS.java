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
	
	public ReceiptDetail getMerchandiseByDetail(String name) {
		return recDetailDAL.getMerchandiseByDetail(name);
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
		if(recDetailDAL.hasMerchandiseDetail(recId, merId)) {
			if(recDetailDAL.updateDetail(recId, merId, quantity, amount)) {
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
	
	public boolean deleteDetail(String id) {
		if(recDetailDAL.deleteDetail(id)) {
			return true;
		} else return false;
	}
}
