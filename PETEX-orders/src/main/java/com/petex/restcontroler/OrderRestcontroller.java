package com.petex.restcontroler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petex.entity.OrderEntity;
import com.petex.service.OrderService;

@RestController
@RequestMapping("/petex")
@CrossOrigin(origins = "*")
public class OrderRestcontroller {

	@Autowired
	private OrderService servies;

//	@PostMapping("/save/{userId}/{productId}")
//	public ResponseEntity<String> saveVacctination(@RequestBody OrderEntity entity, @PathVariable Long userId,
//			@PathVariable String productId) {
//		Boolean status = servies.save(entity, userId, productId);
//		if (status) {
//			return new ResponseEntity<String>("orders booked success", HttpStatus.OK);
//		}
//		return new ResponseEntity<String>("orders not successfully booked", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@PostMapping("/save/{userId}")
	public ResponseEntity<String> saveVaccination(@RequestBody OrderEntity entity, @PathVariable Long userId) {
	    Boolean status = servies.save(entity, userId);
	    if (status) {
	        return new ResponseEntity<String>("Orders booked successfully", HttpStatus.OK);
	    }
	    return new ResponseEntity<String>("Orders not successfully booked", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@GetMapping("/get/{orderId}")
	public ResponseEntity<OrderEntity> getVacctination(@PathVariable String orderId) {
		OrderEntity entity = servies.getOrderById(orderId);
		return new ResponseEntity<OrderEntity>(entity, HttpStatus.OK);
	}
	
	
    @GetMapping("/getOrder")
    public ResponseEntity<List<OrderEntity>> getOrderDetails(
            @RequestParam String productName,
            @RequestParam String quantity) {
        try {
            List<OrderEntity> orders = servies.getOrdersByCriteria(productName, quantity);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
	@GetMapping("/getAll")
	public ResponseEntity<List<OrderEntity>> getAllVacctination1() {
		List<OrderEntity> entity = servies.getAllOrderData();
		return new ResponseEntity<List<OrderEntity>>(entity, HttpStatus.OK);

	}

	/*
	 * @GetMapping("/getRevenue") public ResponseEntity<List<OrderEntity>>
	 * getAllVacctination() { List<OrderEntity> entity =
	 * servies.getAllAppointmentData(); return new
	 * ResponseEntity<List<OrderEntity>>(entity, HttpStatus.OK);
	 * 
	 * }
	 */

}
