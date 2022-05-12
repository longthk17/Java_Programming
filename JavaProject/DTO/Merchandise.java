package DTO;

import java.sql.Date;

public class Merchandise {
	String id, producer, merchandiseName;
	int quantity;
	long price;
	Date createDate, updateDate;
	
	public Merchandise() {
		
	}

	public Merchandise(String id, String producer, String merchandiseName, int quantity, long price,
			Date createDate, Date updateDate) {
		this.id = id;
		this.producer = producer;
		this.merchandiseName = merchandiseName;
		this.quantity = quantity;
		this.price = price;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getMerchandiseName() {
		return merchandiseName;
	}

	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
