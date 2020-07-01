package com.hung.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hung.model.Customer;

public class CustomerService {
	public static Map<Integer, Customer> customers;
	public static int count = 5;

	static {
		customers = new HashMap<>();
		customers.put(1, new Customer(1, "Van Phong", " phong909@gmail.com", "123 Nguyen Tri Phuong"));
		customers.put(2, new Customer(2, "Van Phong", " phong909@gmail.com", "123 Nguyen Tri Phuong"));
		customers.put(3, new Customer(3, "Van Phong", " phong909@gmail.com", "123 Nguyen Tri Phuong"));
		customers.put(4, new Customer(4, "Van Phong", " phong909@gmail.com", "123 Nguyen Tri Phuong"));
		customers.put(5, new Customer(5, "Van Phong", " phong909@gmail.com", "123 Nguyen Tri Phuong"));
	}

	public List<Customer> getAllCustomer() {
		return new ArrayList<>(customers.values());
	}

	public void save(Customer cus) {
		++count;
		cus.setId(count);
		customers.put(cus.getId(), cus);
	}

	public Customer findById(int id) {
		return customers.get(id);
	}

	public void update(Customer cus) {
		customers.put(cus.getId(), cus);
	}

	public void delete(int id) {
		customers.remove(id);
	}
}
