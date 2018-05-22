package project01.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project01.connection.JDBCConnection;
import project01.dao.UserDao;
import project01.model.UserDto;
import project01.ultis.StringUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public UserDto getUserByUserName(String userName) {
		UserDto user = new UserDto();
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			String sql = "select * from user us where 1=1";
			if(StringUtils.isNotNullOrEmpty(userName)) {
				sql += " and us.user_name = ?";
			}
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			if (StringUtils.isNotNullOrEmpty(userName)) {
				preparedStatement.setString(1, userName);
			}
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("user_name");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				String avatar = rs.getString("avatar");

				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setName(name);
				user.setPhone(phone);
				user.setRole(role);
				user.setAvatar(avatar);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
