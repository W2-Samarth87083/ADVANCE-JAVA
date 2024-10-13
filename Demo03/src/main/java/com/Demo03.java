package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo03")
public class Demo03 extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ProcessRequest(req,resp);
}
 
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 ProcessRequest(req,resp);
	}
	
 protected void ProcessRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
	 resp.setContentType("text/plain");
	    PrintWriter out = resp.getWriter();
	   String name =  req.getParameter("name");
	   String author = req.getParameter("Author");
	   String subject = req.getParameter("Subject");
	   Double price = Double.parseDouble(req.getParameter("Price"));
		Book b = new Book(0, name, author, subject, price);
		
		try(BookDao bk = new BookDao()) {
			int count = bk.save(b);
			if(count==1) {
				out.println("Book Add Successfully");
			}
			else 
				out.println("Book Save failed");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	   
	     
}
	
}
