package de.vs.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<Void> delete(@PathVariable Integer productId) {
		Optional<Product> toDelete = this.productRepository.findById(productId);

		if (toDelete.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		this.productRepository.deleteById(productId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
