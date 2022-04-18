package GUI;

import java.util.ArrayList;

class Item {
	int ma_sp;
	String ten_sp, tenloai_sp;
	int price;
	
	public Item() {
		
	}

	public Item(int ma_sp, String ten_sp, int price, String tenloai_sp) {
		this.ma_sp = ma_sp;
		this.ten_sp = ten_sp;
		this.price = price;
		this.tenloai_sp = tenloai_sp;
	}

	public int getMa_sp() {
		return ma_sp;
	}

	public void setMa_sp(int ma_sp) {
		this.ma_sp = ma_sp;
	}

	public String getTen_sp() {
		return ten_sp;
	}

	public void setTen_sp(String ten_sp) {
		this.ten_sp = ten_sp;
	}

	public String getTenloai_sp() {
		return tenloai_sp;
	}

	public void setTenloai_sp(String tenloai_sp) {
		this.tenloai_sp = tenloai_sp;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static ArrayList<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
