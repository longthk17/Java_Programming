package BUS;

import java.util.ArrayList;

import DAL.MerchandiseDAL;
import DTO.Merchandise;

public class MerchandiseBUS {
	
	MerchandiseDAL merDAL = new MerchandiseDAL();
	public ArrayList<Merchandise> getAllMerchandise() {
		return merDAL.getAllMerchandise();
	}
		
	public String addMerchandise(Merchandise mer) {
		if(merDAL.hasMerchandiseID(mer.getId())) {
			return "Mã sản phẩm đã tồn tại";
		} else if (merDAL.addMerchandise(mer)) {
			return "Thêm Thành Công";
		} else {
			return "Thêm Thất Bại";
		}
	}
		
	public String updateMerchandise(Merchandise mer) {
		if (merDAL.updateMerchandise(mer)) {
			return "Cập nhật thành công";
		} else {
			return "Cập nhật thất bại";
		}
	}
		
	public String deleteMerchandise(String id) {
		if(merDAL.hasMerchandiseID(id) == false) {
			return "Sản phẩm không tồn tại";
		} else if(merDAL.deleteMerchandise(id)) {
			return "Xóa thành công";
		} else {
			return "Xóa thất bại";
		}
	}

}

