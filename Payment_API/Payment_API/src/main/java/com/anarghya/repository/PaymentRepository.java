package com.anarghya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarghya.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
