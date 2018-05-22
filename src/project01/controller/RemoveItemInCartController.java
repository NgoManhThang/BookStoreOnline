package project01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project01.model.ItemDto;
import project01.model.OrderDto;

@WebServlet(urlPatterns= {"/shop/removeItemInCart"})
public class RemoveItemInCartController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		Long id = Long.valueOf(req.getParameter("id"));
		HttpSession session = req.getSession();
		OrderDto orderSesion = (OrderDto) session.getAttribute("order");
		List<ItemDto> lstItems = orderSesion.getLstItems();
		for (int i = 0; i < lstItems.size(); i++) {
			ItemDto item = lstItems.get(i);
			if(id == item.getBookDto().getId()) {
				lstItems.remove(i);
				orderSesion.setTotalPayment(orderSesion.getTotalPayment() - item.getAmountPayItem());
			}
		}
		
		orderSesion.setLstItems(lstItems);
		session.setAttribute("order", orderSesion);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/shop/searchBook");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
