package tik.test.cubespark.model.Customer.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tik.test.cubespark.model.LocalBill.entity.LocalBillEntity;


@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
	
	@Column (name = "name")
	private String name;
	
	@OneToMany(mappedBy = "customer")
	private List<LocalBillEntity> localBills = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LocalBillEntity> getLocalBills() {
		return localBills;
	}

	public void setLocalBills(List<LocalBillEntity> localBills) {
		this.localBills = localBills;
	}
	
	

}
