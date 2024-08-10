package com.anarghya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarghya.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, String>{

}
