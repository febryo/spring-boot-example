package com.febryo.oracle.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.febryo.oracle.model.Customer;

public interface CustomerService {
	List<Customer> findByEmail(String email);

    List<Customer> findByDate(Date date);
    
    Customer findByCode(String code);
    
    Page<Customer> findByEmail(String email, int limit, int offset);
    
    Customer create(Customer customer);
    
    void createBigData(int total);
    
}
