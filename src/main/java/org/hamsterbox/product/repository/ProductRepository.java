package org.hamsterbox.product.repository;

import org.bson.types.ObjectId;
import org.hamsterbox.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {

}
