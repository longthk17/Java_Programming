package DTO;

public class ReceiptDetail {
	int quantity;
	float amount, price;
	String id, merchandiseName, producer, merchandiseId, receiptId;
	
	public ReceiptDetail() {
		
	}

	public ReceiptDetail(String id, int quantity, float amount, float price, String merchandiseId, String receiptId, String merchandiseName, String producer) {
		this.id = id;
		this.quantity = quantity;
		this.amount = amount;
		this.price = price;
		this.merchandiseId = merchandiseId;
		this.receiptId = receiptId;
		this.merchandiseName = merchandiseName;
		this.producer = producer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getMerchandiseId() {
		return merchandiseId;
	}

	public void setMerchandiseId(String merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getMerchandiseName() {
		return merchandiseName;
	}

	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
		

}
