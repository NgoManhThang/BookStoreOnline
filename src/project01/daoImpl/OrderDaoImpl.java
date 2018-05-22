package project01.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project01.connection.JDBCConnection;
import project01.dao.OrderDao;
import project01.model.ItemDto;
import project01.model.OrderDto;
import project01.ultis.Function;

public class OrderDaoImpl implements OrderDao{
	
	private Connection connection = null;
	
	public OrderDaoImpl () {
		connection = JDBCConnection.getJDBCConnection();
	}

	@Override
	public boolean insertOrder(OrderDto dto) {
		try {
			List<ItemDto> lstItems = dto.getLstItems();
			connection.setAutoCommit(false);
			
			String sql = "INSERT INTO orders (total_payment,status,date_order,user_customer) VALUES (?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setDouble(1, dto.getTotalPayment());
			preparedStatement.setString(2, "DXL");
			preparedStatement.setDate(3, Function.convertDate(new Date()));
			preparedStatement.setInt(4, 1);
			
			int idOrder = preparedStatement.executeUpdate();
			if(idOrder > 0) {
				for(ItemDto item : lstItems) {
					String sqlItem = "INSERT INTO item (book_id,quantity,price,order_id) VALUES (?,?,?,?)";
					PreparedStatement preparedItem = connection.prepareStatement(sqlItem, Statement.RETURN_GENERATED_KEYS);
					preparedItem.setLong(1, item.getBookDto().getId());
					preparedItem.setInt(2, item.getQuantity());
					preparedItem.setDouble(3, item.getPrice());
					preparedItem.setInt(4, idOrder);
					
					preparedItem.executeUpdate();
				}
			}
			
			connection.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
