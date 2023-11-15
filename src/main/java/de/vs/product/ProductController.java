package de.vs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@PostConstruct
	public void createProduct() {
		this.productRepository.save(new Product("Ball"));
		this.productRepository.save(new Product("Auto"));
		this.productRepository.save(new Product("Schnee"));
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> delete(@PathVariable Integer productId) {
		return this.productService.delete(productId);
	}

}
