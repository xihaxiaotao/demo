package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserMapper;

import pojo.User;
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    
	@Autowired
	private  UserMapper  userMapper;
	
	@Override
	public List<User> getAll(Integer from,Integer size) {
		// TODO Auto-generated method stub
		return userMapper.getAll((from-1)*size,size);
	}

	@Override
	public User getInfo(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getInfo(id);
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return userMapper.add(user);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.del(id);
	}

	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getUserCount();
	}

}
