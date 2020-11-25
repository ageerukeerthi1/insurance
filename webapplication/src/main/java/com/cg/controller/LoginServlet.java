package com.cg.controller;

import com.cg.exceptions.LoginAndCommonException;

import com.cg.service.AdminService;
import com.cg.service.IAdminService;
import com.cg.service.IInsuredService;
import com.cg.service.InsuredService;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Logger logger=LogManager.getLogger();
		
		IAdminService adminService = new AdminService();
		IInsuredService insuredService = new InsuredService();
		HttpSession session = request.getSession();
		
		RequestDispatcher dispatcher=null;
		
		String roleCode = "";
		boolean isFound = false;
		boolean isUserExists = false;
		
		PrintWriter out = response.getWriter();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("username", username);
		System.out.println(username);
		try {
			
			
			isFound = adminService.loginValidation(username,password);
			
			if(isFound == true) {
			
				roleCode = adminService.getRoleCode(username, password);
			    System.out.println("Rolecode is:"+roleCode);
				if(roleCode != null) {
				
					if(roleCode.equals("UW")) {
					
						dispatcher = request.getRequestDispatcher("adminhome.html");
						dispatcher.forward(request, response);
					
					}else if(roleCode.equals("A")) {
					    
						System.out.println(roleCode);
						dispatcher = request.getRequestDispatcher("agenthome.jsp");
						dispatcher.forward(request, response);
					
					}else if(roleCode.equals("I")){
						
						isUserExists = insuredService.accountValidation(username);
						if (isUserExists) {
								dispatcher = request.getRequestDispatcher("insurerhome.html");
								dispatcher.forward(request, response);
						}else {
									dispatcher = request.getRequestDispatcher("InsuredAccountCreation.html");
									dispatcher.include(request, response);
						}
											
					}
				}
				
			} else {
				
				//logger.info("User not found, Please register");
				System.out.println("User not found, Please register");
			}
		}catch (LoginAndCommonException e) {
	
			//logger.error(e.getMessage());
			e.printStackTrace();
		
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}