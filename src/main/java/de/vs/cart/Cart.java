package de.vs.cart;

import java.util.ArrayList;
import java.util.List;

import de.vs.customer.Customer;
import de.vs.orders.Orders;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	private Customer customer;

	@OneToMany
	private List<Orders> orders;

	public Cart() {
		this.orders = new ArrayList<>();

	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Orders> getProducts() {
		return this.orders;
	}

	public void setProducts(List<Orders> orders) {
		this.orders = orders;
	}

	public Integer getId() {
		return this.id;
	}

}
