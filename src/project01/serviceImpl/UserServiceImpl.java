package project01.serviceImpl;

import project01.dao.UserDao;
import project01.daoImpl.UserDaoImpl;
import project01.model.UserDto;
import project01.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public UserDto getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

}
