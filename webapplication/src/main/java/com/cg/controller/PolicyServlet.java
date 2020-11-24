package com.cg.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.dao.IPolicyDAO;
import com.cg.dao.PolicyDAO;
import com.cg.service.IInsuranceQuoteGenerationService;
import com.cg.service.InsuranceQuoteGenerationService;
import com.cg.utility.LoggerUtility;


@WebServlet("/PolicyServlet")
public class PolicyServlet extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	long accNum= Long.parseLong(request.getParameter("accno"));
	PrintWriter out=response.getWriter();
	
	//Logger logger = LoggerUtility.getLogger();
	
	IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
	HttpSession session = request.getSession();
	try 
	{
		String businessSegment=service.findAccount(accNum);
		if(businessSegment.equals("")) {
			request.setAttribute("accountNotFound", "Account does not exist");
			request.getRequestDispatcher("policyCreation.jsp").forward(request, response);
		}
		String businessId=service.findBusinessSegmentId(businessSegment);
		//out.println(bus_seg_id);
		session.setAttribute("businessId", businessId);
		ResultSet resultset=service.findQuestions(businessId);
		session.setAttribute("accountNumber", accNum);
		request.setAttribute("questions", resultset);
		request.getRequestDispatcher("policyCreation.jsp").include(request, response);
	}
	catch (SQLException e) 
	{
//		logger.error(e.getMessage());
		e.printStackTrace();
		response.sendRedirect("ErrorPage.jsp");
	}
	catch (Exception e)
	{
//		logger.error(e.getMessage());
		e.printStackTrace();
		response.sendRedirect("ErrorPage.jsp");
	}
}
}
