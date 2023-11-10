package de.vs.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.vs.cart.Cart;
import de.vs.cart.CartRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CartRepository cartRepository;

	@PostMapping
	public Customer createCustomer() {
		Cart cart = new Cart();
		Customer customer = new Customer();
//		this.cartRepository.save(cart);
		customer.setCart(cart);
		return this.customerRepository.save(customer);
	}

}
