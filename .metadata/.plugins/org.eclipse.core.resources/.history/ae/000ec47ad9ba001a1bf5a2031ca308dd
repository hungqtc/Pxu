package com.hung.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hung.model.Customer;
import com.hung.service.CustomerService;

@WebServlet("/doAdd")
public class CustomerAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerAddController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");

		// init Customer
		Customer cus = new Customer(0, fullname, email, address);

		// save Customer
		CustomerService customerService = new CustomerService();
		customerService.save(cus);
		
		response.sendRedirect("index");
	}

}
