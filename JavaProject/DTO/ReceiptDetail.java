package DTO;

public class ReceiptDetail {
	int id, quantity, amount;
	Merchandise merchandiseId;
	Receipt receiptId;
	
	public ReceiptDetail() {
		
	}

	public ReceiptDetail(int id, int quantity, int amount, Merchandise merchandiseId, Receipt receiptId) {
		this.id = id;
		this.quantity = quantity;
		this.amount = amount;
		this.merchandiseId = merchandiseId;
		this.receiptId = receiptId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Merchandise getMerchandiseId() {
		return merchandiseId;
	}

	public void setMerchandiseId(Merchandise merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

	public Receipt getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Receipt receiptId) {
		this.receiptId = receiptId;
	}
		

}
