package com.cg.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.model.PolicyQuestions;
import com.cg.service.AgentService;
import com.cg.service.IAgentService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AgentReportGenerationServlet")
public class AgentReportGenerationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger logger=LogManager.getLogger();
		RequestDispatcher dispatcher = null;
		int accNumber = Integer.parseInt(request.getParameter("accNumber"));
		String busSegName = null;
		Double premium = 0.0;
		List<PolicyQuestions> questions = new ArrayList<PolicyQuestions>();
		List<String> selectedAns = new ArrayList<String>();
		int polNum = Integer.parseInt(request.getParameter("polNumber"));
		
		IAgentService service = new AgentService();
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
			dispatcher = request.getRequestDispatcher("agentgeneratereport.jsp");
			dispatcher.forward(request, response);
			
		} catch (LoginAndCommonException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}