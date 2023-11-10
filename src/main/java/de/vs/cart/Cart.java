package de.vs.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import de.vs.customer.Customer;
import de.vs.orders.Orders;
import de.vs.product.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	
	private Customer customer;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn
	private List<Orders> orders;

	public Cart() {
		this.orders = new ArrayList<>();
	}
	
	public Cart(Customer customer) {
		this.customer = customer;
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
