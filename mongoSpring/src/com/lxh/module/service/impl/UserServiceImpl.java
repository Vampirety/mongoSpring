package com.lxh.module.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxh.module.base.Pagination;
import com.lxh.module.dao.UserDao;
import com.lxh.module.entity.User;
import com.lxh.module.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User getUserByMap(Map<String, Object> paraMap) {
		return userDao.getUserByMap(paraMap);
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public Pagination getUserPage(Pagination pagination,
			Map<String, Object> paraMap) {
		return userDao.getUserPage(pagination,paraMap);
	}

	@Override
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}
}
