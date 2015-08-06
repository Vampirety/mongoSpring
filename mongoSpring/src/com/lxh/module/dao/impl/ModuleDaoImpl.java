package com.lxh.module.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.lxh.module.base.BaseDaoImpl;
import com.lxh.module.dao.ModuleDao;
import com.lxh.module.entity.Module;

@Repository("moduleDao")
public class ModuleDaoImpl extends BaseDaoImpl implements ModuleDao{

	@Override
	public void saveModule(Module module) {
		getMongoTemplate().insert(module);
	}

	@Override
	public List<Module> getAll() {
		return getMongoTemplate().find(new Query(), Module.class);
	}

	@Override
	public void delOne(String id) {
		Criteria criteria=Criteria.where("id").in(id);
		if(criteria==null){
			Query query=new Query(criteria);
			if(query!=null&&this.getMongoTemplate().findOne(query, Module.class)!=null){
				this.getMongoTemplate().remove(this.getMongoTemplate().findOne(query, Module.class));
			}
		}
	}

	@Override
	public Module getOne(Map<String, Object> paraMap) {
		Criteria criteria=Criteria.where("1").is("1");
		if(paraMap.containsKey("id")){
			criteria.and("id").is(paraMap.get("id"));
		}
		if(paraMap.containsKey("moduleName")){
			Pattern pattern=Pattern.compile("^.*"+paraMap.get("moduleName")+".*$");
			criteria.and("moduleName").regex(pattern.toString());
		}
		if(paraMap.containsKey("moduleCode")){
			Pattern pattern=Pattern.compile(paraMap.get("moduleCode")+".*$");
			criteria.and("moduleCode").regex(pattern.toString());
		}
		List<Module> list=this.getMongoTemplate().find(new Query(criteria), Module.class);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
