package project01.serviceImpl;

import project01.dao.OrderDao;
import project01.daoImpl.OrderDaoImpl;
import project01.model.OrderDto;
import project01.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDao;
	
	public OrderServiceImpl() {
		orderDao = new OrderDaoImpl();
	}

	@Override
	public boolean insertOrder(OrderDto dto) {
		return orderDao.insertOrder(dto);
	}
}
