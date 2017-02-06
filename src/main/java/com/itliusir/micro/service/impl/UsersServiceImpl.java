package com.itliusir.micro.service.impl;

import com.itliusir.micro.mapper.UsersMapper;
import com.itliusir.micro.model.Users;
import com.itliusir.micro.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

	
	@Autowired
	private UsersMapper usersMapper;
	/*@Override
	public Users selectByPrimaryKey(int id) {
		return usersMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(Users users) {
		return usersMapper.insert(users);
	}*/

	@Override
	public List<Users> selectAll() {
		return usersMapper.selectAll();
	}
}
