package com.petex.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petex.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, String> {
    @Query("SELECT o FROM OrderEntity o WHERE o.productName = :productName AND o.quantity = :quantity")
    List<OrderEntity> findByCriteria(@Param("productName") String productName,
                                      @Param("quantity") String quantity);
}



