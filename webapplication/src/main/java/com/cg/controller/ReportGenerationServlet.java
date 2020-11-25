package com.cg.controller;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger.*;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.PolicyDetails;
import com.cg.model.PolicyQuestions;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;

@WebServlet("/ReportGenerationServlet")
public class ReportGenerationServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Logger logger=LogManager.getLogger();
		RequestDispatcher dispatcher = null;
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		String busSegName = null;
		Double premium = 0.0;
		List<PolicyQuestions> questions = new ArrayList<PolicyQuestions>();
		List<String> selectedAns = new ArrayList<String>();
		int polNum = Integer.parseInt(request.getParameter("polNumber"));
		IAdminService service = new AdminService();
		Accounts account = new Accounts();
		
		try {
			account = service.getAccountDetails(accNumber);
			System.out.println(account.getLineOfBusiness());
			busSegName = service.getBusSegName(account.getLineOfBusiness());
			premium = service.getPolicyPremium(polNum);
			questions = service.getPolicyQuestions(account.getLineOfBusiness());
			selectedAns = service.getSelectedAnswers(polNum);
			System.out.println(premium);
			request.setAttribute("account", account);
			request.setAttribute("busSegName", busSegName);
			request.setAttribute("questions", questions);
			request.setAttribute("selectedAns", selectedAns);
			request.setAttribute("premium", premium);
			dispatcher = request.getRequestDispatcher("generatereport.jsp");
			dispatcher.forward(request, response);
			
		} catch (LoginAndCommonException e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doPost(req, resp);
	}
}