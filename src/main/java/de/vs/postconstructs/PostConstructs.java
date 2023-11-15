package de.vs.postconstructs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.vs.customer.CustomerRepository;
import de.vs.product.ProductRepository;

@Service
public class PostConstructs {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductRepository productRepository;

//	@PostConstruct
//	public void add() {
//		List<Customer> customers = this.customerRepository.findAll();
//
//		customers.get(0).getCart().getOrders().add(new Orders(this.productRepository.findById(1).get()));
//	}
}
