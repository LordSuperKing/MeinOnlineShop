package de.vs.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import de.vs.cart.Cart;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

//	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
//	private UUID id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Cart cart;

	public Customer() {
		this.cart = new Cart(this);
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
