package com.lxh.module.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxh.module.dao.ModuleDao;
import com.lxh.module.entity.Module;
import com.lxh.module.service.ModuleService;

@Service("moduleService")
@Transactional
public class ModuleServiceImpl implements ModuleService {
	
	@Resource
	private ModuleDao moduleDao;

	@Override
	public void saveModule(Module module) {
		moduleDao.saveModule(module);
	}

	@Override
	public List<Module> getAll() {
		return moduleDao.getAll();
	}

	@Override
	public void delOne(String id) {
		moduleDao.delOne(id);
	}

	@Override
	public Module getOne(Map<String, Object> paraMap) {
		return moduleDao.getOne(paraMap);
	}

}
