package tik.test.cubespark.model.LocalBill.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tik.test.cubespark.model.Customer.entity.CustomerEntity;


@Entity
@Table(name ="bill")
public class LocalBillEntity extends BaseEntity{	
	@ManyToOne
	@JoinColumn(name = "customer")
    private CustomerEntity customer;
	
	@Column (name = "discount")
	private double discount;
	
	@Column (name = "total")
	private int total;
	
	@Column (name = "status")
	private String status;

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
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
	
}
	