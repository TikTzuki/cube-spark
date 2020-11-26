package tik.test.cubespark.converter.LocalBillConverter;

import org.springframework.stereotype.Component;

import tik.test.cubespark.model.LocalBill.dto.LocalBillDTO;
import tik.test.cubespark.model.LocalBill.entity.LocalBillEntity;

@Component
public class LocalBillConverter {
	public LocalBillEntity toEntity(LocalBillDTO localBillDTO) {
		LocalBillEntity entity = new LocalBillEntity();
		entity.setDiscount(localBillDTO.getDiscount());
		entity.setStatus(localBillDTO.getStatus());
		entity.setTotal(localBillDTO.getTotal());
		return entity;
	}
	
	public LocalBillDTO toDTO (LocalBillEntity localBillEntity) {
		LocalBillDTO dto = new LocalBillDTO();
		if(localBillEntity.getId() != null) {
			dto.setId(localBillEntity.getId());
		}
		dto.setDiscount(localBillEntity.getDiscount());
		dto.setStatus(localBillEntity.getStatus());
		dto.setTotal(localBillEntity.getTotal());
		dto.setCreatedDate(localBillEntity.getCreatedDate());
		dto.setUpdatedDate(localBillEntity.getUpdatedDate());
		return dto;
	}
	public LocalBillEntity toEntity(LocalBillDTO localBillDTO, LocalBillEntity entity) {
		entity.setDiscount(localBillDTO.getDiscount());
		entity.setStatus(localBillDTO.getStatus());
		entity.setTotal(localBillDTO.getTotal());
		return entity;
	}

}
