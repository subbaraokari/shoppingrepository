package org.hcl.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hcl.model.User;
import org.hcl.services.UserService;
import org.hcl.services.UserServiceImpl;


@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	UserService service=new UserServiceImpl();
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String msg="";
		int id=Integer.parseInt(request.getParameter("uid"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String designation=request.getParameter("designation");
		User user=new User(id,username,password,gender,designation);
		boolean b=service.register(user);
		if(b)
		{
			msg="Successfully registered";
		}
		else
			msg="Not Registered";
		request.setAttribute("message", msg);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
