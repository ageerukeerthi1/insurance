package com.cg.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.dao.IReportGenerationDAO;
import com.cg.dao.ReportGenerationDAO;
import com.cg.model.PolicyDetails;
import com.cg.service.IInsuranceQuoteGenerationService;
import com.cg.service.InsuranceQuoteGenerationService;
import com.cg.utility.LoggerUtility;

@WebServlet("/ReportGenerationServlet")
public class ReportGenerationServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Logger logger = LoggerUtility.getLogger();
		
		long policyNumber = Long.parseLong(request.getParameter("policyNumber"));
		PolicyDetails policyDetails;
		IInsuranceQuoteGenerationService service = new InsuranceQuoteGenerationService();
		try 
		{
			policyDetails = service.viewDetailedReport(policyNumber);
			request.setAttribute("policyDetails", policyDetails);
			request.getRequestDispatcher("detailedReportGenerationView.jsp").forward(request, response);
		}
		catch (SQLException e) 
		{
			
//			logger.error(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("ErrorPage.jsp");
		}
		catch(Exception e)
		{
//			logger.error(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("ErrorPage.jsp");
		}
	}
}
