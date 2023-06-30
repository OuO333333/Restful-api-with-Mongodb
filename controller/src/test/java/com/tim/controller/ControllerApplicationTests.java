package com.tim.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tim.common.entity.Product;
import com.tim.common.exception.ItemNotExistsException;
import com.tim.dao.dao.ProductDAOMongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ControllerApplicationTests {

	@Test
	void contextLoads() {
		// arrange
		int number1 = 5;
        int number2 = 10;
        int excepted = 15;

		// act
		int actual = number1 + number2;

		// assert
		assertThat(actual).isEqualTo(excepted);
	}

	// @Test
	// void mongoTemplate(){
	// 	Product product = new Product();
	// 	product.setId("mongoTemplate");
	// 	ProductDAOMongoTemplate productDAOMongoTemplate = new ProductDAOMongoTemplate();
	// 	productDAOMongoTemplate.insert(product);
	// }
}
