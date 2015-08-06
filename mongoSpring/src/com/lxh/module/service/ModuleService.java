package com.lxh.module.service;

import java.util.List;
import java.util.Map;

import com.lxh.module.entity.Module;

public interface ModuleService {

	void saveModule(Module module);

	List<Module> getAll();
	
	void delOne(String id);

	Module getOne(Map<String, Object> paraMap);

}
