package com.example.demo;

import java.util.List;

public interface CustomerService {
	
	public List<Customer> getDetailsOfCustomer();
	public boolean count(Customer customerTransfer);
}
