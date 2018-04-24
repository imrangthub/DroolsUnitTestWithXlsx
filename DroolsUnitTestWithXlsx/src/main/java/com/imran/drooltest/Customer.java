package com.imran.drooltest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private CustomerType type;
	private int years;
	private int discount;

	public Customer(CustomerType type, int numOfYears) {
		this.type = type;
		this.years = numOfYears;
	}
	public Customer(CustomerType type) {
		this.type = type;
	}

	public enum CustomerType {
		INDIVIDUAL, BUSINESS;
	}
}
