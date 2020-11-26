package tik.test.cubespark.repository.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import tik.test.cubespark.model.Customer.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository <CustomerEntity, Long>{
	
	CustomerEntity findOneByName(String name);


}
