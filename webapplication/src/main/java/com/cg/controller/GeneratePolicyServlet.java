package com.cg.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.utility.LoggerUtility;

@WebServlet("/GeneratePolicyServlet")
public class GeneratePolicyServlet extends HttpServlet 
{
	
	private final static String AUTO_BUS_ID = "BA01";
	private final static String RESTAURANT_BUS_ID = "R02";
	private final static String APARTMENT_BUS_ID = "A03";
	private final static String GENERALMERCHANT_BUS_ID = "GM04";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
//		Logger logger = LoggerUtility.getLogger();
		
		ArrayList<String> questionId =(ArrayList<String>) session.getAttribute("questionIds");
		
		System.out.println(questionId);
		
		int numberOfQuestions = questionId.size();
		String[] answers = new String[numberOfQuestions];
		int maxWeightage = numberOfQuestions*600;
		double maxPremium = 0.0;
		int sumOfWeightage = 0;
		String businessId = (String)session.getAttribute("businessId");
		
		if(businessId.equals(AUTO_BUS_ID))
		{
			maxPremium = 70000;
		}
		else if(businessId.equals(RESTAURANT_BUS_ID))
		{
			maxPremium = 95000;
		}
		else if(businessId.equals(APARTMENT_BUS_ID))
		{
			maxPremium = 200000;
		}
		else if (businessId.equals(GENERALMERCHANT_BUS_ID)) 
		{
			maxPremium = 50000;
		}
		
		System.out.println(session.getAttribute("adminName"));
		
		for (int i = 0; i < numberOfQuestions; i++) 
		{
			String ans = request.getParameter(questionId.get(i));
			
			answers[i] = new String(ans.substring(0,ans.lastIndexOf(' ')));
			System.out.println(answers[i]);
			int weightage = Integer.parseInt(ans.substring(ans.lastIndexOf(' ')+1));
			sumOfWeightage += weightage;
			
		}
		
		double premium = ((sumOfWeightage*1.0)/maxWeightage) * maxPremium;
		System.out.println("Proposed premium is "+premium);
		
		for (int i = 0; i < answers.length; i++) {
			System.out.println(questionId.get(i)+answers[i]);
//			logger.info(questionId.get(i)+answers[i]);
		}
		
		out.println("<div align='center'><form action='PolicyCreationServlet' method='post'><h3> Your Premium is : "+premium+"</h3>");
		out.println("<input type='submit' value='Confirm Policy' class='signupbutton'></form></div>");
		
		session.setAttribute("answers", answers);
		session.setAttribute("premium", premium);
		
		request.getRequestDispatcher("policyCreation.jsp").include(request, response);
		
//		request.getRequestDispatcher("policy_creation_account.jsp").forward(request, response);
		
		
	}
}
