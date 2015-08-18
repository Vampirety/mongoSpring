package com.lxh.module.base;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.lxh.module.utils.BasalException;

public class BaseDaoImpl {
	
	@Resource
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public Pagination getPageByCriteria(Class<?> clazz,Criteria criteria,Pagination pagination){
		try{
			List<?> data = this.getMongoTemplate().find(new Query().addCriteria(criteria).skip(pagination.getFirstResult())
					.limit(pagination.getPageSize()), clazz);
			pagination.setTotalCount((int) this.getMongoTemplate().count(new Query().addCriteria(criteria), clazz));
			pagination.setList(data);
		}catch(Exception e){
			throw new BasalException(BasalException.ERROR, "≤È—Ø∑÷“≥¥ÌŒÛ");
		}
		return pagination;
	}
}
