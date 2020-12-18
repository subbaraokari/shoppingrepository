package org.hcl.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hcl.model.Product;
import org.hcl.services.ProductService;
import org.hcl.services.ProductServiceImpl;


@WebServlet("/add")
public class AddProductController extends HttpServlet {
	ProductService service=new ProductServiceImpl();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd=request.getRequestDispatcher("updateProduct.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		String pname=req.getParameter("pname");
		String imageurl=req.getParameter("imageurl");
		String description=req.getParameter("description");
		int price=Integer.parseInt(req.getParameter("price"));
		boolean isInserted=service.addProduct(new Product(pid, pname, imageurl, description, price));
		if(isInserted)
		{
			resp.sendRedirect("./products");
		}
	}

}
