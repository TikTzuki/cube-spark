package org.hamsterbox.product.repository;

import org.hamsterbox.product.model.Sku;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * SkuRepository
 */
public interface SkuRepository extends MongoRepository<Sku, String> {

}
