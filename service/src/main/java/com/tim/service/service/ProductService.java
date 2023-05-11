package com.tim.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.common.entity.Product;
import com.tim.dao.dao.ProductDAO;


@Service
public class ProductService {

    @Autowired
    ProductDAO userRepository;

    public List<Product> getDB() {
        return userRepository.findAll();
    }

    public Integer getDbSize() {
        return userRepository.findAll().size();
    }

    public String getId(Integer num) {
        return userRepository.findAll().get(num).getId();
    }

    public String getName(Integer num) {
        return userRepository.findAll().get(num).getName();
    }

    public Integer getPrice(Integer num) {
        return userRepository.findAll().get(num).getPrice();
    }

    public Product getProduct(Integer num) {
        return userRepository.findAll().get(num);
    }

    public void addProduct(Product product) {
        userRepository.save(product);
    }

    public void removeProduct(int num) {
        userRepository.deleteById(userRepository.findAll().get(num).getId());
    }

}