package de.vs.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.vs.cart.CartRepository;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CustomerService customerService;

	@PostMapping
	@PostConstruct
	public Customer createCustomer() {
		Customer customer = new Customer();
		return this.customerRepository.save(customer);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<List<Customer>>(this.customerRepository.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		Optional<Customer> toFind = this.customerRepository.findById(id);

		if (toFind.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		this.customerRepository.deleteById(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}/products/{productId}")
	public ResponseEntity<Customer> addProduct(@PathVariable Integer id, @PathVariable Integer productId) {
		return this.customerService.addProduct(id, productId);
	}

}
