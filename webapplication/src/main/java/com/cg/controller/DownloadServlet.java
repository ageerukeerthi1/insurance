package com.cg.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.Logger;

import com.cg.model.PolicyDetails;

import com.cg.utility.LoggerUtility;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		PolicyDetails policyDetails = (PolicyDetails)session.getAttribute("policyDetails");
		PdfCreate createPdf = new PdfCreate();
		int result=0;
		try 
		{
			result = createPdf.create(policyDetails);
		}
		catch (SQLException e) 
		{
//			Logger logger = LoggerUtility.getLogger();
//			logger.error(e.getMessage());
			response.sendRedirect("ErrorPage.jsp");
		}
		session.removeAttribute("policyDetails");
		if(result == 0)
			request.setAttribute("pdfStatus", "Failed");
		else
			request.setAttribute("pdfStatus", "Created");
		request.getRequestDispatcher("detailedReportGeneration.jsp").forward(request, response);
	}
}
