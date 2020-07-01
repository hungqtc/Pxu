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

@WebServlet("/doUpdate")
public class CustomerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerService customerService = new CustomerService();
		Customer cus = customerService.findById(id);
		
		request.setAttribute("cus",cus);
		
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");

		// init Customer
		Customer cus = new Customer(id, fullname, email, address);

		// update Customer
		CustomerService customerService = new CustomerService();
		customerService.update(cus);

		response.sendRedirect("index");
	}

}
