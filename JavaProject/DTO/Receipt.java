package DTO;

import java.sql.Date;
import java.util.ArrayList;

public class Receipt {
	String id;
	String employeeId;
	String customerId;
	Date createDate, updateDate;
	
	ArrayList<ReceiptDetail> receiptDetail = new ArrayList<ReceiptDetail>();

	public Receipt() {
		
	}

	public Receipt(String id, String employeeId, String customerId, Date createDate, Date updateDate) {
		this.id = id;
		this.employeeId = employeeId;
		this.customerId = customerId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	
	public ArrayList<ReceiptDetail> getReceiptDetail() {
		return receiptDetail;
	}

	public void setReceiptDetail(ArrayList<ReceiptDetail> receiptDetail) {
		this.receiptDetail = receiptDetail;
	}
	
}
