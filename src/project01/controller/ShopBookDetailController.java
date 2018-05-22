package project01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project01.model.BookDto;
import project01.service.BookService;
import project01.serviceImpl.BookServiceImpl;
import project01.ultis.StringUtils;

@WebServlet(urlPatterns = {"/shop/bookDetail"})
public class ShopBookDetailController extends HttpServlet{
	
	private BookService bookService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		bookService = new BookServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("idBook");
		if (StringUtils.isNotNullOrEmpty(id)) {
			BookDto dto = new BookDto();
			List<BookDto> lstBook = bookService.searchBook(dto);
			req.setAttribute("listBooksShop", lstBook);
			BookDto bookDto = bookService.getBookById(id);
			req.setAttribute("bookShop", bookDto);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/shop/pages/book-detail.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			String url = req.getContextPath() + "/shop/pages/shop-main.jsp";
			resp.sendRedirect(url);
		}
	}
}
