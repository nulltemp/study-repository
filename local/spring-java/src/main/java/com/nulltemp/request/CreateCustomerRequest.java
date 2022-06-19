package com.nulltemp.request;

import com.nulltemp.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
	private String firstName;
	private String lastName;

	public Customer convert() {
		Customer customer = new Customer();
		BeanUtils.copyProperties(this, customer);
		return customer;
	}
}
