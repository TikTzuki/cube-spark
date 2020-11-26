package tik.test.cubespark.model.LocalBill.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocalBillDTO {
	private long id;
	private Date createdDate;
	private Date updatedDate;
	private String customer;
	private double discount;
	private int total;
	private String status;
	
	private List<LocalBillDTO> listResult = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LocalBillDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<LocalBillDTO> listResult) {
		this.listResult = listResult;
	}
	
	
}