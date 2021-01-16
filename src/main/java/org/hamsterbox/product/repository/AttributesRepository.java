package org.hamsterbox.product.repository;

import org.bson.types.ObjectId;
import org.hamsterbox.product.model.Attributes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * AttributesRepository
 */
@Repository
public interface AttributesRepository extends MongoRepository<Attributes, ObjectId> {

}
