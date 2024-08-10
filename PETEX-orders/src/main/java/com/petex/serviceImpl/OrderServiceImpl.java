package com.petex.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petex.entity.OrderEntity;
import com.petex.entity.UserEntity;
import com.petex.repo.OrderRepo;
import com.petex.repo.UserRepository;
import com.petex.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderrepo;
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public Boolean save(OrderEntity entity, Long userId) {
	    Optional<UserEntity> optionalUser = userRepo.findById(userId);
	    if (optionalUser.isPresent()) {
	        UserEntity user = optionalUser.get();
	        
	        entity.setUser(user);
	        orderrepo.save(entity);
	        
	        return true;
	    }
	    return false;
	}

	@Override
	public List<OrderEntity> getAllOrderData() {
		return orderrepo.findAll();
	}

	@Override
	public String deleteOrderById(String orderId) {

		orderrepo.deleteById(orderId);
		return "deleted";
	}

	@Override
	public OrderEntity getOrderById(String orderId) {
		Optional<OrderEntity> appointmentId = orderrepo.findById(orderId);

		if (appointmentId.isPresent()) {
			return appointmentId.get();
		}
		return null;
	}

	@Override
	public Boolean updateOrderData(String orderId, OrderEntity entity) {

		Optional<OrderEntity> optinalId = orderrepo.findById(orderId);
		if (optinalId.isPresent()) {
			OrderEntity entites = optinalId.get();
			BeanUtils.copyProperties(entity, entites);
			entites.setOrderId(orderId);
			orderrepo.save(entites);
			return true;
		}
		return false;
	}

	
//    public OrderEntity getOrderDetails(String productName, int quantity, String productIds) {
//        // Logic to fetch order details based on productName, quantity, and productIds
//        // This logic depends on your database schema and how orders are stored
//        
//        // For demonstration purposes, let's assume you have a method in your repository to fetch orders
//        // Replace this with actual logic based on your database schema
//        List<OrderEntity> orders = orderrepo.findByProductNameAndQuantityAndProductIds(productName, quantity, productIds);
//        
//        // For simplicity, let's assume the first order in the list matches the criteria
//        if (!orders.isEmpty()) {
//            return orders.get(0);
//        } else {
//            return null; // Or handle the case where no order matches the criteria
//        }
//    }
	
	@Override
    public List<OrderEntity> getOrdersByCriteria(String productName, String quantity) {
        return orderrepo.findByCriteria(productName, quantity);
    }
	
}
