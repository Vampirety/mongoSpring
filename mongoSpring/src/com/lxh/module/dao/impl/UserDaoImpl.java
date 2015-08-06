package com.lxh.module.dao.impl;

import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lxh.module.base.BaseDaoImpl;
import com.lxh.module.base.Pagination;
import com.lxh.module.dao.UserDao;
import com.lxh.module.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User getUserByMap(Map<String, Object> paraMap) {
		Criteria criteria=Criteria.where("delFlag").is("0");
		if(paraMap.containsKey("id")){
			criteria.and("id").is(paraMap.get("id"));
		}
		if(paraMap.containsKey("account")){
			criteria.and("account").is(paraMap.get("account"));
		}
		if(paraMap.containsKey("password")){
			criteria.and("password").is(paraMap.get("password"));
		}
		return this.getMongoTemplate().findOne(new Query(criteria), User.class);
	}

	@Override
	public void saveUser(User user) {
		this.getMongoTemplate().insert(user);
	}

	@Override
	public Pagination getUserPage(Pagination pagination,
			Map<String, Object> paraMap) {
		Criteria criteria=Criteria.where("delFlag").is("0");
		if(paraMap.containsKey("id")){
			criteria.and("id").is(paraMap.get("id"));
		}
		if(paraMap.containsKey("account")){
			criteria.and("account").is(paraMap.get("account"));
		}
		if(paraMap.containsKey("nickName")){
			criteria.and("nickName").regex(paraMap.get("nickName")+".*");
		}
		if(paraMap.containsKey("phone")){
			criteria.and("phone").regex(paraMap.get("phone")+".*");
		}
		return this.getPageByCriteria(User.class, criteria, pagination);
	}

	@Override
	public User getUserById(String userId) {
		return this.getMongoTemplate().findById(userId, User.class);
	}

}
