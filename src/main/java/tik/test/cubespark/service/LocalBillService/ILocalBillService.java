package tik.test.cubespark.service.LocalBillService;

import tik.test.cubespark.model.LocalBill.dto.LocalBillDTO;
import tik.test.cubespark.model.LocalBill.entity.LocalBillEntity;

public interface ILocalBillService {
	LocalBillDTO save(LocalBillDTO localBillDTO);
//	NewsDTO update(NewsDTO newsDTO);
	void delete(String[] ids);
}
