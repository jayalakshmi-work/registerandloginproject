package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAcesss;
import com.techpalle.util.SuccessPage;
import com.tecpalle.model.Customer;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String path = request.getServletPath();	
			
			switch(path)
			{
			case "/logcustomer":
				validateCustomer(request,response);
				break;
			case "/regCustomer":
				insertCustomer(request,response);
				break;
			case "/reg":
				getRegistrationPage(request,response);
				break;
			case "/log":
				getLoginPage(request,response);
			default:
			getStartUpPage(request,response);
			break;
			}
}

	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		//read email and pwd from jsp page(customer_login.jsp controle name)
		
		String e = request.getParameter("tbemaillog");
			String p = request.getParameter("tbpwdpass");
			
			
			// call the method in dao
			
			boolean res = DataAcesss.validateCustomer(e, p);
			
			// condition and redirect user to destination page (success)
			if (res)
			{
				try {
					RequestDispatcher rd = request.getRequestDispatcher("customer_success.jsp");

					// store the success page cls data inside RD
					
					SuccessPage sp = new SuccessPage();
					
					request.setAttribute("successDetails", sp);
					
					rd.forward(request, response);
				} 
				catch (ServletException | IOException e1) {
					e1.printStackTrace();
				}
			}
			else
			{
				getLoginPage(request,response);
				
			}
			
		}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
       			// read the data from jsp page (registration.jsp page)
		String name = request.getParameter("tbname");
		String email = request.getParameter("tbemail");
		long mobile =Long.parseLong(request.getParameter("tbmobile"));   //here parselong() is a static method so we can call this by using c;ass name directly
		String password = request.getParameter("tbpwd");
		String state = request.getParameter("ddlstates");
		
		//store the data in customer object
		
		Customer cust = new Customer(name,email, mobile, password, state);
		
		// call the insert customer method present in dao by paasing above object
		
	       DataAcesss.insertCustomer(cust);
	       
	       // redirect user to login page
		
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");

			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");

			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}
			
			
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");

			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}
			
		}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
			
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("management.jsp");

			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}














