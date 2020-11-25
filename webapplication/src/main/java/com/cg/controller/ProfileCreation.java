package com.cg.controller;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.UserRole;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;

import java.util.logging.Logger.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProfileCreation")
public class ProfileCreation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Logger logger=LogManager.getLogger();
		int isInserted = 0;
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		
		IAdminService service = new AdminService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rolecode = request.getParameter("rolecode");
		
		UserRole userRole = new UserRole(username, password, rolecode);
		try {

			isInserted = service.addUser(userRole);
			if (isInserted > 0) {
				//logger.info("User Role creation success");
				System.out.println("User Role creation success");
				dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			} else {
				//logger.info("Username already exists Please Enter a different Username");
				System.out.println("Username already exists Please Enter a different Username");
				dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
		}
		} catch (LoginAndCommonException e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}