package com.hung.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hung.model.Customer;
import com.hung.service.CustomerService;

@WebServlet("/doDelete")
public class CustomerDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		// delete Customer
		CustomerService customerService = new CustomerService();
		customerService.delete(id);

		response.sendRedirect("index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
