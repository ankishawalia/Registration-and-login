package com.userInterface;


import com.userInterface.userInterface;
import com.userInterface.userWal;
import com.userInterface.userWalJdbc;
import com.userInterface.userDetails;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class Registerservlet
 */
@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registerservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobileNo = request.getParameter("mobileNo");

		userInterface user = new userInterface();
		user.setUserName(name);
		user.setEmial(email);
		user.setPassword(password);
		user.setMobileNo(Long.parseLong(mobileNo));

		// adding to the array list

		//userDetails.addUserDetails(user);

		// get arraylist

		//ArrayList<userInterface> getUserInfo = userDetails.getUserInfo();

		/*if (getUserInfo.size() > 0) {
			request.setAttribute("list", getUserInfo);
			RequestDispatcher rd = request.getRequestDispatcher("/RegisterSucess.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/RegisterError.jsp");
			rd.forward(request, response);

		}*/
		
		String addUserDetail=userWal.addUserDetails(user);
		System.out.println("inside the register servlet");
		
		System.out.println(addUserDetail);
		
		if (addUserDetail!= null) {
			request.setAttribute("message", "Successfull registration");
			RequestDispatcher rd = request.getRequestDispatcher("/sucess.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);

		}
		

	}

}
