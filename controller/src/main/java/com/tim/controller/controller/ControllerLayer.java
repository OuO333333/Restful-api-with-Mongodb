package com.tim.controller.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tim.common.entity.Product;
import com.tim.service.service.ServiceLayer;

import jakarta.validation.Valid;


@RestController
public class ControllerLayer {

    @Autowired
    ServiceLayer serviceLayer;

    // find Product, if exist, return ok & product
    // if not exist, return not found
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        System.out.println("In GetMapping");
        boolean findProduct;
        findProduct = false;
        Integer productNum = 0;
        for (int i = 0; i < serviceLayer.getDbSize(); i++) {
            if (serviceLayer.getId(i).equals(id)) {
                findProduct = true;
                productNum = i;
            }
        }
        if (findProduct)
            return ResponseEntity.ok().body(serviceLayer.getProduct(productNum));
        else
            return ResponseEntity.notFound().build();
    }

    // find all Product
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() {
        System.out.println("In GetMapping");
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < serviceLayer.getDbSize(); i++)
            productList.add(serviceLayer.getProduct(i));
        return ResponseEntity.ok().body(productList);
    }

    // check if Product exist
    // if exist, return UNPROCESSABLE_ENTITY
    // if not exist, create URL location and return request product
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product request, BindingResult result) {
        System.out.println("In PostMapping");
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                System.out.println(error);
            }
        }
        boolean isIdDuplicated;
        isIdDuplicated = false;
        for (int i = 0; i < serviceLayer.getDbSize(); i++) {
            if (serviceLayer.getId(i).equals(request.getId())) {
                isIdDuplicated = true;
            }
        }

        if (isIdDuplicated) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        serviceLayer.addProduct(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(product);
    }

    // check if request product exist
    // if not exist, return not found
    // if exist, return modified product
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> replaceProduct(
            @PathVariable("id") String id,@Valid @RequestBody Product request, BindingResult result) {
        System.out.println("In PutMapping");
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                System.out.println(error);
            }
        }
        boolean findProduct;
        findProduct = false;
        Integer productNum = 0;
        for (int i = 0; i < serviceLayer.getDbSize(); i++) {
            if (serviceLayer.getId(i).equals(id)) {
                findProduct = true;
                productNum = i;
            }
        }

        if (findProduct) {
            Product product = serviceLayer.getProduct(productNum);
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            serviceLayer.removeProduct(productNum);
            serviceLayer.addProduct(product);
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // check if request product(by id) exist
    // if not exist, return notFound
    // if exist, return noContent and removerequest from DB
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
        System.out.println("In DeleteMapping");
        boolean isRemoved = false;
        int productNum = -1;
        for (int i = 0; i < serviceLayer.getDbSize(); i++) {
            if (serviceLayer.getId(i).equals(id)) {
                isRemoved = true;
                productNum = i;
            }
        }
        if (productNum != -1) {
            serviceLayer.removeProduct(productNum);
        }
        return isRemoved
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    public void printDB() {
        System.out.println("printDB:");
        for (int i = 0; i < serviceLayer.getDbSize(); i++) {
            System.out.println("product id: " + serviceLayer.getId(i));
            System.out.println("product name: " + serviceLayer.getName(i));
            System.out.println("product price: " + serviceLayer.getPrice(i) + "\n");
        }

    }

}
