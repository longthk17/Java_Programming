package DTO;

public class Merchandise {
	String id, idname, producer, merchandisename;
	int quantity, price;
	
	public Merchandise() {
		
	}
	
	public Merchandise(String id, String idname, String producer, String merchandisename, int quantity, int price) {
		this.id = id;
		this.idname = idname;
		this.producer = producer;
		this.merchandisename = merchandisename;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}
	
	public String getIDName() {
		return idname;
	}

	public void setIDName(String idname) {
		this.idname = idname;
	}
	
	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public String getMerchandiseName() {
		return merchandisename;
	}

	public void setMerchandiseName(String merchandisename) {
		this.merchandisename = merchandisename;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
