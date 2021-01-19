package com.example.mongodemo;

import com.example.mongodemo.models.Product;
import com.example.mongodemo.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongodemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSave() {

		Product product = new Product();

		product.setName("MacBook Pro");
		product.setPrice(100);

		productRepository.save(product);

		assertNotNull(product);
	}

	@Test
	public void testReadAll() {

		List<Product> products = productRepository.findAll();

		assertEquals(1, products.size());
	}

	@Test
	public void testDeleteOperation() {

		productRepository.deleteById("5f58d82cec575247cdae3257");

		Optional<Product> product = productRepository.findById("5f58d82cec575247cdae3257");
		assertEquals(Optional.empty(), product);
	}
}
