package project01.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project01.model.BookDto;
import project01.model.ItemDto;
import project01.model.OrderDto;
import project01.service.BookService;
import project01.serviceImpl.BookServiceImpl;
import project01.ultis.StringUtils;

@WebServlet(urlPatterns = { "/shop/addToCart" })
public class CartController extends HttpServlet {
	
	private BookService bookService;
	
	@Override
	public void init() throws ServletException {
		bookService = new BookServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String bookId = "";
		int quantity = 1;
		if (StringUtils.isNotNullOrEmpty(req.getParameter("bookId"))) {
			bookId = req.getParameter("bookId");
			// Lấy sách theo Id
			BookDto book = bookService.getBookById(bookId);
			if (book != null) {
				if (StringUtils.isNotNullOrEmpty(req.getParameter("quantity"))) {
					quantity = Integer.valueOf(req.getParameter("quantity"));
				}
				
				HttpSession session = req.getSession();
				OrderDto orderDto = new OrderDto();
				List<ItemDto> lstItems = new ArrayList<>();
				if (session.getAttribute("order") == null) {
					ItemDto itemDto = new ItemDto();
					itemDto.setBookDto(book);
					itemDto.setQuantity(quantity);
					itemDto.setPrice(Double.valueOf(book.getPrice()));
					lstItems.add(itemDto);
					orderDto.setLstItems(lstItems);
					session.setAttribute("order", orderDto);
				} else {
					OrderDto orderSesion = (OrderDto) session.getAttribute("order");
					List<ItemDto> lstItem = orderSesion.getLstItems();
					List<Long> lstId = new ArrayList<>();
					boolean checkBookExistOrder = false;
					//For Danh sách sản phẩm đang có
					for (ItemDto item : lstItem) {
						//Nếu đã sản phẩm vừa chọn đã có trong danh sách rồi thì số lượng cộng thêm
						if (item.getBookDto().getId() == book.getId()) {
							int quantityNew = item.getQuantity() + quantity;
							item.setQuantity(quantityNew);
							checkBookExistOrder = true;
						}
					}
					if(!checkBookExistOrder) {
						//Nếu sản phẩm vừa chọn chưa có thì tạo mới, tương tự trên
						ItemDto itemDto = new ItemDto();
						itemDto.setBookDto(book);
						itemDto.setQuantity(quantity);
						itemDto.setPrice(Double.valueOf(book.getPrice()));
						lstItem.add(itemDto);
						orderDto.setLstItems(lstItem);
						session.setAttribute("order", orderDto);
					}
				}
				
				//Tính tổng tiền
				OrderDto orderSesion = (OrderDto) session.getAttribute("order");
				List<ItemDto> lstItemCalcuPay = orderSesion.getLstItems();
				Double totalPay = 0d;
				for(ItemDto item : lstItemCalcuPay) {
					Double temp = item.getPrice() * item.getQuantity();
					totalPay += temp;
					item.setAmountPayItem(temp);
				}
				
				orderSesion.setTotalPayment(totalPay);
				session.setAttribute("order", orderSesion);
			}
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/shop/searchBook");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
