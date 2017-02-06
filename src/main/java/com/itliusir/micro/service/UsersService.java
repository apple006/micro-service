package com.itliusir.micro.service;


import com.itliusir.micro.model.Users;

import java.util.List;

public interface UsersService {
	/*public Users selectByPrimaryKey(int id);
	public int insert(Users users);*/
	public List<Users> selectAll();
}
