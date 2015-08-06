package com.lxh.module.service;

import java.util.Map;

import com.lxh.module.base.Pagination;
import com.lxh.module.entity.User;

public interface UserService {

	User getUserByMap(Map<String, Object> paraMap);

	void saveUser(User user);

	Pagination getUserPage(Pagination pagination, Map<String, Object> paraMap);

	User getUserById(String userId);

}
