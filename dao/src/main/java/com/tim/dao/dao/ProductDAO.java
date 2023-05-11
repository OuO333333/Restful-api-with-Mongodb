package com.tim.dao.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tim.common.entity.Product;


@Repository
public interface ProductDAO extends MongoRepository<Product, String> {

}
