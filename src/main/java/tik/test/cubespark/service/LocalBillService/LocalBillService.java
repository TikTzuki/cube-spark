package tik.test.cubespark.service.LocalBillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tik.test.cubespark.converter.LocalBillConverter.LocalBillConverter;
import tik.test.cubespark.model.Customer.entity.CustomerEntity;
import tik.test.cubespark.model.LocalBill.dto.LocalBillDTO;
import tik.test.cubespark.model.LocalBill.entity.LocalBillEntity;
import tik.test.cubespark.repository.Customer.CustomerRepository;
import tik.test.cubespark.repository.LocalBill.LocalBillRepository;

@Service
public class LocalBillService implements ILocalBillService{
	@Autowired
	private LocalBillRepository localBillRepository;
	//dependency injection
	
	@Autowired 
	private CustomerRepository customerRepository;
	
	@Autowired 
	private LocalBillConverter localBillConverter;


	@Override
	public LocalBillDTO save(LocalBillDTO localBillDTO) {
		LocalBillEntity localBillEntity = new LocalBillEntity();
		if(localBillDTO.getId() != 0) {//update
			LocalBillEntity oldLocalBillEntity = localBillRepository.findById(localBillDTO.getId()).orElse(new LocalBillEntity());
			localBillEntity = localBillConverter.toEntity(localBillDTO, oldLocalBillEntity);
		}else {
			//create
			localBillEntity = localBillConverter.toEntity(localBillDTO);
		}
		CustomerEntity customerEntity =  customerRepository.findOneByName(localBillDTO.getCustomer());
		localBillEntity.setCustomer(customerEntity);
		localBillEntity = localBillRepository.save(localBillEntity);
		return localBillConverter.toDTO(localBillEntity);
	}

	@Override
	public void delete(String[] ids) {
		
	}

}
