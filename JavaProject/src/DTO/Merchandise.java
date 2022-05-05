package DTO;

public class Merchandise {
	String ID, IDName, Producer, MerchandiseName;
	int Quantity, Price;
	
	public Merchandise() {
		
	}
	
	public Merchandise(String ID, String IDName, String Producer, String MerchandiseName, int Quantity, int Price) {
		this.ID = ID;
		this.IDName = IDName;
		this.Producer = Producer;
		this.MerchandiseName = MerchandiseName;
		this.Quantity = Quantity;
		this.Price = Price;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getIDName() {
		return IDName;
	}

	public void setIDName(String IDName) {
		this.IDName = IDName;
	}
	
	public String getProducer() {
		return Producer;
	}

	public void setProducer(String Producer) {
		this.Producer = Producer;
	}
	
	public String getMerchandiseName() {
		return MerchandiseName;
	}

	public void setMerchandiseName(String MerchandiseName) {
		this.MerchandiseName = MerchandiseName;
	}
	
	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
	
	public int getPrice() {
		return Quantity;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}
	
}
