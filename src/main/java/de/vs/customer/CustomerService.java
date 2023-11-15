package de.vs.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.vs.orders.Orders;
import de.vs.product.Product;
import de.vs.product.ProductRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<Customer> addProduct(Integer id, Integer productId) {
		Optional<Customer> customerToFind = this.customerRepository.findById(id);
		Optional<Product> productToFind = this.productRepository.findById(productId);

		if (customerToFind.isEmpty() || productToFind.isEmpty()) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

		customerToFind.get().getCart().addOrder(new Orders(productToFind.get()));
		;
		this.customerRepository.save(customerToFind.get());
		return new ResponseEntity<Customer>(customerToFind.get(), HttpStatus.OK);
	}

}
