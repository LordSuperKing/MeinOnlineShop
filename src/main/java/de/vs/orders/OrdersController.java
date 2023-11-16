package de.vs.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrdersRepository ordersRepository;

	@GetMapping
	public ResponseEntity<List<Orders>> getAllOrders() {
		return new ResponseEntity<List<Orders>>(this.ordersRepository.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> delete(@PathVariable Integer orderId) {
		return this.ordersService.delete(orderId);

	}

}
