package com.nulltemp.db.entity;

import com.nulltemp.domain.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;

	public static CustomerEntity of(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customer, customerEntity);
		return customerEntity;
	}

	public Customer convert() {
		Customer customer = new Customer();
		BeanUtils.copyProperties(this, customer);
		return customer;
	}
}
