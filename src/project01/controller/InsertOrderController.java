package project01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project01.model.OrderDto;
import project01.service.OrderService;
import project01.serviceImpl.OrderServiceImpl;

@WebServlet(urlPatterns = {"/shop/insertOrder"})
public class InsertOrderController extends HttpServlet{
	
	private OrderService orderService;

	public InsertOrderController() {
		orderService = new OrderServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		OrderDto orderSession = (OrderDto) session.getAttribute("order");
		
		if(orderSession != null) {
			boolean checkInsertOrder = orderService.insertOrder(orderSession);
			if(checkInsertOrder) {
				session.removeAttribute("order");
				String url = req.getContextPath() + "/shop/pages/result-order.jsp";
				resp.sendRedirect(url);
			}
//			
//			RequestDispatcher dispatcher = req.getRequestDispatcher("/shop/searchBook");
//			dispatcher.forward(req, resp);
		}else {
			
		}
		
	}
	
	
}
