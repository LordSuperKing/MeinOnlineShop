package de.vs.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import de.vs.orders.Orders;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;
	private String name;

	@ManyToOne
	@JsonBackReference
	private Orders order;

	public Product() {
		super();
	}

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

}
