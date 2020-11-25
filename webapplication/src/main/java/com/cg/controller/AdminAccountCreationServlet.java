package com.cg.controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.Accounts;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;


@WebServlet("/AccountCreationServlet")
public class AdminAccountCreationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IAdminService service = new AdminService();
		
		int isCreated = 0;
		// Logger logger=LogManager.getLogger();
		
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		boolean isUserExists = false;
		String userName = request.getParameter("userName");
		String insuredName = request.getParameter("insuredName");
		String insuredStreet = request.getParameter("insuredStreet");
		//logger.info(insuredStreet);
		System.out.println(insuredStreet);
		String insuredCity = request.getParameter("insuredCity");
		String insuredState = request.getParameter("insuredState");
		int insuredZip = Integer.parseInt(request.getParameter("insuredZip"));
		String busSegName = request.getParameter("busSegName");
		//logger.info("hello");
		System.out.println("hello");
		//int accNumber = Integer.parseInt(request.getParameter("accnumber"));
		System.out.println("line 38");
		//logger.info("line 38");
		try {
						
			String bussinessSegmentId = service.getLineOfBusinessIdByName(busSegName);
			Accounts account = new Accounts(insuredName, insuredStreet, insuredCity, insuredState, insuredZip, bussinessSegmentId,0);
			
			isUserExists = service.isUserExists(userName);
			if (isUserExists) {

				isCreated = service.accountCreation(account, userName);
				if (isCreated == 1) {
					//logger.info("Account Created Successfully!!");
					System.out.println("Account Created Successfully!!");
					/*dispatcher = request.getRequestDispatcher("adminhome.html");
					dispatcher.include(request, response);
			*/	}
			} else {
			//	logger.info("User does not exists! First register as user");
				System.out.println("User does not exists! First register as user");
			/*	dispatcher = request.getRequestDispatcher("adminhome.html");
				dispatcher.include(request, response);
			*/}
		} catch (LoginAndCommonException e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}

	}
}