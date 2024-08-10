package com.petex.service;

import java.util.List;

import com.petex.entity.OrderEntity;

public interface OrderService {
	
	public Boolean save(OrderEntity entity, Long userId);
	
	public List<OrderEntity> getAllOrderData();
	
	public String deleteOrderById(String orderId);
	
	public OrderEntity getOrderById(String orderId);
	
	public Boolean updateOrderData(String orderId,OrderEntity entity);
	
//	 public OrderEntity getOrderDetails(String productName, int quantity, String productIds);
	
	 public List<OrderEntity> getOrdersByCriteria(String productName, String quantity);

}
