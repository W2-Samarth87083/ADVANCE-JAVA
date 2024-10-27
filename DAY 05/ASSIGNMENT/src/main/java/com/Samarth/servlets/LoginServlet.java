package com.Samarth.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Samarth.dataaccess.CustomerDataAccess;
import com.Samarth.entities.Customer;

@SuppressWarnings("serial")
@WebServlet(value = "/login", loadOnStartup = 1)

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	// User Defined Service Method
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Content Type HTML
		resp.setContentType("text/html");

		// Fetching the data from Login.html
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try (CustomerDataAccess custdao = new CustomerDataAccess()) {
			Customer cust = custdao.findByEmail(email);
			// Checking the user passwd with DB passwd
			if (cust != null && password.equals(cust.getCustPsswd())) {

				// On Successful login started the session for the addcart (Empty Cart)
				List<Integer> items = new ArrayList<Integer>();
				HttpSession session = req.getSession();
				session.setAttribute("items", items);

				// Redirection for admin and user login
				if (cust.getCustPsswd().equals("admin") && cust.getCustName().equals("admin")) {
					resp.sendRedirect("/ASSIGNMENT/booklist");
				} else {
					resp.sendRedirect("/ASSIGNMENT/Subjects");
				}
				
			}
			//Redirection to LoginFailed.html when the user fails.
			else {
				resp.sendRedirect("/ASSIGNMENT/pages/LoginFailed.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}

	}

}
