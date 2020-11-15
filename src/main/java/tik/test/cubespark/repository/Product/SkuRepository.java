package tik.test.cubespark.repository.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tik.test.cubespark.model.Product.Sku;

@Repository
public interface SkuRepository extends JpaRepository<Sku, String>{
	
}
