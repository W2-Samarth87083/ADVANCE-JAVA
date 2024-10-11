package com;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Book List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>List of All Books</h1>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.printf("<th>Id</th>");
		out.printf("<th>Name</th>");
		out.printf("<th>Author</th>");
		out.printf("<th>Subject</th>");
		out.printf("<th>Price</th>");
		out.println("</thead>");		
		try(BookDao bookDao = new BookDao()) {
			List<Book> list = bookDao.findAll();
			for (Book b : list) {
				out.println("<tr>");
				out.printf("<td>%d</td>", b.getId());
				out.printf("<td>%s</td>", b.getName());
				out.printf("<td>%s</td>", b.getAuthor());
				out.printf("<td>%s</td>", b.getSubject());
				out.printf("<td>%f</td>", b.getPrice());
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");		
	}
}
