package com.cg.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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

@WebServlet("/PolicyCreationServlet")
public class PolicyCreationServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		//Logger logger = LoggerUtility.getLogger();
		
		double premium = (double)session.getAttribute("premium");
		String insurerName="";
		if(session.getAttribute("adminName")!=null)
			insurerName = (String)session.getAttribute("adminName");
		else
			insurerName = (String)session.getAttribute("agentName");
		
		long accountNumber = (long) session.getAttribute("accountNumber");
		ArrayList<String> questIds = (ArrayList<String>)session.getAttribute("questionIds");
		
		String questionIds[] = new String[questIds.size()];
		
		questIds.toArray(questionIds);
		
		System.out.println(questionIds);
		
		String answers[] = (String[])session.getAttribute("answers");
		
		long policyNumber = 0l;
		
		try 
		{
			policyNumber = service.createPolicy(accountNumber, questionIds, answers, insurerName, premium);
		} 
		catch (SQLException e) 
		{
//			logger.error(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("ErrorPage.jsp");
		}
		catch (Exception e)
		{
			//logger.error(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("ErrorPage.jsp");
		}
		
		PrintWriter out = response.getWriter();
		request.setAttribute("policyNumber", policyNumber);
		request.getRequestDispatcher("policyCreation.jsp").include(request, response);
		out.println("<h3>Policy created with policy number : "+policyNumber+"</h3>");
			
		
	}
}