package de.vs.customer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import de.vs.cart.Cart;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;

	@Autowired
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Cart cart;

	public Customer() {
		this.cart = new Cart();
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
