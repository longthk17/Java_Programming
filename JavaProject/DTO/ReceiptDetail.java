package DTO;

import java.util.UUID;

public class ReceiptDetail {
	int quantity;
	long amount, price;
	String merchandiseName, producer, merchandiseId, receiptId, id;
	
	public ReceiptDetail() {
		
	}

	public ReceiptDetail(String id, int quantity, long amount, long price, String merchandiseId, String receiptId, String merchandiseName, String producer) {
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

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
		

}
