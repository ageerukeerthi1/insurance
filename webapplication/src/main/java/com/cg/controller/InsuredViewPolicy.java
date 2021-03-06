package com.cg.controller;

import java.io.IOException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Policy;
import com.cg.service.IInsuredService;
import com.cg.service.InsuredService;

import java.util.List;

@WebServlet("/InsuredViewPolicy")
public class InsuredViewPolicy extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Logger logger=LogManager.getLogger();
		IInsuredService service = new InsuredService();
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		try {
			String username = (String)session.getAttribute("username");
			System.out.println(username);
			int accNo = service.getAccountNumber(username);
			List<Policy> policies = service.getInsuredPolicies(accNo);
			System.out.println("policies size : "+policies.size());
			if(policies.size() > 0) {
				request.setAttribute("policies", policies);
			
				dispatcher = request.getRequestDispatcher("InsuredViewPolicies.jsp");
				dispatcher.include(request, response);
		
			}
			
			else {
				//logger.info("Policies does not exists.. ");
				System.out.println("Policies does not exists.. ");
							
			}
		}catch (LoginAndCommonException e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}