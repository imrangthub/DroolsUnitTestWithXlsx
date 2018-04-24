package com.imran.drooltest;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.drooltest.Customer.CustomerType;

@Service
public class CustomerService {

	@Autowired
	private KieSession kieSession;

	public Customer getDiscount() {
		//Customer customer = new Customer(CustomerType.BUSINESS, 2);
		Customer customer = new Customer(CustomerType.BUSINESS,5);
		kieSession.insert(customer);
		kieSession.fireAllRules();
		return customer;
	}

}
