package com.nulltemp.controller;

import com.nulltemp.domain.Customer;
import com.nulltemp.request.CreateCustomerRequest;
import com.nulltemp.response.CustomerResponse;
import com.nulltemp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("{id}")
	public CustomerResponse get(@PathVariable String id) {
		Optional<Customer> optionalCustomer = customerService.findById(Long.parseLong(id));
		if (optionalCustomer.isEmpty()) {
			return null;
		}
		return CustomerResponse.of(optionalCustomer.get());
	}

	@GetMapping
	public List<CustomerResponse> getList() {
		return customerService.findAll().stream().map(CustomerResponse::of).collect(Collectors.toList());
	}

	@PostMapping
	public CustomerResponse save(@RequestBody CreateCustomerRequest request) {
		return CustomerResponse.of(customerService.save(request.convert()));
	}
}
