package tik.test.cubespark.service.LocalBillService;

import java.util.List;


import tik.test.cubespark.model.LocalBill.dto.LocalBillDTO;
import tik.test.cubespark.model.LocalBill.entity.LocalBillEntity;

public interface ILocalBillService {
	LocalBillDTO save(LocalBillDTO localBillDTO);
	void delete(String[] ids);
	public List<LocalBillEntity> findAll();

}
