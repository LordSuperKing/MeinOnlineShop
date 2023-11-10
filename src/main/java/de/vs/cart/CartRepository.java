package de.vs.cart;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import de.vs.customer.Customer;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Customer findByCustomerId(UUID customerId);
	
	Optional<Cart> findById(Integer id);

}
