package com.cg.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.dao.IUserRoleDAO;
import com.cg.dao.UserRoleDAO;
import com.cg.model.User;
import com.cg.service.IInsuranceQuoteGenerationService;
import com.cg.service.InsuranceQuoteGenerationService;
import com.cg.utility.LoggerUtility;

/**
 * Servlet implementation class UserCreationServlet
 */
@WebServlet("/UserCreationServlet")
public class UserCreationServlet extends HttpServlet {
	

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		//Logger logger = LoggerUtility.getLogger();
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		String role = request.getParameter("rolecode");
		String rolecode = null;
		if(role.equals("Admin"))
			rolecode = "ADMIN001";
		else if(role.equals("Agent"))
			rolecode = "AGENT002";
		else
			rolecode = "INSURED003";
		
		User user = new User(username, password, rolecode);
		
		
		int result=0;
		try
		{
			result = service.addUser(user);
		}
		catch (SQLException e) 
		{
			//logger.error(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("ErrorPage.jsp");
		}
		catch(Exception e)
		{
			//logger.error(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("ErrorPage.jsp");
		}
		System.out.println(result);
		if(result>0)
		{
		String userCreatedMessage = "User with "+user.getUsername()+" created";
			//logger.info(userCreatedMessage);
		    System.out.println(userCreatedMessage);
			request.setAttribute("userCreationMessage", userCreatedMessage);
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
		else if(result == 0)
		{
			//logger.info("User with same username exists");
			System.out.println("User with same username exists");
			request.setAttribute("userCreationMessage", "User with same username exists");
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/Admin.jsp");
			requestDispatcher.include(request, response);
			//response.sendRedirect("profileCreation.html");
		}	
	}

}
