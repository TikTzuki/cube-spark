package org.hamsterbox.product.repository;

import org.bson.types.ObjectId;
import org.hamsterbox.product.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoryRepository
 */
@Repository
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {

}
