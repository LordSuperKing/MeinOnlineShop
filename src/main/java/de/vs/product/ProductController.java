package de.vs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	public void createProduct() {
		this.productRepository.save(new Product("Ball"));
		this.productRepository.save(new Product("Auto"));
		this.productRepository.save(new Product("Schnee"));
	}

}
