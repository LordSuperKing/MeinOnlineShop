package de.vs.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(this.productRepository.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> delete(@PathVariable Integer productId) {
		return this.productService.delete(productId);
	}

}
