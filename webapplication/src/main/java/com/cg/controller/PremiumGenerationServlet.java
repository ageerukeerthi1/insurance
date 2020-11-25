package com.cg.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Policy;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger.*;


@WebServlet("/PremiumGenerationServlet")
public class PremiumGenerationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//Logger logger=LogManager.getLogger();
		ServletContext context = request.getServletContext();
		int polPremium = 0;
		int sumOfWeightages = 0;
		int isInserted = 0;
		int accNumber = 0;
		int polNumber = 0;
		int numOfQuestions = Integer.parseInt(request.getParameter("numofquestions"));
		//String busSegId = (String) context.getAttribute("busSegId");
		List<String> questionIds = new ArrayList<String>();
		List<String> selectedAnswers = new ArrayList<String>();
		RequestDispatcher dispatcher = null;
		List<Integer> weightages = new ArrayList<Integer>();
		String[] qAndA = null;
		for(int i = 0; i < numOfQuestions; i++) {
			qAndA = new String[3];
			System.out.println("threee values : "+((String)request.getParameter(""+(i+1))));
			qAndA = ((String)request.getParameter(""+(i+1))).split("!");
			questionIds.add(qAndA[0]);
			selectedAnswers.add(qAndA[1]);
			weightages.add(Integer.parseInt(qAndA[2]));
		
			//weightages.add(Integer.parseInt(request.getParameter(""+i+1)));
			sumOfWeightages += weightages.get(i);
			System.out.println("weightage of ans "+ weightages.get(i) + "  sum of wightages as of now "+sumOfWeightages);
		}
		out.print(sumOfWeightages);
		
		IAdminService service = new AdminService();
		Policy policy = new Policy();
		try {
			//context.setAttribute("accNumber", accNumber);
			accNumber = Integer.parseInt(""+context.getAttribute("accNumber"));
			polPremium = service.getPolicyPremiumAmount(sumOfWeightages);
			//questionIds = adminDao.getQuestionIds(busSegId);
			System.out.println(accNumber);
			policy.setAccNumber(accNumber);
			policy.setPolicyPremium(polPremium);
			isInserted = service.createPolicy(policy);
			if(isInserted > 0) {
				//logger.info("Policy created successfully!!!!");
				polNumber = service.getPolicyNumber();
				service.addPolicyDetails(polNumber, questionIds, selectedAnswers);
				System.out.println("In Premium generation servlet "+polNumber);
				dispatcher = request.getRequestDispatcher("adminhome.html");
				dispatcher.include(request, response);
				
			}
			/*System.out.println(polPremium);
			out.println(polPremium);
			*/			
		} catch (LoginAndCommonException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//	logger.error(e.getStackTrace());
		}
	}
}