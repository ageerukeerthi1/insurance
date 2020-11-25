package com.cg.controller;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.util.List;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Policy;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;


@WebServlet("/ViewPolicy")
public class ViewPolicy extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdminService service = new AdminService();
		//Logger logger=LogManager.getLogger();
		RequestDispatcher dispatcher = null;
		try {
			List<Policy> policies = service.getPolicies();
			System.out.println(policies);
			request.setAttribute("policies", policies);
			dispatcher = request.getRequestDispatcher("viewpolicy.jsp");
			dispatcher.include(request, response);
		} catch (LoginAndCommonException e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
}