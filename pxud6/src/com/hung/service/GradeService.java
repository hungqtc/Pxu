package com.hung.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hung.model.Grade;

public class GradeService {
	public static Map<Integer, Grade> grades;
	public static int count = 3;

	static {
		grades = new HashMap<>();
		grades.put(1, new Grade(1, "8"));
		grades.put(2, new Grade(2, "9"));
		grades.put(3, new Grade(3, "10"));
	}

	public List<Grade> getAllGrades() {
		return new ArrayList<>(grades.values());
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
