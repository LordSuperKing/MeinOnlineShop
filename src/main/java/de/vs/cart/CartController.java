package de.vs.cart;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.vs.customer.Customer;
import de.vs.orders.Orders;
import de.vs.orders.OrdersRepository;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@GetMapping("/associatedcustomer")
	public Customer getAssociatedCustomer(@RequestParam("customerid") UUID customerId) {
		return cartRepository.findByCustomerId(customerId);
	}
	
	@GetMapping("/cart")
	public Optional<Cart> getCartById(@RequestParam("customerid") Integer id) {
		return cartRepository.findById(id);
	}
	
	@PostMapping("cart/order")
	public Cart addOrder(Integer cart_id) {
		Optional<Cart> cartOpt = cartRepository.findById(cart_id);
//		Orders order = ordersRepository.save(new Orders());
		Orders order = new Orders();
		Cart cart = null;
		if (cartOpt.isPresent()) {
			cart = cartOpt.get(); 
		}
		cart.getProducts().add(order);
		return cart = cartRepository.save(cart);
	}

}
