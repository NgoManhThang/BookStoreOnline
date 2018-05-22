package project01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project01.model.BookDto;
import project01.service.BookService;
import project01.serviceImpl.BookServiceImpl;
import project01.ultis.StringUtils;

@WebServlet(urlPatterns = {"/searchBook"})
public class SearchBookController extends HttpServlet{
	
	private BookService bookService;
	
	@Override
	public void init() throws ServletException {
		bookService = new BookServiceImpl();
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String bookName = req.getParameter("bookName");
		String bookAuthor = req.getParameter("bookAuthor");
		String bookQuantity = req.getParameter("bookQuantity");
		String page = req.getParameter("page");
		BookDto dto = new BookDto();
		if(StringUtils.isNotNullOrEmpty(bookName)) {
			dto.setBookName(bookName);
		}
		if(StringUtils.isNotNullOrEmpty(bookAuthor)) {
			dto.setAuthor(bookAuthor);
		}
		if(StringUtils.isNotNullOrEmpty(bookQuantity)) {
			dto.setQuantity(bookQuantity);;
		}
		
		if(StringUtils.isNotNullOrEmpty(page)) {
			dto.setPage(Integer.valueOf(page));
		}
		
		List<BookDto> lstBook = bookService.searchBook(dto);
		
		//Set list sách vào request attribute để xuống client thì lấy ra sử dụng jstl
		req.setAttribute("listBooks", lstBook);
		req.setAttribute("searchDto", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/pages/book-manage.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
