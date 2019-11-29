package com.nigmacode.apiREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nigmacode.apiREST.dao.UserDAO;
import com.nigmacode.apiREST.entity.User;

@Service
public class UserServiceImpl implements UserService{
 
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> findAll(){
		List<User> listUsers = userDAO.findAll();
		return listUsers;
	}
	
	@Override
	public User findById(int id) {
		User user = userDAO.findById(id);
		return user;
	}
	
	@Override
	public void save(User user) {
		userDAO.save(user);
	}
	
	@Override
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}
 
}
