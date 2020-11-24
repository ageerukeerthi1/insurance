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
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.Logger;

import com.cg.dao.LoginAndCommonDAO;
import com.cg.model.Insured;
import com.cg.service.IInsuranceQuoteGenerationService;
import com.cg.service.InsuranceQuoteGenerationService;
import com.cg.utility.LoggerUtility;

@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AccountDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		
		String username = request.getParameter("UserName");
		String insuredname = request.getParameter("InsuredName");
		String insuredstreet = request.getParameter("InsuredStreet");
		String insuredcity = request.getParameter("InsuredCity");
		String insuredstate = request.getParameter("InsuredState");
		int insuredzip = Integer.parseInt(request.getParameter("InsuredZip"));
		String lob = request.getParameter("LOB");
		
		//Logger logger = LoggerUtility.getLogger();
		
		
		Insured insured = new Insured(insuredname,insuredstreet,insuredcity,insuredstate,insuredzip,lob,username );
		
		String accountNumber="0";
		
		try 
		{
			accountNumber = service.accountDetails(insured);
		} 
		catch (SQLException e) 
		{
			//logger.error(e.getMessage());
			response.sendRedirect("ErrorPage.jsp");
		}
		if(accountNumber.equals("0")) {
			writer.println("<html><body>Account already exists.</html></body>");
			ServletContext servletContext = getServletContext();
			//logger.info("Account already exist");
			if(session.getAttribute("adminName")!=null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin.jsp");
				requestDispatcher.include(request, response);
			}
			else if(session.getAttribute("agentName")!=null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Agent.jsp");
				requestDispatcher.include(request, response);
			}
			else if(session.getAttribute("insuredName")!=null)
			{
				request.setAttribute("accountExists","Yes");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Insured.jsp");
				requestDispatcher.include(request, response);
			}
		} 
		else {
			ServletContext servletContext = getServletContext();
			//logger.info("New Account created");
			if(session.getAttribute("adminName")!=null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin.jsp");
				requestDispatcher.include(request, response);
				writer.println("<html><body>account created with account number "+accountNumber+"</body></html>");
			}
			else if(session.getAttribute("agentName")!=null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Agent.jsp");
				requestDispatcher.include(request, response);
				writer.println("<html><body>account created with account number "+accountNumber+"</body></html>");
			}else if(session.getAttribute("insuredName")!=null)
			{
				request.setAttribute("accountExists","Yes");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Insured.jsp");
				requestDispatcher.include(request, response);
				writer.println("<html><body>account created with account number "+accountNumber+"</body></html>");
			}
		}
	}

}
