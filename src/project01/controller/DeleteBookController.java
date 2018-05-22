package project01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project01.service.BookService;
import project01.serviceImpl.BookServiceImpl;
import project01.ultis.StringUtils;

@WebServlet(urlPatterns= {"/deleteBook"})
public class DeleteBookController extends HttpServlet{
	
	private BookService bookService;
	
	@Override
	public void init() throws ServletException {
		bookService = new BookServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("idBook");
		if(StringUtils.isNotNullOrEmpty(id)) {
			boolean checkDelete = bookService.deleteBook(id);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/searchBook");
			requestDispatcher.forward(req, resp);
		}else {
			String url = req.getContextPath() + "/admin/pages/book-manage.jsp";
			resp.sendRedirect(url);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
