package com.petex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
