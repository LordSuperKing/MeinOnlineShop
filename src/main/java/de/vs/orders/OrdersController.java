package de.vs.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> delete(@PathVariable Integer orderId) {
		return this.ordersService.delete(orderId);

	}

}
