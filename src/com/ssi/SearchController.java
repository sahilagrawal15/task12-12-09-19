package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// reads the request
		String code = request.getParameter("code");
		// process it using dao/service classes
		BookDAO dao = new BookDAO();
		 Book book=dao.searchBook(code);
		// store the model in scope object

		// deleting book
		//Book book = dao.deleteBook(code);

		HttpSession session = request.getSession();
		session.setAttribute("bookinfo", book);
		// request.setAttribute("bookinfo", book);
		// forwards the request to view
		// response.sendRedirect("details.jsp");

		RequestDispatcher rd = request.getRequestDispatcher("details.jsp");
		rd.forward(request, response);

	}

}
