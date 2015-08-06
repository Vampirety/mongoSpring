package com.lxh.module.dao;

import java.util.Map;

import com.lxh.module.base.Pagination;
import com.lxh.module.entity.User;

public interface UserDao {

	User getUserByMap(Map<String, Object> paraMap);

	void saveUser(User user);

	Pagination getUserPage(Pagination pagination, Map<String, Object> paraMap);

	User getUserById(String userId);

}
