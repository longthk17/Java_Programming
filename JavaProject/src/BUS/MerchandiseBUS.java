package BUS;

import java.util.ArrayList;

import DAL.MerchandiseDAL;
import DTO.Merchandise;

public class MerchandiseBUS {
	
	MerchandiseDAL merDAL = new MerchandiseDAL();
	public ArrayList<Merchandise> getAllMerchandise() {
	return merDAL.getAllMerchandise();
	}
		
	public String addEmployee(Merchandise mer) {
	if(merDAL.hasMerchandiseID(mer.getID())) {
		return "MĂ£ NV Ä‘Ă£ tá»“n táº¡i";
	} else if (merDAL.hasMerchandiseID(mer.getIDName())) {
			return "TĂ i khoáº£n Ä‘Ă£ tá»“n táº¡i";
		} else if (merDAL.addMerchandise(mer)) {
			return "Thêm Thành Công";
		} else {
			return "Thêm Thất Bại";
		}
	}
		
	public String updateMerchandise(Merchandise emp) {
		if (merDAL.updateMerchandise(emp)) {
			return "Cập nhật thành công";
		} else {
			return "Cập nhật thất bại";
		}
	}
		
	public String deleteMerchandise(String id) {
		if(merDAL.hasMerchandiseID(id) == false) {
			return "MĂ£ NV khĂ´ng tá»“n táº¡i";
		} else if(merDAL.deleteMerchandise(id)) {
			return "XĂ³a thĂ nh cĂ´ng";
		} else {
			return "XĂ³a tháº¥t báº¡i";
		}
	}

}

