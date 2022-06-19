package com.nulltemp.request;

import com.nulltemp.domain.Customer;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CreateCustomerRequest {
	private String firstName;
	private String lastName;

	public Customer convert() {
		Customer customer = new Customer();
		BeanUtils.copyProperties(this, customer);
		return customer;
	}
}
