package de.vs.orders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	public ResponseEntity<Void> delete(@PathVariable Integer orderId) {
		Optional<Orders> toDelete = this.ordersRepository.findById(orderId);

		if (toDelete.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		this.ordersRepository.deleteById(orderId);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

}
