package project01.service;

import project01.dao.OrderDao;
import project01.model.OrderDto;

public interface OrderService {
	
	public boolean insertOrder(OrderDto dto);
	
}
