package com.nulltemp.response;

import com.nulltemp.domain.Customer;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CustomerResponse {
	private long id;
	private String firstName;
	private String lastName;

	public static CustomerResponse of(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		BeanUtils.copyProperties(customer, customerResponse);
		return customerResponse;
	}
}
