package com.kmc.microservices.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmc.microservices.customerservice.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
