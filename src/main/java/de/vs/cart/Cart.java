package de.vs.cart;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import de.vs.customer.Customer;
import de.vs.orders.Orders;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer id;

	@OneToOne
	@JsonBackReference
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	@JsonBackReference
	private List<Orders> orders;

	public Cart() {
		this.orders = new ArrayList<>();
	}

	public Cart(Customer customer) {
		this.customer = customer;
	}

	public void addOrder(Orders order) {
		order.setCart(this);
		this.orders.add(order);
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Orders> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Integer getId() {
		return this.id;
	}

}
