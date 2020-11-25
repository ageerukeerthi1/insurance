package com.cg.controller;

import java.io.IOException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Policy;
import com.cg.service.AgentService;
import com.cg.service.IAgentService;

import java.util.List;

@WebServlet("/AgentViewPolicy")
public class AgentViewPolicy extends HttpServlet {
	//Logger logger=LogManager.getLogger();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAgentService service = new AgentService();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		try {
			String username = (String)session.getAttribute("username");
			List<Policy> policies = service.getPolicies(username);
			System.out.println("Result set:"+policies);
			request.setAttribute("policies", policies);
			dispatcher = request.getRequestDispatcher("agentviewpolicy.jsp");
			dispatcher.include(request, response);
		} catch (LoginAndCommonException e) {
			
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