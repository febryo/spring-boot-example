package com.febryo.oracle.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.febryo.oracle.dao.CustomerRepository;
import com.febryo.oracle.model.Customer;
import com.febryo.oracle.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findByDate(Date date) {
		return customerRepository.findByDate(date);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Customer> findByEmail(String email, int limit, int offset) {
		return customerRepository.findByEmail(email, new PageRequest(offset, limit));
	}

	@Override
	@Transactional(readOnly = false)
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findByCode(String code) {
		return customerRepository.findByCode(code);
	}

	@Override
	@Async("threadPoolTaskExecutor")
	public void createBigData(int total) {
		List<Customer> list = new ArrayList<>();
		Long totalCurrentCustomer = customerRepository.count();
		System.out.println("totalCurrentCustomer === " + totalCurrentCustomer);
		try {
			int i = 0;
			if (totalCurrentCustomer > 1) {
				i = totalCurrentCustomer.intValue() + 1;
				total = total + totalCurrentCustomer.intValue();
			}
			while (i < total) {
				Customer customer = new Customer();
				customer.setDate(new Date());
				customer.setEmail(i + "@test.com");
				customer.setName("generateName nama nya" + i);
				customer.setCode("code-0000000000000" + i);
				list.add(customer);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		list.stream().forEach(customer -> {
			this.create(customer);
		});
	}

}
