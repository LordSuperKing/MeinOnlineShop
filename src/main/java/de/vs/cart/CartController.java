package de.vs.cart;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	private static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartRepository cartRepository;

	@GetMapping
	public ResponseEntity<List<Cart>> getAllCarts() {
		return ResponseEntity.ok(this.cartRepository.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		Optional<Cart> toFind = this.cartRepository.findById(id);

		if (toFind.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		if (toFind.get().getCustomer() != null) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}

		this.cartRepository.delete(toFind.get());

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
