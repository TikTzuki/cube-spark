package tik.test.cubespark.repository.LocalBill;

import org.springframework.data.jpa.repository.JpaRepository;

import tik.test.cubespark.model.LocalBill.entity.LocalBillEntity;


public interface LocalBillRepository extends JpaRepository<LocalBillEntity, Long>{

}
