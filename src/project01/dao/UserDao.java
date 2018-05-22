package project01.dao;

import project01.model.UserDto;

public interface UserDao {
	public UserDto getUserByUserName(String userName);
}
