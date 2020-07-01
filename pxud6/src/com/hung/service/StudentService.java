package com.hung.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hung.model.Grade;
import com.hung.model.Student;

public class StudentService {
	public static Map<Integer, Student> stundents;
	public static int count = 5;

	static {
		stundents = new HashMap<>();
		stundents.put(1, new Student(1, "Van Phong 1", "123 Ho Dac Di", "vanphong@gmail.com", new Grade(1, "9")));
		stundents.put(2, new Student(2, "Van Phong 2", "123 Ho Dac Di", "vanphong@gmail.com", new Grade(2, "10")));
		stundents.put(3, new Student(3, "Van Phong 3", "123 Ho Dac Di", "vanphong@gmail.com", new Grade(1, "9")));
		stundents.put(4, new Student(4, "Van Phong 4", "123 Ho Dac Di", "vanphong@gmail.com", new Grade(2, "10")));
		stundents.put(5, new Student(5, "Van Phong 5", "123 Ho Dac Di", "vanphong@gmail.com", new Grade(3, "8")));
	}

	public List<Student> getAllStudents() {
		return new ArrayList<Student>(stundents.values());
	}

	/*
	 * public void save(Customer cus) { ++count; cus.setId(count);
	 * customers.put(cus.getId(), cus); }
	 * 
	 * public Customer findById(int id) { return customers.get(id); }
	 * 
	 * public void update(Customer cus) { customers.put(cus.getId(), cus); }
	 * 
	 * public void delete(int id) { customers.remove(id); }
	 */
}
