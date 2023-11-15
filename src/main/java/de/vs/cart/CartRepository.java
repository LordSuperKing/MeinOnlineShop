package de.vs.cart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

//	Customer findByCustomerId(UUID customerId);

	@Override
	Optional<Cart> findById(Integer id);

}
