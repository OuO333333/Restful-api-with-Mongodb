package com.tim.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DaoApplicationTests {

	@Test
	void contextLoads() {
		int number1 = 5;
        int number2 = 10;
        int excepted = 15;

		int actual = number1 + number2;

		assertThat(actual).isEqualTo(excepted);
	}

}
