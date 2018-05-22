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

@WebServlet(urlPatterns = { "/shop/categoryBook" })
public class SearchBookShopCategoryController extends HttpServlet {

	private BookService bookService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		bookService = new BookServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		BookDto dto = new BookDto();
		String filterPrice = req.getParameter("filterPrice");
		String category = req.getParameter("category");
		String page = req.getParameter("page");
		if (StringUtils.isNotNullOrEmpty(filterPrice)) {
			String[] priceArr = filterPrice.split("-");
			dto.setFromPrice(Double.valueOf(priceArr[0].trim()) * 1000);
			dto.setToPrice(Double.valueOf(priceArr[1].trim()) * 1000);
		}
		dto.setCategory(category);
		if(StringUtils.isNotNullOrEmpty(page)) {
			dto.setPage(Integer.valueOf(page));
		}
		
		List<BookDto> lstBook = bookService.searchBook(dto);

		// Set list sách vào request attribute để xuống client thì lấy ra sử dụng jstl
		req.setAttribute("listBooksShop", lstBook);
		req.setAttribute("searchDto", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/shop/pages/shop-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
