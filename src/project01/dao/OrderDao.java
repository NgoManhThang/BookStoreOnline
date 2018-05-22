package project01.dao;

import project01.model.OrderDto;

public interface OrderDao {
	public boolean insertOrder(OrderDto dto);
}
