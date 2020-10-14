package com.ds.order.repository;

import com.ds.order.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {

}
