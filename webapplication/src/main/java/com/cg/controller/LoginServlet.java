package com.cg.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.cg.dao.IUserRoleDAO;
import com.cg.dao.LoginAndCommonDAO;
import com.cg.dao.UserRoleDAO;
import com.cg.model.Insured;
import com.cg.model.User;
import com.cg.service.IInsuranceQuoteGenerationService;
import com.cg.service.InsuranceQuoteGenerationService;
import com.cg.utility.LoggerUtility;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = null;
		
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		
	//	Logger logger = LoggerUtility.getLogger();
		
		User userRole = new User();
		String uName = request.getParameter("userName");
		String pWord = request.getParameter("password");
		userRole.setUsername(uName);
		userRole.setPassword(pWord);
		PrintWriter writer = response.getWriter();
		String roleCode = "";
		
		try {
			roleCode = service.verifyUser(userRole);
			
			
			if(roleCode.equals("ADMIN001"))
			{
				//writer.println("Welcome "+userRole.getUsername());
				if (session == null) 
				{
					session = request.getSession();
					session.setAttribute("adminName", uName);
				}
				
				System.out.println(uName+" admin has logged in");
				
//				request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
				response.sendRedirect("Admin.jsp");
			}
			else if(roleCode.equals("AGENT002"))
			{
				if (session == null) 
				{
					session = request.getSession();
					session.setAttribute("agentName", uName);
				}
			//	logger.info(uName+" agent has logged in");
				System.out.println(uName+" agent has logged in");
				response.sendRedirect("Agent.jsp");
			}
			else if(roleCode.equals("INSURED003"))
			{
				if (session == null) 
				{
					session = request.getSession();
					session.setAttribute("insuredName", uName);
				}
			//	logger.info(uName+" insured has logged in");
				System.out.println(uName+" insured has logged in");
				
				
				String result = service.accountExists(uName);
				
				request.setAttribute("accountExists", result);
				if(request.getAttribute("accountExists").equals("Yes")) {
					String accountNumber = service.findAccountNumber(uName);
					request.setAttribute("accNum", accountNumber);
				}
				request.getRequestDispatcher("Insured.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("loginFailed", "Invalid Credentials. Try Again");
				request.getRequestDispatcher("LoginScreen.jsp").forward(request, response);
			}
		} 
		catch (SQLException e) 
		{
//			logger.error(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("ErrorPage.jsp");
		}
		catch (Exception e)
		{
//			logger.error(e.getMessage());
			e.getMessage();
			response.sendRedirect("ErrorPage.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("ErrorPage.jsp");
	}
}
