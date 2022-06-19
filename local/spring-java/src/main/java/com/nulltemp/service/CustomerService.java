package com.nulltemp.service;

import com.nulltemp.db.entity.CustomerEntity;
import com.nulltemp.db.repository.CustomerRepository;
import com.nulltemp.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		CustomerEntity resultEntity = customerRepository.save(CustomerEntity.of(customer));
		return resultEntity.convert();
	}

	public Optional<Customer> findById(long id) {
		return customerRepository.findById(id).map(CustomerEntity::convert);
	}

	public List<Customer> findAll() {
		List<Customer> result = new ArrayList<>();
		customerRepository.findAll().forEach(customerEntity -> {
			result.add(customerEntity.convert());
		});
		return result;
	}
}
